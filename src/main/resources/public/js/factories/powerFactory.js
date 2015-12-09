angular.module('mainModule').factory('powerFactory', ['$http', function($http){
    return{
        addPower : function(power){
            return $http.post("/power", power);
        },
    	getPower : function(){
    		return $http.get("/power");
    	}
    }
}])