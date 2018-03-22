create table AbstractRate
(
  rate integer PRIMARY KEY
);

create table UserRate
(
  idUser serial REFERENCES SimpleUser,
  idBuyer serial REFERENCES Buyer

) INHERITS(AbstractRate);

create table ItemRate
(
  idItem serial REFERENCES AbstractItem,
  idBuyer serial REFERENCES Buyer
) INHERITS(AbstractRate);

