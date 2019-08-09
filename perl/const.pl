#!/usr/bin/perl
#
#
$logfile="/var/www/logs/tracking.log";
$rootArea = "/var/www/tracking";
$areaweb = "/var/www/tracking";
$webapp="/tracking";
$jsonArea = "/var/www/tracking/jsondir";

$kmldir="/kml";
$imgdir="/tmp/img/";
$webimgdir="$areaweb/images";
$tmpimgdir="/tmp/img/temp";
$logdir="./logs/";
$gpxdir="/var/www/gpx";
$sqldir="/var/www/sql";
$bindir="/var/www/bin";
$db="Pg";
$dbuser="postgres";
$dbpsw="postgres";
$dbname = "ronco";
$dbhost="localhost";
#$db="Pg";
#$dbuser="postgres";
#$dbpsw="postgres";
#$dbname = "conservazione_test";
#$dbhost="localhost";
#$dbhost="82.107.112.66";
#$dbhost="192.168.1.126";
$mongodb="conservazione";
$mongohost="localhost";
$mongoport=27017;


$fdbdir="/var/www/tracking/db";

$host = "localhost";


$targetfile="gpxfile";
$tabella = "dati_impianti";
$urlimg="http://localhost:8181/img";
$tabisp = "ispezioni";
$dbisp = "dbi:ODBC:googlefile";
$pagedim=20;

$step=10;
$delta=10;
$intervallo=4;
$arrlat = 18.465817;
$arrlong = -64.358611;

$slat = 28.483117;
$slong = -16.210600;

$from="emailgw\@ashweb.it";
$to="piergiorgiocremonese\@gmail.com";
$fn = "config.sbd";
$t="application/octet-stream";
$durata_back=30;
