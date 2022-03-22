DROP TABLE IF EXISTS AUTHORS cascade ;
DROP TABLE IF EXISTS GENRES cascade ;
DROP TABLE IF EXISTS BOOKS cascade ;
DROP TABLE IF EXISTS COMMENTS cascade ;

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

create table comment(
id bigserial,
date timestamp,
comment_text varchar(255),
author varchar(255),
book_id bigint references book(id)
);
