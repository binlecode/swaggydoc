import groovy.util.logging.Slf4j
import swaggydoc.grails3.example.Book

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
