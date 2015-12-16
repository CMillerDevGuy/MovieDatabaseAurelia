angular.module('mainModule').controller('teamCtrl',['$scope', 'teamFactory', 'publicSupportFactory', 'superheroFactory', '$window', '$uibModalInstance', function($scope, teamFactory, publicSupportFactory, superheroFactory, $window, $uibModalInstance){
    
    //$scope variables
    $scope.team = {};
    $scope.teamLead = {};
    $scope.publicSupport = {};
    $scope.superheroes = [];
    $scope.teamLeadArray = [];
    $scope.onTeamArray = [];
    
    
    //Multi-select/Dropdown settings
    $scope.publicSupportSettings = {externalIdProp: '', displayProp: 'publicSupport', idProp: 'id', smartButtonMaxItems: 1, selectionLimit: 1};
    
    $scope.teamLeadSettings = {externalIdProp: '', displayProp: 'superheroName', idProp: 'superheroId', smartButtonMaxItems: 1, selectionLimit: 1};
    
    $scope.superheroSettings = {externalIdProp: '', displayProp: 'superheroName', idProp: 'superheroId', smartButtonMaxItems: 1};
    

    //Populate the dropdowns and multiselects
    $scope.publicSupportData = publicSupportFactory.getPublicSupport().then(
        function(success){
            $scope.publicSupports = success.data;
        },
        function(error){
            $scope.publicSupports = error;
        })
    
    $scope.superheroData = superheroFactory.getSuperheroes().then(
        function(success){
            $scope.superheroArray = success.data;
            for( var i = 0; i < $scope.superheroArray.length; i++){
                if($scope.superheroArray[i].teamLead == false){
                    $scope.teamLeadArray.push($scope.superheroArray[i]);
                }
                if($scope.superheroArray[i].onTeam == false){
                	$scope.onTeamArray.push($scope.superheroArray[i]);
                }
            }
        },
        function(error){
            $scope.superheroArray = error;
        })
    
    
    //On click functions
    $scope.addTeam = function(team, publicSupport, teamLead, superheroes){
        team.publicSupport = publicSupport;
        team.teamLead = teamLead;
        team.superheros = superheroes;
        
        teamFactory.addTeam(team).then(
            function(success) {
                $scope.postResult = success;
                $uibModalInstance.close();
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
    
}])