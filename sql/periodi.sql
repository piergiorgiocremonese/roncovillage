#update periodi
#set fine = fine + interval '18 hours';

ALTER TABLE periodi ADD COLUMN libero boolean;
ALTER TABLE periodi ALTER COLUMN libero SET DEFAULT true;
ALTER TABLE periodi ADD COLUMN numero_massimo integer;
ALTER TABLE periodi ALTER COLUMN numero_massimo SET DEFAULT 60;

update periodi set libero = TRUE;
update periodi set libero = FALSE where anno = '2017' and ordine = '3';

update periodi set numero_massimo = 60;

