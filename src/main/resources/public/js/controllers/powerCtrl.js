angular.module('mainModule').controller('powerCtrl', ['$scope','powerFactory', 'powerTypeFactory', function($scope, powerFactory, powerTypeFactory){

            
        $scope.powerTypeData = powerTypeFactory.getPowerTypes().then(
            function(success){
                $scope.powerTypes = success.data;
            },
            function(error){
                $scope.powerTypes = error;
            }
        )
        
        $scope.powerTypeSettings = {externalIdProp: '', displayProp: 'powerType', idProp: 'id', smartButtonMaxItems: 1, selectionLimit: 1};
        
        $scope.power = {};
        $scope.powerType = {};
    
        $scope.addPower = function (power, powerType){
            power.powerType = powerType;
            powerFactory.addPower(power).then(
                function(success) {
                    $scope.postResult = success;
                },
                function(error){
                    $scope.postResult = error;
                }
            );
        }
        
        $scope.powers = function(){
        	powerFactory.getPower().then(
	        	function(success){
	        		$scope.result = success;
	        	},
	        	function(error){
	        		$scope.result = error;
	        	}
        	);
        }
    $scope.show = false;
    
    $scope.changeBoolean = function(){
    	if($scope.show == true){
    		$scope.show = false;
    	}
    	else{
    		$scope.show = true;
    	}
    }
}])