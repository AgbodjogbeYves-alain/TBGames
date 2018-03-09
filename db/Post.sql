create table PostType
(
  label varchar2(50)
);

create table Post
(
  title varchar2(50),
  description text,
  price decimal,
  status varchar2(50),
  postDate date
) INHERITS (PostType);

create table Demand
(
  itemName varchar2(50)
) INHERITS (Post);

create table Offer
(

) INHERITS(Post);

create table Trial
(
  version varchar2(50)
) INHERITS(Offer);
