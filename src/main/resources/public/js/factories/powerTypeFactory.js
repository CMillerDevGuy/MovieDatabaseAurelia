angular.module('mainModule').factory('powerTypeFactory', ['$http', function($http){
    return{
    	getPowerTypes : function(){
    		return $http.get("/powerType");
    	}
    }
}])