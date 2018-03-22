create table Category
(
  idCategory serial PRIMARY KEY,
  nameCategory varchar(50)
);

create table ConsoleType
(
  idConsoleType serial PRIMARY KEY,
  brand varchar(50)
);


create table AbstractItem
(
  idItem serial PRIMARY KEY,
  nameItem varchar(50),
  ratingItem integer,
  idUser serial REFERENCES SimpleUser,
  consoleType serial REFERENCES ConsoleType
);

create table Game
(
  idGame serial Primary KEY,
  description text,
  gameCategory serial REFERENCES Category
) INHERITS(AbstractItem);

create table Console
(
  idConsole serial PRIMARY Key
) INHERITS(AbstractItem);



