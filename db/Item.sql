create table AbstractItem
(
  name varchar(50),
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
  nameCategory varchar(50)
);

create table ConsoleType
(
  brand varchar(50)
);
