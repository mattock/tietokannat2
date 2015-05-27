CREATE TABLE sijainti (
    sijaintiid int NOT NULL,
    pohjoiskoordinaatti int,
    itakoordinaatti int,
    jarvitunnus int
);

INSERT INTO sijainti (sijaintiid, pohjoiskoordinaatti, itakoordinaatti, jarvitunnus) VALUES (1, 6704587, 3238650, 951101001);
INSERT INTO sijainti (sijaintiid, pohjoiskoordinaatti, itakoordinaatti, jarvitunnus) VALUES (2, 6790064, 3248435, 340541001);
INSERT INTO sijainti (sijaintiid, pohjoiskoordinaatti, itakoordinaatti, jarvitunnus) VALUES (3, 6786285, 3249866, 340541001);
INSERT INTO sijainti (sijaintiid, pohjoiskoordinaatti, itakoordinaatti, jarvitunnus) VALUES (4, 6780135, 3241884, 340311001);
INSERT INTO sijainti (sijaintiid, pohjoiskoordinaatti, itakoordinaatti, jarvitunnus) VALUES (5, 6703485, 3235966, 951101001);
 
ALTER TABLE sijainti
    ADD CONSTRAINT sijainti_pkey PRIMARY KEY (sijaintiid);
