-- supplier
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8001, 'Grommet Builders', 'Local', '788 30th St., SE, Calgary', 'Fred', '4032125692');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8002, 'Pong Works', 'Local', '749 Dufferin Blvd., SE, Calgary', 'Bart', '4032125702');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8003, 'Wiley Inc.', 'Local', '26 40th St., SE, Calgary', 'BillyBob', '4032125712');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8004, 'Winork Manufacturing Inc.', 'Local', '156 51st Ave., SE, Calgary', 'Marty', '4032125722');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8005, 'Grab Bag Inc.', 'Local', '138 42nd Ave., NE, Calgary', 'Monty', '4032125732');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8006, 'Paddy''s Manufacturing', 'Local', '311 McCall Way, NE, Calgary', 'Barney', '4032125742');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8007, 'Smickles Industries', 'Local', '966 Smed Lane, SE, Calgary', 'Lisa', '4032125752');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8008, 'Thangs Inc.', 'Local', '879 37th Ave., NE, Calgary', 'Thelma', '4032125762');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8009, 'Flip Works Inc.', 'Local', '472 Ogden Dale Rd., SE, Calgary', 'Rory', '4032125772');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8010, 'Irkle Industries', 'Local', '754 Sunridge Way, NE, Calgary', 'Irma', '4032125782');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8011, 'Biff Builders', 'Local', '690 19th St., NE, Calgary', 'Borjn', '4032125792');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8012, 'Twinkles Inc.', 'Local', '318 29th St.,NE, Calgary', 'Barkley', '4032125802');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8013, 'Piddles Industries', 'Local', '238 112th Ave., NE, Calgary', 'Parnell', '4032125812');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8014, 'Tic Tac Manufacturing', 'Local', '598 Palmer Rd., NE, Calgary', 'Teisha', '4032125822');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8015, 'Knock Knock Inc.', 'Local', '363 42nd Ave., NE, Calgary', 'Ned', '4032125832');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8016, 'Corky Things Inc.', 'Local', '35 McCall Way, NE, Calgary', 'Corrine', '4032125842');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8017, 'E & O Industries', 'Local', '883 44th St., SE, Calgary', 'Stan', '4032125852');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8018, 'Fiddleys Makes Stuff Inc.', 'Local', '350 27th St., NE, Calgary', 'Fredda', '4032125862');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8019, 'Horks and Stuff Manufacturing', 'Local', '997 42nd Ave., NE, Calgary', 'Harold', '4032125872');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8020, 'Wings Works', 'Local', '754 48th St., SE, Calgary', 'Wing', '4032125882');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8021, 'Busy Bee Tool', 'Local', '2611 Hopewell Pl NE, Calgary', 'Bob', '4032125892');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8022, 'Ken ltd', 'International', '488 Danxia Street,Hefei', 'Jing', '4032125902');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8023, 'PC One', 'Internationall', '1234 Sesame ST NW', 'Stan', '4035642569');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8024, 'Gamers United', 'Local', '1234 Sesame ST NW', 'Stan', '4035642569');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8091, 'Raspberry Shop', 'Local', '3410  Coburn Hollow Road', 'Jessie', '4030012985');
INSERT INTO ToolShopDemoDB.SUPPLIER (SupplierID, Name, Type, Address, CName, Phone) VALUES (8092, 'Refactory Shop', 'Local', '3410  Coburn Hollow Road', 'Steve Nam', '4030012985');

