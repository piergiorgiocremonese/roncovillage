--
-- PostgreSQL database dump
--

-- Dumped from database version 8.4.17
-- Dumped by pg_dump version 9.3.17
-- Started on 2017-06-29 12:39:04 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 156 (class 1259 OID 150218)
-- Name: allegati; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE allegati (
    oid integer NOT NULL,
    nome character varying,
    path character varying,
    descrizione character varying,
    mime character varying,
    creazione timestamp with time zone DEFAULT now(),
    ragazzo_oid integer,
    tipo character varying,
    url character varying,
    image bytea
);


ALTER TABLE public.allegati OWNER TO postgres;

--
-- TOC entry 155 (class 1259 OID 150216)
-- Name: allegati_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE allegati_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.allegati_oid_seq OWNER TO postgres;

--
-- TOC entry 1932 (class 0 OID 0)
-- Dependencies: 155
-- Name: allegati_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE allegati_oid_seq OWNED BY allegati.oid;


--
-- TOC entry 140 (class 1259 OID 150095)
-- Name: giornate; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE giornate (
    oid integer NOT NULL,
    giorno timestamp without time zone,
    periodo_oid integer
);


ALTER TABLE public.giornate OWNER TO postgres;

--
-- TOC entry 160 (class 1259 OID 166481)
-- Name: gruppi_foto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE gruppi_foto (
    oid integer NOT NULL,
    nome character varying,
    icona character varying,
    numero integer,
    url character varying,
    cartella character varying,
    path character varying,
    webpath character varying,
    album character varying,
    anno character varying,
    icona_path character varying
);


ALTER TABLE public.gruppi_foto OWNER TO postgres;

--
-- TOC entry 159 (class 1259 OID 166479)
-- Name: gruppi_foto_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE gruppi_foto_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.gruppi_foto_oid_seq OWNER TO postgres;

--
-- TOC entry 1933 (class 0 OID 0)
-- Dependencies: 159
-- Name: gruppi_foto_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE gruppi_foto_oid_seq OWNED BY gruppi_foto.oid;


--
-- TOC entry 158 (class 1259 OID 150237)
-- Name: pagamenti; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE pagamenti (
    oid integer NOT NULL,
    amount double precision,
    tipo character varying,
    data timestamp with time zone,
    riferimento character varying,
    fattura_emessa boolean DEFAULT false,
    fattura character varying,
    anno integer,
    ragazzo_oid integer,
    completo boolean DEFAULT false,
    numero integer,
    causale text
);


ALTER TABLE public.pagamenti OWNER TO postgres;

--
-- TOC entry 157 (class 1259 OID 150235)
-- Name: pagamenti_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE pagamenti_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pagamenti_oid_seq OWNER TO postgres;

--
-- TOC entry 1934 (class 0 OID 0)
-- Dependencies: 157
-- Name: pagamenti_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE pagamenti_oid_seq OWNED BY pagamenti.oid;


--
-- TOC entry 141 (class 1259 OID 150098)
-- Name: partecipanti; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE partecipanti (
    oid integer NOT NULL,
    periodo_oid integer,
    ragazzo_oid integer,
    tipo_oid integer,
    stato boolean DEFAULT false
);


ALTER TABLE public.partecipanti OWNER TO postgres;

--
-- TOC entry 142 (class 1259 OID 150101)
-- Name: partecipanti_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE partecipanti_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.partecipanti_oid_seq OWNER TO postgres;

--
-- TOC entry 1935 (class 0 OID 0)
-- Dependencies: 142
-- Name: partecipanti_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE partecipanti_oid_seq OWNED BY partecipanti.oid;


--
-- TOC entry 143 (class 1259 OID 150103)
-- Name: periodi; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE periodi (
    oid integer NOT NULL,
    ordine character varying,
    inizio timestamp with time zone,
    fine timestamp with time zone,
    anno character varying
);


ALTER TABLE public.periodi OWNER TO postgres;

--
-- TOC entry 144 (class 1259 OID 150109)
-- Name: periodi_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE periodi_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.periodi_oid_seq OWNER TO postgres;

--
-- TOC entry 1936 (class 0 OID 0)
-- Dependencies: 144
-- Name: periodi_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE periodi_oid_seq OWNED BY periodi.oid;


--
-- TOC entry 146 (class 1259 OID 150114)
-- Name: presenze_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE presenze_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.presenze_oid_seq OWNER TO postgres;

--
-- TOC entry 1937 (class 0 OID 0)
-- Dependencies: 146
-- Name: presenze_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE presenze_oid_seq OWNED BY giornate.oid;


--
-- TOC entry 145 (class 1259 OID 150111)
-- Name: presenze; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE presenze (
    ragazzo_oid integer NOT NULL,
    completo boolean,
    mensa boolean,
    mattina boolean,
    pomeriggio boolean,
    giorno timestamp with time zone,
    oid integer DEFAULT nextval('presenze_oid_seq'::regclass) NOT NULL,
    presente boolean
);


ALTER TABLE public.presenze OWNER TO postgres;

--
-- TOC entry 147 (class 1259 OID 150116)
-- Name: quote; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE quote (
    oid integer NOT NULL,
    anno character varying,
    importo double precision,
    tipo character varying
);


ALTER TABLE public.quote OWNER TO postgres;

--
-- TOC entry 148 (class 1259 OID 150122)
-- Name: quote_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE quote_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.quote_oid_seq OWNER TO postgres;

--
-- TOC entry 1938 (class 0 OID 0)
-- Dependencies: 148
-- Name: quote_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE quote_oid_seq OWNED BY quote.oid;


--
-- TOC entry 149 (class 1259 OID 150124)
-- Name: ragazzi; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ragazzi (
    oid integer NOT NULL,
    nome character varying,
    cognome character varying,
    padre character varying,
    codifisc_padre character varying,
    anno_nascita integer,
    indirizzo character varying,
    madre character varying,
    codfisc_madre character varying,
    parent_oid integer,
    mail_inviata character varying DEFAULT 'OK'::character varying,
    periodi character varying,
    fratelli character varying,
    cell_padre character varying,
    cell_madre character varying,
    email_padre character varying,
    email_madre character varying,
    allergie character varying,
    intolleranze character varying,
    code character varying,
    classe_frequentata character varying,
    data_nascita timestamp with time zone,
    tel_casa character varying,
    tel_work_padre character varying,
    tel_work_madre character varying,
    tel_accompagnatore character varying,
    accompagnatore character varying,
    familiari boolean,
    pagamento character varying,
    citta_nascita character varying,
    sconto double precision DEFAULT 0.0
);


ALTER TABLE public.ragazzi OWNER TO postgres;

--
-- TOC entry 150 (class 1259 OID 150131)
-- Name: ragazzi_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE ragazzi_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.ragazzi_oid_seq OWNER TO postgres;

--
-- TOC entry 1939 (class 0 OID 0)
-- Dependencies: 150
-- Name: ragazzi_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE ragazzi_oid_seq OWNED BY ragazzi.oid;


--
-- TOC entry 162 (class 1259 OID 192843)
-- Name: sconti; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sconti (
    oid integer NOT NULL,
    sconto double precision DEFAULT 0,
    anno integer,
    ragazzo_oid integer
);


ALTER TABLE public.sconti OWNER TO postgres;

--
-- TOC entry 161 (class 1259 OID 192841)
-- Name: sconti_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sconti_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sconti_oid_seq OWNER TO postgres;

--
-- TOC entry 1940 (class 0 OID 0)
-- Dependencies: 161
-- Name: sconti_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sconti_oid_seq OWNED BY sconti.oid;


--
-- TOC entry 151 (class 1259 OID 150133)
-- Name: tipologie; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipologie (
    oid integer NOT NULL,
    forma character varying,
    costo_unitario double precision,
    costo_totale double precision,
    tipo character varying,
    num_settimane integer,
    familiare boolean DEFAULT false,
    mensa boolean,
    full_day boolean
);


ALTER TABLE public.tipologie OWNER TO postgres;

--
-- TOC entry 152 (class 1259 OID 150139)
-- Name: tipologie_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tipologie_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipologie_oid_seq OWNER TO postgres;

--
-- TOC entry 1941 (class 0 OID 0)
-- Dependencies: 152
-- Name: tipologie_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tipologie_oid_seq OWNED BY tipologie.oid;


--
-- TOC entry 153 (class 1259 OID 150141)
-- Name: utenti; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE utenti (
    oid integer NOT NULL,
    login character varying,
    password character varying,
    email character varying,
    nome character varying,
    cognome character varying
);


ALTER TABLE public.utenti OWNER TO postgres;

--
-- TOC entry 154 (class 1259 OID 150147)
-- Name: utenti_oid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE utenti_oid_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utenti_oid_seq OWNER TO postgres;

--
-- TOC entry 1942 (class 0 OID 0)
-- Dependencies: 154
-- Name: utenti_oid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE utenti_oid_seq OWNED BY utenti.oid;


--
-- TOC entry 1769 (class 2604 OID 150221)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY allegati ALTER COLUMN oid SET DEFAULT nextval('allegati_oid_seq'::regclass);


--
-- TOC entry 1757 (class 2604 OID 150149)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY giornate ALTER COLUMN oid SET DEFAULT nextval('presenze_oid_seq'::regclass);


--
-- TOC entry 1774 (class 2604 OID 166484)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gruppi_foto ALTER COLUMN oid SET DEFAULT nextval('gruppi_foto_oid_seq'::regclass);


--
-- TOC entry 1771 (class 2604 OID 150240)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pagamenti ALTER COLUMN oid SET DEFAULT nextval('pagamenti_oid_seq'::regclass);


--
-- TOC entry 1758 (class 2604 OID 150150)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY partecipanti ALTER COLUMN oid SET DEFAULT nextval('partecipanti_oid_seq'::regclass);


--
-- TOC entry 1760 (class 2604 OID 150151)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY periodi ALTER COLUMN oid SET DEFAULT nextval('periodi_oid_seq'::regclass);


--
-- TOC entry 1762 (class 2604 OID 150152)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY quote ALTER COLUMN oid SET DEFAULT nextval('quote_oid_seq'::regclass);


--
-- TOC entry 1764 (class 2604 OID 150153)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ragazzi ALTER COLUMN oid SET DEFAULT nextval('ragazzi_oid_seq'::regclass);


--
-- TOC entry 1775 (class 2604 OID 192846)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sconti ALTER COLUMN oid SET DEFAULT nextval('sconti_oid_seq'::regclass);


--
-- TOC entry 1766 (class 2604 OID 150154)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tipologie ALTER COLUMN oid SET DEFAULT nextval('tipologie_oid_seq'::regclass);


--
-- TOC entry 1768 (class 2604 OID 150155)
-- Name: oid; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY utenti ALTER COLUMN oid SET DEFAULT nextval('utenti_oid_seq'::regclass);


--
-- TOC entry 1918 (class 0 OID 150218)
-- Dependencies: 156
-- Data for Name: allegati; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY allegati (oid, nome, path, descrizione, mime, creazione, ragazzo_oid, tipo, url, image) FROM stdin;
1	modulo_iscrziione	/var/docs/ronco/20160605192133-modulo_iscrziione.pdf	modulo Iscrizione	application/pdf	\N	9	modulo_iscrzione	\N	\N
2	bonifico-berretta	/var/docs/ronco/20160605192133-bonifico-berretta.pdf	bonifico	application/pdf	\N	9	bonifico	\N	\N
3	upload_3dfae101_15591083b47__8000_00000812.tmp	/var/docs/ronco/20160630085902-upload_3dfae101_15591083b47__8000_00000812.tmp.pdf		application/pdf	\N	25		\N	\N
4	libretto sanitario dello sportivo	/var/docs/ronco/20170613184207-libretto sanitario dello sportivo.pdf		application/pdf	\N	121		\N	\N
\.


--
-- TOC entry 1943 (class 0 OID 0)
-- Dependencies: 155
-- Name: allegati_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('allegati_oid_seq', 4, true);


--
-- TOC entry 1902 (class 0 OID 150095)
-- Dependencies: 140
-- Data for Name: giornate; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY giornate (oid, giorno, periodo_oid) FROM stdin;
\.


--
-- TOC entry 1922 (class 0 OID 166481)
-- Dependencies: 160
-- Data for Name: gruppi_foto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY gruppi_foto (oid, nome, icona, numero, url, cartella, path, webpath, album, anno, icona_path) FROM stdin;
1	periodo5	/foto/2016/etichette/13692715_1268750849804223_2279639376268005036_n.jpg	75	/foto/2016/foto/periodo5	periodo5	/var/www/ronco/foto/2016/foto	\N	\N	2016	/var/www/ronco/foto/2016/etichette/13692715_1268750849804223_2279639376268005036_n.jpg
2	bosco	/foto/2016/etichette/boscoland.jpg	75	/foto/2016/foto/bosco	bosco	/var/www/ronco/foto/2016/foto	\N	\N	2016	/var/www/ronco/foto/2016/etichette/boscoland.jpg
4	trucco	/foto/2016/etichette/truccoland.jpg	75	/foto/2016/foto/trucco	trucco	/var/www/ronco/foto/2016/foto	\N	\N	2016	/var/www/ronco/foto/2016/etichette/truccoland.jpg
5	golf	/foto/2016/etichette/golfland.jpg	75	/foto/2016/foto/golf	golf	/var/www/ronco/foto/2016/foto	\N	\N	2016	/var/www/ronco/foto/2016/etichette/golfland.jpg
6	piscina	/foto/2016/etichette/piscinaland.jpg	75	/foto/2016/foto/piscina	piscina	/var/www/ronco/foto/2016/foto	\N	\N	2016	/var/www/ronco/foto/2016/etichette/piscinaland.jpg
7	alcenera	/foto/2016/etichette/alceneraland.jpg	75	/foto/2016/foto/alcenera	alcenera	/var/www/ronco/foto/2016/foto	\N	\N	2016	/var/www/ronco/foto/2016/etichette/alceneraland.jpg
8	periodo4	/foto/2016/etichette/periodo4land.jpg	75	/foto/2016/foto/periodo4	periodo4	/var/www/ronco/foto/2016/foto	\N	\N	2016	/var/www/ronco/foto/2016/etichette/periodo4land.jpg
3	cucina	/foto/2016/etichette/cucinaland.jpg	75	/foto/2016/foto/cucina	cucina	/var/www/ronco/foto/2016/foto	\N	\N	2016	/var/www/ronco/foto/2016/etichette/cucinaland.jpg
\.


--
-- TOC entry 1944 (class 0 OID 0)
-- Dependencies: 159
-- Name: gruppi_foto_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('gruppi_foto_oid_seq', 8, true);


