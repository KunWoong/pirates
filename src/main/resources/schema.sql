create sequence hibernate_sequence start with 1 increment by 1
create sequence store_seq start with 1 increment by 1
create table business_time (id integer not null, close varchar(255), day integer, open varchar(255), store_id integer, primary key (id))
create table holiday (id integer not null, day varchar(255), store_id integer, primary key (id))
create table store (id integer not null, address varchar(255), description varchar(255), level integer not null, name varchar(255), owner varchar(255), phone varchar(255), primary key (id))
alter table business_time add constraint business_time_fk_constraint foreign key (store_id) references store
alter table holiday add constraint holiday_fk_constraint foreign key (store_id) references store