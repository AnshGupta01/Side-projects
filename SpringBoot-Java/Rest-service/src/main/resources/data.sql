insert into user_details(id,birth_date,name)
values (10002,current_date(),'Ansh');

insert into user_details(id,birth_date,name)
values (10003,current_date(),'Aman');

insert into user_details(id,birth_date,name)
values (10004,current_date(),'DEv');

insert into posts(id, description, user_id)
values (201,'I want padhai',10002);

insert into posts(id, description, user_id)
values (202,'I want nothing',10003);

insert into posts(id, description, user_id)
values (203,'I want',10004);