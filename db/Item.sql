create table AbstractItem
(
  name varchar2(50),
  rating integer
);

create table Game
(
  description text
) INHERITS(AbstractItem);

create table Console
(

) INHERITS(AbstractItem);

create table Category
(
  nameCategory varchar2(50)
);

create table ConsoleType
(
  brand varchar2(50)
);