--
-- TOC entry 1920 (class 0 OID 150237)
-- Dependencies: 158
-- Data for Name: pagamenti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY pagamenti (oid, amount, tipo, data, riferimento, fattura_emessa, fattura, anno, ragazzo_oid, completo, numero, causale) FROM stdin;
110	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	26	\N	111	<p>PARTECIPAZIONE A CENTRO ESTIVO DI&nbsp;GIORGIA PICCIANO</p>
158	110	bonifico	2016-08-01 00:00:00+02	5034000194396214486704067040IT	\N	\N	2016	26	\N	159	<p>PARTECIPAZIONE A CENTRO ESTIVO DI&nbsp;GIORGIA PICCIANO&nbsp;</p>
89	35	cash	2016-07-18 00:00:00+02		\N	\N	2016	39	\N	90	<p>PER PARTECIPAZIONE A CAMPUS ESTIVO RONCOVILLAGE DA&nbsp;RICCARDO CROVETTI</p>
140	120	cash	2016-07-29 00:00:00+02		\N	\N	2016	39	\N	141	<p>PER PARTECIPAZIONE A CAMPUS ESTIVO RONCOVILLAGE DI RICCARDO CROVETTI</p>
225	110	bonifico	2016-09-19 00:00:00+02		\N	\N	2016	57	\N	226	\r\nPer attivita' sportiva svolta a RoncoVillage da LORENZO� MANTOVANI\r\n
82	130	cash	2016-07-18 00:00:00+02		\N	\N	2016	73	\N	83	Per attivita' sportiva svolta a RoncoVillage da RICCARDO CAPPELLINI
20	250	cash	2016-07-04 19:54:03.514+02		\N	\N	2016	16	\N	19	Per attivita' sportiva svolta a RoncoVillage da ELENA BURGONI
21	130	cash	2016-07-05 20:38:33.71+02		\N	\N	2016	10	\N	20	Per attivita' sportiva svolta a RoncoVillage da LORENZO BORGHI
22	130	bonifico	2016-07-05 20:46:49.529+02		\N	\N	2016	28	\N	21	Per attivita' sportiva svolta a RoncoVillage da GIULIO GOBER
23	78	cash	2016-07-08 19:26:44.88+02		\N	\N	2016	49	\N	22	Per attivita' sportiva svolta a RoncoVillage da SERENA BONACORSI
24	130	cash	2016-07-08 19:27:11.759+02		\N	\N	2016	21	\N	23	Per attivita' sportiva svolta a RoncoVillage da FEDERICO BENASSI
25	130	cash	2016-07-08 19:27:29.816+02		\N	\N	2016	29	\N	24	Per attivita' sportiva svolta a RoncoVillage da VIOLA DELLI
27	120	cash	2016-07-10 18:07:26.998+02		\N	\N	2016	58	\N	26	Per attivita' sportiva svolta a RoncoVillage da LUCA FIANDRI
28	120	cash	2016-07-10 18:11:04.467+02		\N	\N	2016	59	\N	27	Per attivita' sportiva svolta a RoncoVillage da GIULIA FIANDRI
29	250	cash	2016-07-10 19:04:53.737+02		\N	\N	2016	34	\N	28	Per attivita' sportiva svolta a RoncoVillage da ALESSANDRO VIGNALI
30	120	cash	2016-07-10 19:05:28.364+02		\N	\N	2016	60	\N	29	Per attivita' sportiva svolta a RoncoVillage da EMANUELE VIGNALI
26	0		2016-07-10 18:07:02.52+02		\N	\N	2016	58	\N	25	Per attivita' sportiva svolta a RoncoVillage da LUCA FIANDRI
31	120	cash	2016-07-11 11:35:35.017+02		\N	\N	2016	10	\N	30	Per attivita' sportiva svolta a RoncoVillage da LORENZO BORGHI
32	250	assegno	2016-07-11 11:36:43.416+02	538766740	\N	\N	2016	48	\N	31	Per attivita' sportiva svolta a RoncoVillage da MERY GAMBAIANI
33	110	cash	2016-07-11 11:37:43.135+02		\N	\N	2016	32	\N	32	Per attivita' sportiva svolta a RoncoVillage da EMANUELE INGRAMI
37	250	bonifico	2016-07-11 11:45:12.221+02	1607041127766479480320002400IT	\N	\N	2016	30	\N	36	Per attivita' sportiva svolta a RoncoVillage da FRANCESCA TROMBETTI
38	200	cash	2016-07-11 12:06:10.51+02		\N	\N	2016	62	\N	37	Per attivita' sportiva svolta a RoncoVillage da MARTINA SERAFINI
39	200	cash	2016-07-11 12:06:42.846+02		\N	\N	2016	63	\N	38	Per attivita' sportiva svolta a RoncoVillage da BEATRICE SERAFINI
40	130	cash	2016-07-11 12:09:45.579+02		\N	\N	2016	56	\N	39	Per attivita' sportiva svolta a RoncoVillage da NICOLA  TINTORI
41	130	cash	2016-07-11 12:14:33.839+02		\N	\N	2016	64	\N	40	Per attivita' sportiva svolta a RoncoVillage da MATTEO FERRARI
42	130	cash	2016-07-11 12:19:07.216+02		\N	\N	2016	65	\N	41	Per attivita' sportiva svolta a RoncoVillage da MATTEO SEGHI
43	130	cash	2016-07-11 12:22:22.792+02		\N	\N	2016	66	\N	42	Per attivita' sportiva svolta a RoncoVillage da TOMMASO GALLI
44	130	cash	2016-07-11 12:28:11.982+02		\N	\N	2016	67	\N	43	Per attivita' sportiva svolta a RoncoVillage da GIORGIO LAMBERTINI
45	120	cash	2016-07-11 12:49:08.811+02		\N	\N	2016	29	\N	44	Per attivita' sportiva svolta a RoncoVillage da VIOLA DELLI
46	35	cash	2016-07-11 12:51:02.081+02		\N	\N	2016	54	\N	45	Per attivita' sportiva svolta a RoncoVillage da NICOLO' BONUCCHI
47	250	cash	2016-07-11 19:56:00.077+02		\N	\N	2016	20	\N	46	Per attivita' sportiva svolta a RoncoVillage da DAVIDE VERUCCHI
48	120	cash	2016-07-11 19:58:13.386+02		\N	\N	2016	45	\N	47	Per attivita' sportiva svolta a RoncoVillage da ELIA MARTIN STEPHAN MEULEMAN
49	120	cash	2016-07-11 22:24:38.071+02		\N	\N	2016	37	\N	48	Per attivita' sportiva svolta a RoncoVillage da SARA LEONELLI
50	120	cash	2016-07-11 22:27:44.496+02		\N	\N	2016	28	\N	49	Per attivita' sportiva svolta a RoncoVillage da GIULIO GOBER
52	120	cash	2016-07-11 22:32:12.716+02		\N	\N	2016	44	\N	51	Per attivita' sportiva svolta a RoncoVillage da LORENZO POLLACCI
51	0	cash	2016-07-11 22:38:48.432+02		\N	\N	2016	28	\N	52	Per attivita' sportiva svolta a RoncoVillage da GIULIO GOBER
53	75	cash	2016-07-16 10:43:56.412+02		\N	\N	2016	41	\N	53	Per attivita' sportiva svolta a RoncoVillage da ELEONORA AGRILLO
54	130	cash	2016-07-16 17:07:03.295+02		\N	\N	2016	54	\N	54	Per attivita' sportiva svolta a RoncoVillage da NICOLO' BONUCCHI
55	400	cash	2016-07-16 17:08:02.019+02		\N	\N	2016	53	\N	55	Per attivita' sportiva svolta a RoncoVillage da CATERINA BIOLCHINI
56	400	cash	2016-07-16 17:08:21.829+02		\N	\N	2016	55	\N	56	Per attivita' sportiva svolta a RoncoVillage da PENELOPE BIOLCHINI
57	120	cash	2016-07-16 17:09:38.057+02		\N	\N	2016	40	\N	57	Per attivita' sportiva svolta a RoncoVillage da VITTORIA PELLONI
1	250	bonifico	2016-05-30 00:00:00+02	1101161510266808	\N	\N	2016	9	\N	58	Per attivita' sportiva svolta a RoncoVillage da MARGHERITA BERRETTA
59	130	bonifico	2016-07-13 00:00:00+02	7816071300UZT2	\N	\N	2016	57	\N	60	Per attivita' sportiva svolta a RoncoVillage da LORENZO MANTOVANI
60	230	bonifico	2016-07-13 00:00:00+02	7816071300KGX3	\N	\N	2016	22	\N	61	Per attivita' sportiva svolta a RoncoVillage da GIULIO MAZZOLI
96	25	cash	2016-07-22 00:00:00+02		\N	\N	2016	50	\N	97	Per attivita' sportiva svolta a RoncoVillage da ALEX MOLINARI
61	230	bonifico	2016-07-13 00:00:00+02	7816071300KGX3	\N	\N	2016	23	\N	62	Per attivita' sportiva svolta a RoncoVillage da ELEONORA MAZZOLI
62	320	cash	2016-07-17 00:00:00+02		\N	\N	2016	51	\N	63	Per attivita' sportiva svolta a RoncoVillage da MATTEO POGGI
63	320	cash	2016-07-17 00:00:00+02		\N	\N	2016	52	\N	64	Per attivita' sportiva svolta a RoncoVillage da LARA POGGI
64	110	cash	2016-07-17 00:00:00+02		\N	\N	2016	59	\N	65	Per attivita' sportiva svolta a RoncoVillage da GIULIA FIANDRI
65	110	cash	2016-07-17 00:00:00+02		\N	\N	2016	58	\N	66	Per attivita' sportiva svolta a RoncoVillage da LUCA FIANDRI
66	130	cash	2016-07-17 00:00:00+02		\N	\N	2016	70	\N	67	Per attivita' sportiva svolta a RoncoVillage da LUCA SPELTA
67	130	cash	2016-07-17 00:00:00+02		\N	\N	2016	71	\N	68	Per attivita' sportiva svolta a RoncoVillage da ALESSANDRO MONTI
68	130	cash	2016-07-17 00:00:00+02		\N	\N	2016	72	\N	69	Per attivita' sportiva svolta a RoncoVillage da GABRIELE GROTTI
69	178	cash	2016-07-17 00:00:00+02		\N	\N	2016	50	\N	70	Per attivita' sportiva svolta a RoncoVillage da ALEX MOLINARI
70	120	cash	2016-07-17 00:00:00+02		\N	\N	2016	60	\N	71	Per attivita' sportiva svolta a RoncoVillage da EMANUELE VIGNALI
71	110	cash	2016-07-17 00:00:00+02		\N	\N	2016	42	\N	72	Per attivita' sportiva svolta a RoncoVillage da ALEXANDRA BURCHI
72	110	cash	2016-07-17 00:00:00+02		\N	\N	2016	43	\N	73	Per attivita' sportiva svolta a RoncoVillage da VERONICA  BURCHI
73	110	cash	2016-07-18 00:00:00+02		\N	\N	2016	37	\N	74	Per attivita' sportiva svolta a RoncoVillage da SARA LEONELLI
74	130	cash	2016-07-18 00:00:00+02		\N	\N	2016	74	\N	75	Per attivita' sportiva svolta a RoncoVillage da LUCREZIA LUPPI
75	110	cash	2016-07-18 00:00:00+02		\N	\N	2016	35	\N	76	Per attivita' sportiva svolta a RoncoVillage da LORENZO TEGGI
76	200	cash	2016-07-18 00:00:00+02		\N	\N	2016	16	\N	77	Per attivita' sportiva svolta a RoncoVillage da ELENA BURGONI
77	200	cash	2016-07-18 00:00:00+02		\N	\N	2016	15	\N	78	Per attivita' sportiva svolta a RoncoVillage da ALESSIA BURGONI
78	110	cash	2016-07-18 00:00:00+02		\N	\N	2016	33	\N	79	Per attivita' sportiva svolta a RoncoVillage da ALEX MASINELLI
79	110	cash	2016-07-18 00:00:00+02		\N	\N	2016	10	\N	80	Per attivita' sportiva svolta a RoncoVillage da LORENZO BORGHI
80	130	cash	2016-07-18 00:00:00+02		\N	\N	2016	75	\N	81	Per attivita' sportiva svolta a RoncoVillage da GAIA MINELLI
83	110	cash	2016-07-18 00:00:00+02		\N	\N	2016	28	\N	84	Per attivita' sportiva svolta a RoncoVillage da GIULIO GOBER
84	120	cash	2016-07-18 00:00:00+02		\N	\N	2016	64	\N	85	Per attivita' sportiva svolta a RoncoVillage da MATTEO FERRARI
85	130	cash	2016-07-18 00:00:00+02		\N	\N	2016	76	\N	86	Per attivita' sportiva svolta a RoncoVillage da NICOLA LENZINI
86	120	cash	2016-07-18 00:00:00+02		\N	\N	2016	56	\N	87	Per attivita' sportiva svolta a RoncoVillage da NICOLA  TINTORI
87	130	cash	2016-07-18 00:00:00+02		\N	\N	2016	19	\N	88	Per attivita' sportiva svolta a RoncoVillage da LEONARDO SOLA
88	130	cash	2016-07-18 00:00:00+02		\N	\N	2016	27	\N	89	Per attivita' sportiva svolta a RoncoVillage da EMANUELE STEFANELLI
90	130	cash	2016-07-18 00:00:00+02		\N	\N	2016	78	\N	91	Per attivita' sportiva svolta a RoncoVillage da BENEDETTA VEZZALI
91	25	cash	2016-07-18 00:00:00+02		\N	\N	2016	67	\N	92	Per attivita' sportiva svolta a RoncoVillage da GIORGIO LAMBERTINI
58	275	assegno	2016-07-16 00:00:00+02	0113122614	\N	\N	2016	18	\N	59	Per attivita' sportiva svolta a RoncoVillage da LUCIO CALEFFI
81	110	assegno	2016-07-18 00:00:00+02		\N	\N	2016	38	\N	82	Per attivita' sportiva svolta a RoncoVillage da MARIA VITTORA ZANETTI
35	130	bonifico	2016-07-19 00:00:00+02	7816071903I1MI	\N	\N	2016	17	\N	34	Per attivita' sportiva svolta a RoncoVillage da LORENZO PRANDO
95	120	bonifico	2016-07-19 00:00:00+02	7816071903I1MI	\N	\N	2016	17	\N	96	Per attivita' sportiva svolta a RoncoVillage da LORENZO PRANDO
97	50	cash	2016-07-22 00:00:00+02		\N	\N	2016	67	\N	98	Per attivita' sportiva svolta a RoncoVillage da GIORGIO LAMBERTINI
98	130	cash	2016-07-22 00:00:00+02		\N	\N	2016	77	\N	99	Per attivita' sportiva svolta a RoncoVillage da LEONARDO BAISI
99	130	cash	2016-07-24 00:00:00+02		\N	\N	2016	81	\N	100	Per attivita' sportiva svolta a RoncoVillage da ALESSANDRO ANGELI
100	100	cash	2016-07-25 00:00:00+02		\N	\N	2016	37	\N	101	Per attivita' sportiva svolta a RoncoVillage da SARA LEONELLI
101	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	27	\N	102	Per attivita' sportiva svolta a RoncoVillage da EMANUELE STEFANELLI
102	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	69	\N	103	Per attivita' sportiva svolta a RoncoVillage da FRANCESCO CALI'
103	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	68	\N	104	Per attivita' sportiva svolta a RoncoVillage da EMANUELA CALI'
104	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	73	\N	105	Per attivita' sportiva svolta a RoncoVillage da RICCARDO CAPPELLINI
105	130	cash	2016-07-25 00:00:00+02		\N	\N	2016	79	\N	106	Per attivita' sportiva svolta a RoncoVillage da CARLOTTA FRODATI
106	130	cash	2016-07-25 00:00:00+02		\N	\N	2016	80	\N	107	Per attivita' sportiva svolta a RoncoVillage da ALESSANDRO GHERARDI
107	130	cash	2016-07-25 00:00:00+02		\N	\N	2016	47	\N	108	Per attivita' sportiva svolta a RoncoVillage da SAMANTHA LEONE
109	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	75	\N	110	Per attivita' sportiva svolta a RoncoVillage da GAIA MINELLI
111	130	cash	2016-07-25 00:00:00+02		\N	\N	2016	85	\N	112	Per attivita' sportiva svolta a RoncoVillage da MARTINA PIROZZI
112	100	cash	2016-07-25 00:00:00+02		\N	\N	2016	35	\N	113	Per attivita' sportiva svolta a RoncoVillage da LORENZO TEGGI
113	210	cash	2016-07-25 00:00:00+02		\N	\N	2016	20	\N	114	Per attivita' sportiva svolta a RoncoVillage da DAVIDE VERUCCHI
114	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	74	\N	115	Per attivita' sportiva svolta a RoncoVillage da LUCREZIA LUPPI
115	110	cash	2016-07-25 00:00:00+02		\N	\N	2016	32	\N	116	Per attivita' sportiva svolta a RoncoVillage da EMANUELE INGRAMI
116	100	cash	2016-07-25 00:00:00+02		\N	\N	2016	33	\N	117	Per attivita' sportiva svolta a RoncoVillage da ALEX MASINELLI
34	130	bonifico	2016-07-11 00:00:00+02	5034000371976193486704067040IT	\N	\N	2016	26	\N	33	<p>PARTECIPAZIONE A CENTRO ESTIVO DI&nbsp;GIORGIA PICCIANO</p>
10	130	cash	2016-07-04 00:00:00+02		\N	\N	2016	39	\N	9	<p>PER PARTECIPAZIONE A CAMPUS ESTIVO&nbsp;RoncoVillage da RICCARDO CROVETTI</p>
3	130	cash	2016-07-03 22:56:48.072+02		\N	\N	2016	25	\N	2	Per attivita' sportiva svolta a RoncoVillage da DAVIDE GHIRLINZONI
4	110	cash	2016-07-04 11:47:33.982+02		\N	\N	2016	32	\N	3	Per attivita' sportiva svolta a RoncoVillage da EMANUELE INGRAMI
5	250	cash	2016-07-04 11:54:45.412+02		\N	\N	2016	33	\N	4	Per attivita' sportiva svolta a RoncoVillage da ALEX MASINELLI
6	130	cash	2016-07-04 12:19:24.588+02		\N	\N	2016	35	\N	5	Per attivita' sportiva svolta a RoncoVillage da LORENZO TEGGI
7	130	cash	2016-07-04 17:59:23.192+02		\N	\N	2016	36	\N	6	Per attivita' sportiva svolta a RoncoVillage da EMANUELE MARIA BALBONI
8	130	cash	2016-07-04 18:02:58.052+02		\N	\N	2016	37	\N	7	Per attivita' sportiva svolta a RoncoVillage da SARA LEONELLI
9	250	assegno	2016-07-04 18:09:55.538+02		\N	\N	2016	38	\N	8	Per attivita' sportiva svolta a RoncoVillage da MARIA VITTORA ZANETTI
11	130	cash	2016-07-04 18:26:58.797+02		\N	\N	2016	40	\N	10	Per attivita' sportiva svolta a RoncoVillage da VITTORIA PELLONI
12	250	bonifico	2016-07-04 18:59:19.994+02	161868080015502	\N	\N	2016	24	\N	11	Per attivita' sportiva svolta a RoncoVillage da BEATRICE SERRI
13	130	cash	2016-07-04 19:09:09.092+02		\N	\N	2016	41	\N	12	Per attivita' sportiva svolta a RoncoVillage da ELEONORA AGRILLO
14	120	cash	2016-07-04 19:17:24.81+02		\N	\N	2016	42	\N	13	Per attivita' sportiva svolta a RoncoVillage da ALEXANDRA BURCHI
15	120	cash	2016-07-04 19:17:43.478+02		\N	\N	2016	43	\N	14	Per attivita' sportiva svolta a RoncoVillage da VERONICA  BURCHI
16	130	cash	2016-07-04 19:21:51.54+02		\N	\N	2016	44	\N	15	Per attivita' sportiva svolta a RoncoVillage da LORENZO POLLACCI
17	120	cash	2016-07-04 19:44:48.277+02		\N	\N	2016	46	\N	16	Per attivita' sportiva svolta a RoncoVillage da NICOLAS LEON STEFHANE MEULEMAN
18	120	cash	2016-07-04 19:45:06.547+02		\N	\N	2016	45	\N	17	Per attivita' sportiva svolta a RoncoVillage da ELIA MARTIN STEPHAN MEULEMAN
19	250	cash	2016-07-04 19:53:38.447+02		\N	\N	2016	15	\N	18	Per attivita' sportiva svolta a RoncoVillage da ALESSIA BURGONI
36	120	cash	2016-07-11 11:42:42.5+02		\N	\N	2016	35	\N	35	Per attivita' sportiva svolta a RoncoVillage da LORENZO TEGGI
92	110	cash	2016-07-18 00:00:00+02		\N	\N	2016	45	\N	93	Per attivita' sportiva svolta a RoncoVillage da ELIA MARTIN STEPHAN MEULEMAN
147	100	assegno	2016-08-01 00:00:00+02		\N	\N	2016	38	\N	148	Per attivita' sportiva svolta a RoncoVillage da MARIA VITTORA ZANETTI
148	110	cash	2016-08-01 00:00:00+02		\N	\N	2016	69	\N	149	Per attivita' sportiva svolta a RoncoVillage da FRANCESCO CALI'
117	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	76	\N	118	Per attivita' sportiva svolta a RoncoVillage da NICOLA LENZINI
118	100	cash	2016-07-25 00:00:00+02		\N	\N	2016	28	\N	119	Per attivita' sportiva svolta a RoncoVillage da GIULIO GOBER
119	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	86	\N	120	Per attivita' sportiva svolta a RoncoVillage da ANDREA BONUCCHI
120	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	87	\N	121	Per attivita' sportiva svolta a RoncoVillage da MARTINA BONUCCHI
121	130	cash	2016-07-25 00:00:00+02		\N	\N	2016	88	\N	122	Per attivita' sportiva svolta a RoncoVillage da PIERRE ANTONI
122	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	66	\N	123	Per attivita' sportiva svolta a RoncoVillage da TOMMASO GALLI
123	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	78	\N	124	Per attivita' sportiva svolta a RoncoVillage da BENEDETTA VEZZALI
124	130	cash	2016-07-25 00:00:00+02		\N	\N	2016	90	\N	125	Per attivita' sportiva svolta a RoncoVillage da ANGELICA GUERRI
125	110	cash	2016-07-25 00:00:00+02		\N	\N	2016	64	\N	126	Per attivita' sportiva svolta a RoncoVillage da MATTEO FERRARI
126	120	cash	2016-07-25 00:00:00+02		\N	\N	2016	19	\N	127	Per attivita' sportiva svolta a RoncoVillage da LEONARDO SOLA
127	120	bonifico	2016-07-29 00:00:00+02	7816072609U10E	\N	\N	2016	57	\N	128	Per attivita' sportiva svolta a RoncoVillage da LORENZO MANTOVANI
129	120	bonifico	2016-07-26 00:00:00+02	78160726097WTL	\N	\N	2016	83	\N	130	Per attivita' sportiva svolta a RoncoVillage da VERONICA FLORINI
128	120	bonifico	2016-07-26 00:00:00+02	78160726097WTL	\N	\N	2016	82	\N	129	Per attivita' sportiva svolta a RoncoVillage da ALESSANDRO FLORINI
130	110	bonifico	2016-07-29 00:00:00+02	781607290DECVO	\N	\N	2016	17	\N	131	Per attivita' sportiva svolta a RoncoVillage da LORENZO PRANDO
131	120	cash	2016-07-30 00:00:00+02		\N	\N	2016	25	\N	132	Per attivita' sportiva svolta a RoncoVillage da DAVIDE GHIRLINZONI
132	80	cash	2016-07-30 00:00:00+02		\N	\N	2016	37	\N	133	Per attivita' sportiva svolta a RoncoVillage da SARA LEONELLI
133	120	cash	2016-07-30 00:00:00+02		\N	\N	2016	99	\N	134	Per attivita' sportiva svolta a RoncoVillage da MARGO' MARTINELLI
134	120	cash	2016-07-30 00:00:00+02		\N	\N	2016	100	\N	135	Per attivita' sportiva svolta a RoncoVillage da MORGAN MARTINELLI
135	25	cash	2016-07-29 00:00:00+02		\N	\N	2016	67	\N	136	Per attivita' sportiva svolta a RoncoVillage da GIORGIO LAMBERTINI
136	70	cash	2016-07-28 00:00:00+02		\N	\N	2016	98	\N	137	Per attivita' sportiva svolta a RoncoVillage da GIOELE BRUGNOLI
137	90	cash	2016-07-29 00:00:00+02		\N	\N	2016	11	\N	138	Per attivita' sportiva svolta a RoncoVillage da FEDERICA LUCCHI
138	104	cash	2016-07-29 00:00:00+02		\N	\N	2016	91	\N	139	Per attivita' sportiva svolta a RoncoVillage da SAMUELE ROMANO
139	52	cash	2016-07-28 00:00:00+02		\N	\N	2016	54	\N	140	Per attivita' sportiva svolta a RoncoVillage da NICOLO' BONUCCHI
141	90	cash	2016-07-31 00:00:00+02		\N	\N	2016	58	\N	142	Per attivita' sportiva svolta a RoncoVillage da LUCA FIANDRI
197	110	cash	2016-08-08 00:00:00+02		\N	\N	2016	40	\N	198	Per attivita' sportiva svolta a RoncoVillage da VITTORIA PELLONI
142	90	cash	2016-07-31 00:00:00+02		\N	\N	2016	59	\N	143	Per attivita' sportiva svolta a RoncoVillage da GIULIA FIANDRI
143	110	cash	2016-08-01 00:00:00+02		\N	\N	2016	74	\N	144	Per attivita' sportiva svolta a RoncoVillage da LUCREZIA LUPPI
144	80	cash	2016-08-01 00:00:00+02		\N	\N	2016	33	\N	145	Per attivita' sportiva svolta a RoncoVillage da ALEX MASINELLI
146	120	cash	2016-08-01 00:00:00+02		\N	\N	2016	80	\N	147	Per attivita' sportiva svolta a RoncoVillage da ALESSANDRO GHERARDI
108	130	cash	2016-07-25 00:00:00+02		\N	\N	2016	84	\N	109	<p>per partecipazione a CAMPUS ESTIVO&nbsp;RoncoVillage da FRANCESCO LOLLI</p>
149	110	cash	2016-08-01 00:00:00+02		\N	\N	2016	68	\N	150	Per attivita' sportiva svolta a RoncoVillage da EMANUELA CALI'
150	130	cash	2016-08-01 00:00:00+02		\N	\N	2016	103	\N	151	Per attivita' sportiva svolta a RoncoVillage da LEONARDO MARIA SERAFINI
151	80	cash	2016-08-01 00:00:00+02		\N	\N	2016	28	\N	152	Per attivita' sportiva svolta a RoncoVillage da GIULIO GOBER
152	120	cash	2016-08-01 00:00:00+02		\N	\N	2016	88	\N	153	Per attivita' sportiva svolta a RoncoVillage da PIERRE ANTONI
153	120	cash	2016-08-01 00:00:00+02		\N	\N	2016	90	\N	154	Per attivita' sportiva svolta a RoncoVillage da ANGELICA GUERRI
154	90	cash	2016-08-01 00:00:00+02		\N	\N	2016	42	\N	155	Per attivita' sportiva svolta a RoncoVillage da ALEXANDRA BURCHI
155	90	cash	2016-08-01 00:00:00+02		\N	\N	2016	43	\N	156	Per attivita' sportiva svolta a RoncoVillage da VERONICA  BURCHI
156	110	cash	2016-08-01 00:00:00+02		\N	\N	2016	19	\N	157	Per attivita' sportiva svolta a RoncoVillage da LEONARDO SOLA
157	80	cash	2016-08-01 00:00:00+02		\N	\N	2016	20	\N	158	Per attivita' sportiva svolta a RoncoVillage da DAVIDE VERUCCHI
159	44	cash	2016-08-01 00:00:00+02		\N	\N	2016	32	\N	160	Per attivita' sportiva svolta a RoncoVillage da EMANUELE INGRAMI
160	88	cash	2016-08-02 00:00:00+02		\N	\N	2016	66	\N	161	Per attivita' sportiva svolta a RoncoVillage da TOMMASO GALLI
161	120	cash	2016-08-02 00:00:00+02		\N	\N	2016	85	\N	162	Per attivita' sportiva svolta a RoncoVillage da MARTINA PIROZZI
162	110	cash	2016-08-01 00:00:00+02		\N	\N	2016	75	\N	163	Per attivita' sportiva svolta a RoncoVillage da GAIA MINELLI
163	100	cash	2016-08-01 00:00:00+02		\N	\N	2016	34	\N	164	Per attivita' sportiva svolta a RoncoVillage da ALESSANDRO VIGNALI
164	210	cash	2016-08-01 00:00:00+02		\N	\N	2016	60	\N	165	Per attivita' sportiva svolta a RoncoVillage da EMANUELE VIGNALI
165	88	cash	2016-08-03 00:00:00+02		\N	\N	2016	54	\N	166	Per attivita' sportiva svolta a RoncoVillage da NICOLO' BONUCCHI
93	80	bonifico	2016-07-19 00:00:00+02	7816071903Q819	\N	\N	2016	22	\N	94	Per attivita' sportiva svolta a RoncoVillage da GIULIO MAZZOLI
94	80	bonifico	2016-07-19 00:00:00+02	7816071903Q819	\N	\N	2016	23	\N	95	Per attivita' sportiva svolta a RoncoVillage da ELEONORA MAZZOLI
166	90	bonifico	2016-08-02 00:00:00+02	781608020ICMBP	\N	\N	2016	22	\N	167	Per attivita' sportiva svolta a RoncoVillage da GIULIO MAZZOLI
167	90	bonifico	2016-08-02 00:00:00+02	781608020ICMBP	\N	\N	2016	23	\N	168	Per attivita' sportiva svolta a RoncoVillage da ELEONORA MAZZOLI
168	130	bonifico	2016-08-02 00:00:00+02	781608020I15SY	\N	\N	2016	96	\N	169	Per attivita' sportiva svolta a RoncoVillage da SARA  VENTURELLI
169	50	cash	2016-08-03 00:00:00+02		\N	\N	2016	67	\N	170	Per attivita' sportiva svolta a RoncoVillage da GIORGIO LAMBERTINI
170	35	cash	2016-08-03 00:00:00+02		\N	\N	2016	107	\N	171	Per attivita' sportiva svolta a RoncoVillage da LAURA SIGHINOLFI
171	120	cash	2016-08-04 00:00:00+02		\N	\N	2016	77	\N	172	Per attivita' sportiva svolta a RoncoVillage da LEONARDO BAISI
172	120	cash	2016-08-04 00:00:00+02		\N	\N	2016	11	\N	173	Per attivita' sportiva svolta a RoncoVillage da FEDERICA LUCCHI
173	130	cash	2016-08-06 00:00:00+02		\N	\N	2016	97	\N	174	Per attivita' sportiva svolta a RoncoVillage da ANNA MAGNANI
174	206	cash	2016-08-04 00:00:00+02		\N	\N	2016	36	\N	175	Per attivita' sportiva svolta a RoncoVillage da EMANUELE MARIA BALBONI
175	206	cash	2016-08-04 00:00:00+02		\N	\N	2016	92	\N	176	Per attivita' sportiva svolta a RoncoVillage da JACOPO MARIA BALBONI
177	60	cash	2016-08-07 00:00:00+02		\N	\N	2016	37	\N	178	Per attivita' sportiva svolta a RoncoVillage da SARA LEONELLI
178	35	cash	2016-08-05 00:00:00+02		\N	\N	2016	94	\N	179	Per attivita' sportiva svolta a RoncoVillage da GIOVANNI MALINVERNI
179	35	cash	2016-08-03 00:00:00+02		\N	\N	2016	107	\N	180	Per attivita' sportiva svolta a RoncoVillage da LAURA SIGHINOLFI
180	25	cash	2016-08-03 00:00:00+02		\N	\N	2016	67	\N	181	Per attivita' sportiva svolta a RoncoVillage da GIORGIO LAMBERTINI
181	50	cash	2016-08-08 00:00:00+02		\N	\N	2016	16	\N	182	Per attivita' sportiva svolta a RoncoVillage da ELENA BURGONI
182	50	cash	2016-08-08 00:00:00+02		\N	\N	2016	15	\N	183	Per attivita' sportiva svolta a RoncoVillage da ALESSIA BURGONI
183	90	cash	2016-08-08 00:00:00+02		\N	\N	2016	68	\N	184	Per attivita' sportiva svolta a RoncoVillage da EMANUELA CALI'
184	90	cash	2016-08-08 00:00:00+02		\N	\N	2016	69	\N	185	Per attivita' sportiva svolta a RoncoVillage da FRANCESCO CALI'
185	130	cash	2016-08-08 00:00:00+02		\N	\N	2016	110	\N	186	Per attivita' sportiva svolta a RoncoVillage da NICHOLAS BARBIERI
186	100	cash	2016-08-08 00:00:00+02		\N	\N	2016	74	\N	187	Per attivita' sportiva svolta a RoncoVillage da LUCREZIA LUPPI
145	90	cash	2016-08-01 00:00:00+02		\N	\N	2016	35	\N	146	Per attivita' sportiva svolta a RoncoVillage da LORENZO TEGGI
187	60	cash	2016-08-08 00:00:00+02		\N	\N	2016	28	\N	188	Per attivita' sportiva svolta a RoncoVillage da GIULIO GOBER
188	60	cash	2016-08-08 00:00:00+02		\N	\N	2016	33	\N	189	Per attivita' sportiva svolta a RoncoVillage da ALEX MASINELLI
189	60	cash	2016-08-08 00:00:00+02		\N	\N	2016	33	\N	190	Per attivita' sportiva svolta a RoncoVillage da ALEX MASINELLI
190	110	cash	2016-08-08 00:00:00+02		\N	\N	2016	88	\N	191	Per attivita' sportiva svolta a RoncoVillage da PIERRE ANTONI
191	90	cash	2016-08-08 00:00:00+02		\N	\N	2016	92	\N	192	Per attivita' sportiva svolta a RoncoVillage da JACOPO MARIA BALBONI
192	90	cash	2016-08-08 00:00:00+02		\N	\N	2016	36	\N	193	Per attivita' sportiva svolta a RoncoVillage da EMANUELE MARIA BALBONI
193	60	cash	2016-08-08 00:00:00+02		\N	\N	2016	35	\N	194	Per attivita' sportiva svolta a RoncoVillage da LORENZO TEGGI
194	110	cash	2016-08-08 00:00:00+02		\N	\N	2016	56	\N	195	Per attivita' sportiva svolta a RoncoVillage da NICOLA  TINTORI
195	120	cash	2016-08-08 00:00:00+02		\N	\N	2016	79	\N	196	Per attivita' sportiva svolta a RoncoVillage da CARLOTTA FRODATI
196	110	cash	2016-08-08 00:00:00+02		\N	\N	2016	100	\N	197	Per attivita' sportiva svolta a RoncoVillage da MORGAN MARTINELLI
176	105	cash	2016-08-07 00:00:00+02		\N	\N	2016	108	\N	177	Per attivita' sportiva svolta a RoncoVillage da FEDERICO PELLICCIARI
198	100	cash	2016-08-08 00:00:00+02		\N	\N	2016	19	\N	199	Per attivita' sportiva svolta a RoncoVillage da LEONARDO SOLA
199	120	cash	2016-08-08 00:00:00+02		\N	\N	2016	113	\N	200	Per attivita' sportiva svolta a RoncoVillage da IRENE BIOLCHINI
200	120	cash	2016-08-08 00:00:00+02		\N	\N	2016	112	\N	201	Per attivita' sportiva svolta a RoncoVillage da ALESSANDRO BIOLCHINI
201	120	cash	2016-08-08 00:00:00+02		\N	\N	2016	103	\N	202	Per attivita' sportiva svolta a RoncoVillage da LEONARDO MARIA SERAFINI
202	130	cash	2016-08-08 00:00:00+02		\N	\N	2016	114	\N	203	Per attivita' sportiva svolta a RoncoVillage da FRANCESCO GIANNULI
203	80	cash	2016-08-08 00:00:00+02		\N	\N	2016	42	\N	204	Per attivita' sportiva svolta a RoncoVillage da ALEXANDRA BURCHI
204	80	cash	2016-08-08 00:00:00+02		\N	\N	2016	43	\N	205	Per attivita' sportiva svolta a RoncoVillage da VERONICA  BURCHI
205	110	cash	2016-08-08 00:00:00+02		\N	\N	2016	99	\N	206	Per attivita' sportiva svolta a RoncoVillage da MARGO' MARTINELLI
206	130	cash	2016-08-08 00:00:00+02		\N	\N	2016	115	\N	207	Per attivita' sportiva svolta a RoncoVillage da EMANUELE FERRARI
207	130	cash	2016-08-08 00:00:00+02		\N	\N	2016	107	\N	208	Per attivita' sportiva svolta a RoncoVillage da LAURA SIGHINOLFI
208	50	cash	2016-08-08 00:00:00+02		\N	\N	2016	53	\N	209	Per attivita' sportiva svolta a RoncoVillage da CATERINA BIOLCHINI
209	50	cash	2016-08-08 00:00:00+02		\N	\N	2016	55	\N	210	Per attivita' sportiva svolta a RoncoVillage da PENELOPE BIOLCHINI
210	72	cash	2016-08-10 00:00:00+02		\N	\N	2016	73	\N	211	Per attivita' sportiva svolta a RoncoVillage da RICCARDO CAPPELLINI
211	110	cash	2016-08-10 00:00:00+02		\N	\N	2016	77	\N	212	Per attivita' sportiva svolta a RoncoVillage da LEONARDO BAISI
212	50	cash	2016-08-11 00:00:00+02		\N	\N	2016	23	\N	213	Per attivita' sportiva svolta a RoncoVillage da ELEONORA MAZZOLI
213	50	cash	2016-08-11 00:00:00+02		\N	\N	2016	22	\N	214	Per attivita' sportiva svolta a RoncoVillage da GIULIO MAZZOLI
214	66	cash	2016-08-11 00:00:00+02		\N	\N	2016	66	\N	215	Per attivita' sportiva svolta a RoncoVillage da TOMMASO GALLI
215	100	bonifico	2016-08-11 00:00:00+02	7816071903I1MI	\N	\N	2016	17	\N	216	Per attivita' sportiva svolta a RoncoVillage da LORENZO PRANDO
216	120	bonifico	2016-08-05 00:00:00+02		\N	\N	2016	95	\N	217	Per attivita' sportiva svolta a RoncoVillage da MARTINA MALINVERNI
217	120	bonifico	2016-08-05 00:00:00+02		\N	\N	2016	93	\N	218	Per attivita' sportiva svolta a RoncoVillage da LORENZO MALINVERNI
218	110	cash	2016-08-14 00:00:00+02		\N	\N	2016	93	\N	219	Per attivita' sportiva svolta a RoncoVillage da LORENZO MALINVERNI
219	110	cash	2016-08-14 00:00:00+02		\N	\N	2016	95	\N	220	Per attivita' sportiva svolta a RoncoVillage da MARTINA MALINVERNI
221	66	cash	2016-08-12 00:00:00+02		\N	\N	2016	54	\N	222	Per attivita' sportiva svolta a RoncoVillage da NICOLO' BONUCCHI
222	22	cash	2016-08-12 00:00:00+02		\N	\N	2016	32	\N	223	Per attivita' sportiva svolta a RoncoVillage da EMANUELE INGRAMI
223	22	cash	2016-08-12 00:00:00+02		\N	\N	2016	32	\N	224	Per attivita' sportiva svolta a RoncoVillage da EMANUELE INGRAMI
224	22	cash	2016-08-12 00:00:00+02		\N	\N	2016	32	\N	225	Per attivita' sportiva svolta a RoncoVillage da EMANUELE INGRAMI
220	25	cash	2016-08-12 00:00:00+02		\N	\N	2016	26	\N	221	<p>PARTECIPAZIONE A CENTRO ESTIVO DI&nbsp;GIORGIA PICCIANO</p>
\.


