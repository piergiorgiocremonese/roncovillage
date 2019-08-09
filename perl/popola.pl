#!/usr/bin/perl


do 'db.pl';
do 'const.pl';

sub findCasa{
	local($dbh,$flog,$casa)=@_;
	my $oid = -1;
	my $sql = "select oid from societa where denominazione = '$casa'";
	my @M=getInfoByQuery($sql,$dbh,$flog);
	if ($#M>=0){
		$oid = @M[0]->[0];
	}
	return $oid;
}


sub findConf{
	local($dbh,$flog,$vds)=@_;
	my $oid = -1;
	my $sql = "select oid from modelli_conf where vds = '$vds'";
	my @M=getInfoByQuery($sql,$dbh,$flog);
	if ($#M>=0){
		$oid = @M[0]->[0];
	}
	return $oid;
}


sub findModel{
	local($dbh,$flog,$mod)=@_;
	my $oid = -1;
	my $sql = "select oid from modelli_auto where modello = '$mod'";
	my @M=getInfoByQuery($sql,$dbh,$flog);
	if ($#M>=0){
		$oid = @M[0]->[0];
	}
	return $oid;
}

local($fin)=@ARGV;
open(FLOG,">>sql.log");
my $dbh= dbconn($db,$dbname,$dbhost,$dbuser,$dbpsw);
open(FIN,"<$fin");
my $f=<FIN>;
chop($f);
my @F=split(/;/,$f);

while(<FIN>){
	my $l=$_;
	print $l;
	chop($l);
	my @R=split(/;/,$l);
	my %Rec=();
	for (my $i=0;$i<=$#F;$i++){
		$Rec{@F[$i]}=@R[$i];
		print "add @R[$i] in @F[$i]\n";
	}
	my $casaOid = findCasa($dbh,FLOG,$Rec{'denominazione'});
	if ($casaOid<0){
		my $sql = insert into societa (denominazione) values ('".$Rec{'denominazione'}."')";
		$casaOid = insertIntoDB($sql,$dbh,FLOG,"oid",public","societa",undef);
		
	}
	my $mod=findModel($dbh,FLOG,$Rec{'modello'});
	if ($mod>0){
		if (findConf($dbh,FLOG,$Rec{'vds'})>0){
			print "configurazione presente per $Rec{'vds'} $Rec{'modello'}\n";
		}else{
			
			my $sql = "insert into modelli_conf(vds,wmi,model_oid, modello,manufacturer_oid) values ('".$Rec{'vds'}."','".$Rec{'wmi'}."',$mod,'".$Rec{'modello'}."',$casaOid)";
			print $sql . "\n";
		}
		

		
	}else{
		my $sql = "insert into modelli_auto(casa_oid,nome,modello) values(,wmi,model_oid, modello,manufacturer_oid) values ('".$Rec{'vds'}."','".$Rec{'wmi'}."',$mod,'".$Rec{'modello'}."',$casaOid)";
		$mod = insertIntoDB($sql,$dbh,FLOG,"oid",public","modelli_auto",undef);
		
		$sql = "insert into modelli_conf(vds,wmi,model_oid, modello,manufacturer_oid) values ('".$Rec{'vds'}."','".$Rec{'wmi'}."',$mod,'".$Rec{'modello'}."',$casaOid)";
		$conf = insertIntoDB($sql,$dbh,FLOG,"oid",public","modelli_conf",undef);
		print "added " . $conf . "\n"

		
	}

	
	
}

dbdisconn($dbh);

close FLOG;
close FIN;

