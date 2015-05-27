CREATE TABLE sertifioitunaytteenottaja (
    henkilotunnus varchar(12),
    sertifikaattinumero int,
    nimi varchar(40)
);

INSERT INTO sertifioitunaytteenottaja (henkilotunnus, sertifikaattinumero, nimi) VALUES ( '181168-891S', 1111111111, 'Sven Sevon');
INSERT INTO sertifioitunaytteenottaja (henkilotunnus, sertifikaattinumero, nimi) VALUES ( '250486-366B', 1111111112, 'Mikaela Tallius');
INSERT INTO sertifioitunaytteenottaja (henkilotunnus, sertifikaattinumero, nimi) VALUES ( '260954-393M', 1111111113, 'Anton Willgren');
INSERT INTO sertifioitunaytteenottaja (henkilotunnus, sertifikaattinumero, nimi) VALUES ( '180877-800R', 1111111114, 'Annika Sarin');
INSERT INTO sertifioitunaytteenottaja (henkilotunnus, sertifikaattinumero, nimi) VALUES ( '050281-593V', 1111111115, 'Wilhelm Leanderson');

ALTER TABLE sertifioitunaytteenottaja
    ADD CONSTRAINT sertifioitunaytteenottaja_pkey PRIMARY KEY (henkilotunnus);