--
-- TOC entry 1945 (class 0 OID 0)
-- Dependencies: 157
-- Name: pagamenti_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('pagamenti_oid_seq', 225, true);


--
-- TOC entry 1903 (class 0 OID 150098)
-- Dependencies: 141
-- Data for Name: partecipanti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY partecipanti (oid, periodo_oid, ragazzo_oid, tipo_oid, stato) FROM stdin;
316	6	32	15	t
86	1	50	3	t
270	5	67	14	t
154	3	72	1	t
103	2	53	11	t
104	3	53	11	t
105	4	53	11	t
35	1	20	6	t
106	5	53	11	t
51	3	27	3	t
36	2	20	6	t
37	3	20	6	t
15	4	14	2	t
38	4	20	6	t
45	1	24	3	t
46	2	24	3	t
39	5	20	6	t
55	2	30	3	t
56	3	30	3	t
201	4	78	3	t
52	4	27	3	t
48	2	26	4	t
49	4	26	4	t
50	5	26	4	t
7	1	10	4	t
8	2	10	4	t
159	3	10	4	t
82	4	47	1	t
79	1	44	20	t
274	6	19	5	t
390	7	15	21	t
275	6	103	3	t
391	8	15	21	t
392	9	15	21	t
40	1	21	1	t
54	1	29	3	t
5	4	9	3	t
6	5	9	3	t
165	3	76	3	t
393	10	15	21	t
394	11	15	21	t
395	12	15	21	t
136	2	29	3	t
135	2	39	3	t
169	3	39	3	t
229	5	39	15	t
368	10	68	9	f
396	7	16	21	t
140	2	44	20	t
171	3	44	20	t
397	8	16	21	t
398	9	16	21	t
22	1	16	21	t
85	1	49	1	t
23	2	16	21	t
24	3	16	21	t
25	4	16	21	t
47	1	25	3	t
26	5	16	21	t
276	6	16	21	t
399	10	16	21	t
400	11	16	21	t
16	1	15	21	t
17	2	15	21	t
18	3	15	21	t
401	12	16	21	t
19	4	15	21	t
20	5	15	21	t
108	2	50	3	t
76	1	41	3	t
174	3	50	14	t
278	6	15	21	t
81	1	46	7	t
279	6	37	20	t
369	11	68	9	f
370	12	68	9	f
83	2	48	3	t
84	3	48	3	t
371	10	69	9	f
372	11	69	9	f
373	12	69	9	f
422	7	125	1	t
87	2	51	9	t
88	3	51	9	t
89	4	51	9	t
402	7	45	4	t
403	8	45	4	t
404	9	45	4	t
415	11	81	1	f
362	7	42	7	t
363	7	118	7	t
360	7	38	3	t
147	2	41	3	t
361	8	38	3	t
366	7	120	8	t
367	8	120	8	t
364	7	119	8	t
90	2	52	9	t
91	3	52	9	t
92	4	52	9	t
365	8	119	8	t
124	2	62	8	t
421	8	124	1	t
125	3	62	8	t
126	2	63	8	t
127	3	63	8	t
129	2	65	1	t
153	3	71	1	t
152	3	70	1	t
149	2	18	2	t
32	3	18	3	t
33	4	18	3	t
41	1	22	11	t
317	6	26	18	t
42	2	22	11	t
155	3	73	4	t
178	4	73	4	t
186	4	83	7	t
215	4	39	15	t
172	3	22	11	t
239	5	22	11	t
175	4	79	3	t
269	6	79	3	t
216	4	93	2	t
283	6	22	11	t
43	1	23	11	t
44	2	23	11	t
173	3	23	11	t
141	4	68	9	t
142	5	68	9	t
143	6	68	9	t
240	5	23	11	t
282	6	23	11	t
132	2	67	1	t
167	3	67	14	t
218	5	96	1	t
187	4	67	14	t
9	4	11	13	t
243	5	11	3	t
80	1	45	4	t
138	2	45	4	t
163	3	45	4	t
170	3	78	3	t
179	4	81	1	t
71	1	37	20	t
144	4	69	9	t
145	5	69	9	t
146	6	69	9	t
223	5	93	8	t
114	2	37	20	t
156	3	37	20	t
182	4	37	20	t
222	5	37	20	t
206	4	91	1	t
64	1	35	20	t
65	2	35	20	t
66	3	35	20	t
221	5	25	3	t
67	4	35	20	t
68	5	35	20	t
280	6	35	20	t
185	4	82	7	t
210	4	44	20	t
77	1	42	10	t
374	7	10	4	t
193	4	76	3	t
375	8	10	4	t
133	2	42	10	t
224	5	44	20	t
241	5	42	10	t
288	6	42	10	t
112	2	58	9	t
195	4	86	7	t
151	3	58	9	t
196	4	87	7	t
237	5	58	9	t
78	1	43	10	t
376	9	10	4	t
409	7	39	3	t
134	2	43	10	t
242	5	43	10	t
289	6	43	10	t
284	6	92	9	t
113	2	59	9	t
128	2	64	4	t
164	3	64	4	t
204	4	64	4	t
150	3	59	9	t
238	5	59	9	t
188	4	84	1	t
410	8	39	3	t
212	4	94	2	t
405	7	22	8	t
406	8	22	8	t
407	7	23	8	t
408	8	23	8	t
411	7	122	1	t
417	8	30	1	t
416	8	123	1	t
226	4	98	2	t
160	3	75	4	t
181	4	75	4	t
244	5	75	4	t
418	9	19	1	f
383	7	121	1	t
29	2	17	5	t
271	6	53	11	t
30	3	17	5	t
31	4	17	5	t
34	3	19	5	t
205	4	19	5	t
255	5	17	5	t
303	6	113	7	t
337	7	51	10	t
258	5	19	5	t
338	8	51	10	t
339	9	51	10	t
340	10	51	10	t
341	7	52	10	t
59	1	32	12	t
60	2	32	12	t
177	3	32	15	t
191	4	32	12	t
249	5	32	22	t
252	5	103	3	t
208	4	92	9	t
231	5	92	9	t
342	8	52	10	t
287	6	36	9	t
343	9	52	10	t
344	10	52	10	t
413	7	24	1	t
53	1	28	20	t
139	2	28	20	t
176	4	80	3	t
250	5	80	3	t
162	3	28	20	t
72	1	38	5	t
73	2	38	5	t
161	3	38	5	t
251	5	38	5	t
220	5	97	1	t
194	4	28	20	t
253	5	28	20	t
291	6	28	20	t
203	4	90	3	t
256	5	90	3	t
272	6	55	11	t
293	6	110	1	t
189	4	85	3	t
257	5	85	3	t
157	3	74	5	t
190	4	74	5	t
247	5	74	5	t
61	1	33	20	t
62	2	33	20	t
158	3	33	20	t
192	4	33	20	t
248	5	33	20	t
296	6	33	20	t
197	4	88	4	t
254	5	88	4	t
297	6	88	4	t
107	2	56	4	t
166	3	56	4	t
298	6	56	4	t
228	5	100	8	t
300	6	100	8	t
301	6	99	8	t
304	6	112	7	t
213	5	95	8	t
308	6	95	8	t
414	11	9	1	f
263	5	66	5	t
311	6	66	5	t
314	6	93	8	t
109	2	57	5	t
110	3	57	5	t
111	4	57	5	t
262	5	57	5	t
98	1	54	2	t
137	2	54	4	t
219	4	54	18	t
264	5	54	4	t
312	6	54	15	t
305	6	114	1	t
306	6	115	1	t
419	7	17	3	t
420	8	17	3	t
70	1	36	1	t
209	4	36	9	t
261	5	36	9	t
99	2	55	11	t
100	3	55	11	t
101	4	55	11	t
102	5	55	11	t
63	1	34	1	t
118	2	34	8	t
245	5	34	8	t
115	2	60	7	t
116	3	60	3	t
184	4	60	3	t
259	5	60	8	t
267	5	107	2	t
266	6	107	1	t
294	6	74	5	t
227	5	99	8	t
273	6	108	1	t
75	1	40	4	t
131	2	40	4	t
307	6	40	4	t
168	3	77	4	t
214	4	77	18	t
260	5	77	4	t
309	6	77	4	t
310	6	73	4	t
315	6	44	20	t
130	2	66	5	t
199	4	66	5	t
\.


--
-- TOC entry 1946 (class 0 OID 0)
-- Dependencies: 142
-- Name: partecipanti_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('partecipanti_oid_seq', 422, true);


--
-- TOC entry 1905 (class 0 OID 150103)
-- Dependencies: 143
-- Data for Name: periodi; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY periodi (oid, ordine, inizio, fine, anno) FROM stdin;
1	1	2016-07-04 00:00:00+02	2016-07-08 18:00:00+02	2016
2	2	2016-07-11 00:00:00+02	2016-07-15 18:00:00+02	2016
3	3	2016-07-18 00:00:00+02	2016-07-22 18:00:00+02	2016
4	4	2016-07-25 00:00:00+02	2016-07-29 18:00:00+02	2016
5	5	2016-08-01 00:00:00+02	2016-08-05 18:00:00+02	2016
6	6	2016-08-08 00:00:00+02	2016-08-12 18:00:00+02	2016
7	1	2017-07-03 00:00:00+02	2017-07-07 18:00:00+02	2017
8	2	2017-07-10 00:00:00+02	2017-07-14 18:00:00+02	2017
9	3	2017-07-17 00:00:00+02	2017-07-21 18:00:00+02	2017
10	4	2017-07-24 00:00:00+02	2017-07-28 18:00:00+02	2017
11	5	2017-07-31 00:00:00+02	2017-08-04 18:00:00+02	2017
12	6	2017-08-07 00:00:00+02	2017-08-11 18:00:00+02	2017
\.


--
-- TOC entry 1947 (class 0 OID 0)
-- Dependencies: 144
-- Name: periodi_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('periodi_oid_seq', 12, true);


