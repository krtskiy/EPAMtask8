create table users
(
	id int auto_increment,
	login varchar(10) not null,
	constraint users_pk
		primary key (id)
);
create unique index users_login_uindex
	on users (login);

create table teams
(
	id int auto_increment,
	name varchar(10) not null,
	constraint teams_pk
		primary key (id)
);
create unique index teams_name_uindex
	on teams (name);


