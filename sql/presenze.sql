select  ragazzo_oid,nome,cognome,giorno,presente  from presenze p, ragazzi r where p.ragazzo_oid = r.oid and to_char(giorno,'YYYYMMDD')>='20170710' and to_char(giorno,'YYYYMMDD')<='20170715' and r.cognome = 'TURCHI' order by cognome, nome;

