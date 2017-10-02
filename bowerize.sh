#!/bin/sh

bower install

BOWER_DIR=bower-sources/swagger-ui/dist/

ASSETS=swaggydoc-grails3/grails-app/assets
rm -rf $ASSETS/images/ $ASSETS/stylesheets/ $ASSETS/javascripts/
mkdir -p $ASSETS/images/
mkdir -p $ASSETS/stylesheets/
mkdir -p $ASSETS/javascripts/swagger-lib/

cp -R $BOWER_DIR/images/*      $ASSETS/images/
cp -R $BOWER_DIR/css/*         $ASSETS/stylesheets/
cp -R $BOWER_DIR/lib/*         $ASSETS/javascripts/swagger-lib/
cp -R $BOWER_DIR/swagger-ui.js $ASSETS/javascripts/
