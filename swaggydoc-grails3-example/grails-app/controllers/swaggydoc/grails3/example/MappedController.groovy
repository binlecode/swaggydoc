package swaggydoc.grails3.example

import com.wordnik.swagger.annotations.Api
import grails.rest.RestfulController

@Api(value = 'mappedAsResource')
class MappedController extends RestfulController {

    static responseFormats = ['json', 'xml']

    MappedController() {
        super(Domain)
    }
}
