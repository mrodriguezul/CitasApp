package com.mrodriguezul.citasapp.persistence.audit;

import com.mrodriguezul.citasapp.persistence.entity.Person;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreUpdate;

public class AuditPersonListener {

    private Person currentPerson;

    @PostLoad
    public void postLoad(Person entity) {
        System.out.println("POST LOAD");
        this.currentPerson = createPersonCopy(entity);
    }

    @PreUpdate
    public void onPreUpdate(Person entity) {
        System.out.println("PRE UPDATE");
        System.out.println(entity.toString());
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(Person entity) {
        System.out.println("POST PERSIST OR UPDATE");
        System.out.println("LAST VALUE: " + (currentPerson != null ? currentPerson.toString() : "null"));
        System.out.println("POST VALUE: " + entity.toString());
    }

    private Person createPersonCopy(Person original) {
        if (original == null) return null;

        Person copy = new Person();
        copy.setId(original.getId());
        copy.setIdentificationNumber(original.getIdentificationNumber());
        copy.setNames(original.getNames());
        copy.setSurnames(original.getSurnames());
        copy.setDateOfBirth(original.getDateOfBirth());
        copy.setEmail(original.getEmail());
        copy.setPhoneNumber(original.getPhoneNumber());
        copy.setIdentification(original.getIdentification());

        return copy;
    }
}
