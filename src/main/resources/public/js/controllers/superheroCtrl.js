angular.module('mainModule').controller('superheroCtrl',['$scope', 'superheroFactory', 'powerFactory', 'originFactory', function($scope, superheroFactory, powerFactory, originFactory){
    
    $scope.superhero = {};
    $scope.origin = {};
    $scope.powersArray = [];
    $scope.show = false;
    
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
    
    $scope.originSettings = {externalIdProp: '', displayProp: 'origin', idProp: 'id', smartButtonMaxItems: 1, selectionLimit: 1};
    
    $scope.powerSettings = {externalIdProp: '', displayProp: 'powerName', idProp: 'id', smartButtonMaxItems: 3};
    
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
                },
                function(error){
                    console.log(error);
                    $scope.postResult = error;
                }
            );
    }
}])