--liquibase formatted sql
--changeset datafill:fill_tables

insert into t_people(id, full_name, pin)
values(123,'anita', '0000000000');
insert into t_people(id, full_name, pin)
values(12,'Aanita', '0000000020');
insert into t_people(id, full_name, pin)
values(13,'aaniita', '0000030000');
insert into t_people(id, full_name, pin)
values(14,'aniita', '0000400000');
insert into t_people(id, full_name, pin)
values(15,'annitaa', '0000050000');
insert into t_people(id, full_name, pin)
values(16,'annitta', '0006000000');
insert into t_people(id, full_name, pin)
values(17,'anita', '0000007000');

INsert into t_addresses( t_people_id,addr_type,addr_info)
values(123,'aaa','abc');
INsert into t_addresses( t_people_id,addr_type,addr_info)
values(12,'bbb','bbb');
INsert into t_addresses(t_people_id,addr_type,addr_info)
values(13,'ccc','ccc');
INsert into t_addresses(t_people_id,addr_type,addr_info)
values(14,'ddd','ddd');
INsert into t_addresses(t_people_id,addr_type,addr_info)
values(15,'eee','eee');
INsert into t_addresses(t_people_id,addr_type,addr_info)
values(16,'fff','fff');

insert into t_mails( t_people_id, mail_type,mail)
values(123,'abv','abv@abv.bg');
insert into t_mails( t_people_id, mail_type,mail)
values(12,'gmail','gmail@gmail.com');
insert into t_mails( t_people_id, mail_type,mail)
values(13,'yahoo','yahoo@yahoo.com');
insert into t_mails( t_people_id, mail_type,mail)
values(14,'abv','abv2abv@abv.bg');
insert into t_mails( t_people_id, mail_type,mail)
values(15,'gmail','gmail2gmail@gmail.com');
insert into t_mails( t_people_id, mail_type,mail)
values(16,'yahoo','yahoo2yahoo@yahoo.com');
insert into t_mails( t_people_id, mail_type,mail)
values(17,'abv','abv@gmail.com');
