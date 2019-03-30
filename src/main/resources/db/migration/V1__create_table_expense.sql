create table expense (
  id varchar2(64),
  description varchar2(256) not null,
  constraint pk_expense primary key (id)
)
