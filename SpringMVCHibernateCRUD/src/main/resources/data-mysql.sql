create table DataBank(id number auto increment, token varchar2, int weitage);
insert into DataBank(token, weitage) values ('happy',9);
insert into DataBank(token, weitage) values ('nice',8);
insert into DataBank(token, weitage) values ('bad',1);
insert into DataBank(token, weitage) values ('horrible',1);
insert into DataBank(token, weitage) values ('good',5);

insert into token_words (Token,weightage) values('best',5);
insert into token_words (Token,weightage) values('good',4);
insert into token_words (Token,weightage) values('ok',3);
insert into token_words (Token,weightage) values('bad',2);
insert into token_words (Token,weightage) values('worst',1);