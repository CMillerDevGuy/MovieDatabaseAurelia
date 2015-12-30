angular.module('mainModule').controller('powerCtrl', ['$scope','powerFactory', 'powerTypeFactory','$uibModalInstance', function($scope, powerFactory, powerTypeFactory, $uibModalInstance){

    //$scope variables    
    $scope.power = {};
    $scope.powerType = {};    
    $scope.showOne = true;
    
    
    //Multi-select/Dropdown settings
    $scope.powerTypeSettings = {externalIdProp: '', displayProp: 'powerType', idProp: 'id', smartButtonMaxItems: 1, selectionLimit: 1};
    
    
    //Populate the dropdowns and multiselects
    $scope.powerTypeData = powerTypeFactory.getPowerTypes().then(
        function(success){
            $scope.powerTypes = success.data;
            if($scope.powerTypes.length == 0){
                $scope.show = true;
                $scope.showOne = false;
            }
        },
        function(error){
            $scope.powerTypes = error;
        }
    )
        
    
    //On click functions
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
    
    $scope.addPower = function (power, powerType){
        power.powerType = powerType;
        powerFactory.addPower(power).then(
            function(success) {
                $scope.postResult = success;
                $scope.closeModal();
            },
            function(error){
                $scope.postResult = error;
            }
        );
    }
        
    $scope.changeBoolean = function(){
    	if($scope.show == true){
    		$scope.show = false;
    	}
    	else{
    		$scope.show = true;
    	}
    }
    
    $scope.closeModal = function (){
    	$uibModalInstance.close();
    }
}])