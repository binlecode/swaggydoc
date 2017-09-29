class UrlMappings {

    static mappings = {


        //fixme: this reveals a bug in swaggyDataSerivce swaggy spec json generation logic that a custom action
        //fixme:   url mapping will supersede conventional CRUDs url paths by prefixing this custom action to
        //fixme:   all url paths
        '/book/customIndex'(controller: 'book', action: 'index')

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
