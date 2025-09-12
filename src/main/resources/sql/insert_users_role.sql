-- Inserts para la tabla users_role
-- Asigna roles a los usuarios existentes

-- Asignar rol ADMIN al usuario admin
insert into users_role (username, role, granted_date) values
('admin', 'ADMIN', '2025-09-12 10:00:00');

-- Asignar rol CUSTOMER al usuario customer
insert into users_role (username, role, granted_date) values
('customer', 'CUSTOMER', '2025-09-12 10:00:00');
