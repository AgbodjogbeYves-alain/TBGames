DELETE FROM BUYER;
DELETE FROM EDITOR;
DELETE FROM ACTOR;


insert into Buyer (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor)
  values ('Zetsubou no ou', 'zetsujava@yopmail.com', 'truc', true, false, false, false);

  insert into Buyer (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor)
    values ('Kurogitsune', 'ayakajava@yopmail.com', 'truc', true, false, false, false);

insert into Buyer (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor)
    values ('Yue', 'moonjava@yopmail.com', 'truc', true, false, false, false);

insert into Buyer (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor)
    values ('Madara', 'wolfjava@yopmail.com', 'truc', true, false, false, false);

insert into Buyer (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor)
    values ('Gilgamesh', 'worldjava@yopmail.com', 'truc', true, false, false, false);



insert into Editor (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor, representativeName, validation)
    values ('Mordred Pendragon', 'swordjava@yopmail.com', 'truc', false, false, false, true, 'Shishigo Taiga', true);

insert into Editor (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor, representativeName, validation)
    values ('Astolfo', 'bookjava@yopmail.com', 'truc', false, false, false, true, 'Yggdmillenia Celenicke', false);

insert into Editor (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor, representativeName, validation)
    values ('Kino', 'motorradjava@yopmail.com', 'truc', false, false, false, true, 'Hermes', true);

insert into Editor (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor, representativeName, validation)
    values ('Nagisa Shiota', 'korojava@yopmail.com', 'truc', false, false, false, true, 'Koro Sensei', true);

insert into Editor (username, email, password, isBuyer, isSuperAdmin, isAdministrator, isEditor, representativeName, validation)
    values ('Bolt', 'housekijava@yopmail.com', 'truc', false, false, false, true, 'Diamond Class', false);

INSERT INTO administrator(username,email,password,isbuyer,issuperadmin,isadministrator,iseditor) VALUES
('tbgames','tbgames','truc',false,false,true,false);

INSERT INTO posttype(label) VALUES ('Demand');
INSERT INTO posttype(label) VALUES ('Offer');
INSERT INTO posttype(label) VALUES ('Trial');

INSERT INTO consoletype(brand) VALUES ('PS2');

INSERT INTO console(nameitem,iduser,consoletype) VALUES ('Play Station 2',4,1);

INSERT INTO category(namecategory) VALUES ('Sport');

INSERT INTO game(nameitem,iduser,consoletype,gamecategory) VALUES ('Fifa12',4,1,1);

INSERT INTO itemrate(iditem,rate,idbuyer) VALUES (1,5,1);

itemrate