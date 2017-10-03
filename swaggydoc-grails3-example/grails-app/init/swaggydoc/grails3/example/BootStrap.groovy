package swaggydoc.grails3.example

import groovy.util.logging.Slf4j

@Slf4j
class BootStrap {

    def init = { servletContext ->

        Book.withTransaction {
            10.times { idx ->
                log.info "saving book with title: test-book-${idx}"
                new Book(title: "test-book-$idx").save()
            }
        }

    }
    def destroy = {
    }
}
