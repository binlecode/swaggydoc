
[![Build Status](https://travis-ci.org/binlecode/swaggydoc.svg?branch=dev-g3.0)](https://travis-ci.org/binlecode/swaggydoc)

![Unmaintained](https://img.shields.io/badge/status-unmaintained-yellow.svg) This repository is not actively maintained. If you are interested in taking it over, please let me know.

## Documentation

wip

## Contributing

Before you can run any other commands, you will have to obtain the swagger-ui assets.

```bash
./bowerize.sh
```

Running grails3 plugin in dev mode
```bash
./gradlew swaggydoc-grails3:bootRun
```

## Change Log

#### v 0.30.3
* integrate common annotation supporting libs to grails plugin codebase
* fix multi-build issue by gradle version upgrade and codebase integration
* update travis script for integrated codebase 

#### v 0.30.2
* fix default action logic for missing action setting in url mapping
* fix url path overriding for each and specific url mapped path

#### v 0.30.1
* refactor api method documentation building logic

#### v 0.30.0
* update plugin for Grails 3.2+

#### v 0.29.0
* update plugin for Grails 3.0+
* fix custom url mappings path concatenating Grails CRUDs url path bug 




