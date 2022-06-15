create table if not exists items (
    id serial primary key,
    name text,
    created timestamp
);

create table cars(
    id serial primary key,
    model varchar(255),
    created timestamp
);

create table students(
    id serial primary key,
    name varchar,
    age INTEGER,
    city varchar
);