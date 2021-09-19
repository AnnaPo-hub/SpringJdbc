insert into author(id,name) values
  (1,'Blok'),
  (2,'Proust'),
  (3,'Shildt');

insert into genre(id,name) values
  (1,'Poetry'),
  (2,'Fiction'),
  (3,'Non-fiction');

insert into book(id,name, author_id, genre_id) values
  (1,'The sun','1','2'),
  (2,'The nature','2','1'),
  (3,'Snowing', '3','3'),
  (4,'The sun is shining', '2','3'),
  (5,'Singing', '3','1'),
  (6,'Dancing', '3','2');



