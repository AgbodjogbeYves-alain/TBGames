
create TABLE Actor
(
  idActor serial PRIMARY KEY,
  username varchar(50),
  email varchar(50),
  password varchar(50),
  isBuyer boolean,
  isSuperAdmin boolean,
  isAdministrator boolean,
  isEditor boolean
);

create TABLE SimpleUser
(
  idSimpleUser serial PRIMARY KEY,
  zipCode varchar(50),
  phoneNumber varchar(20)
) INHERITS (Actor);

create TABLE Administrator
(
 idAdministrator serial PRIMARY KEY
) INHERITS (Actor);

create TABLE SuperAdmin
(
  idSuperAdmin serial PRIMARY KEY
) INHERITS (Administrator);

create TABLE Buyer
(
  idBuyer serial PRIMARY KEY
) INHERITS (SimpleUser);

create TABLE Editor
(
  idEditor serial PRIMARY KEY,
  representativeName varchar(50),
  validation boolean
) INHERITS (SimpleUser);

