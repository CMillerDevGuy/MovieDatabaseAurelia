angular.module('mainModule').controller('superheroCtrl',['$scope', 'superheroFactory', 'powerFactory', 'originFactory', '$uibModalInstance', function($scope, superheroFactory, powerFactory, originFactory, $uibModalInstance){
    
    //$scope variables
    $scope.superhero = {};
    $scope.origin = {};
    $scope.powersArray = [];
    $scope.showOne = true;
    
    
    
    
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
            if($scope.origins.length == 0){
                $scope.show = true;
                $scope.showOne = false;
            }
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
                $scope.closeModal();
            },
            function(error){
                $scope.postResult = error;
            }
        );
    }
    
    $scope.closeModal = function (){
    	$uibModalInstance.close();
    }
}])