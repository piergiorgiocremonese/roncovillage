#!/usr/bin/perl

do 'const.pl';
do 'db.pl';

open(FLOG,">sql.log");
open(FOUT,">carichi");
my $dbh= dbconn ($db,$dbname,$dbhost,$dbuser,$dbpsw);
my $sqlstatement = "select v.oid,ma.oid, count(*) from carico c, auto a, viaggi v, modelli_auto ma where v.oid = c.viaggio_oid and c.auto_oid=a.oid and a.modello_oid = ma.oid group by v.oid, ma.oid order by v.oid,ma.oid";
my @R= getInfoByQuery ($sqlstatement,$dbh,FLOG);
print FOUT "Viaggio;Modello;Unita\n"; 
for my $r (@R){
	print FOUT $r->[0] . ";" . $r->[1] . ";" . $r->[2] . "\n";
	my $sql = "select oid,viaggio_oid,modello_oid,unita from viaggi_report where viaggio_oid = $r->[0] and modello_oid = $r->[1]";
	my @Recs = getInfoByQuery($sql,$dbh,FLOG);
	if ($#Recs>=0){
		my $oid = $Recs[0]->[0];
		my $unita = @Recs[0]->[2];
		if ($unita != $r->[2]){
		print $sqlupd . "\n";
		my $sqlupd = "update viaggi_report set unita = @R[0]->[2] where oid = $oid";
		execSql($sqlupd,$dbh,FLOG);
		}else{
			print "non aggiorno $r->[0], $r->[1] gia aggiornati\n";
		}
		
	}else{
		my $sqlins = "insert into viaggi_report (viaggio_oid,modello_oid,unita) values ($r->[0],$r->[1],$r->[2])";
		print $sqlins . "\n";
		execSql($sqlins,$dbh,FLOG);
		
		print $sqlins . "\n";
	}
}

dbdisconn($dbh);
close FOUT;
close FLOG;