-- tool
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1000, 'Knock Bitzzz', 'Electric', 120, 15, 8004);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1001, 'Widgets', 'Non_Electric', 50, 35.5, 8004);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1002, 'Grommets', 'Non_Electric', 50, 23.45, 8001);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1003, 'Wedges', 'Non_Electric', 50, 10.15, 8020);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1004, 'Wing Bats', 'Non_Electric', 50, 11.25, 8003);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1005, 'Twinkies', 'Non_Electric', 75, 15.75, 8012);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1006, 'Wiggles', 'Non_Electric', 50, 12.34, 8020);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1007, 'Bing Bobs', 'Non_Electric', 50, 2.39, 8005);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1008, 'Wog Wits', 'Non_Electric', 300, 19.99, 8004);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1009, 'Barney Bits', 'Non_Electric', 50, 23.59, 8006);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1010, 'Willie Widgits', 'Non_Electric', 89, 12.99, 8003);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1011, 'Barge Bogs', 'Non_Electric', 50, 2.99, 8011);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1012, 'Poggy Pogs', 'Non_Electric', 99, 1.1, 8002);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1013, 'Pardle Pins', 'Non_Electric', 400, 0.69, 8013);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1014, 'Piddley Wicks', 'Non_Electric', 54, 5.19, 8013);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1015, 'Iggy Orks', 'Non_Electric', 50, 49.95, 8010);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1016, 'Crank Cribs', 'Non_Electric', 888, 0.29, 8005);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1017, 'Thingies', 'Non_Electric', 67, 45.98, 8008);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1018, 'Orf Dappers', 'Non_Electric', 50, 19.98, 8018);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1019, 'Piff Knocks', 'Non_Electric', 82, 4.95, 8002);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1020, 'Knit Piks', 'Non_Electric', 66, 6.75, 8015);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1021, 'Piddley Pins', 'Non_Electric', 370, 0.25, 8020);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1022, 'Tic Tocs', 'Non_Electric', 87, 1.36, 8014);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1023, 'Tin Wits', 'Non_Electric', 50, 5.67, 8014);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1024, 'Thinga-ma-bobs', 'Non_Electric', 40, 10.98, 8012);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1025, 'Fling Flobs', 'Non_Electric', 254, 2.33, 8009);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1026, 'Barn Bins', 'Non_Electric', 45, 88.67, 8006);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1027, 'Flap Wrappers', 'Non_Electric', 89, 44.88, 8009);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1028, 'Pong Pangs', 'Non_Electric', 2345, 0.1, 8002);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1029, 'Oof Tongs', 'Non_Electric', 345, 8.49, 8011);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1030, 'Nic Nacs', 'Non_Electric', 238, 2.99, 8015);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1031, 'Tork Tins', 'Non_Electric', 376, 0.95, 8012);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1032, 'Lilly Larks', 'Non_Electric', 56, 12.99, 8007);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1033, 'Minnie Morks', 'Non_Electric', 800, 1.95, 8007);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1034, 'Cork Handles', 'Non_Electric', 654, 2.66, 8016);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1035, 'Ding Darns', 'Non_Electric', 1208, 0.15, 8019);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1036, 'Erk Orks', 'Non_Electric', 498, 3.99, 8017);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1037, 'Foo Figs', 'Non_Electric', 234, 5.89, 8018);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1038, 'Googly Eyes', 'Non_Electric', 756, 6.99, 8001);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1039, 'Handy Pandies', 'Non_Electric', 298, 4.35, 8017);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1040, 'Inny Outies', 'Non_Electric', 219, 3.45, 8010);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1041, 'Cordless Drill', 'Electric', 40, 200, 8022);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1042, 'Circular Saw', 'Electric', 42, 300, 8022);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1094, 'Tester', 'Electric', 50, 150, 8022);
INSERT INTO ToolShopDemoDB.TOOL (ToolID, Name, Type, Quantity, Price, SupplierID) VALUES (1095, 'Heavy Duty Blower', 'Electric', 49, 150, 8022);


-- client
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17561, 'White', 'Teressa', 'Residential', '4030012891', '289  Sweetwood Drive', 'T1X 0L3');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17562, 'sTANNN', 'lEEEE', 'Residential', '4039996666', '7899  Washington Street', 'T1X 0L4');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17564, 'Cena', 'Moe', 'Residential', '4030012927', '3410  Coburn Hollow Road', 'T1X 0L6');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17565, 'Kang', 'Khaled', 'Residential', '4030012937', '2223  Washington Street', 'T1X 1E1');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17566, 'Xing', 'Omar', 'Residential', '4030012953', '2775  Colonial Drive', 'T1X 1G3');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17567, 'Simmon', 'Jing', 'Commercial', '4030012961', '3120  Euclid Avenue', 'T1X 1G4');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17568, 'Boggs', 'Jacob', 'Commercial', '4030012967', '3012  Fannie Street', 'T1X 1G5');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17569, 'Voss', 'Edward', 'Residential', '4030012985', '3009  Fannie Street', 'T1X 0L6');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17570, 'Walter', 'White', 'Residential', '4030012985', '3410  Coburn Hollow Road', '0X0 OYO');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17571, 'Black', 'Teressa', 'Residential', '4030012891', '289  Sweetwood Drive', 'T1X 1G4');
INSERT INTO ToolShopDemoDB.CLIENT (ClientID, LName, FName, Type, PhoneNum, Address, PostalCode) VALUES (17572, 'Smith', 'Mike', 'Residential', '4030012907', '2378  Riverside Drive', 'T1X 0L5');


