-- Table: sconti

-- DROP TABLE sconti;

CREATE TABLE sconti
(
  oid serial NOT NULL,
  sconto double precision DEFAULT 0,
  anno integer,
  ragazzo_oid integer,
  CONSTRAINT sconti_pk PRIMARY KEY (oid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sconti
  OWNER TO postgres;

