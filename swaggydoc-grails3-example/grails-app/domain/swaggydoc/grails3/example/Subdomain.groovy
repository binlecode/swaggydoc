package swaggydoc.grails3.example

class Subdomain {

    String name

    static belongsTo = [domain: Domain]

    static constraints = {
    }
}
