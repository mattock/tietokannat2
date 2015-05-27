#!/bin/sh
#
# A simple wrapper for launching the main program on *NIX.
#
JAVA=`which java`

cd src
./build.sh
if [ $? -eq 0 ]; then
    $JAVA -Djdbc.drivers=org.postgresql.Driver -cp /usr/share/java/postgresql-jdbc4.jar:. main
fi
cd ..
