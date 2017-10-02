package swaggydoc.grails3.example

import com.github.rahulsom.swaggydoc.SwaggyList
import com.github.rahulsom.swaggydoc.SwaggyUpdate
import com.wordnik.swagger.annotations.*
import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Api(value = 'mapped with some overriding annotations')
// TODO This should return Domain in codegen, not MappedWithAnnotations
class MappedWithAnnotationsController extends RestfulController {

    static responseFormats = ['json', 'xml']

    MappedWithAnnotationsController() {
        super(Domain)
    }

    @Override
    @SwaggyList(searchParam = false)
    def index() {
        super.index()
    }

    @Override
    @SwaggyUpdate
    def update() {
        super.update()
    }

    @Override
    @ApiOperation(value = "Patch Demo", response = Domain)
    @ApiResponses([
        @ApiResponse(code = 400, message = 'Bad Id provided'),
        @ApiResponse(code = 404, message = 'Could not find Demo with that Id'),
        @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
        @ApiImplicitParam(name = 'id', value = 'Id to patch', paramType = 'path', dataType = 'int', required = true),
        @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'Domain')
    ])
    Domain patch() {
        return super.patch()
    }
}
