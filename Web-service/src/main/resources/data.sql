
INSERT INTO public.kind VALUES ('Fantasy');
INSERT INTO public.kind VALUES ('Science-fiction');
INSERT INTO public.kind VALUES ('Fantastique');
INSERT INTO public.kind VALUES ('Horreur');
INSERT INTO public.kind VALUES ('Aventure');
INSERT INTO public.kind VALUES ('Nouvelle');
INSERT INTO public.kind VALUES ('Biographie');
INSERT INTO public.kind VALUES ('Témoignage');
INSERT INTO public.kind VALUES ('Conte');
INSERT INTO public.kind VALUES ('Épopée');
INSERT INTO public.kind VALUES ('Policier');
INSERT INTO public.kind VALUES ('Western');
INSERT INTO public.kind VALUES ('Bande dessinée');



INSERT INTO public.roles VALUES ('ROLE_USER');
INSERT INTO public.roles VALUES ('ROLE_ADMIN');

INSERT INTO public.users VALUES (1, true, NULL, '$2a$10$h4V9hkjanI2YUJ7Q4rHxg..lKFKFhQym76AqAh54rE0bV0L1DLug6', 'User123', 0);
INSERT INTO public.users VALUES (2, true, NULL, '$2a$10$QPdCr.dqrM1zGgkGEFshXuDGUYoCBo0Iskeucaf8SkZRl.GEicBlW', 'Admin1', 0);

INSERT INTO public.mail VALUES (1, 'pichat.morgan@gmail.com', NULL, NULL, 0, 1);
INSERT INTO public.mail VALUES (2, 'pichat.morgan01@gmail.com', NULL, NULL, 0, 2);

INSERT INTO public.users_roles VALUES (1, 'ROLE_USER');
INSERT INTO public.users_roles VALUES (2, 'ROLE_USER');
INSERT INTO public.users_roles VALUES (2, 'ROLE_ADMIN');

SELECT pg_catalog.setval('public.mail_sequence', 51, true);
SELECT pg_catalog.setval('public.user_seq', 51, true);