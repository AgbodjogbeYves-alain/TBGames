create TABLE Actor
(
  username varchar2(50),
  email varchar2(50),
  password varchar2(50)
);

create TABLE User
(
    zipCode varchar2(50),
    phoneNumber varchar2(20)
) INHERITS (Actor);

create TABLE Administrator
(

) INHERITS (Actor);

create TABLE SuperAdmin
(

) INHERITS (Administrator);

create TABLE Buyer
(

) INHERITS (User);

create TABLE Editor
(
  representativeName varchar2(50),
  validation boolean
) INHERITS (User);
