package swaggydoc.grails3.example

class Photo {

    Album album

    static constraints = {
    }

    static belongsTo = [album: Album]
}
