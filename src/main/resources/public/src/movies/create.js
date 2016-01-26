import {inject} from "aurelia-framework";
import {MovieData} from "./movieData";
import {Router} from "aurelia-router";
import {Validation} from "aurelia-validation";

@inject(MovieData, Router, Validation)
export class Create{

    constructor(movieData, router, validation){
        this.data = movieData;
        this.router = router;

        this.validation = validation.on(this)
                    .ensure("movie.movie")
                        .isNotEmpty()
                        .hasMinLength(3)
                        .hasMaxLength(100)
                    .ensure("movie.releaseYear")
                        .isNumber()
                        .isBetween(1900,2020)
                    .ensure("movie.genre")
                        .isNotEmpty()
                        .hasMinLength(3)
                        .hasMaxLength(20);
    }

    save(){
        this.validation.validate().then(() => {
            this.data.create(this.movie)
	            .then(movie => {
	                let url = this.router.generate("home");
	                this.router.navigate(url);
	            })
        });
    }
}