--
-- TOC entry 1907 (class 0 OID 150111)
-- Dependencies: 145
-- Data for Name: presenze; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY presenze (ragazzo_oid, completo, mensa, mattina, pomeriggio, giorno, oid, presente) FROM stdin;
22	t	t	f	f	2016-07-04 00:00:00+02	132	t
49	f	f	f	f	2016-07-04 00:00:00+02	158	f
25	t	t	f	f	2016-07-04 00:00:00+02	133	t
20	t	t	f	f	2016-07-04 00:00:00+02	134	t
29	t	t	f	f	2016-07-04 00:00:00+02	135	t
15	t	t	f	f	2016-07-04 00:00:00+02	136	t
16	t	t	f	f	2016-07-04 00:00:00+02	137	t
32	f	t	t	f	2016-07-04 00:00:00+02	138	t
23	t	t	f	f	2016-07-04 00:00:00+02	139	t
33	t	t	f	f	2016-07-04 00:00:00+02	140	t
34	t	t	f	f	2016-07-04 00:00:00+02	141	t
21	t	t	f	f	2016-07-04 00:00:00+02	142	t
10	t	t	f	f	2016-07-04 00:00:00+02	143	t
35	t	t	f	f	2016-07-04 00:00:00+02	144	t
36	t	t	f	f	2016-07-04 00:00:00+02	145	t
37	t	t	f	f	2016-07-04 00:00:00+02	146	t
38	t	t	f	f	2016-07-04 00:00:00+02	147	t
39	t	t	f	f	2016-07-04 00:00:00+02	148	t
40	t	t	f	f	2016-07-04 00:00:00+02	149	t
24	t	t	f	f	2016-07-04 00:00:00+02	150	t
42	t	t	f	f	2016-07-04 00:00:00+02	151	t
43	t	t	f	f	2016-07-04 00:00:00+02	152	t
44	t	t	f	f	2016-07-04 00:00:00+02	153	t
41	t	t	f	f	2016-07-04 00:00:00+02	154	t
46	t	t	f	f	2016-07-04 00:00:00+02	155	t
45	t	t	f	f	2016-07-04 00:00:00+02	156	t
28	t	t	f	f	2016-07-04 00:00:00+02	157	t
22	t	t	f	f	2016-07-05 00:00:00+02	159	t
25	t	t	f	f	2016-07-05 00:00:00+02	160	t
20	t	t	f	f	2016-07-05 00:00:00+02	161	t
29	t	t	f	f	2016-07-05 00:00:00+02	162	t
15	t	t	f	f	2016-07-05 00:00:00+02	163	t
16	t	t	f	f	2016-07-05 00:00:00+02	164	t
32	f	t	t	f	2016-07-05 00:00:00+02	165	t
23	t	t	f	f	2016-07-05 00:00:00+02	166	t
33	t	t	f	f	2016-07-05 00:00:00+02	167	t
34	t	t	f	f	2016-07-05 00:00:00+02	168	t
21	t	t	f	f	2016-07-05 00:00:00+02	169	t
10	t	t	f	f	2016-07-05 00:00:00+02	170	t
35	t	t	f	f	2016-07-05 00:00:00+02	171	t
36	t	t	f	f	2016-07-05 00:00:00+02	172	t
37	t	t	f	f	2016-07-05 00:00:00+02	173	t
38	t	t	f	f	2016-07-05 00:00:00+02	174	t
39	f	f	f	f	2016-07-05 00:00:00+02	175	f
40	t	t	f	f	2016-07-05 00:00:00+02	176	t
24	t	t	f	f	2016-07-05 00:00:00+02	177	t
42	t	t	f	f	2016-07-05 00:00:00+02	178	t
43	t	t	f	f	2016-07-05 00:00:00+02	179	t
44	t	t	f	f	2016-07-05 00:00:00+02	180	t
41	t	t	f	f	2016-07-05 00:00:00+02	181	t
46	t	t	f	f	2016-07-05 00:00:00+02	182	t
45	t	t	f	f	2016-07-05 00:00:00+02	183	t
28	t	t	f	f	2016-07-05 00:00:00+02	184	t
49	f	f	f	f	2016-07-05 00:00:00+02	185	f
22	t	t	f	f	2016-07-06 00:00:00+02	186	t
25	t	t	f	f	2016-07-06 00:00:00+02	187	t
20	t	t	f	f	2016-07-06 00:00:00+02	188	t
24	t	t	f	f	2016-07-06 00:00:00+02	189	t
29	t	t	f	f	2016-07-06 00:00:00+02	190	t
15	t	t	f	f	2016-07-06 00:00:00+02	191	t
50	t	t	f	f	2016-07-06 00:00:00+02	192	t
16	t	t	f	f	2016-07-06 00:00:00+02	193	t
23	t	t	f	f	2016-07-06 00:00:00+02	195	t
33	t	t	f	f	2016-07-06 00:00:00+02	196	t
34	t	t	f	f	2016-07-06 00:00:00+02	197	t
21	t	t	f	f	2016-07-06 00:00:00+02	198	t
10	t	t	f	f	2016-07-06 00:00:00+02	199	t
35	t	t	f	f	2016-07-06 00:00:00+02	200	t
36	t	t	f	f	2016-07-06 00:00:00+02	201	t
37	t	t	f	f	2016-07-06 00:00:00+02	202	t
38	t	t	f	f	2016-07-06 00:00:00+02	203	t
39	f	f	f	f	2016-07-06 00:00:00+02	204	f
40	t	t	f	f	2016-07-06 00:00:00+02	205	t
42	t	t	f	f	2016-07-06 00:00:00+02	206	t
43	t	t	f	f	2016-07-06 00:00:00+02	207	t
44	t	t	f	f	2016-07-06 00:00:00+02	208	t
41	t	t	f	f	2016-07-06 00:00:00+02	209	t
46	t	t	f	f	2016-07-06 00:00:00+02	210	t
45	t	t	f	f	2016-07-06 00:00:00+02	211	t
28	t	t	f	f	2016-07-06 00:00:00+02	212	t
49	t	t	f	f	2016-07-06 00:00:00+02	213	t
35	t	t	f	f	2016-07-07 00:00:00+02	228	t
32	f	t	t	f	2016-07-06 00:00:00+02	194	t
22	t	t	f	f	2016-07-07 00:00:00+02	214	t
25	t	t	f	f	2016-07-07 00:00:00+02	215	t
20	t	t	f	f	2016-07-07 00:00:00+02	216	t
24	t	t	f	f	2016-07-07 00:00:00+02	217	t
29	t	t	f	f	2016-07-07 00:00:00+02	218	t
15	t	t	f	f	2016-07-07 00:00:00+02	219	t
50	t	t	f	f	2016-07-07 00:00:00+02	220	t
16	t	t	f	f	2016-07-07 00:00:00+02	221	t
23	t	t	f	f	2016-07-07 00:00:00+02	223	t
33	t	t	f	f	2016-07-07 00:00:00+02	224	t
34	t	t	f	f	2016-07-07 00:00:00+02	225	t
21	f	f	f	f	2016-07-07 00:00:00+02	226	f
10	t	t	f	f	2016-07-07 00:00:00+02	227	t
36	t	t	f	f	2016-07-07 00:00:00+02	229	t
37	t	t	f	f	2016-07-07 00:00:00+02	230	t
38	t	t	f	f	2016-07-07 00:00:00+02	232	t
39	f	f	f	f	2016-07-07 00:00:00+02	233	f
40	t	t	f	f	2016-07-07 00:00:00+02	234	t
42	t	t	f	f	2016-07-07 00:00:00+02	235	t
43	t	t	f	f	2016-07-07 00:00:00+02	236	t
44	t	t	f	f	2016-07-07 00:00:00+02	237	t
41	t	t	f	f	2016-07-07 00:00:00+02	238	t
46	t	t	f	f	2016-07-07 00:00:00+02	239	t
45	t	t	f	f	2016-07-07 00:00:00+02	240	t
28	t	t	f	f	2016-07-07 00:00:00+02	241	t
49	t	t	f	f	2016-07-07 00:00:00+02	242	t
32	f	t	t	f	2016-07-07 00:00:00+02	222	t
22	t	t	f	f	2016-07-08 00:00:00+02	243	t
25	t	t	f	f	2016-07-08 00:00:00+02	244	t
20	t	t	f	f	2016-07-08 00:00:00+02	245	t
24	t	t	f	f	2016-07-08 00:00:00+02	246	t
29	t	t	f	f	2016-07-08 00:00:00+02	247	t
15	t	t	f	f	2016-07-08 00:00:00+02	248	t
50	t	t	f	f	2016-07-08 00:00:00+02	249	t
16	t	t	f	f	2016-07-08 00:00:00+02	250	t
23	t	t	f	f	2016-07-08 00:00:00+02	252	t
33	t	t	f	f	2016-07-08 00:00:00+02	253	t
34	t	t	f	f	2016-07-08 00:00:00+02	254	t
10	t	t	f	f	2016-07-08 00:00:00+02	256	t
35	t	t	f	f	2016-07-08 00:00:00+02	257	t
36	t	t	f	f	2016-07-08 00:00:00+02	258	t
37	t	t	f	f	2016-07-08 00:00:00+02	259	t
38	t	t	f	f	2016-07-08 00:00:00+02	261	t
39	f	f	f	f	2016-07-08 00:00:00+02	262	f
40	t	t	f	f	2016-07-08 00:00:00+02	263	t
42	t	t	f	f	2016-07-08 00:00:00+02	264	t
43	t	t	f	f	2016-07-08 00:00:00+02	265	t
44	t	t	f	f	2016-07-08 00:00:00+02	266	t
41	t	t	f	f	2016-07-08 00:00:00+02	267	t
46	f	f	f	f	2016-07-08 00:00:00+02	268	f
45	t	t	f	f	2016-07-08 00:00:00+02	269	t
28	t	t	f	f	2016-07-08 00:00:00+02	270	t
49	t	t	f	f	2016-07-08 00:00:00+02	271	t
21	f	f	f	f	2016-07-08 00:00:00+02	255	f
54	f	f	f	f	2016-07-08 00:00:00+02	260	f
32	f	t	t	f	2016-07-08 00:00:00+02	251	t
54	t	t	f	f	2016-07-07 00:00:00+02	231	t
22	t	t	f	f	2016-07-11 00:00:00+02	272	t
10	t	t	f	f	2016-07-11 00:00:00+02	273	t
32	f	t	f	f	2016-07-11 00:00:00+02	274	t
17	t	t	f	f	2016-07-11 00:00:00+02	275	t
20	t	t	f	f	2016-07-11 00:00:00+02	276	t
24	t	t	f	f	2016-07-11 00:00:00+02	277	t
30	t	t	f	f	2016-07-11 00:00:00+02	278	t
15	t	t	f	f	2016-07-11 00:00:00+02	279	t
43	t	t	f	f	2016-07-11 00:00:00+02	280	t
42	t	t	f	f	2016-07-11 00:00:00+02	281	t
16	t	t	f	f	2016-07-11 00:00:00+02	282	t
23	t	t	f	f	2016-07-11 00:00:00+02	283	t
33	t	t	f	f	2016-07-11 00:00:00+02	284	t
39	t	t	f	f	2016-07-11 00:00:00+02	285	t
45	t	t	f	f	2016-07-11 00:00:00+02	286	t
35	t	t	f	f	2016-07-11 00:00:00+02	287	t
29	t	t	f	f	2016-07-11 00:00:00+02	288	t
54	t	t	f	f	2016-07-11 00:00:00+02	289	t
38	t	t	f	f	2016-07-11 00:00:00+02	290	t
59	t	t	f	f	2016-07-11 00:00:00+02	291	t
58	t	t	f	f	2016-07-11 00:00:00+02	292	t
26	t	t	f	f	2016-07-11 00:00:00+02	293	t
50	t	t	f	f	2016-07-11 00:00:00+02	294	t
48	t	t	f	f	2016-07-11 00:00:00+02	295	t
55	t	t	f	f	2016-07-11 00:00:00+02	296	t
51	t	t	f	f	2016-07-11 00:00:00+02	297	t
53	t	t	f	f	2016-07-11 00:00:00+02	298	t
37	t	t	f	f	2016-07-11 00:00:00+02	299	t
52	t	t	f	f	2016-07-11 00:00:00+02	300	t
57	t	t	f	f	2016-07-11 00:00:00+02	301	t
62	t	t	f	f	2016-07-11 00:00:00+02	302	t
56	t	t	f	f	2016-07-11 00:00:00+02	303	t
34	t	t	f	f	2016-07-11 00:00:00+02	304	t
60	t	t	f	f	2016-07-11 00:00:00+02	305	t
63	t	t	f	f	2016-07-11 00:00:00+02	306	t
64	t	t	f	f	2016-07-11 00:00:00+02	307	t
65	t	t	f	f	2016-07-11 00:00:00+02	308	t
66	t	t	f	f	2016-07-11 00:00:00+02	309	t
40	t	t	f	f	2016-07-11 00:00:00+02	310	t
67	t	t	f	f	2016-07-11 00:00:00+02	311	t
28	t	t	f	f	2016-07-11 00:00:00+02	312	t
44	t	t	f	f	2016-07-11 00:00:00+02	313	t
22	t	t	f	f	2016-07-12 00:00:00+02	314	t
10	t	t	f	f	2016-07-12 00:00:00+02	315	t
17	t	t	f	f	2016-07-12 00:00:00+02	316	t
20	t	t	f	f	2016-07-12 00:00:00+02	317	t
24	t	t	f	f	2016-07-12 00:00:00+02	318	t
30	t	t	f	f	2016-07-12 00:00:00+02	319	t
15	t	t	f	f	2016-07-12 00:00:00+02	320	t
42	t	t	f	f	2016-07-12 00:00:00+02	321	t
16	t	t	f	f	2016-07-12 00:00:00+02	322	t
23	t	t	f	f	2016-07-12 00:00:00+02	323	t
33	t	t	f	f	2016-07-12 00:00:00+02	324	t
39	t	t	f	f	2016-07-12 00:00:00+02	325	t
35	t	t	f	f	2016-07-12 00:00:00+02	326	t
29	t	t	f	f	2016-07-12 00:00:00+02	327	t
54	t	t	f	f	2016-07-12 00:00:00+02	328	t
28	t	t	f	f	2016-07-12 00:00:00+02	329	t
43	t	t	f	f	2016-07-12 00:00:00+02	330	t
38	t	t	f	f	2016-07-12 00:00:00+02	331	t
59	t	t	f	f	2016-07-12 00:00:00+02	332	t
58	t	t	f	f	2016-07-12 00:00:00+02	333	t
44	t	t	f	f	2016-07-12 00:00:00+02	334	t
26	t	t	f	f	2016-07-12 00:00:00+02	335	t
45	t	t	f	f	2016-07-12 00:00:00+02	336	t
50	t	t	f	f	2016-07-12 00:00:00+02	337	t
32	f	t	t	f	2016-07-12 00:00:00+02	338	t
57	t	t	f	f	2016-07-12 00:00:00+02	339	t
48	t	t	f	f	2016-07-12 00:00:00+02	340	t
55	t	t	f	f	2016-07-12 00:00:00+02	341	t
51	t	t	f	f	2016-07-12 00:00:00+02	342	t
53	t	t	f	f	2016-07-12 00:00:00+02	343	t
37	t	t	f	f	2016-07-12 00:00:00+02	344	t
52	t	t	f	f	2016-07-12 00:00:00+02	345	t
62	t	t	f	f	2016-07-12 00:00:00+02	346	t
56	t	t	f	f	2016-07-12 00:00:00+02	347	t
34	t	t	f	f	2016-07-12 00:00:00+02	348	t
60	t	t	f	f	2016-07-12 00:00:00+02	349	t
63	t	t	f	f	2016-07-12 00:00:00+02	350	t
64	t	t	f	f	2016-07-12 00:00:00+02	351	t
65	t	t	f	f	2016-07-12 00:00:00+02	352	t
66	t	t	f	f	2016-07-12 00:00:00+02	353	t
40	t	t	f	f	2016-07-12 00:00:00+02	354	t
67	t	t	f	f	2016-07-12 00:00:00+02	355	t
22	t	t	f	f	2016-07-13 00:00:00+02	356	t
10	t	t	f	f	2016-07-13 00:00:00+02	357	t
17	t	t	f	f	2016-07-13 00:00:00+02	358	t
20	t	t	f	f	2016-07-13 00:00:00+02	359	t
24	t	t	f	f	2016-07-13 00:00:00+02	360	t
30	t	t	f	f	2016-07-13 00:00:00+02	361	t
15	t	t	f	f	2016-07-13 00:00:00+02	362	t
42	t	t	f	f	2016-07-13 00:00:00+02	363	t
16	t	t	f	f	2016-07-13 00:00:00+02	364	t
23	t	t	f	f	2016-07-13 00:00:00+02	365	t
33	t	t	f	f	2016-07-13 00:00:00+02	366	t
39	t	t	f	f	2016-07-13 00:00:00+02	367	t
35	t	t	f	f	2016-07-13 00:00:00+02	368	t
29	t	t	f	f	2016-07-13 00:00:00+02	369	t
54	t	t	f	f	2016-07-13 00:00:00+02	370	t
28	t	t	f	f	2016-07-13 00:00:00+02	371	t
43	t	t	f	f	2016-07-13 00:00:00+02	372	t
38	t	t	f	f	2016-07-13 00:00:00+02	373	t
59	t	t	f	f	2016-07-13 00:00:00+02	374	t
58	t	t	f	f	2016-07-13 00:00:00+02	375	t
45	t	t	f	f	2016-07-13 00:00:00+02	378	t
32	f	t	t	f	2016-07-13 00:00:00+02	380	t
57	t	t	f	f	2016-07-13 00:00:00+02	381	t
48	t	t	f	f	2016-07-13 00:00:00+02	382	t
55	t	t	f	f	2016-07-13 00:00:00+02	383	t
51	t	t	f	f	2016-07-13 00:00:00+02	384	t
53	t	t	f	f	2016-07-13 00:00:00+02	385	t
41	t	t	f	f	2016-07-13 00:00:00+02	386	t
37	t	t	f	f	2016-07-13 00:00:00+02	387	t
52	t	t	f	f	2016-07-13 00:00:00+02	388	t
62	t	t	f	f	2016-07-13 00:00:00+02	389	t
56	t	t	f	f	2016-07-13 00:00:00+02	390	t
34	t	t	f	f	2016-07-13 00:00:00+02	391	t
60	t	t	f	f	2016-07-13 00:00:00+02	392	t
63	t	t	f	f	2016-07-13 00:00:00+02	393	t
64	t	t	f	f	2016-07-13 00:00:00+02	394	t
65	t	t	f	f	2016-07-13 00:00:00+02	395	t
66	t	t	f	f	2016-07-13 00:00:00+02	396	t
44	f	f	f	f	2016-07-13 00:00:00+02	376	f
40	t	t	f	f	2016-07-13 00:00:00+02	397	t
67	t	t	f	f	2016-07-13 00:00:00+02	398	t
50	f	f	f	f	2016-07-13 00:00:00+02	379	f
26	t	t	f	f	2016-07-13 00:00:00+02	377	t
22	f	f	f	f	2016-07-14 00:00:00+02	399	f
10	t	t	f	f	2016-07-14 00:00:00+02	400	t
17	t	t	f	f	2016-07-14 00:00:00+02	401	t
20	t	t	f	f	2016-07-14 00:00:00+02	402	t
24	t	t	f	f	2016-07-14 00:00:00+02	403	t
30	t	t	f	f	2016-07-14 00:00:00+02	404	t
15	t	t	f	f	2016-07-14 00:00:00+02	405	t
42	t	t	f	f	2016-07-14 00:00:00+02	406	t
16	t	t	f	f	2016-07-14 00:00:00+02	407	t
23	t	t	f	f	2016-07-14 00:00:00+02	408	t
33	t	t	f	f	2016-07-14 00:00:00+02	409	t
39	t	t	f	f	2016-07-14 00:00:00+02	410	t
35	t	t	f	f	2016-07-14 00:00:00+02	411	t
29	t	t	f	f	2016-07-14 00:00:00+02	412	t
54	t	t	f	f	2016-07-14 00:00:00+02	413	t
28	t	t	f	f	2016-07-14 00:00:00+02	414	t
43	t	t	f	f	2016-07-14 00:00:00+02	415	t
38	t	t	f	f	2016-07-14 00:00:00+02	416	t
59	t	t	f	f	2016-07-14 00:00:00+02	417	t
58	t	t	f	f	2016-07-14 00:00:00+02	418	t
44	f	f	f	f	2016-07-14 00:00:00+02	419	f
45	t	t	f	f	2016-07-14 00:00:00+02	420	t
50	t	t	f	f	2016-07-14 00:00:00+02	421	t
32	f	t	t	f	2016-07-14 00:00:00+02	422	t
57	t	t	f	f	2016-07-14 00:00:00+02	423	t
48	t	t	f	f	2016-07-14 00:00:00+02	424	t
55	t	t	f	f	2016-07-14 00:00:00+02	425	t
51	t	t	f	f	2016-07-14 00:00:00+02	426	t
53	t	t	f	f	2016-07-14 00:00:00+02	427	t
26	t	t	f	f	2016-07-14 00:00:00+02	428	t
41	t	t	f	f	2016-07-14 00:00:00+02	429	t
37	t	t	f	f	2016-07-14 00:00:00+02	430	t
52	t	t	f	f	2016-07-14 00:00:00+02	431	t
62	t	t	f	f	2016-07-14 00:00:00+02	432	t
56	t	t	f	f	2016-07-14 00:00:00+02	433	t
34	t	t	f	f	2016-07-14 00:00:00+02	434	t
60	t	t	f	f	2016-07-14 00:00:00+02	435	t
63	t	t	f	f	2016-07-14 00:00:00+02	436	t
64	t	t	f	f	2016-07-14 00:00:00+02	437	t
65	t	t	f	f	2016-07-14 00:00:00+02	438	t
66	t	t	f	f	2016-07-14 00:00:00+02	439	t
40	t	t	f	f	2016-07-14 00:00:00+02	440	t
67	t	t	f	f	2016-07-14 00:00:00+02	441	t
22	t	t	f	f	2016-07-15 00:00:00+02	442	t
10	t	t	f	f	2016-07-15 00:00:00+02	443	t
17	t	t	f	f	2016-07-15 00:00:00+02	444	t
20	t	t	f	f	2016-07-15 00:00:00+02	445	t
24	t	t	f	f	2016-07-15 00:00:00+02	446	t
30	t	t	f	f	2016-07-15 00:00:00+02	447	t
15	t	t	f	f	2016-07-15 00:00:00+02	448	t
42	t	t	f	f	2016-07-15 00:00:00+02	449	t
16	t	t	f	f	2016-07-15 00:00:00+02	450	t
23	t	t	f	f	2016-07-15 00:00:00+02	451	t
33	t	t	f	f	2016-07-15 00:00:00+02	452	t
39	t	t	f	f	2016-07-15 00:00:00+02	453	t
35	t	t	f	f	2016-07-15 00:00:00+02	454	t
29	f	f	f	f	2016-07-15 00:00:00+02	455	f
54	t	t	f	f	2016-07-15 00:00:00+02	456	t
28	t	t	f	f	2016-07-15 00:00:00+02	457	t
43	t	t	f	f	2016-07-15 00:00:00+02	458	t
38	t	t	f	f	2016-07-15 00:00:00+02	459	t
59	t	t	f	f	2016-07-15 00:00:00+02	460	t
58	t	t	f	f	2016-07-15 00:00:00+02	461	t
44	f	f	f	f	2016-07-15 00:00:00+02	462	f
18	t	t	f	f	2016-07-15 00:00:00+02	463	t
45	t	t	f	f	2016-07-15 00:00:00+02	464	t
50	t	t	f	f	2016-07-15 00:00:00+02	465	t
32	f	t	f	f	2016-07-15 00:00:00+02	466	t
57	t	t	f	f	2016-07-15 00:00:00+02	467	t
48	t	t	f	f	2016-07-15 00:00:00+02	468	t
55	t	t	f	f	2016-07-15 00:00:00+02	469	t
51	t	t	f	f	2016-07-15 00:00:00+02	470	t
53	t	t	f	f	2016-07-15 00:00:00+02	471	t
26	t	t	f	f	2016-07-15 00:00:00+02	472	t
41	t	t	f	f	2016-07-15 00:00:00+02	473	t
37	t	t	f	f	2016-07-15 00:00:00+02	474	t
52	t	t	f	f	2016-07-15 00:00:00+02	475	t
62	t	t	f	f	2016-07-15 00:00:00+02	476	t
56	t	t	f	f	2016-07-15 00:00:00+02	477	t
34	t	t	f	f	2016-07-15 00:00:00+02	478	t
60	t	t	f	f	2016-07-15 00:00:00+02	479	t
63	t	t	f	f	2016-07-15 00:00:00+02	480	t
64	t	t	f	f	2016-07-15 00:00:00+02	481	t
65	t	t	f	f	2016-07-15 00:00:00+02	482	t
66	t	t	f	f	2016-07-15 00:00:00+02	483	t
40	t	t	f	f	2016-07-15 00:00:00+02	484	t
67	t	t	f	f	2016-07-15 00:00:00+02	485	t
57	f	f	f	f	2016-07-18 00:00:00+02	486	f
19	t	t	f	f	2016-07-18 00:00:00+02	487	t
77	t	t	f	f	2016-07-18 00:00:00+02	488	t
72	t	t	f	f	2016-07-18 00:00:00+02	489	t
17	t	t	f	f	2016-07-18 00:00:00+02	490	t
27	t	t	f	f	2016-07-18 00:00:00+02	491	t
20	t	t	f	f	2016-07-18 00:00:00+02	492	t
30	t	t	f	f	2016-07-18 00:00:00+02	493	t
39	t	t	f	f	2016-07-18 00:00:00+02	494	t
45	t	t	f	f	2016-07-18 00:00:00+02	495	t
35	t	t	f	f	2016-07-18 00:00:00+02	496	t
44	t	t	f	f	2016-07-18 00:00:00+02	497	t
38	t	t	f	f	2016-07-18 00:00:00+02	498	t
50	t	t	f	f	2016-07-18 00:00:00+02	499	t
60	t	t	f	f	2016-07-18 00:00:00+02	500	t
48	t	t	f	f	2016-07-18 00:00:00+02	501	t
55	t	t	f	f	2016-07-18 00:00:00+02	502	t
51	t	t	f	f	2016-07-18 00:00:00+02	503	t
53	t	t	f	f	2016-07-18 00:00:00+02	504	t
52	t	t	f	f	2016-07-18 00:00:00+02	505	t
62	t	t	f	f	2016-07-18 00:00:00+02	506	t
63	t	t	f	f	2016-07-18 00:00:00+02	507	t
74	t	t	f	f	2016-07-18 00:00:00+02	508	t
71	t	t	f	f	2016-07-18 00:00:00+02	509	t
58	t	t	f	f	2016-07-18 00:00:00+02	510	t
59	t	t	f	f	2016-07-18 00:00:00+02	511	t
15	t	t	f	f	2016-07-18 00:00:00+02	512	t
16	t	t	f	f	2016-07-18 00:00:00+02	513	t
70	t	t	f	f	2016-07-18 00:00:00+02	514	t
18	t	t	f	f	2016-07-18 00:00:00+02	515	t
37	t	t	f	f	2016-07-18 00:00:00+02	516	t
33	t	t	f	f	2016-07-18 00:00:00+02	517	t
10	t	t	f	f	2016-07-18 00:00:00+02	518	t
75	t	t	f	f	2016-07-18 00:00:00+02	519	t
73	t	t	f	f	2016-07-18 00:00:00+02	520	t
28	t	t	f	f	2016-07-18 00:00:00+02	521	t
64	t	t	f	f	2016-07-18 00:00:00+02	522	t
76	t	t	f	f	2016-07-18 00:00:00+02	523	t
56	t	t	f	f	2016-07-18 00:00:00+02	524	t
78	t	t	f	f	2016-07-18 00:00:00+02	525	t
23	t	t	f	f	2016-07-18 00:00:00+02	526	t
22	t	t	f	f	2016-07-18 00:00:00+02	527	t
67	t	t	f	f	2016-07-18 00:00:00+02	528	t
77	t	t	f	f	2016-07-19 00:00:00+02	529	t
55	t	t	f	f	2016-07-19 00:00:00+02	530	t
53	t	t	f	f	2016-07-19 00:00:00+02	531	t
10	t	t	f	f	2016-07-19 00:00:00+02	532	t
16	t	t	f	f	2016-07-19 00:00:00+02	533	t
15	t	t	f	f	2016-07-19 00:00:00+02	534	t
18	t	t	f	f	2016-07-19 00:00:00+02	535	t
73	t	t	f	f	2016-07-19 00:00:00+02	536	t
39	f	f	f	f	2016-07-19 00:00:00+02	537	f
64	t	t	f	f	2016-07-19 00:00:00+02	538	t
58	t	t	f	f	2016-07-19 00:00:00+02	539	t
59	t	t	f	f	2016-07-19 00:00:00+02	540	t
48	t	t	f	f	2016-07-19 00:00:00+02	541	t
28	t	t	f	f	2016-07-19 00:00:00+02	542	t
72	t	t	f	f	2016-07-19 00:00:00+02	543	t
67	f	f	f	f	2016-07-19 00:00:00+02	544	f
76	t	t	f	f	2016-07-19 00:00:00+02	545	t
37	t	t	f	f	2016-07-19 00:00:00+02	546	t
74	t	t	f	f	2016-07-19 00:00:00+02	547	t
57	t	t	f	f	2016-07-19 00:00:00+02	548	t
33	t	t	f	f	2016-07-19 00:00:00+02	549	t
22	t	t	f	f	2016-07-19 00:00:00+02	550	t
23	t	t	f	f	2016-07-19 00:00:00+02	551	t
45	t	t	f	f	2016-07-19 00:00:00+02	552	t
75	t	t	f	f	2016-07-19 00:00:00+02	553	t
50	f	f	f	f	2016-07-19 00:00:00+02	554	f
71	t	t	f	f	2016-07-19 00:00:00+02	555	t
51	t	t	f	f	2016-07-19 00:00:00+02	556	t
52	t	t	f	f	2016-07-19 00:00:00+02	557	t
44	f	f	f	f	2016-07-19 00:00:00+02	558	f
17	t	t	f	f	2016-07-19 00:00:00+02	559	t
62	t	t	f	f	2016-07-19 00:00:00+02	560	t
63	t	t	f	f	2016-07-19 00:00:00+02	561	t
19	t	t	f	f	2016-07-19 00:00:00+02	562	t
70	t	t	f	f	2016-07-19 00:00:00+02	563	t
27	t	t	f	f	2016-07-19 00:00:00+02	564	t
35	t	t	f	f	2016-07-19 00:00:00+02	565	t
56	t	t	f	f	2016-07-19 00:00:00+02	566	t
30	t	t	f	f	2016-07-19 00:00:00+02	567	t
20	t	t	f	f	2016-07-19 00:00:00+02	568	t
78	t	t	f	f	2016-07-19 00:00:00+02	569	t
60	t	t	f	f	2016-07-19 00:00:00+02	570	t
38	t	t	f	f	2016-07-19 00:00:00+02	571	t
77	t	t	f	f	2016-07-20 00:00:00+02	572	t
55	t	t	f	f	2016-07-20 00:00:00+02	573	t
53	t	t	f	f	2016-07-20 00:00:00+02	574	t
10	t	t	f	f	2016-07-20 00:00:00+02	575	t
16	t	t	f	f	2016-07-20 00:00:00+02	576	t
15	t	t	f	f	2016-07-20 00:00:00+02	577	t
18	f	f	f	f	2016-07-20 00:00:00+02	578	f
73	t	t	f	f	2016-07-20 00:00:00+02	579	t
64	t	t	f	f	2016-07-20 00:00:00+02	581	t
58	t	t	f	f	2016-07-20 00:00:00+02	582	t
59	t	t	f	f	2016-07-20 00:00:00+02	583	t
48	t	t	f	f	2016-07-20 00:00:00+02	584	t
28	t	t	f	f	2016-07-20 00:00:00+02	585	t
72	t	t	f	f	2016-07-20 00:00:00+02	586	t
32	f	t	t	f	2016-07-20 00:00:00+02	587	t
76	t	t	f	f	2016-07-20 00:00:00+02	589	t
37	t	t	f	f	2016-07-20 00:00:00+02	590	t
74	t	t	f	f	2016-07-20 00:00:00+02	591	t
57	t	t	f	f	2016-07-20 00:00:00+02	592	t
33	t	t	f	f	2016-07-20 00:00:00+02	593	t
22	t	t	f	f	2016-07-20 00:00:00+02	594	t
23	t	t	f	f	2016-07-20 00:00:00+02	595	t
45	t	t	f	f	2016-07-20 00:00:00+02	596	t
75	t	t	f	f	2016-07-20 00:00:00+02	597	t
71	t	t	f	f	2016-07-20 00:00:00+02	599	t
51	t	t	f	f	2016-07-20 00:00:00+02	600	t
52	t	t	f	f	2016-07-20 00:00:00+02	601	t
44	f	f	f	f	2016-07-20 00:00:00+02	602	f
17	t	t	f	f	2016-07-20 00:00:00+02	603	t
62	t	t	f	f	2016-07-20 00:00:00+02	604	t
63	t	t	f	f	2016-07-20 00:00:00+02	605	t
19	t	t	f	f	2016-07-20 00:00:00+02	606	t
70	t	t	f	f	2016-07-20 00:00:00+02	607	t
27	t	t	f	f	2016-07-20 00:00:00+02	608	t
35	t	t	f	f	2016-07-20 00:00:00+02	609	t
56	t	t	f	f	2016-07-20 00:00:00+02	610	t
30	t	t	f	f	2016-07-20 00:00:00+02	611	t
20	t	t	f	f	2016-07-20 00:00:00+02	612	t
78	t	t	f	f	2016-07-20 00:00:00+02	613	t
60	t	t	f	f	2016-07-20 00:00:00+02	614	t
38	t	t	f	f	2016-07-20 00:00:00+02	615	t
77	t	t	f	f	2016-07-21 00:00:00+02	616	t
55	t	t	f	f	2016-07-21 00:00:00+02	617	t
53	t	t	f	f	2016-07-21 00:00:00+02	618	t
10	t	t	f	f	2016-07-21 00:00:00+02	619	t
16	t	t	f	f	2016-07-21 00:00:00+02	620	t
15	t	t	f	f	2016-07-21 00:00:00+02	621	t
18	t	t	f	f	2016-07-21 00:00:00+02	622	t
73	t	t	f	f	2016-07-21 00:00:00+02	623	t
64	t	t	f	f	2016-07-21 00:00:00+02	625	t
58	t	t	f	f	2016-07-21 00:00:00+02	626	t
59	t	t	f	f	2016-07-21 00:00:00+02	627	t
48	t	t	f	f	2016-07-21 00:00:00+02	628	t
28	t	t	f	f	2016-07-21 00:00:00+02	629	t
72	t	t	f	f	2016-07-21 00:00:00+02	630	t
76	t	t	f	f	2016-07-21 00:00:00+02	633	t
37	t	t	f	f	2016-07-21 00:00:00+02	634	t
74	t	t	f	f	2016-07-21 00:00:00+02	635	t
57	f	f	f	f	2016-07-21 00:00:00+02	636	f
33	t	t	f	f	2016-07-21 00:00:00+02	637	t
22	t	t	f	f	2016-07-21 00:00:00+02	638	t
23	t	t	f	f	2016-07-21 00:00:00+02	639	t
45	t	t	f	f	2016-07-21 00:00:00+02	640	t
75	t	t	f	f	2016-07-21 00:00:00+02	641	t
71	t	t	f	f	2016-07-21 00:00:00+02	643	t
51	t	t	f	f	2016-07-21 00:00:00+02	644	t
52	t	t	f	f	2016-07-21 00:00:00+02	645	t
44	f	f	f	f	2016-07-21 00:00:00+02	646	f
17	t	t	f	f	2016-07-21 00:00:00+02	647	t
62	t	t	f	f	2016-07-21 00:00:00+02	648	t
63	t	t	f	f	2016-07-21 00:00:00+02	649	t
19	t	t	f	f	2016-07-21 00:00:00+02	650	t
70	t	t	f	f	2016-07-21 00:00:00+02	651	t
27	t	t	f	f	2016-07-21 00:00:00+02	652	t
35	t	t	f	f	2016-07-21 00:00:00+02	653	t
56	t	t	f	f	2016-07-21 00:00:00+02	654	t
30	t	t	f	f	2016-07-21 00:00:00+02	655	t
20	t	t	f	f	2016-07-21 00:00:00+02	656	t
78	t	t	f	f	2016-07-21 00:00:00+02	657	t
60	t	t	f	f	2016-07-21 00:00:00+02	658	t
38	t	t	f	f	2016-07-21 00:00:00+02	659	t
39	f	f	f	f	2016-07-21 00:00:00+02	624	f
32	f	f	f	f	2016-07-21 00:00:00+02	631	f
77	f	f	f	f	2016-07-22 00:00:00+02	660	f
55	t	t	f	f	2016-07-22 00:00:00+02	661	t
53	t	t	f	f	2016-07-22 00:00:00+02	662	t
10	t	t	f	f	2016-07-22 00:00:00+02	663	t
16	t	t	f	f	2016-07-22 00:00:00+02	664	t
15	t	t	f	f	2016-07-22 00:00:00+02	665	t
18	t	t	f	f	2016-07-22 00:00:00+02	666	t
73	t	t	f	f	2016-07-22 00:00:00+02	667	t
39	f	f	f	f	2016-07-22 00:00:00+02	668	f
64	t	t	f	f	2016-07-22 00:00:00+02	669	t
58	t	t	f	f	2016-07-22 00:00:00+02	670	t
59	t	t	f	f	2016-07-22 00:00:00+02	671	t
48	t	t	f	f	2016-07-22 00:00:00+02	672	t
28	t	t	f	f	2016-07-22 00:00:00+02	673	t
72	t	t	f	f	2016-07-22 00:00:00+02	674	t
32	f	f	f	f	2016-07-22 00:00:00+02	675	f
76	t	t	f	f	2016-07-22 00:00:00+02	677	t
37	t	t	f	f	2016-07-22 00:00:00+02	678	t
74	t	t	f	f	2016-07-22 00:00:00+02	679	t
33	t	t	f	f	2016-07-22 00:00:00+02	681	t
22	t	t	f	f	2016-07-22 00:00:00+02	682	t
23	t	t	f	f	2016-07-22 00:00:00+02	683	t
45	t	t	f	f	2016-07-22 00:00:00+02	684	t
75	t	t	f	f	2016-07-22 00:00:00+02	685	t
71	t	t	f	f	2016-07-22 00:00:00+02	687	t
51	t	t	f	f	2016-07-22 00:00:00+02	688	t
52	t	t	f	f	2016-07-22 00:00:00+02	689	t
44	f	f	f	f	2016-07-22 00:00:00+02	690	f
17	t	t	f	f	2016-07-22 00:00:00+02	691	t
62	t	t	f	f	2016-07-22 00:00:00+02	692	t
63	t	t	f	f	2016-07-22 00:00:00+02	693	t
19	t	t	f	f	2016-07-22 00:00:00+02	694	t
70	t	t	f	f	2016-07-22 00:00:00+02	695	t
27	f	f	f	f	2016-07-22 00:00:00+02	696	f
35	t	t	f	f	2016-07-22 00:00:00+02	697	t
56	t	t	f	f	2016-07-22 00:00:00+02	698	t
30	t	t	f	f	2016-07-22 00:00:00+02	699	t
20	t	t	f	f	2016-07-22 00:00:00+02	700	t
78	t	t	f	f	2016-07-22 00:00:00+02	701	t
60	t	t	f	f	2016-07-22 00:00:00+02	702	t
38	t	t	f	f	2016-07-22 00:00:00+02	703	t
50	f	f	f	f	2016-07-21 00:00:00+02	642	f
50	f	f	f	f	2016-07-22 00:00:00+02	686	f
67	t	t	f	f	2016-07-21 00:00:00+02	632	t
67	t	t	f	f	2016-07-22 00:00:00+02	676	t
57	t	t	f	f	2016-07-22 00:00:00+02	680	t
50	f	f	f	f	2016-07-20 00:00:00+02	598	f
39	t	t	f	f	2016-07-20 00:00:00+02	580	t
67	f	f	f	f	2016-07-20 00:00:00+02	588	f
32	f	f	f	f	2016-07-19 00:00:00+02	704	f
81	t	t	f	f	2016-07-25 00:00:00+02	705	t
88	t	t	f	f	2016-07-25 00:00:00+02	706	t
77	f	f	f	f	2016-07-25 00:00:00+02	707	f
92	f	f	f	f	2016-07-25 00:00:00+02	708	f
36	f	f	f	f	2016-07-25 00:00:00+02	709	f
9	t	t	f	f	2016-07-25 00:00:00+02	710	t
55	t	t	f	f	2016-07-25 00:00:00+02	711	t
53	t	t	f	f	2016-07-25 00:00:00+02	712	t
87	t	t	f	f	2016-07-25 00:00:00+02	713	t
86	t	t	f	f	2016-07-25 00:00:00+02	714	t
15	t	t	f	f	2016-07-25 00:00:00+02	715	t
16	t	t	f	f	2016-07-25 00:00:00+02	716	t
18	t	t	f	f	2016-07-25 00:00:00+02	717	t
68	t	t	f	f	2016-07-25 00:00:00+02	718	t
69	t	t	f	f	2016-07-25 00:00:00+02	719	t
73	t	t	f	f	2016-07-25 00:00:00+02	720	t
39	f	f	f	f	2016-07-25 00:00:00+02	721	f
64	t	t	f	f	2016-07-25 00:00:00+02	722	t
82	t	t	f	f	2016-07-25 00:00:00+02	723	t
83	t	t	f	f	2016-07-25 00:00:00+02	724	t
79	t	t	f	f	2016-07-25 00:00:00+02	725	t
66	t	t	f	f	2016-07-25 00:00:00+02	726	t
80	t	t	f	f	2016-07-25 00:00:00+02	727	t
28	t	t	f	f	2016-07-25 00:00:00+02	728	t
90	t	t	f	f	2016-07-25 00:00:00+02	729	t
32	t	t	f	f	2016-07-25 00:00:00+02	730	t
67	f	f	f	f	2016-07-25 00:00:00+02	731	f
76	t	t	f	f	2016-07-25 00:00:00+02	732	t
47	t	t	f	f	2016-07-25 00:00:00+02	733	t
37	t	t	f	f	2016-07-25 00:00:00+02	734	t
84	t	t	f	f	2016-07-25 00:00:00+02	736	t
74	t	t	f	f	2016-07-25 00:00:00+02	738	t
94	f	f	f	f	2016-07-25 00:00:00+02	739	f
57	t	t	f	f	2016-07-25 00:00:00+02	740	t
33	t	t	f	f	2016-07-25 00:00:00+02	741	t
75	t	t	f	f	2016-07-25 00:00:00+02	742	t
26	t	t	f	f	2016-07-25 00:00:00+02	743	t
85	t	t	f	f	2016-07-25 00:00:00+02	744	t
51	t	t	f	f	2016-07-25 00:00:00+02	745	t
52	t	t	f	f	2016-07-25 00:00:00+02	746	t
44	f	f	f	f	2016-07-25 00:00:00+02	747	f
17	t	t	f	f	2016-07-25 00:00:00+02	748	t
91	f	f	f	f	2016-07-25 00:00:00+02	749	f
19	t	t	f	f	2016-07-25 00:00:00+02	750	t
27	t	t	f	f	2016-07-25 00:00:00+02	751	t
35	t	t	f	f	2016-07-25 00:00:00+02	752	t
20	t	t	f	f	2016-07-25 00:00:00+02	753	t
78	t	t	f	f	2016-07-25 00:00:00+02	754	t
60	t	t	f	f	2016-07-25 00:00:00+02	755	t
81	t	t	f	f	2016-07-26 00:00:00+02	756	t
88	t	t	f	f	2016-07-26 00:00:00+02	757	t
9	t	t	f	f	2016-07-26 00:00:00+02	761	t
55	t	t	f	f	2016-07-26 00:00:00+02	762	t
53	t	t	f	f	2016-07-26 00:00:00+02	763	t
87	t	t	f	f	2016-07-26 00:00:00+02	764	t
86	t	t	f	f	2016-07-26 00:00:00+02	765	t
18	t	t	f	f	2016-07-26 00:00:00+02	768	t
68	t	t	f	f	2016-07-26 00:00:00+02	769	t
69	t	t	f	f	2016-07-26 00:00:00+02	770	t
73	t	t	f	f	2016-07-26 00:00:00+02	771	t
39	f	f	f	f	2016-07-26 00:00:00+02	772	f
64	t	t	f	f	2016-07-26 00:00:00+02	773	t
82	t	t	f	f	2016-07-26 00:00:00+02	774	t
83	t	t	f	f	2016-07-26 00:00:00+02	775	t
79	t	t	f	f	2016-07-26 00:00:00+02	776	t
66	t	t	f	f	2016-07-26 00:00:00+02	777	t
80	t	t	f	f	2016-07-26 00:00:00+02	778	t
28	t	t	f	f	2016-07-26 00:00:00+02	779	t
90	t	t	f	f	2016-07-26 00:00:00+02	780	t
67	f	f	f	f	2016-07-26 00:00:00+02	782	f
76	t	t	f	f	2016-07-26 00:00:00+02	783	t
47	t	t	f	f	2016-07-26 00:00:00+02	784	t
37	t	t	f	f	2016-07-26 00:00:00+02	785	t
14	f	f	f	f	2016-07-26 00:00:00+02	786	f
84	t	t	f	f	2016-07-26 00:00:00+02	787	t
11	f	f	t	f	2016-07-26 00:00:00+02	788	t
74	t	t	f	f	2016-07-26 00:00:00+02	789	t
94	f	f	f	f	2016-07-26 00:00:00+02	790	f
57	t	t	f	f	2016-07-26 00:00:00+02	791	t
33	t	t	f	f	2016-07-26 00:00:00+02	792	t
75	t	t	f	f	2016-07-26 00:00:00+02	793	t
26	t	t	f	f	2016-07-26 00:00:00+02	794	t
85	t	t	f	f	2016-07-26 00:00:00+02	795	t
52	t	t	f	f	2016-07-26 00:00:00+02	796	t
17	t	t	f	f	2016-07-26 00:00:00+02	799	t
91	t	t	f	f	2016-07-26 00:00:00+02	800	t
19	t	t	f	f	2016-07-26 00:00:00+02	801	t
27	t	t	f	f	2016-07-26 00:00:00+02	802	t
35	t	t	f	f	2016-07-26 00:00:00+02	803	t
20	t	t	f	f	2016-07-26 00:00:00+02	804	t
78	t	t	f	f	2016-07-26 00:00:00+02	805	t
60	t	t	f	f	2016-07-26 00:00:00+02	806	t
14	f	f	f	f	2016-07-25 00:00:00+02	735	f
93	f	f	f	f	2016-07-25 00:00:00+02	808	f
11	f	f	t	f	2016-07-25 00:00:00+02	737	t
77	t	t	f	f	2016-07-26 00:00:00+02	758	t
36	t	t	f	f	2016-07-26 00:00:00+02	760	t
92	t	t	f	f	2016-07-26 00:00:00+02	759	t
16	f	f	f	f	2016-07-26 00:00:00+02	767	f
15	f	f	f	f	2016-07-26 00:00:00+02	766	f
32	f	f	f	f	2016-07-26 00:00:00+02	781	f
93	t	t	f	f	2016-07-26 00:00:00+02	807	t
51	f	f	t	t	2016-07-26 00:00:00+02	797	t
44	t	t	f	f	2016-07-26 00:00:00+02	798	t
81	t	t	f	f	2016-07-27 00:00:00+02	809	t
88	t	t	f	f	2016-07-27 00:00:00+02	810	t
77	f	f	f	f	2016-07-27 00:00:00+02	811	f
36	t	t	f	f	2016-07-27 00:00:00+02	812	t
92	t	t	f	f	2016-07-27 00:00:00+02	813	t
9	t	t	f	f	2016-07-27 00:00:00+02	814	t
55	t	t	f	f	2016-07-27 00:00:00+02	815	t
53	t	t	f	f	2016-07-27 00:00:00+02	816	t
87	t	t	f	f	2016-07-27 00:00:00+02	817	t
86	t	t	f	f	2016-07-27 00:00:00+02	818	t
16	t	t	f	f	2016-07-27 00:00:00+02	819	t
15	t	t	f	f	2016-07-27 00:00:00+02	820	t
18	t	t	f	f	2016-07-27 00:00:00+02	821	t
69	t	t	f	f	2016-07-27 00:00:00+02	822	t
68	t	t	f	f	2016-07-27 00:00:00+02	823	t
73	t	t	f	f	2016-07-27 00:00:00+02	824	t
39	t	t	f	f	2016-07-27 00:00:00+02	825	t
64	t	t	f	f	2016-07-27 00:00:00+02	826	t
82	t	t	f	f	2016-07-27 00:00:00+02	827	t
83	t	t	f	f	2016-07-27 00:00:00+02	828	t
79	t	t	f	f	2016-07-27 00:00:00+02	829	t
66	t	t	f	f	2016-07-27 00:00:00+02	830	t
80	t	t	f	f	2016-07-27 00:00:00+02	831	t
28	t	t	f	f	2016-07-27 00:00:00+02	832	t
90	t	t	f	f	2016-07-27 00:00:00+02	833	t
32	f	t	t	f	2016-07-27 00:00:00+02	834	t
67	f	f	f	f	2016-07-27 00:00:00+02	835	f
76	t	t	f	f	2016-07-27 00:00:00+02	836	t
47	t	t	f	f	2016-07-27 00:00:00+02	837	t
37	t	t	f	f	2016-07-27 00:00:00+02	838	t
84	t	t	f	f	2016-07-27 00:00:00+02	840	t
74	t	t	f	f	2016-07-27 00:00:00+02	842	t
93	f	f	f	f	2016-07-27 00:00:00+02	843	f
94	f	f	f	f	2016-07-27 00:00:00+02	844	f
57	t	t	f	f	2016-07-27 00:00:00+02	845	t
33	t	t	f	f	2016-07-27 00:00:00+02	846	t
75	t	t	f	f	2016-07-27 00:00:00+02	847	t
26	t	t	f	f	2016-07-27 00:00:00+02	848	t
85	t	t	f	f	2016-07-27 00:00:00+02	849	t
52	t	t	f	f	2016-07-27 00:00:00+02	850	t
51	t	t	f	f	2016-07-27 00:00:00+02	851	t
44	t	t	f	f	2016-07-27 00:00:00+02	852	t
17	t	t	f	f	2016-07-27 00:00:00+02	853	t
91	t	t	f	f	2016-07-27 00:00:00+02	854	t
19	t	t	f	f	2016-07-27 00:00:00+02	855	t
27	t	t	f	f	2016-07-27 00:00:00+02	856	t
35	t	t	f	f	2016-07-27 00:00:00+02	857	t
20	t	t	f	f	2016-07-27 00:00:00+02	858	t
78	t	t	f	f	2016-07-27 00:00:00+02	859	t
60	t	t	f	f	2016-07-27 00:00:00+02	860	t
11	f	f	t	f	2016-07-27 00:00:00+02	841	t
14	f	f	f	f	2016-07-27 00:00:00+02	839	f
81	t	t	f	f	2016-07-28 00:00:00+02	861	t
88	t	t	f	f	2016-07-28 00:00:00+02	862	t
77	f	f	f	f	2016-07-28 00:00:00+02	863	f
36	t	t	f	f	2016-07-28 00:00:00+02	864	t
92	t	t	f	f	2016-07-28 00:00:00+02	865	t
9	t	t	f	f	2016-07-28 00:00:00+02	866	t
53	t	t	f	f	2016-07-28 00:00:00+02	867	t
55	t	t	f	f	2016-07-28 00:00:00+02	868	t
86	t	t	f	f	2016-07-28 00:00:00+02	869	t
87	t	t	f	f	2016-07-28 00:00:00+02	870	t
54	t	t	f	f	2016-07-28 00:00:00+02	871	t
15	t	t	f	f	2016-07-28 00:00:00+02	872	t
16	t	t	f	f	2016-07-28 00:00:00+02	873	t
18	t	t	f	f	2016-07-28 00:00:00+02	874	t
68	t	t	f	f	2016-07-28 00:00:00+02	875	t
69	t	t	f	f	2016-07-28 00:00:00+02	876	t
73	t	t	f	f	2016-07-28 00:00:00+02	877	t
39	t	t	f	f	2016-07-28 00:00:00+02	878	t
64	t	t	f	f	2016-07-28 00:00:00+02	879	t
82	t	t	f	f	2016-07-28 00:00:00+02	880	t
83	t	t	f	f	2016-07-28 00:00:00+02	881	t
79	t	t	f	f	2016-07-28 00:00:00+02	882	t
66	t	t	f	f	2016-07-28 00:00:00+02	883	t
80	t	t	f	f	2016-07-28 00:00:00+02	884	t
28	t	t	f	f	2016-07-28 00:00:00+02	885	t
90	t	t	f	f	2016-07-28 00:00:00+02	886	t
32	t	t	f	f	2016-07-28 00:00:00+02	887	t
76	t	t	f	f	2016-07-28 00:00:00+02	889	t
47	t	t	f	f	2016-07-28 00:00:00+02	890	t
37	t	t	f	f	2016-07-28 00:00:00+02	891	t
14	f	f	f	f	2016-07-28 00:00:00+02	892	f
84	t	t	f	f	2016-07-28 00:00:00+02	893	t
74	t	t	f	f	2016-07-28 00:00:00+02	895	t
93	f	f	f	f	2016-07-28 00:00:00+02	896	f
94	t	t	f	f	2016-07-28 00:00:00+02	897	t
33	t	t	f	f	2016-07-28 00:00:00+02	899	t
75	t	t	f	f	2016-07-28 00:00:00+02	900	t
26	t	t	f	f	2016-07-28 00:00:00+02	901	t
85	t	t	f	f	2016-07-28 00:00:00+02	902	t
52	t	t	f	f	2016-07-28 00:00:00+02	903	t
51	t	t	f	f	2016-07-28 00:00:00+02	904	t
17	t	t	f	f	2016-07-28 00:00:00+02	906	t
91	t	t	f	f	2016-07-28 00:00:00+02	907	t
19	t	t	f	f	2016-07-28 00:00:00+02	908	t
27	t	t	f	f	2016-07-28 00:00:00+02	909	t
35	t	t	f	f	2016-07-28 00:00:00+02	910	t
20	t	t	f	f	2016-07-28 00:00:00+02	911	t
78	t	t	f	f	2016-07-28 00:00:00+02	912	t
60	t	t	f	f	2016-07-28 00:00:00+02	913	t
57	f	f	f	f	2016-07-28 00:00:00+02	898	f
67	f	f	f	f	2016-07-28 00:00:00+02	888	f
81	t	t	f	f	2016-07-29 00:00:00+02	914	t
88	t	t	f	f	2016-07-29 00:00:00+02	915	t
77	f	f	f	f	2016-07-29 00:00:00+02	916	f
92	t	t	f	f	2016-07-29 00:00:00+02	917	t
36	t	t	f	f	2016-07-29 00:00:00+02	918	t
9	t	t	f	f	2016-07-29 00:00:00+02	919	t
53	t	t	f	f	2016-07-29 00:00:00+02	920	t
55	t	t	f	f	2016-07-29 00:00:00+02	921	t
54	t	t	f	f	2016-07-29 00:00:00+02	922	t
86	t	t	f	f	2016-07-29 00:00:00+02	923	t
87	t	t	f	f	2016-07-29 00:00:00+02	924	t
15	t	t	f	f	2016-07-29 00:00:00+02	925	t
16	t	t	f	f	2016-07-29 00:00:00+02	926	t
18	t	t	f	f	2016-07-29 00:00:00+02	927	t
69	t	t	f	f	2016-07-29 00:00:00+02	928	t
68	t	t	f	f	2016-07-29 00:00:00+02	929	t
73	t	t	f	f	2016-07-29 00:00:00+02	930	t
39	t	t	f	f	2016-07-29 00:00:00+02	931	t
64	t	t	f	f	2016-07-29 00:00:00+02	932	t
82	t	t	f	f	2016-07-29 00:00:00+02	933	t
83	t	t	f	f	2016-07-29 00:00:00+02	934	t
79	t	t	f	f	2016-07-29 00:00:00+02	935	t
66	t	t	f	f	2016-07-29 00:00:00+02	936	t
80	t	t	f	f	2016-07-29 00:00:00+02	937	t
28	t	t	f	f	2016-07-29 00:00:00+02	938	t
90	t	t	f	f	2016-07-29 00:00:00+02	939	t
32	t	t	f	f	2016-07-29 00:00:00+02	940	t
67	t	t	f	f	2016-07-29 00:00:00+02	941	t
76	t	t	f	f	2016-07-29 00:00:00+02	942	t
47	t	t	f	f	2016-07-29 00:00:00+02	943	t
37	t	t	f	f	2016-07-29 00:00:00+02	944	t
84	t	t	f	f	2016-07-29 00:00:00+02	946	t
11	f	f	f	f	2016-07-29 00:00:00+02	947	t
74	t	t	f	f	2016-07-29 00:00:00+02	948	t
94	f	f	f	f	2016-07-29 00:00:00+02	949	f
93	f	f	f	f	2016-07-29 00:00:00+02	950	f
57	f	f	f	f	2016-07-29 00:00:00+02	951	f
33	t	t	f	f	2016-07-29 00:00:00+02	952	t
75	t	t	f	f	2016-07-29 00:00:00+02	953	t
26	t	t	f	f	2016-07-29 00:00:00+02	954	t
85	t	t	f	f	2016-07-29 00:00:00+02	955	t
51	t	t	f	f	2016-07-29 00:00:00+02	956	t
52	t	t	f	f	2016-07-29 00:00:00+02	957	t
44	t	t	f	f	2016-07-29 00:00:00+02	958	t
17	t	t	f	f	2016-07-29 00:00:00+02	959	t
91	t	t	f	f	2016-07-29 00:00:00+02	960	t
19	t	t	f	f	2016-07-29 00:00:00+02	961	t
27	f	f	f	f	2016-07-29 00:00:00+02	962	f
35	t	t	f	f	2016-07-29 00:00:00+02	963	t
20	t	t	f	f	2016-07-29 00:00:00+02	964	t
78	t	t	f	f	2016-07-29 00:00:00+02	965	t
60	t	t	f	f	2016-07-29 00:00:00+02	966	t
98	t	t	f	f	2016-07-28 00:00:00+02	967	t
54	f	f	f	f	2016-07-26 00:00:00+02	968	f
98	t	t	f	f	2016-07-26 00:00:00+02	969	t
54	f	f	f	f	2016-07-25 00:00:00+02	970	f
98	f	f	f	f	2016-07-25 00:00:00+02	971	f
98	f	f	f	f	2016-07-29 00:00:00+02	972	f
14	f	f	f	f	2016-07-29 00:00:00+02	945	f
11	f	f	f	f	2016-07-28 00:00:00+02	894	t
44	f	f	f	f	2016-07-28 00:00:00+02	905	f
39	t	t	f	f	2016-08-01 00:00:00+02	980	t
93	f	f	f	f	2016-08-01 00:00:00+02	983	f
44	f	f	f	f	2016-08-01 00:00:00+02	988	f
39	t	t	f	f	2016-08-02 00:00:00+02	999	t
44	f	f	f	f	2016-08-02 00:00:00+02	1007	f
88	t	t	f	f	2016-08-01 00:00:00+02	1011	t
77	t	t	f	f	2016-08-01 00:00:00+02	1012	t
92	t	t	f	f	2016-08-01 00:00:00+02	1013	t
36	t	t	f	f	2016-08-01 00:00:00+02	1014	t
9	t	t	f	f	2016-08-01 00:00:00+02	973	t
53	t	t	f	f	2016-08-01 00:00:00+02	975	t
55	t	t	f	f	2016-08-01 00:00:00+02	974	t
43	t	t	f	f	2016-08-01 00:00:00+02	1015	t
42	t	t	f	f	2016-08-01 00:00:00+02	1016	t
15	t	t	f	f	2016-08-01 00:00:00+02	976	t
16	t	t	f	f	2016-08-01 00:00:00+02	977	t
69	t	t	f	f	2016-08-01 00:00:00+02	979	t
68	t	t	f	f	2016-08-01 00:00:00+02	978	t
58	t	t	f	f	2016-08-01 00:00:00+02	1017	t
59	t	t	f	f	2016-08-01 00:00:00+02	1018	t
80	t	t	f	f	2016-08-01 00:00:00+02	1019	t
25	t	t	f	f	2016-08-01 00:00:00+02	981	t
28	t	t	f	f	2016-08-01 00:00:00+02	1020	t
90	t	t	f	f	2016-08-01 00:00:00+02	1021	t
32	t	t	f	f	2016-08-01 00:00:00+02	1022	t
37	t	t	f	f	2016-08-01 00:00:00+02	982	t
11	t	t	f	f	2016-08-01 00:00:00+02	1023	t
74	t	t	f	f	2016-08-01 00:00:00+02	1024	t
97	t	t	f	f	2016-08-01 00:00:00+02	1025	t
95	t	t	f	f	2016-08-01 00:00:00+02	984	t
57	t	t	f	f	2016-08-01 00:00:00+02	1026	t
100	t	t	f	f	2016-08-01 00:00:00+02	985	t
99	t	t	f	f	2016-08-01 00:00:00+02	986	t
33	t	t	f	f	2016-08-01 00:00:00+02	1027	t
22	t	t	f	f	2016-08-01 00:00:00+02	1028	t
23	t	t	f	f	2016-08-01 00:00:00+02	1029	t
75	t	t	f	f	2016-08-01 00:00:00+02	1030	t
26	t	t	f	f	2016-08-01 00:00:00+02	987	t
85	t	t	f	f	2016-08-01 00:00:00+02	1031	t
17	t	t	f	f	2016-08-01 00:00:00+02	1032	t
103	t	t	f	f	2016-08-01 00:00:00+02	1033	t
19	t	t	f	f	2016-08-01 00:00:00+02	1034	t
35	t	t	f	f	2016-08-01 00:00:00+02	989	t
96	t	t	f	f	2016-08-01 00:00:00+02	990	t
20	t	t	f	f	2016-08-01 00:00:00+02	991	t
60	t	t	f	f	2016-08-01 00:00:00+02	1035	t
34	t	t	f	f	2016-08-01 00:00:00+02	1036	t
38	t	t	f	f	2016-08-01 00:00:00+02	1037	t
88	t	t	f	f	2016-08-02 00:00:00+02	1038	t
77	t	t	f	f	2016-08-02 00:00:00+02	1039	t
36	t	t	f	f	2016-08-02 00:00:00+02	1040	t
92	t	t	f	f	2016-08-02 00:00:00+02	1041	t
9	t	t	f	f	2016-08-02 00:00:00+02	992	t
55	t	t	f	f	2016-08-02 00:00:00+02	993	t
53	t	t	f	f	2016-08-02 00:00:00+02	994	t
54	t	t	f	f	2016-08-02 00:00:00+02	1042	t
42	t	t	f	f	2016-08-02 00:00:00+02	1043	t
43	t	t	f	f	2016-08-02 00:00:00+02	1044	t
15	t	t	f	f	2016-08-02 00:00:00+02	995	t
16	t	t	f	f	2016-08-02 00:00:00+02	996	t
68	t	t	f	f	2016-08-02 00:00:00+02	997	t
69	t	t	f	f	2016-08-02 00:00:00+02	998	t
58	t	t	f	f	2016-08-02 00:00:00+02	1045	t
59	t	t	f	f	2016-08-02 00:00:00+02	1046	t
66	t	t	f	f	2016-08-02 00:00:00+02	1047	t
80	t	t	f	f	2016-08-02 00:00:00+02	1048	t
25	t	t	f	f	2016-08-02 00:00:00+02	1000	t
28	t	t	f	f	2016-08-02 00:00:00+02	1049	t
90	t	t	f	f	2016-08-02 00:00:00+02	1050	t
32	f	f	f	f	2016-08-02 00:00:00+02	1051	f
37	t	t	f	f	2016-08-02 00:00:00+02	1001	t
11	t	t	f	f	2016-08-02 00:00:00+02	1052	t
74	t	t	f	f	2016-08-02 00:00:00+02	1053	t
97	t	t	f	f	2016-08-02 00:00:00+02	1054	t
95	t	t	f	f	2016-08-02 00:00:00+02	1003	t
93	t	t	f	f	2016-08-02 00:00:00+02	1002	t
57	t	t	f	f	2016-08-02 00:00:00+02	1055	t
99	t	t	f	f	2016-08-02 00:00:00+02	1005	t
100	t	t	f	f	2016-08-02 00:00:00+02	1004	t
33	t	t	f	f	2016-08-02 00:00:00+02	1056	t
23	t	t	f	f	2016-08-02 00:00:00+02	1057	t
22	t	t	f	f	2016-08-02 00:00:00+02	1058	t
75	t	t	f	f	2016-08-02 00:00:00+02	1059	t
26	t	t	f	f	2016-08-02 00:00:00+02	1006	t
85	t	t	f	f	2016-08-02 00:00:00+02	1060	t
17	t	t	f	f	2016-08-02 00:00:00+02	1061	t
103	t	t	f	f	2016-08-02 00:00:00+02	1062	t
19	t	t	f	f	2016-08-02 00:00:00+02	1063	t
35	t	t	f	f	2016-08-02 00:00:00+02	1008	t
96	t	t	f	f	2016-08-02 00:00:00+02	1009	t
20	t	t	f	f	2016-08-02 00:00:00+02	1010	t
60	t	t	f	f	2016-08-02 00:00:00+02	1064	t
34	t	t	f	f	2016-08-02 00:00:00+02	1065	t
38	t	t	f	f	2016-08-02 00:00:00+02	1066	t
88	t	t	f	f	2016-08-03 00:00:00+02	1067	t
77	t	t	f	f	2016-08-03 00:00:00+02	1068	t
36	t	t	f	f	2016-08-03 00:00:00+02	1069	t
92	t	t	f	f	2016-08-03 00:00:00+02	1070	t
9	t	t	f	f	2016-08-03 00:00:00+02	1071	t
55	t	t	f	f	2016-08-03 00:00:00+02	1072	t
53	t	t	f	f	2016-08-03 00:00:00+02	1073	t
54	t	t	f	f	2016-08-03 00:00:00+02	1074	t
42	t	t	f	f	2016-08-03 00:00:00+02	1075	t
43	t	t	f	f	2016-08-03 00:00:00+02	1076	t
15	t	t	f	f	2016-08-03 00:00:00+02	1077	t
16	t	t	f	f	2016-08-03 00:00:00+02	1078	t
68	t	t	f	f	2016-08-03 00:00:00+02	1079	t
69	t	t	f	f	2016-08-03 00:00:00+02	1080	t
39	f	f	f	f	2016-08-03 00:00:00+02	1081	f
58	t	t	f	f	2016-08-03 00:00:00+02	1082	t
59	t	t	f	f	2016-08-03 00:00:00+02	1083	t
66	t	t	f	f	2016-08-03 00:00:00+02	1084	t
80	t	t	f	f	2016-08-03 00:00:00+02	1085	t
25	t	t	f	f	2016-08-03 00:00:00+02	1086	t
28	t	t	f	f	2016-08-03 00:00:00+02	1087	t
90	t	t	f	f	2016-08-03 00:00:00+02	1088	t
32	t	t	f	f	2016-08-03 00:00:00+02	1089	t
37	t	t	f	f	2016-08-03 00:00:00+02	1090	t
11	t	t	f	f	2016-08-03 00:00:00+02	1091	t
74	t	t	f	f	2016-08-03 00:00:00+02	1092	t
97	t	t	f	f	2016-08-03 00:00:00+02	1093	t
95	t	t	f	f	2016-08-03 00:00:00+02	1094	t
93	t	t	f	f	2016-08-03 00:00:00+02	1095	t
57	t	t	f	f	2016-08-03 00:00:00+02	1096	t
99	t	t	f	f	2016-08-03 00:00:00+02	1097	t
100	t	t	f	f	2016-08-03 00:00:00+02	1098	t
33	t	t	f	f	2016-08-03 00:00:00+02	1099	t
22	t	t	f	f	2016-08-03 00:00:00+02	1100	t
23	t	t	f	f	2016-08-03 00:00:00+02	1101	t
75	t	t	f	f	2016-08-03 00:00:00+02	1102	t
26	t	t	f	f	2016-08-03 00:00:00+02	1103	t
85	t	t	f	f	2016-08-03 00:00:00+02	1104	t
44	t	t	f	f	2016-08-03 00:00:00+02	1105	t
17	t	t	f	f	2016-08-03 00:00:00+02	1106	t
103	t	t	f	f	2016-08-03 00:00:00+02	1107	t
19	t	t	f	f	2016-08-03 00:00:00+02	1108	t
35	t	t	f	f	2016-08-03 00:00:00+02	1109	t
96	t	t	f	f	2016-08-03 00:00:00+02	1110	t
20	t	t	f	f	2016-08-03 00:00:00+02	1111	t
60	t	t	f	f	2016-08-03 00:00:00+02	1112	t
34	t	t	f	f	2016-08-03 00:00:00+02	1113	t
38	t	t	f	f	2016-08-03 00:00:00+02	1114	t
88	t	t	f	f	2016-08-04 00:00:00+02	1116	t
77	t	t	f	f	2016-08-04 00:00:00+02	1117	t
92	t	t	f	f	2016-08-04 00:00:00+02	1118	t
36	t	t	f	f	2016-08-04 00:00:00+02	1119	t
9	t	t	f	f	2016-08-04 00:00:00+02	1120	t
55	t	t	f	f	2016-08-04 00:00:00+02	1121	t
53	t	t	f	f	2016-08-04 00:00:00+02	1122	t
54	t	t	f	f	2016-08-04 00:00:00+02	1123	t
42	t	t	f	f	2016-08-04 00:00:00+02	1124	t
43	t	t	f	f	2016-08-04 00:00:00+02	1125	t
16	t	t	f	f	2016-08-04 00:00:00+02	1126	t
15	t	t	f	f	2016-08-04 00:00:00+02	1127	t
68	t	t	f	f	2016-08-04 00:00:00+02	1128	t
69	t	t	f	f	2016-08-04 00:00:00+02	1129	t
39	f	f	f	f	2016-08-04 00:00:00+02	1130	f
59	t	t	f	f	2016-08-04 00:00:00+02	1131	t
58	t	t	f	f	2016-08-04 00:00:00+02	1132	t
66	t	t	f	f	2016-08-04 00:00:00+02	1133	t
80	t	t	f	f	2016-08-04 00:00:00+02	1134	t
25	t	t	f	f	2016-08-04 00:00:00+02	1135	t
28	t	t	f	f	2016-08-04 00:00:00+02	1136	t
90	t	t	f	f	2016-08-04 00:00:00+02	1137	t
32	f	f	f	f	2016-08-04 00:00:00+02	1138	f
37	t	t	f	f	2016-08-04 00:00:00+02	1139	t
11	t	t	f	f	2016-08-04 00:00:00+02	1140	t
74	t	t	f	f	2016-08-04 00:00:00+02	1141	t
97	t	t	f	f	2016-08-04 00:00:00+02	1142	t
95	t	t	f	f	2016-08-04 00:00:00+02	1144	t
57	t	t	f	f	2016-08-04 00:00:00+02	1145	t
99	t	t	f	f	2016-08-04 00:00:00+02	1146	t
100	t	t	f	f	2016-08-04 00:00:00+02	1147	t
33	t	t	f	f	2016-08-04 00:00:00+02	1148	t
22	t	t	f	f	2016-08-04 00:00:00+02	1149	t
23	t	t	f	f	2016-08-04 00:00:00+02	1150	t
75	t	t	f	f	2016-08-04 00:00:00+02	1151	t
26	t	t	f	f	2016-08-04 00:00:00+02	1152	t
85	t	t	f	f	2016-08-04 00:00:00+02	1153	t
44	t	t	f	f	2016-08-04 00:00:00+02	1154	t
17	t	t	f	f	2016-08-04 00:00:00+02	1155	t
103	f	f	t	t	2016-08-04 00:00:00+02	1156	t
107	t	t	f	f	2016-08-04 00:00:00+02	1157	t
19	t	t	f	f	2016-08-04 00:00:00+02	1158	t
35	t	t	f	f	2016-08-04 00:00:00+02	1159	t
96	t	t	f	f	2016-08-04 00:00:00+02	1160	t
20	t	t	f	f	2016-08-04 00:00:00+02	1161	t
34	t	t	f	f	2016-08-04 00:00:00+02	1162	t
60	t	t	f	f	2016-08-04 00:00:00+02	1163	t
38	t	t	f	f	2016-08-04 00:00:00+02	1164	t
93	f	f	f	f	2016-08-04 00:00:00+02	1143	f
67	t	t	f	f	2016-08-04 00:00:00+02	1165	t
67	t	t	f	f	2016-08-03 00:00:00+02	1166	t
107	t	t	f	f	2016-08-03 00:00:00+02	1115	t
88	t	t	f	f	2016-08-05 00:00:00+02	1167	t
77	t	t	f	f	2016-08-05 00:00:00+02	1168	t
36	t	t	f	f	2016-08-05 00:00:00+02	1169	t
92	t	t	f	f	2016-08-05 00:00:00+02	1170	t
9	t	t	f	f	2016-08-05 00:00:00+02	1171	t
53	t	t	f	f	2016-08-05 00:00:00+02	1172	t
55	t	t	f	f	2016-08-05 00:00:00+02	1173	t
54	t	t	f	f	2016-08-05 00:00:00+02	1174	t
42	t	t	f	f	2016-08-05 00:00:00+02	1175	t
43	t	t	f	f	2016-08-05 00:00:00+02	1176	t
15	t	t	f	f	2016-08-05 00:00:00+02	1177	t
16	t	t	f	f	2016-08-05 00:00:00+02	1178	t
69	t	t	f	f	2016-08-05 00:00:00+02	1179	t
68	t	t	f	f	2016-08-05 00:00:00+02	1180	t
39	f	f	f	f	2016-08-05 00:00:00+02	1181	f
59	t	t	f	f	2016-08-05 00:00:00+02	1182	t
58	t	t	f	f	2016-08-05 00:00:00+02	1183	t
66	t	t	f	f	2016-08-05 00:00:00+02	1184	t
80	f	f	f	f	2016-08-05 00:00:00+02	1185	f
25	t	t	f	f	2016-08-05 00:00:00+02	1186	t
28	t	t	f	f	2016-08-05 00:00:00+02	1187	t
90	t	t	f	f	2016-08-05 00:00:00+02	1188	t
32	f	f	f	f	2016-08-05 00:00:00+02	1189	f
67	t	t	f	f	2016-08-05 00:00:00+02	1190	t
37	t	t	f	f	2016-08-05 00:00:00+02	1191	t
11	t	t	f	f	2016-08-05 00:00:00+02	1192	t
74	t	t	f	f	2016-08-05 00:00:00+02	1193	t
97	t	t	f	f	2016-08-05 00:00:00+02	1194	t
93	t	t	f	f	2016-08-05 00:00:00+02	1195	t
95	t	t	f	f	2016-08-05 00:00:00+02	1196	t
57	f	f	f	f	2016-08-05 00:00:00+02	1197	f
100	t	t	f	f	2016-08-05 00:00:00+02	1198	t
99	t	t	f	f	2016-08-05 00:00:00+02	1199	t
33	t	t	f	f	2016-08-05 00:00:00+02	1200	t
22	t	t	f	f	2016-08-05 00:00:00+02	1201	t
23	t	t	f	f	2016-08-05 00:00:00+02	1202	t
75	t	t	f	f	2016-08-05 00:00:00+02	1203	t
26	t	t	f	f	2016-08-05 00:00:00+02	1204	t
85	t	t	f	f	2016-08-05 00:00:00+02	1205	t
44	f	f	f	f	2016-08-05 00:00:00+02	1206	f
17	t	t	f	f	2016-08-05 00:00:00+02	1207	t
103	t	t	f	f	2016-08-05 00:00:00+02	1208	t
107	f	f	f	f	2016-08-05 00:00:00+02	1209	f
19	t	t	f	f	2016-08-05 00:00:00+02	1210	t
35	t	t	f	f	2016-08-05 00:00:00+02	1211	t
96	t	t	f	f	2016-08-05 00:00:00+02	1212	t
20	t	t	f	f	2016-08-05 00:00:00+02	1213	t
34	t	t	f	f	2016-08-05 00:00:00+02	1214	t
60	t	t	f	f	2016-08-05 00:00:00+02	1215	t
38	t	t	f	f	2016-08-05 00:00:00+02	1216	t
54	f	f	f	f	2016-08-01 00:00:00+02	1217	f
66	f	f	f	f	2016-08-01 00:00:00+02	1218	f
67	f	f	f	f	2016-08-01 00:00:00+02	1219	f
107	f	f	f	f	2016-08-01 00:00:00+02	1220	f
67	f	f	f	f	2016-08-02 00:00:00+02	1221	f
107	f	f	f	f	2016-08-02 00:00:00+02	1222	f
88	t	t	f	f	2016-08-08 00:00:00+02	1223	t
77	t	t	f	f	2016-08-08 00:00:00+02	1224	t
92	t	t	f	f	2016-08-08 00:00:00+02	1225	t
36	t	t	f	f	2016-08-08 00:00:00+02	1226	t
110	t	t	f	f	2016-08-08 00:00:00+02	1227	t
55	t	t	f	f	2016-08-08 00:00:00+02	1228	t
53	t	t	f	f	2016-08-08 00:00:00+02	1229	t
113	t	t	f	f	2016-08-08 00:00:00+02	1230	t
112	t	t	f	f	2016-08-08 00:00:00+02	1231	t
43	t	t	f	f	2016-08-08 00:00:00+02	1232	t
42	t	t	f	f	2016-08-08 00:00:00+02	1233	t
16	t	t	f	f	2016-08-08 00:00:00+02	1234	t
15	t	t	f	f	2016-08-08 00:00:00+02	1235	t
68	t	t	f	f	2016-08-08 00:00:00+02	1236	t
69	t	t	f	f	2016-08-08 00:00:00+02	1237	t
115	t	t	f	f	2016-08-08 00:00:00+02	1238	t
79	t	t	f	f	2016-08-08 00:00:00+02	1239	t
114	t	t	f	f	2016-08-08 00:00:00+02	1240	t
28	t	t	f	f	2016-08-08 00:00:00+02	1241	t
37	t	t	f	f	2016-08-08 00:00:00+02	1242	t
74	t	t	f	f	2016-08-08 00:00:00+02	1243	t
95	t	t	f	f	2016-08-08 00:00:00+02	1244	t
99	t	t	f	f	2016-08-08 00:00:00+02	1245	t
100	t	t	f	f	2016-08-08 00:00:00+02	1246	t
33	t	t	f	f	2016-08-08 00:00:00+02	1247	t
23	t	t	f	f	2016-08-08 00:00:00+02	1248	t
22	t	t	f	f	2016-08-08 00:00:00+02	1249	t
108	t	t	f	f	2016-08-08 00:00:00+02	1250	t
40	t	t	f	f	2016-08-08 00:00:00+02	1251	t
103	t	t	f	f	2016-08-08 00:00:00+02	1252	t
107	t	t	f	f	2016-08-08 00:00:00+02	1253	t
19	t	t	f	f	2016-08-08 00:00:00+02	1254	t
35	t	t	f	f	2016-08-08 00:00:00+02	1255	t
56	t	t	f	f	2016-08-08 00:00:00+02	1256	t
88	t	t	f	f	2016-08-09 00:00:00+02	1257	t
77	t	t	f	f	2016-08-09 00:00:00+02	1258	t
92	t	t	f	f	2016-08-09 00:00:00+02	1259	t
36	t	t	f	f	2016-08-09 00:00:00+02	1260	t
110	t	t	f	f	2016-08-09 00:00:00+02	1261	t
112	t	t	f	f	2016-08-09 00:00:00+02	1262	t
53	t	t	f	f	2016-08-09 00:00:00+02	1263	t
55	t	t	f	f	2016-08-09 00:00:00+02	1264	t
113	t	t	f	f	2016-08-09 00:00:00+02	1265	t
42	t	t	f	f	2016-08-09 00:00:00+02	1267	t
43	t	t	f	f	2016-08-09 00:00:00+02	1268	t
15	t	t	f	f	2016-08-09 00:00:00+02	1269	t
16	t	t	f	f	2016-08-09 00:00:00+02	1270	t
69	t	t	f	f	2016-08-09 00:00:00+02	1271	t
68	t	t	f	f	2016-08-09 00:00:00+02	1272	t
73	t	t	f	f	2016-08-09 00:00:00+02	1273	t
115	t	t	f	f	2016-08-09 00:00:00+02	1274	t
79	t	t	f	f	2016-08-09 00:00:00+02	1275	t
114	t	t	f	f	2016-08-09 00:00:00+02	1277	t
28	t	t	f	f	2016-08-09 00:00:00+02	1278	t
37	t	t	f	f	2016-08-09 00:00:00+02	1279	t
74	t	t	f	f	2016-08-09 00:00:00+02	1280	t
95	t	t	f	f	2016-08-09 00:00:00+02	1281	t
93	t	t	f	f	2016-08-09 00:00:00+02	1282	t
99	t	t	f	f	2016-08-09 00:00:00+02	1283	t
100	t	t	f	f	2016-08-09 00:00:00+02	1284	t
33	t	t	f	f	2016-08-09 00:00:00+02	1285	t
22	t	t	f	f	2016-08-09 00:00:00+02	1286	t
23	t	t	f	f	2016-08-09 00:00:00+02	1287	t
108	f	f	f	f	2016-08-09 00:00:00+02	1288	f
40	t	t	f	f	2016-08-09 00:00:00+02	1289	t
103	t	t	f	f	2016-08-09 00:00:00+02	1290	t
107	t	t	f	f	2016-08-09 00:00:00+02	1291	t
19	t	t	f	f	2016-08-09 00:00:00+02	1292	t
35	t	t	f	f	2016-08-09 00:00:00+02	1293	t
56	t	t	f	f	2016-08-09 00:00:00+02	1294	t
54	f	f	f	f	2016-08-09 00:00:00+02	1266	f
66	f	f	f	f	2016-08-09 00:00:00+02	1276	f
88	t	t	f	f	2016-08-10 00:00:00+02	1295	t
77	t	t	f	f	2016-08-10 00:00:00+02	1296	t
92	t	t	f	f	2016-08-10 00:00:00+02	1297	t
36	t	t	f	f	2016-08-10 00:00:00+02	1298	t
110	t	t	f	f	2016-08-10 00:00:00+02	1299	t
112	t	t	f	f	2016-08-10 00:00:00+02	1300	t
53	t	t	f	f	2016-08-10 00:00:00+02	1301	t
55	t	t	f	f	2016-08-10 00:00:00+02	1302	t
113	t	t	f	f	2016-08-10 00:00:00+02	1303	t
54	t	t	f	f	2016-08-10 00:00:00+02	1304	t
42	t	t	f	f	2016-08-10 00:00:00+02	1305	t
43	t	t	f	f	2016-08-10 00:00:00+02	1306	t
15	t	t	f	f	2016-08-10 00:00:00+02	1307	t
16	t	t	f	f	2016-08-10 00:00:00+02	1308	t
69	t	t	f	f	2016-08-10 00:00:00+02	1309	t
68	t	t	f	f	2016-08-10 00:00:00+02	1310	t
73	t	t	f	f	2016-08-10 00:00:00+02	1311	t
115	t	t	f	f	2016-08-10 00:00:00+02	1312	t
79	t	t	f	f	2016-08-10 00:00:00+02	1313	t
66	t	t	f	f	2016-08-10 00:00:00+02	1314	t
114	t	t	f	f	2016-08-10 00:00:00+02	1315	t
28	t	t	f	f	2016-08-10 00:00:00+02	1316	t
37	t	t	f	f	2016-08-10 00:00:00+02	1317	t
74	t	t	f	f	2016-08-10 00:00:00+02	1318	t
95	t	t	f	f	2016-08-10 00:00:00+02	1319	t
93	t	t	f	f	2016-08-10 00:00:00+02	1320	t
99	t	t	f	f	2016-08-10 00:00:00+02	1321	t
100	t	t	f	f	2016-08-10 00:00:00+02	1322	t
33	t	t	f	f	2016-08-10 00:00:00+02	1323	t
22	t	t	f	f	2016-08-10 00:00:00+02	1324	t
23	t	t	f	f	2016-08-10 00:00:00+02	1325	t
108	f	f	f	f	2016-08-10 00:00:00+02	1326	f
40	t	t	f	f	2016-08-10 00:00:00+02	1327	t
107	t	t	f	f	2016-08-10 00:00:00+02	1329	t
19	t	t	f	f	2016-08-10 00:00:00+02	1330	t
35	t	t	f	f	2016-08-10 00:00:00+02	1331	t
56	t	t	f	f	2016-08-10 00:00:00+02	1332	t
103	f	t	t	f	2016-08-10 00:00:00+02	1328	t
88	t	t	f	f	2016-08-11 00:00:00+02	1333	t
77	t	t	f	f	2016-08-11 00:00:00+02	1334	t
92	t	t	f	f	2016-08-11 00:00:00+02	1335	t
36	t	t	f	f	2016-08-11 00:00:00+02	1336	t
110	t	t	f	f	2016-08-11 00:00:00+02	1337	t
112	t	t	f	f	2016-08-11 00:00:00+02	1338	t
53	t	t	f	f	2016-08-11 00:00:00+02	1339	t
55	t	t	f	f	2016-08-11 00:00:00+02	1340	t
113	t	t	f	f	2016-08-11 00:00:00+02	1341	t
54	t	t	f	f	2016-08-11 00:00:00+02	1342	t
42	t	t	f	f	2016-08-11 00:00:00+02	1343	t
43	t	t	f	f	2016-08-11 00:00:00+02	1344	t
15	t	t	f	f	2016-08-11 00:00:00+02	1345	t
16	t	t	f	f	2016-08-11 00:00:00+02	1346	t
69	t	t	f	f	2016-08-11 00:00:00+02	1347	t
68	t	t	f	f	2016-08-11 00:00:00+02	1348	t
73	t	t	f	f	2016-08-11 00:00:00+02	1349	t
115	t	t	f	f	2016-08-11 00:00:00+02	1350	t
79	t	t	f	f	2016-08-11 00:00:00+02	1351	t
66	t	t	f	f	2016-08-11 00:00:00+02	1352	t
114	t	t	f	f	2016-08-11 00:00:00+02	1353	t
28	t	t	f	f	2016-08-11 00:00:00+02	1354	t
37	t	t	f	f	2016-08-11 00:00:00+02	1355	t
74	t	t	f	f	2016-08-11 00:00:00+02	1356	t
95	t	t	f	f	2016-08-11 00:00:00+02	1357	t
93	t	t	f	f	2016-08-11 00:00:00+02	1358	t
99	t	t	f	f	2016-08-11 00:00:00+02	1359	t
100	f	f	f	f	2016-08-11 00:00:00+02	1360	f
33	t	t	f	f	2016-08-11 00:00:00+02	1361	t
22	t	t	f	f	2016-08-11 00:00:00+02	1362	t
23	t	t	f	f	2016-08-11 00:00:00+02	1363	t
108	t	t	f	f	2016-08-11 00:00:00+02	1364	t
40	t	t	f	f	2016-08-11 00:00:00+02	1365	t
103	t	t	f	f	2016-08-11 00:00:00+02	1366	t
107	t	t	f	f	2016-08-11 00:00:00+02	1367	t
19	t	t	f	f	2016-08-11 00:00:00+02	1368	t
35	t	t	f	f	2016-08-11 00:00:00+02	1369	t
56	t	t	f	f	2016-08-11 00:00:00+02	1370	t
44	t	t	f	f	2016-08-11 00:00:00+02	1371	t
88	t	t	f	f	2016-08-12 00:00:00+02	1372	t
77	t	t	f	f	2016-08-12 00:00:00+02	1373	t
36	t	t	f	f	2016-08-12 00:00:00+02	1374	t
92	t	t	f	f	2016-08-12 00:00:00+02	1375	t
110	t	t	f	f	2016-08-12 00:00:00+02	1376	t
112	t	t	f	f	2016-08-12 00:00:00+02	1377	t
53	t	t	f	f	2016-08-12 00:00:00+02	1378	t
113	t	t	f	f	2016-08-12 00:00:00+02	1379	t
55	t	t	f	f	2016-08-12 00:00:00+02	1380	t
54	t	t	f	f	2016-08-12 00:00:00+02	1381	t
43	t	t	f	f	2016-08-12 00:00:00+02	1382	t
42	t	t	f	f	2016-08-12 00:00:00+02	1383	t
16	t	t	f	f	2016-08-12 00:00:00+02	1384	t
15	t	t	f	f	2016-08-12 00:00:00+02	1385	t
69	t	t	f	f	2016-08-12 00:00:00+02	1386	t
68	t	t	f	f	2016-08-12 00:00:00+02	1387	t
73	t	t	f	f	2016-08-12 00:00:00+02	1388	t
115	t	t	f	f	2016-08-12 00:00:00+02	1389	t
79	t	t	f	f	2016-08-12 00:00:00+02	1390	t
66	t	t	f	f	2016-08-12 00:00:00+02	1391	t
114	t	t	f	f	2016-08-12 00:00:00+02	1392	t
28	t	t	f	f	2016-08-12 00:00:00+02	1393	t
32	t	t	f	f	2016-08-12 00:00:00+02	1394	t
37	t	t	f	f	2016-08-12 00:00:00+02	1395	t
74	t	t	f	f	2016-08-12 00:00:00+02	1396	t
95	t	t	f	f	2016-08-12 00:00:00+02	1397	t
93	t	t	f	f	2016-08-12 00:00:00+02	1398	t
100	t	t	f	f	2016-08-12 00:00:00+02	1399	t
99	t	t	f	f	2016-08-12 00:00:00+02	1400	t
33	t	t	f	f	2016-08-12 00:00:00+02	1401	t
23	t	t	f	f	2016-08-12 00:00:00+02	1402	t
22	t	t	f	f	2016-08-12 00:00:00+02	1403	t
108	t	t	f	f	2016-08-12 00:00:00+02	1404	t
40	t	t	f	f	2016-08-12 00:00:00+02	1405	t
44	f	f	f	f	2016-08-12 00:00:00+02	1406	f
103	t	t	f	f	2016-08-12 00:00:00+02	1407	t
107	t	t	f	f	2016-08-12 00:00:00+02	1408	t
19	t	t	f	f	2016-08-12 00:00:00+02	1409	t
35	t	t	f	f	2016-08-12 00:00:00+02	1410	t
56	t	t	f	f	2016-08-12 00:00:00+02	1411	t
26	t	t	f	f	2016-08-12 00:00:00+02	1412	t
\.


