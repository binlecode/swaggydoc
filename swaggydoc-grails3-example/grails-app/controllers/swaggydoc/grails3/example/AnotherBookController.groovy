package swaggydoc.grails3.example

import com.wordnik.swagger.annotations.*
import grails.converters.JSON
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Api(value = 'anotherBook')
@Transactional(readOnly = true)
class AnotherBookController {

    static allowedMethods = [customNonUrlMappedAction: 'GET', customSave: 'POST', save: "POST", update: "PUT", delete: "DELETE"]


    @ApiOperation(value = 'book resource custom non-crud action', response = Map, httpMethod = 'GET')
    @ApiResponses([
            @ApiResponse(code = 200, message = 'book resource custom non-crud action 200 ok', response = Map),
            @ApiResponse(code = 400, message = 'Bad request'),
            @ApiResponse(code = 500, message = 'Internal server error message')
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'Accept', value = 'Accepted mime type',
                    paramType = 'header', dataType = 'string', required = false, defaultValue = 'application/json'),
            @ApiImplicitParam(name = 'format', value = 'response content type', defaultValue = 'json', paramType = 'query', dataType = 'string')
    ])
    def customNonCrudAction() {
        render ([message: 'response of custom non-crud action'] as JSON)
    }

    @ApiOperation(value = 'book resource list and count', response = Book, responseContainer = 'array', httpMethod = 'GET')
    @ApiResponses([
            @ApiResponse(code = 200, message = 'book resource list and count', response = Book),
            @ApiResponse(code = 400, message = 'Bad request'),
            @ApiResponse(code = 500, message = 'Internal server error message')
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'Accept', value = 'Accepted mime type',
                    paramType = 'header', dataType = 'string', required = false, defaultValue = 'application/json'),
            @ApiImplicitParam(name = 'offset', value = 'Records to skip', defaultValue = '0', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'max', value = 'Max records to return', defaultValue = '10', paramType = 'query', dataType = 'int'),
            @ApiImplicitParam(name = 'sort', value = 'Field to sort by', defaultValue = 'id', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 'order', value = 'Order to sort by', defaultValue = 'asc', paramType = 'query', dataType = 'string'),
            @ApiImplicitParam(name = 'format', value = 'response content type', defaultValue = 'json', paramType = 'query', dataType = 'string')
    ])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Book.list(params), model:[bookCount: Book.count()]
    }

    @ApiOperation(value = 'book custom show', response = Book, httpMethod = 'GET')
    @ApiResponses([
            @ApiResponse(code = 200, message = 'book resource', response = Book),
            @ApiResponse(code = 404, message = 'Not found'),
            @ApiResponse(code = 500, message = 'Internal server error message')
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Book resource id', paramType = 'query', dataType = 'string')
    ])
    def customShow(String id) {
        respond Book.get(id)
    }

    @ApiOperation(value = 'book show', response = Book, httpMethod = 'GET')
    @ApiResponses([
            @ApiResponse(code = 200, message = 'book resource', response = Book),
            @ApiResponse(code = 404, message = 'Not found'),
            @ApiResponse(code = 500, message = 'Internal server error message')
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'id', value = 'Book resource id', paramType = 'query', dataType = 'string')
    ])
    def show(Book book) {
        respond book
    }


}
