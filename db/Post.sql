create table PostType
(
  label varchar(50)
);

create table Post
(
  title varchar(50),
  description text,
  price decimal,
  status varchar(50),
  postDate date
) INHERITS (PostType);

create table Demand
(
  itemName varchar(50)
) INHERITS (Post);

create table Offer
(

) INHERITS(Post);

create table Trial
(
  version varchar(50)
) INHERITS(Offer);