--
-- TOC entry 1948 (class 0 OID 0)
-- Dependencies: 146
-- Name: presenze_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('presenze_oid_seq', 1412, true);


--
-- TOC entry 1909 (class 0 OID 150116)
-- Dependencies: 147
-- Data for Name: quote; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY quote (oid, anno, importo, tipo) FROM stdin;
\.


--
-- TOC entry 1949 (class 0 OID 0)
-- Dependencies: 148
-- Name: quote_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('quote_oid_seq', 1, false);


--
-- TOC entry 1911 (class 0 OID 150124)
-- Dependencies: 149
-- Data for Name: ragazzi; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ragazzi (oid, nome, cognome, padre, codifisc_padre, anno_nascita, indirizzo, madre, codfisc_madre, parent_oid, mail_inviata, periodi, fratelli, cell_padre, cell_madre, email_padre, email_madre, allergie, intolleranze, code, classe_frequentata, data_nascita, tel_casa, tel_work_padre, tel_work_madre, tel_accompagnatore, accompagnatore, familiari, pagamento, citta_nascita, sconto) FROM stdin;
9	MARGHERITA	BERRETTA	Sebastiano Musso		\N	Via Federico Faruffini 2 Milano	Simona Berretta	BRRSMN74L51D007V	\N	\N	4;5	\N		3357498133		simona1berretta@gmail.com	Nessuna	Nessuna	Margherita_Berretta_1465147293281	Quarta primaria	2007-07-07 00:00:00+02	\N	\N	\N	\N	\N	f	\N	BOLOGNA	\N
10	LORENZO	BORGHI	Roberto Borghi	BRGRRT74D28I462X	\N	via fratelli rosselli, 258 - 41125 Modena	Paola Moretti	MRTPLA77D53B819X	\N	\N	\N	\N	3472781830	3476876378	Robby.borghi74@gmail.com	Ciccybit@gmail.com			Lorenzo_Borghi_1465663176109	Seconda primaria	2008-12-04 00:00:00+01	\N	\N	\N	\N	\N	f	\N	MODENA	0
24	BEATRICE	SERRI	Filippo		\N	via Michelangelo Buonarroti, 24 PAVULLO NEL FRIGNANO	Monica Roncaglia	RNCMNC71LG383G	\N	\N	\N	\N	3357116038	3896394416	fserri@tecno-pro.it	monica.roncaglia@bper.it	nessuna	Epilessia monofocale notturna	Beatrice_Serri_1467214878870	Prima media	2005-04-07 00:00:00+02	\N	\N	\N	\N	\N	f	\N	Pavullo	0
123	MARTA	ZANOTTI	ZANOTTI CARLO		\N	VIA MASSOLO 110	DIETMANN ELISA	DTMLSE76E61F257L	\N	\N	\N	\N	3478885217	3475251017		elisa.dietmann@gmail-com			MARTA_ZANOTTI_1498405576829	Terza primaria	2008-03-28 00:00:00+01	\N	\N	\N	\N	\N	f	\N	MODENA	0
21	FEDERICO	BENASSI	ENRICO BENASSI	BNSNRC76A10I462Y	\N	VIA MEKONG 28 FIORANO MODENESE MO	SAMANTHA RIPPA		\N	\N	\N	\N		3491177210	stcomm@arian.it				FEDERICO_BENASSI_1466962337168	Seconda primaria	2008-04-28 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
20	DAVIDE	VERUCCHI	VERUCCHI RENZO		\N	VIA FIOPPE N. 96 41 029 SESTOLA MODENA	DEBORA FERRARI	FRRDBR74D67G393I	\N	\N	\N	\N	3384807428	3389600275		deborenzo2004@gmai.com			DAVIDE_VERUCCHI_1466960932762	Quarta primaria	2006-01-15 00:00:00+01	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
125	Giulio	Gober	Alessandro	Gober	\N	Via dei monti 19 montecreto	Benedetta	Borghi	\N	\N	\N	\N	3383078689	3396679910		benni.bb@libero.it			Giulio_Gober_1498680216537	Terza primaria	2009-03-01 00:00:00+01	\N	\N	\N	\N	\N	f	\N	Pavullo nel frignano	0
15	ALESSIA	BURGONI	Massimo Burgoni	BRGMSM70S06F257O	\N	via Caduti in guerra, 21 41025 ACQUARIA MODENA	Paola Iattoni	TTNPLA75A41G393Y	\N	\N	\N	ELENA BURGONI	3384638594	3397648729	paolaiattoni1975@gmail.com	paolaiattoni75@gmail.com	nessuna	Nessuna	Alessia_Burgoni_1466418818428	Seconda media	2004-11-12 00:00:00+01	\N	\N	\N	\N	\N	t	\N	REGGIO EMILIA	\N
25	DAVIDE	GHIRLINZONI			\N	VIA BONDANELLO 16/A 40013 CASTEL MAGGIORE (BO)	YLENIA ANTONIONI	NTNYLN71E58A944X	\N	\N	\N	\N	3357735755	3494230509	ghirli@hotmail.com	ylenia.antonioni@gmail.com	no	nessuna	DAVIDE_GHIRLINZONI_1467215222020	Seconda media	2003-10-02 00:00:00+02	\N	\N	\N	\N	\N	f	\N	BOLOGNA	\N
14	MATILDE	LINZARINI	LORENZO LINZARINI		\N	VIA DE CORREGGI N. 10 MODENA			\N	\N	\N	\N	3386205718						MATILDE_LINZARINI_1466370475671	Prima primaria	\N	\N	\N	\N	\N	\N	f	\N	\N	\N
16	ELENA	BURGONI	Massimo Burgoni	BRGMSM70S06F257O	\N	via Caduti in guerra, 21 41025 ACQUARIA MODENA	Paola Iattoni	TTNPLA75A41G393Y	\N	\N	\N	ALESSIA BURGONI	3384638594	3397648729	paolaiattoni1975@gmail.com	paolaiattoni75@gmail.com	nessuna	Nessune	Elena_Burgoni_1466419436935	Seconda media	2004-11-12 00:00:00+01	\N	\N	\N	\N	\N	t	\N	Reggio Emilia	\N
32	EMANUELE	INGRAMI	INGRAMI BRUNO		\N	FRAZ.ACQUARIA N. 17 41025 MONTECRETO MO	MARCHETTI BLANDINA	MRCBND67C50G393W	\N	\N	\N	\N	3355631299	3356631170		aziendamarchetti@alice.it			EMANUELE_INGRAMI_1467625493416	Seconda primaria	2008-08-29 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
91	SAMUELE	ROMANO		CCCCCC	\N				\N	\N	\N	\N	333333333			CCCCCCCCC			SAMUELE_ROMANO_1469443429578	Seleziona la classe frequentata	2006-08-23 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
26	GIORGIA	PICCIANO	Domenico Picciano		\N	Via per Vesale 40 -  41029 Sestola	Emanuela Bernardini	BRNMNL71B47G393S	\N	\N	\N	\N	3313608560	3491931485	Piccianod@libero.it 	Bernardiniemanuela1971@gmail.com 			Giorgia_Picciano_1467230993874	Quarta primaria	2006-03-21 00:00:00+01	\N	\N	\N	\N	\N	f	\N	Pavullo nel Frignano 	\N
29	VIOLA	DELLI	STEFANO DELLI		\N	VIA TROFOLINO 12 MONTECRETO MODENA	LUDOVICA BALOTTI	BLLMLD77A60G393R	\N	\N	\N	\N	3934185216	3391319653		marylu77@libero.it			VIOLA_DELLI_1467578778058	Prima primaria	2009-10-06 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLONELFRIGNANO 	\N
118	VERONICA	BURCHI	RICCARDO BURCHI		\N	via statale ovest 5	ELISA DANIELS	DNLLNG72P66Z404R	\N	\N	\N	ALEXANDRA BURCHI	3382108493	3473222806	riccardoburchi@virgilio.it	elisa.daniels72@yahoo.it			VERONICA_BURCHI_1497086945450	Prima primaria	2010-02-17 00:00:00+01	\N	\N	\N	\N	\N	t	\N	PAVULLO	0
120	Ludovico	Zara	Costantino Zara		\N		Valentina Ricci	RCCVNT83H52H501O	\N	\N	\N	Edoardo Zara	3357853006	3394144814	c.zara@immobiliaremedagliedoro.it	valeedoludocosta@gmail.com	Arachidi	Utilizzo Ventolin al bisogno e Bentelan in caso di crisi asmatica allergica (graminacee, betulla, erba canina,..). 	Ludovico_Zara_1497281118344	Seleziona la classe frequentata	2011-06-18 00:00:00+02	\N	\N	\N	\N	\N	t	\N	Modena	0
119	Edoardo	Zara	Costantino Zara		\N		Valentina Ricci	RCCVNT83H52H501O	\N	\N	\N	Ludovico Zara	3357853006	3394144814	c.zara@immobiliaremedagliedoro.it	valeedoludocosta@gmail.com			Edoardo_Zara_1497280691689	Seconda primaria	2009-04-23 00:00:00+02	\N	\N	\N	\N	\N	t	\N	Modena	0
124	Gabriele 	Beneventi	Luca BENEVENTI	BNVLCU74H16E393M	\N	Via dell'artigianato 38/2	Mara Castelli 	CSTMRA77B52F257T	\N	\N	\N	\N	3336120272	3485490865	topy77@alice.it 	castellimara1977@gmail.com 	No	No	Gabriele__Beneventi_1498580886238	Quarta primaria	2007-12-24 00:00:00+01	\N	\N	\N	\N	\N	f	\N	Pavullo 	0
107	LAURA	SIGHINOLFI	GABIRELE SIGHINOLFI		\N	VIA PASSERINO,90 41029 SESTOLA MO	BASTAI SIMONA	BSTSMN73D48G393E	\N	\N	\N	\N	3292506658	3334946901		simona,bastai@gmail.com		si kiwi	LAURA_SIGHINOLFI_1470328453357	Terza primaria	2007-10-11 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNANO	\N
53	CATERINA	BIOLCHINI	ALESSANDRO BIOLCHINI		\N	Via stadio 44 41029 SESTOLA	ELENA RICCI	RCCLNE78C67F257F	\N	\N	\N	PENELOPE BIOLCHINI	3355878504	3387647879					Caterina__Biolchini__1467974923963	Terza primaria	2007-12-18 00:00:00+01	\N	\N	\N	\N	\N	t	\N	Modena	\N
44	LORENZO	POLLACCI	POLLACCI MATTEO		\N	VIA STATALE PER FANANO 47/1  41029 SESTOLA (MO)	GIROTTI SARA	GRTSRA83D55A944X	\N	\N	\N	\N	3315655957	3277320805		saragirotti83@yahoo.it			LORENZO_POLLACCI_1467652864821	Seleziona la classe frequentata	2011-11-24 00:00:00+01	\N	\N	\N	\N	\N	f	\N	MODENA	\N
46	NICOLAS LEON STEFHANE	MEULEMAN	STEPHANE PIERRE MAURICE MEULEMAN	MLMSPH74D28Z110V	\N	VIA AOSTA, N 75  41125 MODENA	ANNALISA BANDIERI		\N	\N	\N	ELIA MARTIN STEFHAN MEULEMAN		3483715642		flaggies@libero.it			NICOLAS_LEON_STEFHANE_MEULEMAN_1467653587907	Seleziona la classe frequentata	2011-05-07 00:00:00+02	\N	\N	\N	\N	\N	t	\N	MODENA	\N
81	ALESSANDRO	ANGELI	JEAN LUC ANGELI		\N	VIA DELLA CITTADELLA 41/1 MODENA	STEFANIA TRONCA	TRNSFN65R52G902J	\N	\N	\N	\N	3357127776	3490847800	jeanluc.angeli@virgilio.it				ALESSANDRO_ANGELI_1469314024853	Seconda media	2004-06-29 00:00:00+02	\N	\N	\N	\N	\N	f	\N	NAPOLI	\N
45	ELIA MARTIN STEPHAN	MEULEMAN	STEPHANE PIERRE MAURICE MEULEMAN	MLMSPH74D28Z110V	\N	VIA AOSTA, N. 75 41125 MODENA	ANNALISA BANDIERI		\N	\N	\N	NICOLAS LEON STEFHANE MEULEMON		3483715642		flaggies@libero.it			ELIA_MARTIN_STEPHAN_MEULEMAN_1467653369830	Seconda primaria	2009-10-01 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
71	ALESSANDRO	MONTI	MARCELLO MONTI	MNTMCL71A26A944N	\N	VIA EMILIA 96 40100 BOLOGNA	GLENDA GORINI		\N	\N	\N	\N		3356338408	monti.snc@libero.it				ALESSANDRO_MONTI_1468773991777	Seconda media	2003-05-10 00:00:00+02	\N	\N	\N	\N	\N	f	\N	BOLOGNA	\N
72	GABRIELE	GROTTI	GERMANO GROTTI	GRTGMN67P22A944T	\N	VIA CALVI 16 40131 BOLOGNA	SIMONA FORNI		\N	\N	\N	\N	3482302128	3489334860	germano.grotti@gmail.com				GABRIELE_GROTTI_1468774798288	Terza Media	2002-04-27 00:00:00+02	\N	\N	\N	\N	\N	f	\N	BOLOGNA	\N
70	LUCA	SPELTA	MARCO SPELTA	SPLMRC62M07F205Y	\N	VIA CODROIPO 24 4125 MODENA	PAOLA PIOPPI		\N	\N	\N	\N	3487667670	3386896047	famigliaspelta@gmail.com				LUCA_SPELTA_1468773727741	Prima media	2004-08-04 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
18	LUCIO	CALEFFI	NICOLA CALEFFI	CLFNCL73S28I462J	\N	VIA INDIPENDENZA 60	LAURA STORCHI		\N	\N	\N	\N	3389553099	3292103883		laura.storchi@libero.it			LUCIO_CALEFFI_1466621441053	Quarta primaria	2006-09-22 00:00:00+02	\N	\N	\N	\N	\N	f	\N	REGGIO EMILIA	\N
73	RICCARDO	CAPPELLINI	Alessandro Cappellini	cpplsn72h14g393e	\N	VIA GAMBARA' 10 41029 SESTOLA MO			\N	\N	\N	\N	3382401848	3394595115	ale.cappellini@gmail.com				Riccardo_Cappellini_1468788796609	Seconda primaria	2008-06-03 00:00:00+02	\N	\N	\N	\N	\N	f	\N	Pavullo nel Frignano	\N
79	CARLOTTA	FRODATI	Mirko Frodati	frdmrk75p13g393z	\N	Virgilio 24	Tiziana Giovinetti 	gvntzn75r62g393z	\N	\N	\N	\N	3389500643	3391825000	mirkofrodati@libero.it			Nessuna	carlotta_Frodati_1468835939955	Seconda primaria	2008-03-07 00:00:00+01	\N	\N	\N	\N	\N	f	\N	Pavullo Nel Frignano	\N
68	EMANUELA	CALI'	Vincenzo 	CLAVCN72T16H558T	\N	Valsamoggia (BO) loc. Bazzano Via Caduti di Sabbiuno 7/9 	Sapori Silvia 	SPRSLV70E43A726T	\N	\N	\N	FRANCESCO CALI'	3313607070	3470081458	vince_silvy@libero.it				Emanuela_Cale_1468320903619	Prima media	2005-06-01 00:00:00+02	\N	\N	\N	\N	\N	t	\N	Bologna 	\N
69	FRANCESCO	CALI'	Vincenzo 	CLAVCN72T16H558T	\N	Valsamoggia (BO) loc. Bazzano Via Caduti di Sabbiuno 7/9	Sapori Silvia 	SPRSLV70E43A726T	\N	\N	\N	Emanuela Cal�	3313607070	3470081458	vince_silvy@libero.it				Francesco_Cale_1468321522493	Quarta primaria	2007-08-28 00:00:00+02	\N	\N	\N	\N	\N	t	\N	Bologna 	\N
67	GIORGIO	LAMBERTINI	GIOVANNI LAMBERTINI		\N	VIA PROVINCIALE PER PAVULLO, 55 41029 SESTOLA MO	CHIARA GIALDINI	GLDCHR71B64A944G	\N	\N	\N	\N	3392246354			chiaragialdini@virgilio.it			GIORGIO_LAMBERTINI_1468232837515	Terza primaria	2007-03-26 00:00:00+02	\N	\N	\N	\N	\N	f	\N	BOLOGNA	\N
76	NICOLA	LENZINI	LENZINI FEDERICO	LNZFRC80H21G393S	\N	VIA SANTA CROCE 250- FANANO-MO	D'ADDABBO SARA		\N	\N	\N	\N	3394008384	3487102836		sara.daddabbo@libero.it			NICOLA_LENZINI_1468829552905	Prima primaria	2009-12-05 00:00:00+01	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
80	ALESSANDRO	GHERARDI	Denis	ghrdns79c22g393i	\N		Domenica		\N	\N	\N	\N	3382682235	3335045895	gherardidenis@alice.it		no	no	Alessandro_Gherardi_1468934451604	Seconda primaria	2011-01-07 00:00:00+01	\N	\N	\N	\N	\N	f	\N	Pavullo n/f	\N
78	BENEDETTA	VEZZALI	VEZZALI	MICHELE	\N	VIA FIRENZE, 222-MO-	CASELLI	CRISTINA	\N	\N	\N	\N		3493180945	casellicri@alice.it				BENEDETTA_VEZZALI_1468832480747	Quinta primaria	2005-10-09 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
22	GIULIO	MAZZOLI	MIRCO MAZZOLI	MZZMRC68L28F257M	\N	VIA DON T. PEDRONI, 19 41029 SESTOLA	SIMONA CANTELLI		\N	\N	\N	Eleonora Mazzoli	3383732100	3391337597		cantelli.simona@alice.it			GIULIO_MAZZOLI_1466963274570	Prima primaria	2010-02-16 00:00:00+01	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNANO	0
50	ALEX	MOLINARI	MOLINARI SIMONE	MLNSMN76A19F257U	\N	VIA DEL MERCATO 308 MODENA	ZANERATI MANUELA		\N	\N	\N	\N	3466217173	3484324627	simonemolinari76@gmail.com				ALEX_MOLINARI_1467791532213	Quarta primaria	2006-03-11 00:00:00+01	\N	\N	\N	\N	\N	f	\N	MODENA	\N
23	ELEONORA	MAZZOLI	MIRCO MAZZOLI	MZZMRC68L28F257M	\N	VIA DON T. PEDRONI 19 41029 SESTOLA MO	SIMONA CANTELLI		\N	\N	\N	Giulio Mazzoli	3383732100	3391337597		cantelli.simona@alice.it			ELEONORA_MAZZOLI_1466963418749	Quarta primaria	2006-01-03 00:00:00+01	\N	\N	\N	\N	\N	t	\N	PAVUULLO NEL FRIGNANO	0
62	MARTINA	SERAFINI	STEFANO SERAFINI	SRFSFN74B10G393I	\N	VIA DELLA VOLPE1-41029 SESTOLA MO	ERIKA CONTENTO		\N	\N	\N	BEATRICE SERAFINI	3429387263		stefano.serafini74@gmail.com				MARTINA_SERAFINI_1468231268168	Quarta primaria	2006-03-22 00:00:00+01	\N	\N	\N	\N	\N	t	\N	BAGNO A RIPOLI(FI)	\N
63	BEATRICE	SERAFINI	SERAFINI STEFANO	SRFSFN74B10G393I	\N	VIA DELLA VOLPE 1 -41029 SESTOLA MO	ERIKA CONTENTO		\N	\N	\N	MARTINA SERAFINI	4293872633		stefano.serafini74@gmail.com				BEATRICE_SERAFINI_1468231429577	Seconda primaria	2008-06-23 00:00:00+02	\N	\N	\N	\N	\N	t	\N	BAGNO A RIPOLI	\N
65	MATTEO	SEGHI	RAFFAELLO SEGHI	SGHRFL74B16H294N	\N	VIA CIRCONVALLAZIONE SUD 36 MONTECRETO - MO-	PASSINI SILVIA		\N	\N	\N	\N	3483946405	3385899111		silvia.passini@bper.it			MATTEO_SEGHI_1468232309568	Terza primaria	2006-10-04 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
37	SARA	LEONELLI	LEONELLI ENRICO		\N	VIA I MAGGIO 15 41029 SESTOLA-MO-	MORELLI PAOLA	MRLPLA69A66G393D	\N	\N	\N	\N	3332208979			morellipaa@gmail.com			SARA_LEONELLI_1467648124472	Terza primaria	2007-09-05 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
35	LORENZO	TEGGI	TEGGI FABRIZIO	TGGFRZ78C11G393D	\N	VIA STATALE PER RONCOSCAGLIA 10 ROCNCOSCAGLIA SEATOLA (MO)	FRANCHI BARBARA		\N	\N	\N	\N	3478365338		lorenzo.teggi@alice.it				LORENZO_TEGGI_1467627479118	Terza Media	2002-08-22 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
83	VERONICA	FLORINI	MASSIMO FLORINI		\N	VIA ACQUA SOLFOROSA 357 FANANO-MO-	MONICA BERTI	BRTMNC72E62G393D 	\N	\N	\N	ALESSANDRO FLORINI	3319104577	3805112444	florini.massimo@libero.it		cioccolato + frutti a guscio	celiachia	VERONICA_FLORINI_1469437044945	Quarta primaria	2006-11-22 00:00:00+01	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
110	NICHOLAS	BARBIERI	BARBIERI TOMMASO	BRBTMS75E30F257J	\N	VIA FONTANA 13- MONTECRETO -MO-	FRODATI ALESSIA		\N	\N	\N	\N	3392488315	3341194731	barbieri.tommaso1975@yahoo.it				NICHOLAS_BARBIERI_1470641730427	Terza primaria	2007-08-19 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
98	GIOELE	BRUGNOLI	LUCA BRUGNOLI	brglcu225	\N	VIA PROVINCIALE 211 CASINE SESTOLA MO	MANUELA QUECIAGROSSA		\N	\N	\N	\N	3485664096	3496270315	marcyeluca@hotmail.com				GIOELE_BRUGNOLI_1469955697432	Prima primaria	2009-12-19 00:00:00+01	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
33	ALEX	MASINELLI	GIULIANO MASINELLI		\N	VIA PROVINCIALE PER PAVULLO 131 CASINE DI SESTOLA (MO)	CLAUDIA CHIODI	CHDCLD67B58G393Z	\N	\N	\N	\N		3337081826					ALEX_MASINELLI_1467625963682	Quarta primaria	2016-05-08 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
82	ALESSANDRO	FLORINI	FLORINI MASSIMO		\N	VIA ACQUA SOLFOROSA 357 FANANO-MO-	MONICA BERTI	BRTMNC72E62G393D 	\N	\N	\N	VERONICA FLORINI	3805112444	3319104517	florini.massimo@libero.it		celiachia		ALESSANDRO_FLORINI_1469436799574	Quarta primaria	2006-11-22 00:00:00+01	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
84	FRANCESCO	LOLLI	SIMONE LOLLI		\N	VIA TRINITA' 9/E VIGNOLA- MO-	MANUELA TURCHI	TRCMNL75E48F257J	\N	\N	\N	\N	3355334101		simone.aersat@aermec.com				FRANCESCO_LOLLI_1469438040080	Terza primaria	2007-04-18 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
96	SARA 	VENTURELLI	Venturelli Paolo	VNTPLA69C18D711W	\N	via dei gigli 22 maranello Modena	Ferrari Micaela	FRRMCL74E66F257T	\N	\N	\N	\N	339 8600230	335 8347174	venturelli40@teletu.it	=	nessuna	nessuna	Sara_Venturelli_1469649519443	Quarta primaria	2006-06-06 00:00:00+02	\N	\N	\N	\N	\N	f	\N	Pavullo N.F.	\N
39	RICCARDO	CROVETTI	ANDREA CROVETTI		\N	VIA BORTOLOTTI 44 MONTECRETO MO	BALLOTTI ELEONORA	BLLLNR80S56F257Q	\N	\N	\N	\N	3271131370	3396679901		eleonora.ballotti@bancopopolare.it			RICCARDO_CROVETTI_1467648920419	Prima primaria	2009-11-25 00:00:00+01	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	0
86	ANDREA	BONUCCHI	ANDREA BONUCCHI		\N	VIA PRATOLUNGO 5 ACQUARIA MONTECRETO MO	SIMONA FILI 	FLISMN70S48I462Q	\N	\N	\N	MARTINA BONUCCHI		3384137023		simona.fili@alice.it			ANDREA_BONUCCHI_1469441094166	Terza primaria	2007-10-23 00:00:00+02	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
87	MARTINA	BONUCCHI	ROBERTO BONUCCHI		\N	VIA PRATOLUNGO 5 ACQUARIA MONTECRETO MO	SIMONA FILI 	FLISMN70S48I462Q	\N	\N	\N	ANDREA BONUCCHI	3384137023			simona.fili@alice.it			MARTINA_BONUCCHI_1469441776604	Prima media	2004-08-30 00:00:00+02	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
28	GIULIO	GOBER	gober alessandro	gbrlsn81r15g393b	\N	via dei monti 19 Montecreto	borghi benedetta	brgbdt81c65g393c	\N	\N	\N	\N	3383078689	3396679910	kiopper@yahoo.it	benni.bb@libero.it			giulio_gober_1467551535779	Seconda primaria	2009-03-01 00:00:00+01	\N	\N	\N	\N	\N	f	\N	pavullo nel frignano	\N
113	IRENE	BIOLCHINI	AUGUSTO BIOLCHINI		\N	VIASERLINA 1- VESALE 41029 SESTOLA MO	CASTELLI ANGIOLINA	CSTNLN71B64G393Z	\N	\N	\N	ALESSANDRO BIOLCHINI		3343913390					IRENE_BIOLCHINI_1470645503653	Quinta primaria	2005-06-30 00:00:00+02	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
94	GIOVANNI	MALINVERNI	GIUSEPPE MALINVERNI		\N	VIA COSTINO MONTE CARMELO73-17025 LOANO (SV)	LAURA DE FASI	DFSLRA66L62D969A	\N	\N	\N	LORENZO MALINVERNI		3356011324		laura@defasi.it			GIOVANNI_MALINVERNI_1469644632221	Seleziona la classe frequentata	2011-07-14 00:00:00+02	\N	\N	\N	\N	\N	t	\N	PIETRA LIGURE	\N
74	LUCREZIA	LUPPI	SIMONE LUPPI		\N	VIA PROVINCIALE 56 ACQUARIA MONTECRETO-MO-	FIAMMETTA FIOCCHI	FCCFMT72B47G393B	\N	\N	\N	\N	3386002147		simone-l73@virgilio.it				LUCREZIA_LUPPI_1468826570494	Quarta primaria	2006-06-11 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
88	PIERRE	ANTONI	LUCIANO ANTONI	NTNLCN71T13G393B	\N	VIA RONCO LA CROCE 220-MONTECRETO-MO-	DELFHINE MEULEMAN		\N	\N	\N	\N	3332137752	339348743	luciano@staigi.it				PIERRE_ANTONI_1469442265992	Quarta primaria	2006-09-20 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
56	NICOLA 	TINTORI	MIRKO TINTORI		\N		 MARIA ELENA PELLONI	PLLMLN67L42G393H	\N	\N	\N	\N	3398148381	3396115243		MMEP@BLU.IT			NICOLA__TINTORI_1468060461954	Prima primaria	2009-07-16 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
64	MATTEO	FERRARI	FERRARI ROMANO	FRRRMN70E23G393U	\N	VIA MURIANA 2511 FANANO -MO-	DE SANTIS ROBERTA		\N	\N	\N	\N		3296917343		robertadesantis-72@libero.it			MATTEO_FERRARI_1468232034976	Terza Media	2002-05-23 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
90	ANGELICA	GUERRI	ALESSANDRO GUERRI		\N	CORSO UMBERTO1&#65533; N. 166/1 41029 SESTOLA MO	SONIA TURCHI	TRCSNO71S53F257G	\N	\N	\N	\N		3939089860		turchi.sonia@libero.it			ANGELICA_GUERRI_1469443049357	Quarta primaria	2006-09-03 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
19	LEONARDO	SOLA	Sola Mauro		\N	VIA BACUCCOLA 42C 41014 CASTELVETRO-MO-	SIMONA PINI	PNSSMNsmnp64f257d	\N	\N	\N	\N		3383018572		sola.mauro@alice.it			Leonardo__Sola__1466802523661	Prima primaria	2010-01-13 00:00:00+01	\N	\N	\N	\N	\N	f	\N	Reggio Emilia 	\N
85	MARTINA	PIROZZI	MATTEO PIROZZI		\N	VIA DI GIOGOLI 9/A	ERICA MELLUZZA	MLLRCE78D53D612X	\N	\N	\N	\N		3470964810	sunbody11@yahoo.it				MARTINA_PIROZZI_1469439031707	Quarta primaria	2006-12-29 00:00:00+01	\N	\N	\N	\N	\N	f	\N	BAGNO A RISPOLI FI	\N
92	JACOPO MARIA	BALBONI	ANDREA BALBONI		\N	CORSO UMBERTO I, 55- 41029 SESTOLA (MO)	GIULIA FANI	FNANGL67L55A271S	\N	\N	\N	\N		3398700302		agiulia.f@libero.it			JACOPO_MARIA_BALBONI_1469443883373	Seleziona la classe frequentata	2006-07-27 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
55	PENELOPE	BIOLCHINI	ALESSANDRO BIOLCHINI		\N	Via stadio 44 41029 SESTOLA	ELENA RICCI	RCCLNE78C67F257F	\N	\N	\N	\N	3355878504	3387647879					PENELOPE_BIOLCHINI_1468053234883	Prima primaria	2009-06-20 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
100	MORGAN	MARTINELLI	MARTINELLI MORIS	MRTMRS73D21B352E	\N	VIA TRIESTE 29 CAMPI BISENZIO FIRENZE	ZANFARDINO KATIA		\N	\N	\N	MARGO' MARTINELLI	3402764349						MORGAN_MARTINELLI_1469956691261	Prima primaria	2009-03-13 00:00:00+01	\N	\N	\N	\N	\N	t	\N	FIRENZE	\N
36	EMANUELE MARIA	BALBONI	BALBONI ANDREA		\N	CORSO UMBERTO I, 55- 41029 SESTOLA (MO)	FANI GIULIA	FNANGL67L55A271S	\N	\N	\N	BALBONI JACOPO MARIA		3398700302		agiulia.f@libero.it	frutta secca, cioccolata, nutella pelo animali		EMANUELE_MARIA_BALBONI_1467647857821	Terza Media	2002-10-21 00:00:00+02	\N	\N	\N	\N	\N	t	\N	ANCONA	\N
99	MARGO'	MARTINELLI	MARTINELLI MORIS	MRTMRS73D21B352E	\N	VIA TRIESTE 29 CAMPI BISENZIO FI	ZANFARDINO KATIA		\N	\N	\N	MORGAN MARTINELLI		3402764349					MARGO__MARTINELLI_1469956568808	Prima primaria	2006-01-29 00:00:00+01	\N	\N	\N	\N	\N	t	\N	FIRENZE	\N
17	LORENZO	PRANDO	Prando Boris		\N	Via Castello 9-MONTECRETO MO	Pagliai Carlotta	PGLCLT81C51G393T	\N	\N	\N	Gherardi Alessandro		3201541318		tottap11@gmail.com	nessuna nota		Lorenzo_Prando_1466599944339		2011-05-05 00:00:00+02	\N	\N	\N	\N	\N	t	\N	Pavullo nel Frignano	0
42	ALEXANDRA	BURCHI	RICCARDO BURCHI		\N	VIA STATALE OVEST, 5 41029 SESTOLA (MO)	ELISA ANGELA DANIELS	DNLLNG72P66Z404R	\N	\N	\N	VERONICA BURCHI	3382108493	3473222806	riccardoburchi@virgilio.it	elisa.daniels72@yahoo.it			ALEXNDRA_BURCHI_1467652395561	Prima media	2005-12-22 00:00:00+01	\N	\N	\N	\N	\N	t	\N	MODENA	0
121	GIULIA	NICOLETTI	alex nicoletti	ncllxa84e30g393x	\N	via piave 15/b acquaria montecreto	francesca valicelli	vlcfnc81r71g393n	\N	\N	\N	\N	333 8526356	333 8069845	nicoalex@live.it	frevalli@hotmail.it			giulia_nicoletti_1497372127137	Seconda primaria	2009-07-16 00:00:00+02	\N	\N	\N	\N	\N	f	\N	pavullo nel frignano	0
122	SOFIA	ZANARINI	FABIO ZANARINI	ZNRFBA77P27G393U	\N	VIA CANEVARE 2160 FANANO (MO)	MIRKA VIGNALI	VGNMRK76R69G393X	\N	\N	\N	\N	3383321098	3383321097	Fabiozanarini.77@gmail.com	Mirkavignali@icloud.com		Pelle sensibile al sole : da aiutare a mettere la crema in piscina (protezione 50)	SOFIA_ZANARINI_1497904128935	Terza primaria	2008-09-08 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNANO	0
108	FEDERICO	PELLICCIARI	PELLICCIARI  CORRADO		\N	VIA G. FRESCOBALDI 35 41122 MODENA	PARISE ALESSIA	PRLLSS75M66B819V	\N	\N	\N	\N	3396607577	3204081787	cpellicciari@virgilio.it				FEDERICO_PELLICCIARI_1470584491613	Terza primaria	2007-02-18 00:00:00+01	\N	\N	\N	\N	\N	f	\N	MODENA	\N
93	LORENZO	MALINVERNI	GIUSEPPE MALINVERNI		\N	VIA COSTINO MONTE CARMELO 73-17025 LOANO(SV)	LAURA DE FASI	DFSLRA66L62D969A	\N	\N	\N	GIOVANNI MALINVERNI		3356011324		laura@defasi.it			LORENZO_MALINVERNI_1469644504946	Seleziona la classe frequentata	2011-07-14 00:00:00+02	\N	\N	\N	\N	\N	t	\N	PIETRA LIGURE	\N
115	EMANUELE	FERRARI	FAUSTO FERRARI	FRRFST80C09G393S	\N	VIA CIRCONVALLAZIONE SUD 45 MONTECRETO MO	BONUCCHI MICHELA		\N	\N	\N	\N	3206980559	3206980561					EMANUELE_FERRARI_1470646690842	Quarta primaria	2006-06-23 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
114	FRANCESCO	GIANNULI	ANDREA GIANNULI	GNNNDR66M21A944E	\N	VIA GUSTAVO MODENA 22 40127 BOLOGNA	ELISA FRIGIERI		\N	\N	\N	\N	3389600897	3389167501	andrea.giannuli@gmail.com	poldo74@gmail.com			FRANCESCO_GIANNULI_1470646476508	Prima primaria	2010-05-01 00:00:00+02	\N	\N	\N	\N	\N	f	\N	BOLOGNA	\N
58	LUCA	FIANDRI	ANDREA FIANDRI	FNANDR70M02F257M	\N	VIA ALBINONI, 17 MODENA	ELENA BOLDRINI		\N	\N	\N	GIULIA FIANDRI	3358283798	3389629765	af105105@gmail.com				LUCA_FIANDRI_1468166142661	Seconda media	2003-03-20 00:00:00+01	\N	\N	\N	\N	\N	t	\N	MODENA	\N
97	ANNA	MAGNANI	FABIO MAGNANI	MGNFBA62C29Z133Z 	\N	VIA MARTINI DI RENNO PAVULLO MO	SILVIA LAMI		\N	\N	\N	\N	3355481471						ANNA_MAGNANI_1469873188360	Quarta primaria	2006-06-16 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
40	VITTORIA	PELLONI	CLAUDIO PELLONI		\N	VIA VIVAIO N. 2 41029 SESTOLA (MO)	LAURA BONACORSI	BNCLRA77R46G393N	\N	\N	\N	\N	3355897273	3385376490		laura.bonacorsi77@gmail.com			VITTORIA_PELLONI_1467649548996	Terza primaria	2007-09-21 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
77	LEONARDO	BAISI	GIAN MATTEO BAISI DE TOFOLI	BSDGMT68L02G393Z	\N	VIA ROMA 39 - FANANO-MO	SABRINA GIUSTI		\N	\N	\N	\N	3388658144	335426442	gianmatteobaisi@gmail.com				LEONARDO_BAISI_1468830901622	Seleziona la classe frequentata	2007-08-28 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
112	ALESSANDRO	BIOLCHINI	AUGUSTO BIOLCHINI		\N	VIA SERLINA 1 VESALE -41029 SESTOLA MO	ANGIOLINA CASTELLI	CSTNLN71B64G393Z	\N	\N	\N	IRENE BIOLCHINI		3343913390					ALESSANDRO_BIOLCHINI_1470645203189	Seconda primaria	2008-04-25 00:00:00+02	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
95	MARTINA	MALINVERNI	GIUSEPPE MALINVERNI		\N	VIA COSTINO MONTE CARMELO, 73 -17025 LOANO (SV)	LAURA DE FASI	DFSLRA66L62D969A	\N	\N	\N	LORENZO MALINVERNI		3356011324		laura@defasi.it			MARTINA_MALINVERNI_1469644745583	Prima media	2004-08-25 00:00:00+02	\N	\N	\N	\N	\N	t	\N	BRESCIA	\N
57	LORENZO	MANTOVANI	MANTOVANI VITTORIO		\N	VIA CIRO BISI 89, SAN VITO DI MODENA                                	MANTOVANI ALESSANDRA	MNTLSN71C43F257R	\N	\N	\N	\N		3337536936		alessandra.mantovani@nordiconad.it			LORENZO_MANTOVANI_1468165919695	Terza primaria	2007-02-28 00:00:00+01	\N	\N	\N	\N	\N	f	\N	CARPI	\N
75	GAIA	MINELLI	DAVIDE MINELLI		\N	VIA PROVINVIALE 33 CASTELARO SESTOLA -MO-	RINALDI CLAUDIA	RNLCLD71R46I462D	\N	\N	\N	\N	3920352718	3343207404					GAIA_MINELLI_1468827907982	Quarta primaria	2006-03-01 00:00:00+01	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
34	ALESSANDRO	VIGNALI	CHRISTIAN VIGNALI		\N	VIA PER VESALE 105 SESTOLA	BONUCCHI STEFANIA	BNCSFN76E58G393R	\N	\N	\N	EMANUELE VIGNALI	3388268783	3384950940	vignalichristian@alice.it				ALESSANDRO_VIGNALI_1467626516890	Seleziona la classe frequentata	2006-10-01 00:00:00+02	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
60	EMANUELE	VIGNALI	CHRISTIAN VIGNALI		\N	VIA PER VESALE 105 41029 SESTOLA MO	STEFANIA BONUCCHI	BNCSFN76E58G393R	\N	\N	\N	ALESSANDRO VIGNALI	3388268783	3384950940	vignalichristian@alice.it				EMANUELE_VIGNALI_1468169591478	Seleziona la classe frequentata	2010-10-22 00:00:00+02	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
11	FEDERICA	LUCCHI	LUCCHI ALESSANDRO	LCCFRC09A55B819T	\N	VIA PARRI 12 CARPI MO	MANFREDINI MILENA		\N	\N	\N	\N	3455802050						FEDERICA_LUCCHI_1466335014673	Prima primaria	2009-09-19 00:00:00+02	\N	\N	\N	\N	\N	f	\N	CARPI	\N
51	MATTEO	POGGI	FABRIZIO POGGI	PGGFRZ69H29D548J	\N	VIA PORRETTO 3A 41013 CASTELFRANCO EMILIA -MO-	CINZIA BIAGI	BGICNZ68S68F257I	\N	\N	\N	LARA POGGI	347/2995085	340/4605246	fabriziopoggi69@gmail.com	cinzia.biagi68@gmail.com	/	/	MATTEO_POGGI_1467916783434	Quinta primaria	2006-01-04 00:00:00+01	\N	\N	\N	\N	\N	t	\N	MODENA	0
66	TOMMASO	GALLI	GALLI CRISTIANO		\N	VIA SASSATELLI 12 SESTOLA	CRISTINA COSTA	CSTCST74C65G393O	\N	\N	\N	\N		3333140468		costacristinagalli@libero.it			TOMMASO_GALLI_1468232498431	Seconda primaria	2008-11-30 00:00:00+01	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
52	LARA	POGGI	FABRIZIO POGGI	PGGFRZ69H29D548J	\N	VIA PORRETTO 3A - 41013CASTELFRANCO E.	CINZIA BIAGI	BGICNZ68S68F257I	\N	\N	\N	MATTEO POGGI	347/2995085	340/4605246	cinzia.biagi68@gmail.com	fabriziopoggi69@gmail.com	/	/	LARA_POGGI_1467917152360	Prima primaria	2010-08-06 00:00:00+02	\N	\N	\N	\N	\N	t	\N	MODENA	0
43	VERONICA 	BURCHI	RICCARDO BURCHI		\N	VIA STATALE OVEST, 5 41029 SESTOLA (MO)	ELISA ANGELA DANIELS	DNLLNG72P66Z404R	\N	\N	\N	ALEXANDRA BURCHI		3473222806	riccardoburchi@virgilio.it	elisa.daniels72@yahoo.it			VERONICA__BURCHI_1467652581074	Seleziona la classe frequentata	2010-02-17 00:00:00+01	\N	\N	\N	\N	\N	t	\N	PAVULLO NEL FRIGNAGNO	\N
38	MARIA VITTORA	ZANETTI	ZANETTI GIUSEPPE	ZNTGPP68C29F257B	\N	VIA GANACETO 12 41121 MODENA	FERRARINI ROBERTA		\N	\N	\N	\N	3358033310	3476420587		robertaf74@gmail.com			MARIA_VITTORA_ZANETTI_1467648406462	Quarta primaria	2006-04-18 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	0
30	FRANCESCA	TROMBETTI	RICCARDO TROMBETTI		\N	VIA TAGLIACOZZI 44	CRISTINA NANNI	NNNCST75M49A944D	\N	\N	\N	\N		3283379094		cristinananni@gmail.com			FRANCESCA_TROMBETTI_1498405888416	Terza primaria	2009-03-11 00:00:00+01	\N	\N	\N	\N	\N	f	\N	BOLOGNA	0
59	GIULIA	FIANDRI	ANDREA FIANDRI	FNANDR70M02F257M	\N	VIA ALBINONI 17, MODENA	ELENA BOLDRINI		\N	\N	\N	LUCA FIANDRI	3358283798	3389629765		elena.boldrini69@gmail.com			GIULIA_FIANDRI_1468166326777	Seconda primaria	2008-05-17 00:00:00+02	\N	\N	\N	\N	\N	t	\N	MODENA	\N
27	EMANUELE	STEFANELLI	tommaso stefanelli		\N	VIA GIACOMO ZANELLA 10 - MILANO	erika buzzi	bzzrke82t57f205v	\N	\N	\N	\N	3491438017	3351253882	tomstefa@gmail.com	erika.buzzi@gmail.com	nessuna	nessuna	emanuele_stefanelli_1467323941859	Quinta primaria	2005-08-26 00:00:00+02	\N	\N	\N	\N	\N	f	\N	milano	\N
48	MERY	GAMBAIANI	MAURO GAMBAIANI		\N	VIA MONTE DI SOPRA N. 300- 41021 FANANO (MO)	ADRIANA PARROCCHETTI	PRRDRN71M43G393Y	\N	\N	\N	\N		3779792691		adriana.parrocchetti@gmail.com			MERY_GAMBAIANI_1467656597567	Terza primaria	2007-01-20 00:00:00+01	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
47	SAMANTHA	LEONE	LEONE MAURIZIO		\N	VIA CREMASCHI 290 - VILLANOVA (MO)	LOSI DEBORAH	LSDNRC48L31F257I	\N	\N	\N	\N		3479753195		debvet78@libero.it			SAMANTHA_LEONE_1467656324729	Seconda primaria	2008-06-28 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
49	SERENA	BONACORSI	Luca Bonacorsi	BNCLCU74E07G393A	\N	via provinciale per pavullo 236 casine sestola	Rosalba Barbieri	BRBRLB74C53F257F	\N	\N	\N	\N	3389054899	3342410488	luca.bonacorsi@libero.it	rosalba.barbieri@libero.it	allergica alla penicillina e al nurefen	pomodoro,albume d'uovo,cioccolata,fragole,banana	Serena_Bonacorsi_1467725357517	Quarta primaria	2006-12-17 00:00:00+01	\N	\N	\N	\N	\N	f	\N	Pavullo nel frignano	\N
103	LEONARDO MARIA	SERAFINI	SERAFINI ALBERTO		\N	VIA G.B. PERFETTI 12 SESTOLA MO	PARENTI M.CRSITINA	PRNMCR75B47G393Q	\N	\N	\N	\N		3391319655		parentimc@tiscali.it			LEONARDO_MARIA_SERAFINI_1470038372660	Quarta primaria	2006-08-04 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNAGNO	\N
41	ELEONORA	AGRILLO	AGRILLO FABIO		\N	AIA DELLE LUCCIOLE  41029 SESTOLA(MO)	TINTORRI CHIARA	TNTCHR83H48G393M	\N	\N	\N	\N	3388522032	3803181115		chiatin83gmail.com		funghi	ELEONORA_AGRILLO_1467652047704	Seleziona la classe frequentata	2010-07-30 00:00:00+02	\N	\N	\N	\N	\N	f	\N	MODENA	\N
54	NICOLO'	BONUCCHI	AMEDEO BONUCCHI	BNCMDA70P14G393S	\N	VIA PRIMO MAGGIO N. 93 -41029 SESTOLA	BARBARA NICOLETTI		\N	\N	\N	\N	3384836329	3396432379	amedeo.bonucchi@gmai.com				NICOLO__BONUCCHI_1467998344337	Terza primaria	2007-09-07 00:00:00+02	\N	\N	\N	\N	\N	f	\N	PAVULLO NEL FRIGNANO	\N
\.


