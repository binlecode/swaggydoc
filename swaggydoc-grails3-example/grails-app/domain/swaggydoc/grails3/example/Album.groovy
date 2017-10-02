package swaggydoc.grails3.example

class Album {

    String title

    static constraints = {
    }

    static hasMany = [photos: Photo]
}
