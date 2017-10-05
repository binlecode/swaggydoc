package swaggydoc.grails3.example

import com.wordnik.swagger.annotations.*
import grails.converters.JSON
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Api(value = 'book')
@Transactional(readOnly = true)
class BookController {

    static allowedMethods = [customNonUrlMappedAction: 'GET', customSave: 'POST', save: "POST", update: "PUT", delete: "DELETE"]


    @ApiOperation(value = 'book resource custom non-url-mapped action', response = Map, httpMethod = 'GET')
    @ApiResponses([
            @ApiResponse(code = 200, message = 'book resource custom non-url-mapped action 200 ok', response = Map),
            @ApiResponse(code = 400, message = 'Bad request'),
            @ApiResponse(code = 500, message = 'Internal server error message')
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'Accept', value = 'Accepted mime type',
                    paramType = 'header', dataType = 'string', required = false, defaultValue = 'application/json'),
            @ApiImplicitParam(name = 'format', value = 'response content type', defaultValue = 'json', paramType = 'query', dataType = 'string')
    ])
    def customNonUrlMappedAction() {
        render ([message: 'response of custom non-url-mapped action'] as JSON)
    }

    def customUrlMappedAction() {
        render ([message: 'response of custom url mapped action'] as JSON)
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

    def create() {
        respond new Book(params)
    }

    @ApiOperation(value = 'custom book save', response = Book, httpMethod = 'POST')
    @ApiResponses([
            @ApiResponse(code = 200, message = 'book resource', response = Book),
            @ApiResponse(code = 400, message = 'Bad request'),
            @ApiResponse(code = 500, message = 'Internal server error message')
    ])
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'body', value = 'Book resource json', paramType = 'body', dataType = 'string')
    ])
    def customSave() {
        respond new Book()
    }

    @Transactional
    def save(Book book) {
        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (book.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond book.errors, view:'create'
            return
        }

        book.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*' { respond book, [status: CREATED] }
        }
    }

    def edit(Book book) {
        respond book
    }



    @Transactional
    def update(Book book) {
        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (book.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond book.errors, view:'edit'
            return
        }

        book.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect book
            }
            '*'{ respond book, [status: OK] }
        }
    }

    @Transactional
    def delete(Book book) {

        if (book == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        book.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'book.label', default: 'Book'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
