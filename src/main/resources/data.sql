insert into authors(id,  `name` ) values (1, 'Block');
insert into genres(id,  `name` ) values (1, 'Poetry');

insert into books (id, `name`,`author_id`,`genre_id`) values (1,  'the sun', 1, 1);
insert into books (id, `name`,`author_id`,`genre_id`) values (2,  'the wind', 1, 1);