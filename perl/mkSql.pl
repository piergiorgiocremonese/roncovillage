#!/usr/bin/perl


do 'db.pl';
do 'const.pl';

open(FLOG,">>db.log");
my $sql = "select tipo,valore from tipi_allegato";
my $updsqltpl = "update tipi_allegato set valore='<VALORE>' where tipo='<TIPO>'";
my $dbh = dbconn($db,$dbname,$dbhost,$dbuser,$dbpsw);
my $recs = getHashByQuery($sql,$dbh,FLOG);
my @Recs = @$recs;
for my $r (@Recs){
	my $updsql = $updsqltpl;
	$updsql=~s/<TIPO>/$r->{'tipo'}/g;
	$updsql=~s/<VALORE>/$r->{'valore'}/g;
	print $updsql . ";\n";
} 


dbdisconn($dbh);
