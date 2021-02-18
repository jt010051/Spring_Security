use data;
create table user (id int (3)  auto_increment not null primary key,
name varchar(20),
email varchar (20),
username varchar (20),
password varchar (20),
 role varchar (20));
 insert into user values (1, 'JT', 'jt@gmail.com', 'jt0100', 'opensesame', 'ADMIN'),
 (2, 'Tom', 'tom@gmail.com', 'tom101', 'opensesame', 'STANDARD'),
 (3, 'Jessie', 'jess@gmail.com', 'jessis808', 'opensesame', 'ADMIN');
 select * from user;
 drop table user;