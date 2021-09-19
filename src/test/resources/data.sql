insert into author (id, `name`)
values (1, 'Blok');

insert into author (id ,`name`)
values (2, 'Dostoevskiy');

insert into genre  (id, `name`)
values (1, 'Poetry');

insert into book (id, `name`, author_id, genre_id)
values (1, 'The nature', 1 ,1);

insert into book (id, `name`, author_id, genre_id)
values (2, 'The sun', 2 ,1);


