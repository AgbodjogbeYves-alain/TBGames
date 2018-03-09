create TABLE Actor
(
  username varchar(50),
  email varchar(50),
  password varchar(50)
);

create TABLE SimpleUser
(
    zipCode varchar(50),
    phoneNumber varchar(20)
) INHERITS (Actor);

create TABLE Administrator
(

) INHERITS (Actor);

create TABLE SuperAdmin
(

) INHERITS (Administrator);

create TABLE Buyer
(

) INHERITS (SimpleUser);

create TABLE Editor
(
  representativeName varchar(50),
  validation boolean
) INHERITS (SimpleUser);
