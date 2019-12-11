
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1000 increment by 1;


insert into categoria (id, nombre) values (1, 'Comida');
insert into categoria (id, nombre) values (2, 'Bebida');
insert into categoria (id, nombre) values (3, 'Complementos');

insert into producto (id, nombre, precio, categoria_id, imagen) values (1, 'Juice - Orange, Concentrate', 91, 2, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (2, 'Beef - Ground, Extra Lean, Fresh', 87, 1, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (3, 'Cheese - Parmesan Grated', 39, 1, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (4, 'Cups 10oz Trans', 67, 1, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (5, 'Wine - Beringer Founders Estate', 27, 2, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (6, 'Bread - Wheat Baguette', 82, 2, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (7, 'Quail - Eggs, Fresh', 3, 2, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (8, 'Cheese - Mascarpone', 97, 2, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (9, 'Mace', 25, 2, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (10, 'Oil - Shortening - All - Purpose', 63, 2, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (11, 'Marjoram - Fresh', 60, 2, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (12, 'Turnip - White', 74, 2, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (13, 'Pork Salted Bellies', 38, 2, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (14, 'Longos - Greek Salad', 15, 2, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (15, 'Amaretto', 85, 2, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (16, 'Godiva White Chocolate', 97, 2, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (17, 'Tomatoes - Roma', 61, 2, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (18, 'Oven Mitt - 13 Inch', 1, 3, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (19, 'Vermouth - White, Cinzano', 72, 2, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (20, 'Club Soda - Schweppes, 355 Ml', 38, 2, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (21, 'Fenngreek Seed', 1, 1, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (22, 'Dill Weed - Dry', 72, 1, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (23, 'Pepper - Green', 56, 1, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (24, 'Bacardi Breezer - Tropical', 35, 2, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (25, 'Wine - Merlot Vina Carmen', 14, 2, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (26, 'Sauce - Black Current, Dry Mix', 9, 1, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (27, 'Crab - Soft Shell', 17, 1, 'http://dummyimage.com/133x134.bmp/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (28, 'Jameson Irish Whiskey', 19, 2, 'http://dummyimage.com/245x246.jpg/dddddd/000000');
insert into producto (id, nombre, precio, categoria_id, imagen) values (29, 'Muffin Chocolate Individual Wrap', 77, 1, 'http://dummyimage.com/139x103.bmp/5fa2dd/ffffff');
insert into producto (id, nombre, precio, categoria_id, imagen) values (30, 'Mussels - Frozen', 95, 1, 'http://dummyimage.com/206x125.bmp/cc0000/ffffff');

-- Contraseña: Admin1
insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at) 
values (1, 'Admin admin', 'admin@openwebinars.net','admin','$2a$10$vPaqZvZkz6jhb7U7k/V/v.5vprfNdOnh4sxi/qpPRkYTzPmFlI9p2','https://api.adorable.io/avatars/285/admin@openwebinars.net.png',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (1,'USER');
insert into user_entity_roles (user_entity_id, roles) values (1,'ADMIN');


-- Contraseña: Marialopez1
insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at) 
values (2, 'María López', 'maria.lopez@openwebinars.net','marialopez','$2a$10$3i95KIxdl8igcpDby.URMOgwdDR2q9UaSfor2kJJrhAPfNOC/HMSi','https://api.adorable.io/avatars/285/maria.lopez@openwebinars.net.png',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (2,'USER');

-- Contraseña: Angelmartinez1
insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at) 
values (3, 'Ángel Martínez', 'angel.martinez@openwebinars.net','angelmartinez','$2a$10$37IEM6zzuwXqFrotYDtySOKITKfeNWR3NBRqcM7JYWnBDIaq9ByZm','https://api.adorable.io/avatars/285/angel.martinez@openwebinars.net.png',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (3,'USER');

-- Contraseña: Anajimenez1
insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at) 
values (4, 'Ana Jiménez', 'ana.jimenez@openwebinars.net','anajimenez','$2a$10$k0om5gtNBheWX54VzD1E0etCnqC0xChHjfW3lOXaeCpN5ST1vVGYm','https://api.adorable.io/avatars/285/ana.jimenez@openwebinars.net.png',CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_entity_roles (user_entity_id, roles) values (4,'USER');


insert into pedido (id, cliente_id, fecha) values (1, 2, CURRENT_TIMESTAMP);
insert into linea_pedido (id, producto_id, precio, cantidad, pedido_id) values (1, 1, 91, 1, 1);
insert into linea_pedido (id, producto_id, precio, cantidad, pedido_id) values (2, 2, 87, 3, 1);
insert into linea_pedido (id, producto_id, precio, cantidad, pedido_id) values (3, 29, 77, 2, 1);


insert into pedido (id, cliente_id, fecha) values (2, 3, CURRENT_TIMESTAMP);
insert into linea_pedido (id, producto_id, precio, cantidad, pedido_id) values (4, 19, 72, 3, 2);
insert into linea_pedido (id, producto_id, precio, cantidad, pedido_id) values (5, 28, 19, 2, 2);

insert into pedido (id, cliente_id, fecha) values (3, 4, CURRENT_TIMESTAMP);
insert into linea_pedido (id, producto_id, precio, cantidad, pedido_id) values (6, 9, 25, 1, 3);
insert into linea_pedido (id, producto_id, precio, cantidad, pedido_id) values (7, 13, 38, 5, 3);
insert into linea_pedido (id, producto_id, precio, cantidad, pedido_id) values (8, 22, 72, 1, 3);


insert into lote (id, nombre) values (1, 'Lote 1');
insert into lote_productos (lote_id, producto_id) values (1, 1);
insert into lote_productos (lote_id, producto_id) values (1, 2);
insert into lote_productos (lote_id, producto_id) values (1, 3);
insert into lote_productos (lote_id, producto_id) values (1, 4);

insert into lote (id, nombre) values (2, 'Lote 2');
insert into lote_productos (lote_id, producto_id) values (2, 1);
insert into lote_productos (lote_id, producto_id) values (2, 11);
insert into lote_productos (lote_id, producto_id) values (2, 12);
insert into lote_productos (lote_id, producto_id) values (2, 13);
insert into lote_productos (lote_id, producto_id) values (2, 14);

insert into lote (id, nombre) values (3, 'Lote 3');
insert into lote_productos (lote_id, producto_id) values (3, 21);
insert into lote_productos (lote_id, producto_id) values (3, 22);
insert into lote_productos (lote_id, producto_id) values (3, 23);
insert into lote_productos (lote_id, producto_id) values (3, 24);


