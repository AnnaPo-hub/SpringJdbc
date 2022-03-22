DROP TABLE IF EXISTS AUTHORS cascade ;
DROP TABLE IF EXISTS GENRES cascade ;
DROP TABLE IF EXISTS BOOKS cascade ;
DROP TABLE IF EXISTS COMMENTS cascade ;

create table authors(
id bigserial,
name varchar(255),
primary key (id)
);

create table genres(
id bigserial,
name varchar(255),
primary key (id)
);

create table books(
id bigserial,
name varchar(255),
author_id bigint references authors(id),
genre_id bigint references genres(id),
primary key (id)
);

create table comments(
id bigserial,
date timestamp,
comment_text varchar(255),
author varchar(255),
book_id bigint references books(id)
);


