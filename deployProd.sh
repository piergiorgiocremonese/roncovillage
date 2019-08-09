#!/bin/sh


#ant clean
ant -Denv=prod clean distapp
scp distapp/ronco.war ashuser@www.cremonese.org:/home/ashuser/tmp/ronco.war
ssh ashuser@www.ashweb.it /home/ashuser/deployRonco.sh 
