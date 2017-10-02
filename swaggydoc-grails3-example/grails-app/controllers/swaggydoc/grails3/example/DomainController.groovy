package swaggydoc.grails3.example

import com.github.rahulsom.swaggydoc.*
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiImplicitParam
import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Api(
        value = 'demo'/*,
        description = 'Demo API',
        position = 0,
        produces = 'application/json,application/xml,text/html',
        consumes = 'application/json,application/xml,application/x-www-form-urlencoded' */
)
class DomainController extends RestfulController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [
            delete: ['POST', 'DELETE'],
            update: ['POST', 'PUT'],
            patch: ['POST', 'PATCH'],
    ]

    DomainController() {
        super(Domain)
    }

    @Override
    @SwaggyList(extraParams = [
            @ApiImplicitParam(name="include", value="Fields to include in result", dataType = "string")
    ])
    def index() {
        super.index()
    }

    @Override
    @SwaggyShow(extraParams = [
            @ApiImplicitParam(name="animal", value="Animal to use", dataType = 'string',
                    allowableValues = '[dog, cat, "mad dog"]', required = true)
    ])
    def show() {
        super.show()
    }

    @SwaggySave
    @Override
    def save() {
        super.save()
    }

    @Override
    @SwaggyUpdate
    def update() {
        super.update()
    }

    @Override
    @SwaggyDelete
    def delete() {
        super.delete()
    }

    @Override
    @SwaggyPatch
    Object patch() {
        return super.patch()
    }
}
