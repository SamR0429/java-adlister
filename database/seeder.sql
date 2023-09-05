use adlister_db;

insert into users (username, email, password) values
 ('sam', 'sam@email.com', 'password');

insert into ads (user_id, title, description) values
(1, 'test add one', 'description for add'),
(1, 'test add two', 'description for add'),
(1, 'test add three', 'description for add'),
(1, 'test add four', 'description for add'),
(1, 'test add five', 'description for add');