--
-- TOC entry 1950 (class 0 OID 0)
-- Dependencies: 150
-- Name: ragazzi_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('ragazzi_oid_seq', 125, true);


--
-- TOC entry 1924 (class 0 OID 192843)
-- Dependencies: 162
-- Data for Name: sconti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sconti (oid, sconto, anno, ragazzo_oid) FROM stdin;
1	22	2016	32
2	26	2016	91
3	1	2016	26
4	240	2016	44
5	52	2016	49
6	45	2016	41
7	72	2016	50
8	30	2016	62
9	30	2016	63
10	10	2016	18
11	38	2016	73
12	10	2016	45
13	75	2016	39
14	25	2016	108
15	35	2016	93
16	24	2016	92
17	24	2016	36
18	26	2016	77
19	100	2016	57
20	22	2016	54
21	10	2016	34
22	35	2016	60
23	5	2016	11
24	56	2016	66
25	0	2017	123
26	0	2017	30
27	0	2017	10
28	0	2017	30
29	0	2017	42
30	0	2017	118
31	0	2017	39
32	0	2017	22
33	0	2017	22
34	0	2017	23
35	0	2017	121
36	0	2017	51
37	0	2017	52
38	0	2017	24
39	0	2017	122
40	0	2017	38
41	0	2017	120
42	0	2017	119
43	0	2017	17
44	0	2017	17
45	0	2017	30
46	0	2017	123
47	0	2017	124
48	0	2017	124
49	0	2017	125
50	0	2017	125
\.


