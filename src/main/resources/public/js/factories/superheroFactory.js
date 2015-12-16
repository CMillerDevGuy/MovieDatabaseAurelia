angular.module('mainModule').factory('superheroFactory', ['$http', function($http){
    return{
        addSuperhero : function(superhero){
            return $http.post("/superhero", superhero);
        },
        getSuperheroes : function(){
            return $http.get("/superhero")
        },
        getSuperheroById : function(superheroId){
        	return $http.get("/superhero/"+superheroId)
        }
    }
}])