-- order
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (10031, '2020-11-20 10:03:30');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (10218, '2020-11-21 03:00:11');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (15203, '2020-11-23 09:18:06');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (17000, '2020-11-20 10:10:39');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (17622, '2020-11-20 10:07:15');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (18072, '2020-11-20 10:03:48');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (18087, '2020-11-20 10:00:37');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (18188, '2020-11-20 11:24:23');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (18276, '2020-11-21 03:07:40');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (18438, '2020-11-20 10:47:42');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (20198, '2020-11-21 03:42:47');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (20265, '2020-11-21 03:01:27');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (20729, '2020-11-20 10:06:08');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (23450, '2020-11-20 11:27:29');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (24361, '2020-11-24 08:31:16');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (26053, '2020-11-20 11:13:22');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (27050, '2020-11-21 03:48:25');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (27051, '2020-11-20 11:24:23');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (27052, '2020-11-20 11:24:23');
INSERT INTO ToolShopDemoDB.ORDER_ (OrderID, Date) VALUES (29647, '2020-11-23 09:18:04');


-- orderLine
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (10218, 1000, 8015, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (15203, 1000, 8015, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18188, 1000, 8015, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18276, 1000, 8015, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1001, 8004, 40);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1002, 8001, 30);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1003, 8020, 35);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1004, 8003, 39);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1006, 8020, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1007, 8005, 25);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1009, 8006, 29);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1011, 8011, 15);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1015, 8010, 28);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1018, 8018, 18);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1023, 8014, 27);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1041, 8022, 40);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (18438, 1042, 8022, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (20198, 1000, 8015, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (20265, 1000, 8015, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (23450, 1000, 8015, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (24361, 1041, 8022, 41);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (26053, 1000, 8015, 22);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (27050, 1000, 8015, 20);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (27051, 1001, 8014, 15);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (27052, 1001, 8014, 15);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (29647, 1094, 8022, 30);
INSERT INTO ToolShopDemoDB.ORDERLINE (OrderID, ToolID, SupplierID, Quantity) VALUES (29647, 1095, 8022, 30);

-- purchase
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-20 11:13:22');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-20 11:24:23');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-20 11:27:29');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-21 03:00:11');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-21 03:01:27');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-21 03:07:39');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-21 03:42:47');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-21 03:48:25');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1000, '2020-11-23 09:18:05');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1000, '2020-11-23 20:56:51');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1000, '2020-11-23 20:56:57');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17564, 1001, '2020-11-21 03:07:39');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17572, 1001, '2020-11-21 03:07:39');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1034, '2020-11-25 16:59:16');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1038, '2020-11-23 23:39:32');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17562, 1039, '2020-11-24 01:41:04');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1039, '2020-11-24 01:42:18');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1041, '2020-11-25 00:39:06');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1041, '2020-11-23 21:00:03');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1042, '2020-11-25 17:03:08');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1094, '2020-11-23 20:58:27');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17561, 1095, '2020-11-24 13:11:48');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1095, '2020-11-23 23:40:30');
INSERT INTO ToolShopDemoDB.PURCHASE (ClientID, ToolID, Date) VALUES (17569, 1095, '2020-11-25 17:00:24');

-- electrical
INSERT INTO ToolShopDemoDB.ELECTRICAL (ToolID, PowerType) VALUES (1041, 'USB');
INSERT INTO ToolShopDemoDB.ELECTRICAL (ToolID, PowerType) VALUES (1094, 'Battery');


-- international
INSERT INTO ToolShopDemoDB.INTERNATIONAL (SupplierID, ImportTax) VALUES (8023, 0.05);
INSERT INTO ToolShopDemoDB.INTERNATIONAL (SupplierID, ImportTax) VALUES (8091, 200);

-- user
INSERT INTO ToolShopDemoDB.USER (username, password) VALUES ('user01', 'hello123');