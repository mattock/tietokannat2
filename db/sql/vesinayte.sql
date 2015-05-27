CREATE TABLE vesinayte (
    nayteid int NOT NULL,
    lampotila int,
    sahkonjohtavuus int,
    ph int,
    kokonaisfosfori int,
    kokonaistyppi int,
    hapenkyllastysaste int,
    alkaliniteetti int,
    klorofylli int
);

INSERT INTO vesinayte (nayteid, lampotila, sahkonjohtavuus, ph, kokonaisfosfori, kokonaistyppi, hapenkyllastysaste, alkaliniteetti, klorofylli) VALUES (1, 1.9, 11, 7.3, 23, 550, 91, 0.41, NULL);
INSERT INTO vesinayte (nayteid, lampotila, sahkonjohtavuus, ph, kokonaisfosfori, kokonaistyppi, hapenkyllastysaste, alkaliniteetti, klorofylli) VALUES (2, 19.2, 14.8, 9.2, 150, 1740, 98, NULL, NULL);
INSERT INTO vesinayte (nayteid, lampotila, sahkonjohtavuus, ph, kokonaisfosfori, kokonaistyppi, hapenkyllastysaste, alkaliniteetti, klorofylli) VALUES (3, 18.4, 15.1, 8.5, 98, 1200, 108, 0.79, 92);
INSERT INTO vesinayte (nayteid, lampotila, sahkonjohtavuus, ph, kokonaisfosfori, kokonaistyppi, hapenkyllastysaste, alkaliniteetti, klorofylli) VALUES (4, 5.5, 9, 7.4, 8, 470, NULL, NULL, 6.4);
INSERT INTO vesinayte (nayteid, lampotila, sahkonjohtavuus, ph, kokonaisfosfori, kokonaistyppi, hapenkyllastysaste, alkaliniteetti, klorofylli) VALUES (5,15.3,11,7.3,27,470,81,NULL,6.7);
 
ALTER TABLE vesinayte
    ADD CONSTRAINT vesinayte_pkey PRIMARY KEY (nayteid);
