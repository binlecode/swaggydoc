package swaggydoc.grails3.example

class Book {

    String title
    String isbn
    String author

    static constraints = {
        title blank: false, maxSize: 255
        isbn nullable: true
        author nullable: true
    }
}
