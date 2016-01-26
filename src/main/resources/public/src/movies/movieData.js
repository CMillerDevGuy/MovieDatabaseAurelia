import {inject} from "aurelia-framework";
import {HttpClient} from "aurelia-http-client";

let baseUrl = "/movie";

@inject(HttpClient)
export class MovieData{
    
    constructor(httpClient){
        this.http = httpClient;
    };
    
    getAll(){
        return this.http.get(baseUrl)
            .then(response => {
                return response.content;
        })
    };
    
    getById(id){
    	return this.http.get(baseUrl + "/" + id)
    		.then(response => {
    			return response.content;
    		})
    }
    
    save(movie) {
        return this.http.put(baseUrl, movie);
    };
    
    create(movie){
        return this.http.post(baseUrl, movie);
    }
    
    delete(id){
    	return this.http.delete(baseUrl + "/" + id);
    }
}