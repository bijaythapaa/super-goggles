-- drop database expensetrackerdb;
-- drop user expensetracker;
-- create user expensetracker with password 'expense';
-- create database expensetrackerdb with template=template0 owner=expensetracker;
-- \connect expensetrackerdb;
-- alter default privileges grant all on tables to expensetracker;
-- alter default privileges grant all on sequences to expensetracker;
--
-- create table et_users(
-- user_id integer primary key not null,
-- first_name varchar(20) not null,
-- last_name varchar(20) not null,
-- email varchar(30) not null,
-- password text not null
-- );
--
-- create table et_categories(
-- category_id integer primary key not null,
-- user_id integer not null,
-- title varchar(20) not null,
-- description varchar(50) not null
-- );
-- alter table et_categories add constraint cat_users_fk
-- foreign key (user_id) references et_users(user_id);
--
-- create table et_transactions(
-- transaction_id integer primary key not null,
-- category_key integer not null,
-- user_id integer not null,
-- amount numeric(10,2) not null,
-- note varchar(50) not null,
-- transaction_date bigint not null
-- );
-- alter table er_transactions add constraint trans_cat_fk
-- foreign key (category_id) references et_categories(category_id);
-- alter table et_transactions add constraint trans_users_fk
-- foreign key (user_id) references et_users(user_id);
--
-- create sequence et_users_seq increment 1 start 1;
-- create sequence et_categories_seq increment 1 start 1;
-- create sequence et_transactions_seq increment 1 start 1000;

DROP DATABASE IF EXISTS about_jwt;
CREATE DATABASE about_jwt;
USE about_jwt;

DROP TABLE IF EXISTS et_users;
DROP TABLE IF EXISTS et_categories;
DROP TABLE IF EXISTS et_transactions;

CREATE TABLE et_users
(
    user_id    INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20)         NOT NULL,
    last_name  VARCHAR(20)         NOT NULL,
    email      VARCHAR(30)         NOT NULL,
    password   TEXT                NOT NULL
);

create table et_categories
(
    category_id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id     INTEGER             NOT NULL,
    title       VARCHAR(20)         NOT NULL,
    description VARCHAR(50)         NOT NULL,
    CONSTRAINT cat_users_fk FOREIGN KEY (user_id) REFERENCES et_users (user_id)
);

CREATE TABLE et_transactions
(
    transaction_id   INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    category_key     INTEGER             NOT NULL,
    user_id          INTEGER             NOT NULL,
    amount           DECIMAL(10, 2) NOT NULL,
    note             VARCHAR(50)         NOT NULL,
    transaction_date bigint              NOT NULL,
    CONSTRAINT trans_cat_fk FOREIGN KEY (category_key) REFERENCES et_categories (category_id),
    CONSTRAINT trans_users_fk FOREIGN KEY (user_id) REFERENCES et_users (user_id)
);
