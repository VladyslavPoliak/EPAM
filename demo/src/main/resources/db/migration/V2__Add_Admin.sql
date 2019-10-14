insert into users (id, login, password, username)
    values (1, 'admin', '123', 'username');

insert into user_role(user_id, roles)
    values (1,'USER'), (1,'ADMIN');
