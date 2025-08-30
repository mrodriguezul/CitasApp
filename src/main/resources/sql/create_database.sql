create table identification (
  id bigint primary key generated always as identity,
  name varchar(30) not null,
  description varchar(40) not null
);

create table speciality (
  id bigint primary key generated always as identity,
  name varchar(40) not null
);

create table person (
  id bigint primary key generated always as identity,
  identification_id bigint not null references identification (id),
  identification_number varchar(20) not null unique,
  names varchar(30) not null,
  surnames varchar(40),
  date_of_birth date not null,
  email varchar(30),
  phone_number varchar(15)
);

create table doctor (
  id bigint primary key references person (id),
  speciality_id bigint not null references speciality (id)
);

create table patient (
  id bigint primary key references person (id)
);

create table appointment (
  id bigint primary key generated always as identity,
  doctor_id bigint not null references doctor (id),
  patient_id bigint not null references patient (id),
  appointment_date timestamp not null,
  reason text not null
);


