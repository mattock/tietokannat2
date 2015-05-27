CREATE TABLE jarvi (
    jarvitunnus int NOT NULL,
    nimi varchar(40),
    jarvityyppi varchar(60),
    korkeustaso int,
    tilavuus int,
    pintaala int,
    keskisyvyys int
);

INSERT INTO jarvi (jarvitunnus, nimi, jarvityyppi, korkeustaso, tilavuus, pintaala, keskisyvyys) VALUES ( 951101001, 'Kakskerranjärvi', 'Pienet ja keskikokoiset vähähumuksiset järvet' , 6.9, 10372, 162, 6.38 );
INSERT INTO jarvi (jarvitunnus, nimi, jarvityyppi, korkeustaso, tilavuus, pintaala, keskisyvyys) VALUES ( 340541001, 'Köyliönjärvi' ,'Runsasravinteiset järvet', 40.5, 32574, 1245, 2.62 );
INSERT INTO jarvi (jarvitunnus, nimi, jarvityyppi, korkeustaso, tilavuus, pintaala, keskisyvyys) VALUES ( 820431001, 'Littoistenjärvi', 'Matalat vähähumuksiset järvet', 35.6, 2956, 146, 2.03 );
INSERT INTO jarvi (jarvitunnus, nimi, jarvityyppi, korkeustaso, tilavuus, pintaala, keskisyvyys) VALUES ( 230211001, 'Lohjanjärvi', 'Runsasravinteiset järvet', 31.6, 1119018, 8821, 12.68 );
INSERT INTO jarvi (jarvitunnus, nimi, jarvityyppi, korkeustaso, tilavuus, pintaala, keskisyvyys) VALUES ( 340311001, 'Pyhäjärvi', 'Suuret vähähumuksiset järvet', 44.9, 848686, 15532, 5.47 );

ALTER TABLE jarvi
    ADD CONSTRAINT jarvi_pkey PRIMARY KEY (jarvitunnus);
