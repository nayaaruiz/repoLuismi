INSERT INTO ARTISTA (id, nombre) VALUES (1, 'Aitana');
INSERT INTO ARTISTA (id, nombre) VALUES (2, 'Bad Bunny');
INSERT INTO ARTISTA (id, nombre) VALUES (3, 'Bad Gyal');

INSERT INTO FESTIVAL (id, nombre, ciudad) VALUES (1, 'Festival Solar', 'Barcelona');
INSERT INTO FESTIVAL (id, nombre, ciudad) VALUES (2, 'Ocean Fest', 'Málaga');
INSERT INTO FESTIVAL (id, nombre, ciudad) VALUES (3, 'Night Beats', 'Madrid');

INSERT INTO festival_artista (festival_id, artista_id) VALUES (1, 1);
INSERT INTO festival_artista (festival_id, artista_id) VALUES (1, 3);
INSERT INTO festival_artista (festival_id, artista_id) VALUES (2, 2);
INSERT INTO festival_artista (festival_id, artista_id) VALUES (2, 3);
INSERT INTO festival_artista (festival_id, artista_id) VALUES (3, 1);