#!/usr/bin/perl

# -- SOAP::Lite -- soaplite.com -- Copyright (C) 2001 Paul Kulchenko --
#
use DBI;
sub execSql{
	local($sqlstatement,$dbh,$fout)=@_;
	print  "parto     $sqlstatement";


	 #prepare and execute SQL statement
	 $sth = $dbh->prepare($sqlstatement);
	 $x=$sth->execute || die  "Could not execute SQL statement ... maybe invalid?";
	#  print $fout "fine esex $sqlstatement $x\n";   
	#$dbh->commit();
}



sub insertIntoDB{
local($sqlstatement,$dbh,$fout,$c,$s,$t,$f)=@_;
#print  "parto     $sqlstatement";
#$dbh = DBI->connect('dbi:ODBC:ispezioni');
#$dbh = DBI->connect($dbval);
print $fout "connesso: $dbh\n";
#print "connesso: $dbh\n";

 #prepare and execute SQL statement
 $sth = $dbh->prepare($sqlstatement);
 $x=$sth->execute || die  "Could not execute SQL statement ... maybe invalid?";
  print $fout "fine esex $sqlstatement $x\n";   
 #
 #           #output database results
 #while (@row=$sth->fetchrow_array)
 #	{ print "@row\n" };
return $dbh->last_insert_id($c,$s,$t,$f);

}


sub getInfoByQuery{
	local($sqlstatement,$dbh,$fout)=@_;
	my @Result;
	#$dbh = DBI->connect($db);
	print $fout "connesso";
	print $fout $sqlstatement . "  e dbh vale $dbh \n";
	 $sth = $dbh->prepare($sqlstatement);
	 $x=$sth->execute || 
	     die "Could not execute SQL statement ... maybe invalid?";
	     $i=0;
	while (my @riga=$sth->fetchrow_array){
		#my @r=@$riga;
		push(@Result,\@riga);
	}
	
	print $fout " finito statement via\n";
	
	return @Result;	

}


sub getHashByQuery{
	local($sqlstatement,$dbh,$fout)=@_;
	my @Result;
	#$dbh = DBI->connect($db);
	print $fout "connesso";
	print $fout $sqlstatement . "  e dbh vale $dbh \n";
	 $sth = $dbh->prepare($sqlstatement);
	 $x=$sth->execute || 
	     die "Could not execute SQL statement ... maybe invalid?";
	     $i=0;
	while (my $riga=$sth->fetchrow_hashref){
		#my @r=@$riga;
		%Riga=%$riga;
		print $fout "riga =  $riga\n"; 
		push(@Result,$riga);
	}
	
	
	return \@Result;	

}

sub dbconn{
	local($db,$dbname,$dbhost,$dbuser,$dbpsw)=@_;
	#print $fout "$db,$dbname,$dbhost,$dbuser,$dbpsw\n";
	$strconn="DBI:$db:dbname=$dbname;host=$dbhost";
	#print $fout $strconn . "\n";
	my $dbh = DBI->connect($strconn,$dbuser, $dbpsw, {'RaiseError' => 1});
	#print $fout $dbh . "\n";
	return $dbh;
 
}
sub dbdisconn{
	local($dbh)=@_;
	$dbh->disconnect();

 
}


sub getCmd{
               local($tab,$riso)=@_;
                my %Riso=%$riso;
                my $risoSql = "insert into $tab ";
                my $risoV = "";
                my $risoF = "";
                for my $x (keys %Riso){
                        $risoF = $risoF . $x . ",";
                        $risoV = $risoV . $Riso{$x} . ",";
                }
                chop($risoF);
                chop($risoV);
                $risoSql = $risoSql . "( " . $risoF . ") values (". $risoV.")";
                return $risoSql;
}