--
-- TOC entry 1951 (class 0 OID 0)
-- Dependencies: 161
-- Name: sconti_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sconti_oid_seq', 50, true);


--
-- TOC entry 1913 (class 0 OID 150133)
-- Dependencies: 151
-- Data for Name: tipologie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipologie (oid, forma, costo_unitario, costo_totale, tipo, num_settimane, familiare, mensa, full_day) FROM stdin;
1	settimanale	130	130	S	1	f	t	t
4	trisettimanale	120	360	S	3	f	t	t
5	quadrisettimanale	115	460	S	4	f	t	t
6	pentasettimanale	108	540	S	5	f	t	t
7	settimanale multi	120	120	S	1	t	t	t
8	bisettimanale multi	115	230	S	2	t	t	t
10	quadrisettimanale multi	100	400	S	4	t	t	t
13	settimanale mattina nomensa	90	90	S	1	f	f	f
11	pentasettimanale multi	90	450	S	5	t	t	t
9	trisettimanale multi	106.66666666666667	320	S	3	t	t	t
12	settimanale mattina	110	110	S	1	f	t	f
15	GIORNALIERO 22	22	22	G	1	f	t	f
2	giornaliero 35	35	35	G	1	f	t	t
14	giornaliero bisettimanale	25	25	G	1	f	t	t
17	BISETTIMANALE 3 FRATELLI	52.5	105	S	2	f	f	f
16	SETTIMANALE 3 FRATELLI	-115	115	S	1	f	f	f
18	GIORNALIERO 26	26	26	G	1	f	f	f
19	GIORNALIERO 24	12	24	G	2	f	f	f
20	6 SETTIMANE SINGOLO	100	600	S	6	f	f	f
22	BIGIORNALIERO DA 22	22	44	G	2	f	f	f
21	6 SETTIMANE MULTI	166.66666666666666	500	S	6	t	f	f
3	bisettimanale	125	250	S	2	f	t	t
\.


