insert into authors( `name` ) values ('Blok');
insert into authors( `name` ) values ('Dostoevsky');
insert into genres(  `name` ) values ('Poetry');
insert into genres(  `name` ) values ('Fiction');

insert into books ( `name`,`author_id`,`genre_id`) values ( 'The dark Maiden', 1, 1);
insert into books ( `name`,`author_id`,`genre_id`) values ('The lady unknown', 1, 1);