#!/usr/bin/perl


do 'db.pl';
do 'const.pl';

local($oid)=@ARGV;

open(LOG,">sql.log");
my $sqlall = "select oid from viaggi where oid<$oid";
my $dbh = dbconn ($db,$dbname,$dbhost,$dbuser,$dbpsw);
my @List=getInfoByQuery($sqlall,$dbh,LOG);

for my $x (@List){

$oid = $x->[0];



my $dd="delete from dettaglio_danno where danno_oid in (select oid from danni d where d.viaggio_oid = $oid)";
my $d="delete from danni where viaggio_oid=$oid";
my $pc = "delete from perizia_case_auto pca where pca.oid in (select oid from perizie where viaggio_oid = $oid)";
my $ap = "delete from allegati_perizia where perizia_oid in (select oid from perizie where viaggio_oid  = $oid)";
my $p = "delete from perizie where viaggio_oid = $oid";
my $set = "select auto_oid from carico where viaggio_oid = $oid";
my $c = "delete from carico where viaggio_oid = $oid";
my $a = "delete from auto where oid = <OID>";
my $av = "delete from allegati_viaggio where viaggio_oid = $oid";
my $vr = "delete from viaggi_report where viaggio_OID = $oid";
my $vca = "delete from viaggio_case_auto where viaggio_oid = $oid";
my $v = "delete from viaggi where oid = $oid";

my @Al = getInfoByQuery($set,$dbh,LOG);
execSql($dd,$dbh,LOG);
execSql($d,$dbh,LOG);
execSql($pc,$dbh,LOG);
execSql($ap,$dbh,LOG);
execSql($p,$dbh,LOG);
execSql($c,$dbh,LOG);
for my $x (@Al){
	my $sql = $a;
	$sql=~s/<OID>/$x->[0]/g;
	print $sql . "\n";	
	execSql($sql,$dbh,LOG);
	
}
execSql($av,$dbh,LOG);
execSql($vr,$dbh,LOG);
execSql($vca,$dbh,LOG);
execSql($v,$dbh,LOG);
}
dbdisconn($dbh);
    
