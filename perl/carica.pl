#!/usr/bin/perl


do 'db.pl';
do 'const.pl';


local($fin,$table)=@ARGV;
my $dbh =  dbconn ($db,$dbname,$dbhost,$dbuser,$dbpsw);

open(FIN,"<$fin");
open(FLOG,">>db.log");
my $f=<FIN>;
chop($f);
my @F=split(/;/,$f);
my $fields="(";
for (my $i=0;$i<=$#F;$i++){
	$fields = $fields . @F[$i].",";
}
chop($fields);
$fields = $fields . ")";
while(<FIN>){
	my $l=$_;
	chop($l);
	my @V=split(/;/,$l);
	my $vals="(";
	for (my $i=0;$i<=$#V;$i++){
		$vals = $vals . "'".@V[$i]."',";
	}
	chop($vals);
	$vals = $vals . ")";
	#my $sql = "INSERT INTO $table $fields values $vals";
	print $sql . ";\n";
	#my $oid = insertIntoDB($sql,$dbh,FLOG,"oid","public",$table,'');
	print "inserito record $oid via $sql\n";
	
}
	
dbdisconn($dbh);
close(FLOG)
close(FIN);
