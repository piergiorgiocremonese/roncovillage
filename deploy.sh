#!/bin/sh

TOMCAT_ROOT=/usr/local/tomcat
TOMCAT_PATH=/usr/local/tomcat/webapps
#TOMCAT_PATH=/var/lib/tomcat7/webapps
app="$1"
if test -z $app 
then
echo "manca app da deployare: aggiorno con ronco"
app="ronco"
fi
ant clean
ant -Denv=dev distapp
curr=`pwd`
echo "deployare $curr/distapp/$app.war in $TOMCAT_PATH"
$TOMCAT_ROOT/bin/shutdown.sh
cd $TOMCAT_PATH
rm -R $app
rm  $app.war
cp $curr/distapp/$app.war .
$TOMCAT_ROOT/bin/startup.sh
cd $curr
