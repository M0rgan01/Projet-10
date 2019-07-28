

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


INSERT INTO public.book VALUES (1, 'J.K. Rowling', true, 4, 5, 'Le jour de ses onze ans, Harry Potter, un orphelin élevé par un oncle et une tante qui le détestent, voit son existence bouleversée. Un géant vient le chercher pour l''emmener à Poudlard, une école de sorcellerie !
Voler en balai, jeter des sorts, combattre les trolls : Harry Potter se révèle un sorcier doué. Mais un mystère entoure sa naissance et l''effroyable V..., le mage dont personne n''ose prononcer le nom.', false, 'Harry Potter à l''école des sorciers', 'Fantasy');
INSERT INTO public.book VALUES (3, 'Victor Hugo', true, 5, 6, 'Dans la France chaotique du XIXe siècle, Jean Valjean sort de prison. Personne ne tend la main à cet ancien détenu hormis un homme d’église, qui le guide sur la voie de la bonté. Valjean décide alors de vouer sa vie à la défense des miséreux. Son destin va croiser le chemin de Fantine, une mère célibataire prête à tout pour le bonheur de sa fille. Celui des Thénardier, famille cruelle et assoiffée d’argent. Et celui de Javert, inspecteur de police dont l’obsession est de le renvoyer en prison !', false, 'Les Misérables', 'Policier');
INSERT INTO public.book VALUES (4, 'Morris', true, 1, 2, 'Ce personnage immortel parcourt depuis 1947 l''histoire de l''ouest américain. Il y a rencontré des personnages célèbres (Jesse James, Calamity Jane, Billy the Kid, Sarah Bernhardt...). Lucky Luke est l''homme des missions impossibles, le défenseur des pauvres, des veuves et des orphelins, bref le parfait héros !', false, 'Lucky Luke - Alerte aux Pieds-Bleus', 'Bande dessinée');
INSERT INTO public.book VALUES (2, 'Agatha Christie', false, 0, 2, 'Le célèbre détective belge Hercule Poirot prend l''Orient-Express pour rentrer d''Istanbul à Londres mais alors que le train se retrouve bloqué par la neige dans les montagnes yougoslaves, un meurtre est commis. Les 13 passagers sont tous suspects et le fameux détective Hercule Poirot se lance dans une course contre la montre pour identifier l''assassin, avant qu''il ne frappe à nouveau.', false, 'Le Crime de l''Orient-Express', 'Policier');
INSERT INTO public.book VALUES (5, 'Stieg Larsson', true, 2, 3, 'Chaque année depuis trente-six ans, un homme reçoit à son anniversaire une fleur séchée dans un joli petit cadre, un envoi évidemment anonyme ; tous ont été accrochés à un mur de son bureau. Et, chaque année, il téléphone immédiatement à un commissaire à la retraite pour lui confirmer le message reçu. Quel message ? De qui ? Pourquoi ?', false, 'Les Hommes qui n''aimaient pas les femmes', 'Aventure');
INSERT INTO public.book VALUES (6, 'J.K. Rowling', false, 0, 2, 'Une rentrée fracassante en voiture volante, une étrange malédiction qui s''abat sur les élèves, cette deuxième année à l''école des sorciers ne s''annonce pas de tout repos ! Entre les cours de potions magiques, les matches de Quidditch et les combats de mauvais sorts, Harry et ses amis Ron et Hermione trouveront-ils le temps de percer le mystère de la Chambre des Secrets ?

Le deuxième volume des aventures de Harry Potter : un livre magique pour sorciers confirmés.', false, 'Harry Potter et la chambre des secrets', 'Fantasy');




INSERT INTO public.users VALUES (1, true, NULL, '$2a$10$2uc5tUa/5.NsnScFifkqpuAJHnWK25C8vjyFmXSc9n9aRXyeiRgCq', 'emilie', 0);
INSERT INTO public.users VALUES (52, true, NULL, '$2a$10$YHfHz8vOlu8LnDEMBsRVFuz3vDjybnPEsB5Q88m0qDCFXTcHstQWy', 'morgan', 0);




INSERT INTO public.loan VALUES (1, '2019-06-08 18:03:50.021', false, false, '2019-04-21 18:03:50.021', 1, 52);
INSERT INTO public.loan VALUES (2, '2019-06-08 18:03:50.054', false, false, '2019-04-21 18:03:50.054', 2, 52);
INSERT INTO public.loan VALUES (3, '2019-06-08 18:03:50.061', false, false, '2019-04-21 18:03:50.061', 3, 52);
INSERT INTO public.loan VALUES (4, '2019-06-08 18:03:50.068', false, false, '2019-04-21 18:03:50.068', 4, 1);
INSERT INTO public.loan VALUES (5, '2019-06-08 18:03:50.076', false, false, '2019-04-21 18:03:50.076', 2, 1);
INSERT INTO public.loan VALUES (6, '2019-06-08 18:03:50.083', false, false, '2019-04-21 18:03:50.083', 6, 1);
INSERT INTO public.loan VALUES (52, '2019-03-21 00:00:00', false, false, '2019-02-01 00:00:00', 5, 52);
INSERT INTO public.loan VALUES (102, '2018-03-21 00:00:00', false, false, '2018-02-01 00:00:00', 6, 52);



INSERT INTO public.mail VALUES (1, 'emy78@hotmail.fr', NULL, NULL, 0, 1);
INSERT INTO public.mail VALUES (52, 'pichat.morgan@gmail.com', '2019-04-21 18:54:46.084', '510192c4', 0, 52);



INSERT INTO public.roles VALUES ('ROLE_USER');
INSERT INTO public.roles VALUES ('ROLE_ADMIN');



INSERT INTO public.users_roles VALUES (1, 'ROLE_USER');
INSERT INTO public.users_roles VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.users_roles VALUES (52, 'ROLE_USER');



