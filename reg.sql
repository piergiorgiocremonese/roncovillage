-- Column: code

-- ALTER TABLE ragazzi DROP COLUMN code;

ALTER TABLE ragazzi ADD COLUMN code character varying;
ALTER TABLE ragazzi ADD COLUMN classe_frequentata character varying;
ALTER TABLE ragazzi ADD COLUMN data_nascita timestamp with time zone;
ALTER TABLE ragazzi ADD COLUMN tel_casa character varying;
ALTER TABLE ragazzi ADD COLUMN tel_work_padre character varying;
ALTER TABLE ragazzi ADD COLUMN tel_work_madre character varying;
ALTER TABLE ragazzi ADD COLUMN tel_accompagnatore character varying;

