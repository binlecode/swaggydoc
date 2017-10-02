package swaggydoc.grails3.example

import com.wordnik.swagger.annotations.ApiModelProperty

class Domain {

    @ApiModelProperty(value = "Name of the domain")
    String name
    @ApiModelProperty(value = "Description of the domain")
    String description
    String unmentionable

    List subdomainsWithoutGenerics
//    List<Subdomain> subdomainsWithGenerics

    static hasMany = [
            subdomainsWithoutGenerics: Subdomain,
//            subdomainsWithGenerics   : Subdomain,
//            implicitSubdomains       : Subdomain,
    ]
    static constraints = {
        description nullable: true
        unmentionable nullable: true
    }
    static transients = ['unmentionable']
}
