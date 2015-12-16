angular.module('mainModule').factory('publicSupportFactory', ['$http', function($http){
    return{
    	getPublicSupport : function(){
    		return $http.get("/publicSupport");
    	}
    }
}])