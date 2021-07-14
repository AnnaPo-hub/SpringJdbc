insert into authors (`name`)
values ('Blok');
insert into authors (`name`)
values ('Dostoevskiy');
insert into genres  (`name`)
values ('Poetry');
insert into books (`name`, author_id, genre_id)
values ('The nature', 1 ,
1);
insert into comments (date, comment_text, author, book_id)
 values ('2011-12-21', 'Good book', 'Alicia', 1)
