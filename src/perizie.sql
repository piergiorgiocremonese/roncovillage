update danni d
set perizia_oid = (select oid from perizie p where p.viaggio_oid = d.viaggio_oid)