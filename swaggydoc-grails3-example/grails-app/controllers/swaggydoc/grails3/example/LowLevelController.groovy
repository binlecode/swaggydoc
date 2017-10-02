package swaggydoc.grails3.example

import com.github.rahulsom.swaggydoc.SwaggyAdditionalClasses
import com.wordnik.swagger.annotations.*
import grails.rest.RestfulController
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Api(
        value = 'demo',
        description = 'Demo API',
        position = 0,
        produces = 'application/json,application/xml,text/html',
        consumes = 'application/json,application/xml,application/x-www-form-urlencoded'
)
class LowLevelController extends RestfulController {

    static allowedMethods = [
            delete: ['POST', 'DELETE'],
            update: ['POST', 'PUT'],
            patch: ['POST', 'PATCH'],
    ]

    static responseFormats = ['json', 'xml']

    LowLevelController() {
        super(Domain)
    }

    @Override
    @ApiOperation(value = 'List demos', response = Domain, responseContainer = 'array')
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'offset', value = 'Records to skip', defaultValue = '0', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'max', value = 'Max records to return', defaultValue = '10', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'sort', value = 'Field to sort by', defaultValue = 'id', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 'order', value = 'Order to sort by', defaultValue = 'asc', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 'q', value = 'Query', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 's', value = 'Shirt Size', paramType = 'query', dataType = 'ShirtSize'),
    ])
    @SwaggyAdditionalClasses(ShirtSize)
    def index() {
        super.index()
    }

    @Override
    @ApiOperation(value = "Show Demo", response = Domain)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided', response = ErrorMessage),
            @ApiResponse(code = 404, message = 'Could not find Demo with that Id'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to fetch', paramType = 'path', dataType = 'int', required = true),
            @ApiImplicitParam(name = 'a', value = 'Animals', paramType = 'query', dataType = 'string', allowMultiple = true),
    ])
    def show() {
        super.show()
    }

    @ApiOperation(value = "Show Demo", response = Domain)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find Demo with that Id'),
    ])
    def noImplicitParams() {
        super.show()
    }

    @ApiOperation(value = "Show Demo", response = Domain)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find Demo with that Id'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to fetch', paramType = 'path', dataType = 'int', required = true),
    ])
    def duplicateMethod(Domain domain) {
        super.show()
    }

    @ApiOperation(value = "Save Demo", response = Domain)
    @ApiResponses([
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'LowForm',
                    defaultValue = '{"name":"foo", "address":"bar"}')
    ])
    @SwaggyAdditionalClasses([LowForm])
    @Override
    def save() {
        super.save()
    }

    @Override
    @ApiOperation(value = "Update Demo", response = Domain)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find Demo with that Id'),
            @ApiResponse(code = 422, message = 'Bad Entity Received'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to update', paramType = 'path', dataType = 'int', required = true),
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'Demo')
    ])
    def update() {
        super.update()
    }

    @Override
    @ApiOperation(value = "Delete Demo", response = Void)
    @ApiResponses([
            @ApiResponse(code = 400, message = 'Bad Id provided'),
            @ApiResponse(code = 404, message = 'Could not find Demo with that Id'),
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Id to delete', paramType = 'path', dataType = 'int', required = true),
    ])
    def delete() {
        super.delete()
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
            @ApiImplicitParam(name = 'body', paramType = 'body', required = true, dataType = 'Demo')
    ])
    Object patch() {
        return super.patch()
    }
}
