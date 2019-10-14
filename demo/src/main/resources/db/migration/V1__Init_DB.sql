
SET GLOBAL time_zone = '+2:00';

create table car
(
    id        bigint not null auto_increment,
    class_car varchar(255),
    cost      bigint,
    mark      varchar(255),
    name      varchar(255),
    status    varchar(255),
    primary key (id)
);

create table user_role
(
    user_id bigint not null,
    roles   varchar(255)
);
create table users
(
    id                bigint       not null auto_increment,
    login             varchar(255) not null,
    password          varchar(255) not null,
    registration_date datetime,
    username          varchar(255),
    car_id            bigint,
    primary key (id)
);

alter table users
    add constraint car_user_fk
        foreign key (car_id) references car (id);

alter table user_role
    add constraint user_role_fk
        foreign key (user_id) references users (id);
