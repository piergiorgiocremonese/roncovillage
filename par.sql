ALTER TABLE partecipanti ADD COLUMN stato boolean;
ALTER TABLE partecipanti ALTER COLUMN stato SET DEFAULT false;

insert into partecipanti (periodo_oid,ragazzo_oid,stato) 
(select p.oid,r.oid,false from ragazzi r,periodi p where p.ordine = r.periodi);

