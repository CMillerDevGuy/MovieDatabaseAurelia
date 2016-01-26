export class App {
  
    configureRouter(config, router){
        this.router = router;
        config.map([
            {
                route:["", "list"], moduleId:"movies/list", title:"List", nav:true, name:"home"
            },
            {
                route:"create", moduleId:"movies/create", title:"Create", nav:true
            },
            {
                route:"details/:id", moduleId:"movies/details", name:"details", title:"Details"
            },
            {
                route:"edit/:id", moduleId:"movies/edit", name:"edit", title:"Edit"
            },
            {
                route:"Edit", moduleId:"movies/edit", name:"Edit", title:"Edit"
            }
        ]);
    }
}
