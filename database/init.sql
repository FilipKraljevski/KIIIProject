create table user_activities
(
    id          bigserial primary key,
    first_name  varchar(255) not null,
    first_name  varchar(255) not null
)

create table activities
(
    id               bigserial primary key,
    date_time        timestamp not null,
    time_spent       bigint not null,
    description      varchar(255) not null,
    id_user_activity bigint not null,
    constraint fk_user_activity foreign key (id_user_activity) references (id)
)