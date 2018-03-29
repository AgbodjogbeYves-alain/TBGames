alter table actor add constraint id_unique_user unique (idactor);
alter table post drop constraint post_idactor_fkey;
alter table post add constraint fk_idactor FOREIGN KEY (idactor) REFERENCES actor (idactor);

create table PostType
(
  idPostType serial PRIMARY KEY,
  label varchar(50)
);

create table Post
(
  idPost serial primary key,
  title varchar(50),
  descriptionPost text,
  price decimal,
  status varchar(50),
  postDate date,
  postType serial REFERENCES PostType,
  idactor serial REFERENCES Actor
);

create table Demand
(
  idDemand serial primary KEY,
  itemName varchar(50)
) INHERITS (Post);

create table Offer
(
  idOffer serial primary KEY
) INHERITS(Post);

create table Trial
(
  idTrial serial primary KEY,
  version varchar(50)
) INHERITS(Offer);