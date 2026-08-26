erDiagram
    identification {
        bigint id PK
        varchar name "not null"
        varchar description "not null"
    }

    speciality {
        bigint id PK
        varchar name "not null"
    }

    person {
        bigint id PK
        bigint identification_id FK
        varchar identification_number "not null, unique"
        varchar names "not null"
        varchar surnames
        date date_of_birth "not null"
        varchar email
        varchar phone_number
    }

    doctor {
        bigint id PK, FK
        bigint speciality_id FK
    }

    patient {
        bigint id PK, FK
    }

    appointment {
        bigint id PK
        bigint doctor_id FK
        bigint patient_id FK
        timestamp appointment_date "not null"
        text reason "not null"
    }

    users {
        varchar username PK
        varchar password "not null"
        varchar email
        boolean locked "not null"
        boolean disabled "not null"
    }

    users_role {
        varchar username PK, FK
        varchar role PK
        timestamp granted_date "not null"
    }

    identification ||--o{ person : "has"
    speciality ||--o{ doctor : "has"
    person ||--o| doctor : "is"
    person ||--o| patient : "is"
    doctor ||--o{ appointment : "attends"
    patient ||--o{ appointment : "books"
    users ||--o{ users_role : "has"