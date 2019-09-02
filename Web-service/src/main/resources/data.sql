
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


INSERT INTO public.book VALUES (1, 'J.K. Rowling', true, false, 5, 5, 'Le jour de ses onze ans, Harry Potter, un orphelin élevé par un oncle et une tante qui le détestent, voit son existence bouleversée. Un géant vient le chercher pour l''''emmener à Poudlard, une école de sorcellerie !
Voler en balai, jeter des sorts, combattre les trolls : Harry Potter se révèle un sorcier doué. Mais un mystère entoure sa naissance et l''''effroyable V..., le mage dont personne n''''ose prononcer le nom.', false, NULL, 0, 'Harry Potter à l''''école des sorciers', 'Fantasy');
INSERT INTO public.book VALUES (2, 'Victor Hugo', true, false, 2, 2, 'Dans la France chaotique du XIXe siècle, Jean Valjean sort de prison. Personne ne tend la main à cet ancien détenu hormis un homme d’église, qui le guide sur la voie de la bonté. Valjean décide alors de vouer sa vie à la défense des miséreux. Son destin va croiser le chemin de Fantine, une mère célibataire prête à tout pour le bonheur de sa fille. Celui des Thénardier, famille cruelle et assoiffée d’argent. Et celui de Javert, inspecteur de police dont l’obsession est de le renvoyer en prison !', false, NULL, 0, 'Les Misérables', 'Policier');
INSERT INTO public.book VALUES (4, 'Agatha Christie', true, false, 2, 2, 'Le célèbre détective belge Hercule Poirot prend l''''Orient-Express pour rentrer d''''Istanbul à Londres mais alors que le train se retrouve bloqué par la neige dans les montagnes yougoslaves, un meurtre est commis. Les 13 passagers sont tous suspects et le fameux détective Hercule Poirot se lance dans une course contre la montre pour identifier l''''assassin, avant qu''''il ne frappe à nouveau.', false, NULL, 0, 'Le Crime de l''''Orient-Express', 'Policier');
INSERT INTO public.book VALUES (6, 'J.K. Rowling', true, false, 5, 5, 'Une rentrée fracassante en voiture volante, une étrange malédiction qui s''''abat sur les élèves, cette deuxième année à l''''école des sorciers ne s''''annonce pas de tout repos ! Entre les cours de potions magiques, les matches de Quidditch et les combats de mauvais sorts, Harry et ses amis Ron et Hermione trouveront-ils le temps de percer le mystère de la Chambre des Secrets ?
Le deuxième volume des aventures de Harry Potter : un livre magique pour sorciers confirmés.', false, NULL, 0, 'Harry Potter et la chambre des secrets', 'Fantasy');
INSERT INTO public.book VALUES (3, 'Morris', false, true, 0, 1, 'Ce personnage immortel parcourt depuis 1947 l''''histoire de l''''ouest américain. Il y a rencontré des personnages célèbres (Jesse James, Calamity Jane, Billy the Kid, Sarah Bernhardt...). Lucky Luke est l''''homme des missions impossibles, le défenseur des pauvres, des veuves et des orphelins, bref le parfait héros !', false, '2019-09-18 17:47:49.8', 0, 'Lucky Luke - Alerte aux Pieds-Bleus', 'Bande dessinée');
INSERT INTO public.book VALUES (5, 'Stieg Larsson', false, true, 0, 1, 'Chaque année depuis trente-six ans, un homme reçoit à son anniversaire une fleur séchée dans un joli petit cadre, un envoi évidemment anonyme ; tous ont été accrochés à un mur de son bureau. Et, chaque année, il téléphone immédiatement à un commissaire à la retraite pour lui confirmer le message reçu. Quel message ? De qui ? Pourquoi ?', false, '2019-09-18 17:47:49.841', 1, 'Les Hommes qui n''aimaient pas les femmes', 'Policier');

INSERT INTO public.loan VALUES (1, '2019-09-18 17:47:49.8', false, false, '2019-08-01 17:47:49.8', 3, 1);
INSERT INTO public.loan VALUES (2, '2019-09-18 17:47:49.841', false, false, '2019-08-01 17:47:49.841', 5, 2);
INSERT INTO public.reservation VALUES (1, NULL, 1, '2019-08-01 17:49:05.506', 5, 2);

SELECT pg_catalog.setval('public.reservation_seq', 51, true);
SELECT pg_catalog.setval('public.loan_sequence', 51, true);
SELECT pg_catalog.setval('public.mail_sequence', 51, true);
SELECT pg_catalog.setval('public.user_seq', 51, true);
SELECT pg_catalog.setval('public.book_sequence', 51, true);