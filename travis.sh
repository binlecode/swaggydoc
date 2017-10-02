#!/bin/bash
set -e
rm -rf *.zip
./bowerize.sh


#echo "Publishing plugin 'swaggydoc' version $version"
#
#./gradlew \
#    swaggydoc-commons:bintrayUpload \
#    swaggydoc-grails3:bintrayUpload \
#    --info || echo "Bintray upload failed"
#
