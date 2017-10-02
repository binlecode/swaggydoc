class UrlMappings {

    static mappings = {

        '/customBook/customIndex'(controller: 'book', action: 'index')

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
