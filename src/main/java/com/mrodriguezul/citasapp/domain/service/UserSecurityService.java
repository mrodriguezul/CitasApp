package com.mrodriguezul.citasapp.domain.service;

import com.mrodriguezul.citasapp.domain.Usuario;
import com.mrodriguezul.citasapp.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UserSecurityService implements UserDetailsService {

    // Authorities
    private static final String AUTHORITY_DOCTOR = "VIEW_DOCTORS_ALL";
    private static final String AUTHORITY_VIEW_SPECIALTIES = "VIEW_DOCTORS_BY_SPECIALTIES";

    // ROL -> AUTHORITIES mapping
    private static final Map<String, List<String>> ROLE_AUTHORITIES_MAP = Map.of(
        "ADMIN", List.of(AUTHORITY_DOCTOR, AUTHORITY_VIEW_SPECIALTIES),
        "CUSTOMER", Arrays.asList(AUTHORITY_DOCTOR, AUTHORITY_VIEW_SPECIALTIES)
    );

    private final UserRepository userRepository;

    @Autowired
    public UserSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        String[] roles = usuario.getRoles() != null && !usuario.getRoles().isEmpty() ?
                usuario.getRoles().stream()
                        .map(rol -> rol.getNombre())
                        .toArray(String[]::new) :
                new String[]{"NO-ROL"};

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                //.roles(roles)
                .authorities(this.getGrantedAuthorities(roles))
                .accountLocked(usuario.getLocked())
                .disabled(usuario.getDisabled())
                .build();
    }

    private String[] getAuthorities(String role) {
        List<String> authorities = ROLE_AUTHORITIES_MAP.getOrDefault(role, Collections.emptyList());
        return authorities.toArray(new String[0]);
    }

    private List<GrantedAuthority> getGrantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String role: roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            for (String authority: this.getAuthorities(role)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }
}
