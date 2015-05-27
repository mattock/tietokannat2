CREATE TABLE nayte (
    nayteid int NOT NULL,
    naytteenotin varchar(30),
    naytesyvyys int,
    sijaintiid int,
    naytothetu varchar(12),
    ajankohta date
);

INSERT INTO nayte (nayteid, naytteenotin, naytesyvyys, sijaintiid, naytothetu, ajankohta) VALUES (1, 'Pullonäytteenotin', 9.3,  1, '260954-393M', '2015-02-22');
INSERT INTO nayte (nayteid, naytteenotin, naytesyvyys, sijaintiid, naytothetu, ajankohta) VALUES (2, 'Pullonäytteenotin', 7.8,  2, '260954-393M','2003-08-11');
INSERT INTO nayte (nayteid, naytteenotin, naytesyvyys, sijaintiid, naytothetu, ajankohta) VALUES (3, 'Pullonäytteenotin', 8.5,  3, '050281-593V', '1996-09-02');
INSERT INTO nayte (nayteid, naytteenotin, naytesyvyys, sijaintiid, naytothetu, ajankohta) VALUES (4, 'Pullonäytteenotin', 10.7, 4, '250486-366B', '1997-10-22');
INSERT INTO nayte (nayteid, naytteenotin, naytesyvyys, sijaintiid, naytothetu, ajankohta) VALUES (5, 'Pullonäytteenotin', 15,   5, '180877-800R', '2011-09-21');
 
ALTER TABLE nayte
    ADD CONSTRAINT nayte_pkey PRIMARY KEY (nayteid);
