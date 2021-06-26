drop table if exists LISTING;

create table LISTING (
--    id SERIAL PRIMARY KEY,
    dealer VARCHAR(255),
    code VARCHAR(255),
    make VARCHAR(255),
    model VARCHAR(255),
    yar INT,
    color VARCHAR(255),
    price INT
);