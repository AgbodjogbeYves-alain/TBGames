create table AbstractRate
(
  rate integer
);

create table UserRate
(

) INHERITS(AbstractRate);

create table ItemRate
(

) INHERITS(AbstractRate);
