create type product_category as enum ( 'Electronics','Shoes');
create type product_sub_type as enum ('RADIO', 'TELEVISION', 'SPORT', 'FORMAL');

create table shop
(
    id   serial primary key,
    name varchar(50) unique not null,
    url  varchar(50) unique not null
);
create table customer
(
    id       serial primary key,
    username varchar(20) unique not null,
    password varchar(20)        not null
);
create table product
(
    id               serial primary key,
    name             varchar(50) unique not null,
    product_category product_category   not null,
    product_sub_type product_sub_type   not null,
    price            double precision,
    countInShop      int
);
create table cart
(
    id          serial primary key,
    customer_id int references customer (id)
);
create table cart_item
(
    id serial primary key,
    cart_id int references cart(id),
    product_id int references product(id),
    count_in_cart int
)




