--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: jarvi; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE jarvi (
    jarvitunnus integer NOT NULL,
    nimi character varying(40),
    jarvityyppi character varying(60),
    korkeustaso numeric,
    tilavuus integer,
    pintaala integer,
    keskisyvyys numeric
);


ALTER TABLE jarvi OWNER TO postgres;

--
-- Name: nayte; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE nayte (
    nayteid integer NOT NULL,
    naytteenotin character varying(30),
    naytesyvyys numeric,
    sijaintiid integer,
    naytothetu character varying(12),
    ajankohta date
);


ALTER TABLE nayte OWNER TO postgres;

--
-- Name: sertifioitunaytteenottaja; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sertifioitunaytteenottaja (
    henkilotunnus character varying(12) NOT NULL,
    sertifikaattinumero integer,
    nimi character varying(40)
);


ALTER TABLE sertifioitunaytteenottaja OWNER TO postgres;

--
-- Name: sijainti; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sijainti (
    sijaintiid integer NOT NULL,
    pohjoiskoordinaatti integer,
    itakoordinaatti integer,
    jarvitunnus integer
);


ALTER TABLE sijainti OWNER TO postgres;

--
-- Name: vesinayte; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE vesinayte (
    nayteid integer NOT NULL,
    lampotila numeric,
    sahkonjohtavuus numeric,
    ph numeric,
    kokonaisfosfori integer,
    kokonaistyppi integer,
    hapenkyllastysaste integer,
    alkaliniteetti numeric,
    klorofylli numeric
);


ALTER TABLE vesinayte OWNER TO postgres;

--
-- Data for Name: jarvi; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY jarvi (jarvitunnus, nimi, jarvityyppi, korkeustaso, tilavuus, pintaala, keskisyvyys) FROM stdin;
951101001	Kakskerranjärvi	Pienet ja keskikokoiset vähähumuksiset järvet	7	10372	162	6
340541001	Köyliönjärvi	Runsasravinteiset järvet	41	32574	1245	3
820431001	Littoistenjärvi	Matalat vähähumuksiset järvet	36	2956	146	2
230211001	Lohjanjärvi	Runsasravinteiset järvet	32	1119018	8821	13
340311001	Pyhäjärvi	Suuret vähähumuksiset järvet	45	848686	15532	5
\.


--
-- Data for Name: nayte; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY nayte (nayteid, naytteenotin, naytesyvyys, sijaintiid, naytothetu, ajankohta) FROM stdin;
1	Pullonäytteenotin	9	1	260954-393M	2015-02-22
2	Pullonäytteenotin	8	2	260954-393M	2003-08-11
3	Pullonäytteenotin	9	3	050281-593V	1996-09-02
4	Pullonäytteenotin	11	4	250486-366B	1997-10-22
5	Pullonäytteenotin	15	5	180877-800R	2011-09-21
\.


--
-- Data for Name: sertifioitunaytteenottaja; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sertifioitunaytteenottaja (henkilotunnus, sertifikaattinumero, nimi) FROM stdin;
181168-891S	1111111111	Sven Sevon
250486-366B	1111111112	Mikaela Tallius
260954-393M	1111111113	Anton Willgren
180877-800R	1111111114	Annika Sarin
050281-593V	1111111115	Wilhelm Leanderson
\.


--
-- Data for Name: sijainti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sijainti (sijaintiid, pohjoiskoordinaatti, itakoordinaatti, jarvitunnus) FROM stdin;
1	6704587	3238650	951101001
2	6790064	3248435	340541001
3	6786285	3249866	340541001
4	6780135	3241884	340311001
5	6703485	3235966	951101001
\.


--
-- Data for Name: vesinayte; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY vesinayte (nayteid, lampotila, sahkonjohtavuus, ph, kokonaisfosfori, kokonaistyppi, hapenkyllastysaste, alkaliniteetti, klorofylli) FROM stdin;
1	2	11	7	23	550	91	0	\N
2	19	15	9	150	1740	98	\N	\N
3	18	15	9	98	1200	108	1	92
4	6	9	7	8	470	\N	\N	6
5	15	11	7	27	470	81	\N	7
\.


--
-- Name: jarvi_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY jarvi
    ADD CONSTRAINT jarvi_pkey PRIMARY KEY (jarvitunnus);


--
-- Name: nayte_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY nayte
    ADD CONSTRAINT nayte_pkey PRIMARY KEY (nayteid);


--
-- Name: sertifioitunaytteenottaja_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sertifioitunaytteenottaja
    ADD CONSTRAINT sertifioitunaytteenottaja_pkey PRIMARY KEY (henkilotunnus);


--
-- Name: sijainti_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sijainti
    ADD CONSTRAINT sijainti_pkey PRIMARY KEY (sijaintiid);


--
-- Name: vesinayte_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vesinayte
    ADD CONSTRAINT vesinayte_pkey PRIMARY KEY (nayteid);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

