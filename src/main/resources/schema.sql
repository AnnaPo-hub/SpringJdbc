DROP TABLE IF EXISTS BOOKS;
DROP TABLE IF EXISTS AUTHORS;
DROP TABLE IF EXISTS GENRES;

create table authors(
id bigserial NOT NULL AUTO_INCREMENT,
name varchar(255),
primary key (id)
);

create table genres(
id bigserial NOT NULL AUTO_INCREMENT,
name varchar(255),
primary key (id)
);

create table books(
id bigserial NOT NULL AUTO_INCREMENT,
name varchar(255),
author_id bigint references authors(id),
genre_id bigint references genres(id),
primary key (id)
);