--
-- TOC entry 1952 (class 0 OID 0)
-- Dependencies: 152
-- Name: tipologie_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tipologie_oid_seq', 22, true);


--
-- TOC entry 1915 (class 0 OID 150141)
-- Dependencies: 153
-- Data for Name: utenti; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY utenti (oid, login, password, email, nome, cognome) FROM stdin;
1	crironco	12sS1y3mfxLm2kJOwxQD1zSD6iI=	cristina@roncovillage.it	Cristina	Gambarelli
2	cristina	12sS1y3mfxLm2kJOwxQD1zSD6iI=	cristina@roncovillage.it	Cristina	Gambarelli
3	tester	RG4Wl9ub1V8S+8FRx4vmi9wvN/E=	tester@roncovillage.it	Piergiorgio	Cremonese
\.


--
-- TOC entry 1953 (class 0 OID 0)
-- Dependencies: 154
-- Name: utenti_oid_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('utenti_oid_seq', 3, true);


--
-- TOC entry 1802 (class 2606 OID 150227)
-- Name: allegati_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY allegati
    ADD CONSTRAINT allegati_pk PRIMARY KEY (oid);


--
-- TOC entry 1779 (class 2606 OID 150157)
-- Name: giornate_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY giornate
    ADD CONSTRAINT giornate_pk PRIMARY KEY (oid);


--
-- TOC entry 1806 (class 2606 OID 166489)
-- Name: gruppi_foto_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY gruppi_foto
    ADD CONSTRAINT gruppi_foto_pk PRIMARY KEY (oid);


--
-- TOC entry 1798 (class 2606 OID 150159)
-- Name: login_uidx; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY utenti
    ADD CONSTRAINT login_uidx UNIQUE (login);


--
-- TOC entry 1804 (class 2606 OID 150247)
-- Name: pagamenti_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY pagamenti
    ADD CONSTRAINT pagamenti_pk PRIMARY KEY (oid);


--
-- TOC entry 1784 (class 2606 OID 150161)
-- Name: partecipanti_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY partecipanti
    ADD CONSTRAINT partecipanti_pk PRIMARY KEY (oid);


--
-- TOC entry 1786 (class 2606 OID 150163)
-- Name: periodi_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY periodi
    ADD CONSTRAINT periodi_pk PRIMARY KEY (oid);


--
-- TOC entry 1789 (class 2606 OID 150250)
-- Name: presenze_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY presenze
    ADD CONSTRAINT presenze_pk PRIMARY KEY (oid);


--
-- TOC entry 1791 (class 2606 OID 150167)
-- Name: quote_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY quote
    ADD CONSTRAINT quote_pk PRIMARY KEY (oid);


--
-- TOC entry 1794 (class 2606 OID 150169)
-- Name: ragazzi_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ragazzi
    ADD CONSTRAINT ragazzi_pk PRIMARY KEY (oid);


--
-- TOC entry 1808 (class 2606 OID 192849)
-- Name: sconti_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sconti
    ADD CONSTRAINT sconti_pk PRIMARY KEY (oid);


--
-- TOC entry 1796 (class 2606 OID 150171)
-- Name: tipologie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipologie
    ADD CONSTRAINT tipologie_pk PRIMARY KEY (oid);


--
-- TOC entry 1800 (class 2606 OID 150173)
-- Name: utenti_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY utenti
    ADD CONSTRAINT utenti_pk PRIMARY KEY (oid);


--
-- TOC entry 1792 (class 1259 OID 150174)
-- Name: fki_fam_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_fam_fk ON ragazzi USING btree (parent_oid);


--
-- TOC entry 1777 (class 1259 OID 150175)
-- Name: fki_girnata_periodo_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_girnata_periodo_fk ON giornate USING btree (periodo_oid);


--
-- TOC entry 1780 (class 1259 OID 150176)
-- Name: fki_part_periodo_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_part_periodo_fk ON partecipanti USING btree (periodo_oid);


--
-- TOC entry 1781 (class 1259 OID 150177)
-- Name: fki_part_raga_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_part_raga_fk ON partecipanti USING btree (ragazzo_oid);


--
-- TOC entry 1782 (class 1259 OID 150178)
-- Name: fki_part_tipo_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_part_tipo_fk ON partecipanti USING btree (tipo_oid);


--
-- TOC entry 1787 (class 1259 OID 150179)
-- Name: fki_pres_rag_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_pres_rag_fk ON presenze USING btree (ragazzo_oid);


--
-- TOC entry 1815 (class 2606 OID 150228)
-- Name: allegato_ragazzo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY allegati
    ADD CONSTRAINT allegato_ragazzo_fk FOREIGN KEY (ragazzo_oid) REFERENCES ragazzi(oid);


--
-- TOC entry 1814 (class 2606 OID 150180)
-- Name: fam_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY ragazzi
    ADD CONSTRAINT fam_fk FOREIGN KEY (parent_oid) REFERENCES ragazzi(oid);


--
-- TOC entry 1809 (class 2606 OID 150185)
-- Name: girnata_periodo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY giornate
    ADD CONSTRAINT girnata_periodo_fk FOREIGN KEY (periodo_oid) REFERENCES periodi(oid);


--
-- TOC entry 1810 (class 2606 OID 150190)
-- Name: part_periodo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY partecipanti
    ADD CONSTRAINT part_periodo_fk FOREIGN KEY (periodo_oid) REFERENCES periodi(oid);


--
-- TOC entry 1811 (class 2606 OID 150195)
-- Name: part_raga_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY partecipanti
    ADD CONSTRAINT part_raga_fk FOREIGN KEY (ragazzo_oid) REFERENCES ragazzi(oid);


--
-- TOC entry 1812 (class 2606 OID 150200)
-- Name: part_tipo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY partecipanti
    ADD CONSTRAINT part_tipo_fk FOREIGN KEY (tipo_oid) REFERENCES tipologie(oid);


--
-- TOC entry 1813 (class 2606 OID 150210)
-- Name: pres_rag_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY presenze
    ADD CONSTRAINT pres_rag_fk FOREIGN KEY (ragazzo_oid) REFERENCES ragazzi(oid);


--
-- TOC entry 1931 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-06-29 12:39:04 CEST

--
-- PostgreSQL database dump complete
--

