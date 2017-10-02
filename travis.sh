#!/bin/bash
set -e
rm -rf *.zip
./bowerize.sh

filename=$(find . -name "grails-*.zip" | head -1)
filename=$(basename $filename)

echo "Publishing plugin 'swaggydoc' version $version"

./gradlew \
    swaggydoc-commons:bintrayUpload \
    swaggydoc-grails3:bintrayUpload \
    --info || echo "Bintray upload failed"

