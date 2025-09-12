package com.mrodriguezul.citasapp.domain.service;

import com.mrodriguezul.citasapp.domain.Usuario;
import com.mrodriguezul.citasapp.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
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
                .roles(roles)
                .accountLocked(usuario.getLocked())
                .disabled(usuario.getDisabled())
                .build();
    }
}
