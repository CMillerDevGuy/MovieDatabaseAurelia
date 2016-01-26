import {MovieData} from "./movieData";
import {inject} from "aurelia-framework";

@inject(MovieData)
export class List {
  
    constructor(movieData, router){
        this.movieData = movieData;
        this.router = router;
    }
    
    activate(){
        return this.movieData
            .getAll()
            .then(movies => this.movies = movies);  
    }
    

}