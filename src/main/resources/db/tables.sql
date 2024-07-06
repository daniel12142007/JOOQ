create table if not exists users
(
    id       serial primary key,
    username varchar(80) not null unique,
    email    varchar(50) not null unique,
    age      smallint    not null
);
create table if not exists friends
(
    user_one bigint,
    user_two bigint,
    primary key (user_one, user_two),
    foreign key (user_one) references users (id),
    foreign key (user_two) references users (id),
    constraint unique_user_friend unique (user_one, user_two)
);