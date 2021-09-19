DROP TABLE IF EXISTS AUTHORS cascade ;
DROP TABLE IF EXISTS GENRES cascade ;
DROP TABLE IF EXISTS BOOKS cascade ;

create table author(
id bigserial,
name varchar(255),
primary key (id)
);

create table genre(
id bigserial,
name varchar(255),
primary key (id)
);

create table book(
id bigserial,
name varchar(255),
author_id bigint references author(id),
genre_id bigint references genre(id),
primary key (id)
);


