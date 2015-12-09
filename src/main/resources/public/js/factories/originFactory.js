angular.module('mainModule').factory('originFactory', ['$http', function($http){
    return{
    	getOrigin : function(){
    		return $http.get("/origin");
    	}
    }
}])