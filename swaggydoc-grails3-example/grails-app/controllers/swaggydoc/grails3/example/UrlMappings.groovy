package swaggydoc.grails3.example

class UrlMappings {

    static mappings = {

        '/customBook/customAction'(controller: 'book', action: 'customUrlMappedAction')

        '/customBook/customIndex'(controller: 'book', action: 'index')

        get '/another/book'(controller: 'anotherBook')
        get "/another/book/customShow/$id"(controller: 'anotherBook', action: 'show')

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
