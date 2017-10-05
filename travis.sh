#!/bin/bash
set -e
rm -rf *.zip
./bowerize.sh

echo "building plugin and example Grails app"
./gradlew \
    swaggydoc-grails3:assemble \
    swaggydoc-grails3-example:assemble \
    --info || echo "Bintray upload failed"

#echo "Publishing plugin 'swaggydoc' version $version"
#
#./gradlew \
#    swaggydoc-grails3:bintrayUpload \
#
#
