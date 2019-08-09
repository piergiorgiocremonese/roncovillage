#!/usr/bin/perl


local($n,$file)=@ARGV;
open(FIN,"<$file");
my $i=$n;
my $somma=0;
while($n>0){
	my $m=<FIN>;
	chop($m);
	if ($m<0){
		$somma=$somma+$m;
	}
	$n=$n-1;
	
}
print $somma . "\n";


