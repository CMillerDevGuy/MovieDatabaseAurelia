angular.module('mainModule').controller('superheroCtrl',['$scope', 'superheroFactory', 'powerFactory', 'originFactory', '$uibModal', function($scope, superheroFactory, powerFactory, originFactory, $uibModal){
    
    //$scope variables
    $scope.superhero = {};
    $scope.origin = {};
    $scope.powersArray = [];
    $scope.show = false;
    
    
    
    //Multi-select/Dropdown settings
    $scope.originSettings = {externalIdProp: '', displayProp: 'origin', idProp: 'id', smartButtonMaxItems: 1, selectionLimit: 1};
    
    $scope.powerSettings = {externalIdProp: '', displayProp: 'powerName', idProp: 'id', smartButtonMaxItems: 3};
    
    
    //Populate the dropdowns and multiselects
    $scope.getPowers = powerFactory.getPower().then(
        function(success){
            $scope.powers = success.data;
        },
        function(error){
            $scope.powers = error;
        }
    )
    
    $scope.getOrigins = originFactory.getOrigin().then(
        function(success){
            $scope.origins = success.data;
        },
        function(error){
            $scope.origins = error;
        }
    )
    
    
    //On click functions
    $scope.changeBoolean = function(){
    	if($scope.show == true){
    		$scope.show = false;
    	}
    	else{
    		$scope.show = true;
    	}
    }
    
    $scope.addSuperhero = function(superhero, origin, powers){
        superhero.powers = powers;
        superhero.origin = origin;
        
        superheroFactory.addSuperhero(superhero).then(
            function(success) {
                $scope.postResult = success;
                $uibModalInstance.close();
            },
            function(error){
                $scope.postResult = error;
            }
        );
    }
}])