angular.module('mainModule').factory('superheroFactory', ['$http', function($http){
    return{
        addSuperhero : function(superhero){
            return $http.post("/superhero", superhero);
        }
    }
}])



