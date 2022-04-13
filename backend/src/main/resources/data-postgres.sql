INSERT INTO ROLE (id, name)
VALUES (nextval('role_seq_gen'), 'ROLE_USER');
INSERT INTO ROLE (id, name)
VALUES (nextval('role_seq_gen'), 'ROLE_ADMIN');

INSERT INTO registered_user(id, email, name, password, phone, surname)
VALUES (nextval('user_seq_gen'), 'marijakljestan@gmail.com', 'Marija', '$2a$10$Hnlon2YebrUY9LGdP0u3EeQlhK1enOMEKa99fDRH1pF/YX9pKFcHm', 123456789, 'Kljestan');
INSERT INTO registered_user(id, email, name, password, phone, surname)
VALUES (nextval('user_seq_gen'), 'pavkovicn51@gmail.com', 'Nikolina', '$2a$10$Hnlon2YebrUY9LGdP0u3EeQlhK1enOMEKa99fDRH1pF/YX9pKFcHm', 123456789, 'Pavkovic');

INSERT INTO user_role(user_id, role_id)
VALUES(1,1);
INSERT INTO user_role(user_id, role_id)
VALUES(2,2);