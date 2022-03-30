--users
INSERT INTO registered_user(id, email, password, name, surname, phone) VALUES (nextval('user_seq_gen'), 'marko@gmail.com', '123456', 'Marko', 'Markovic', '0213654');
INSERT INTO registered_user(id, email, password, name, surname, phone) VALUES (nextval('user_seq_gen'), 'nikola@gmail.com', '123456', 'Nikola', 'Nikolic', '0658796');
INSERT INTO registered_user(id, email, password, name, surname, phone) VALUES (nextval('user_seq_gen'), 'milica@gmail.com', '123456', 'Milica', 'Petrovic', '0689759');

