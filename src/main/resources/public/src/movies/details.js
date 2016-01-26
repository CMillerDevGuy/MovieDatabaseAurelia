import {inject} from "aurelia-framework";
import {Router} from "aurelia-router";
import {MovieData} from "./movieData";


@inject(MovieData, Router)
export class Details {
    
    constructor(movieData, router){
        this.data = movieData;
        this.router = router;
    }
      
    activate(params){
        this.data.getById(params.id).then(movie => this.movie = movie);
    }
    
    delete(id){
    	this.data.delete(id)
    		.then(movie => {
    			let url = this.router.generate("home");
                this.router.navigate(url);
    		});
    }
}