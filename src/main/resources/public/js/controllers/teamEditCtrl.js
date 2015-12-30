angular.module('mainModule').controller('teamEditCtrl',['$scope','teamEditInfo', '$uibModalInstance','teamFactory', 'publicSupportFactory', 'superheroFactory', function($scope, teamEditInfo, $uibModalInstance, teamFactory, publicSupportFactory, superheroFactory){
    $scope.publicSupport = {};
    $scope.teamLead = {};
    $scope.superheroes = [];
    $scope.teamLeadArray = [];
    $scope.teamlessSuperheroes = [];
    $scope.showOne = true;
    
	$scope.team = teamEditInfo.data;
	
	$scope.team.teamName = teamEditInfo.data.teamName;
	$scope.team.headquarters = teamEditInfo.data.headquarters;
	$scope.publicSupport = teamEditInfo.data.publicSupport;
	$scope.teamLead = teamEditInfo.data.teamLead;
	$scope.superheroes = teamEditInfo.data.superheros;
	
	
	
	$scope.editTeam = function(team, publicSupport, teamLead, superheroes){
        team.publicSupport = publicSupport;
        team.teamLead = teamLead;
        team.superheros = superheroes;
        
        teamFactory.editTeam(team).then(
            function(success) {
                $scope.postResult = success;
                //$window.location.href = '/';
                
            },
            function(error){
                $scope.postResult = error;
            }
        );
    }
	
	
	//Multi-select/Dropdown settings
    $scope.publicSupportSettings = {externalIdProp: '', displayProp: 'publicSupport', idProp: 'id', smartButtonMaxItems: 1, selectionLimit: 1};
    
    $scope.teamLeadSettings = {externalIdProp: '', displayProp: 'superheroName', idProp: 'superheroId', smartButtonMaxItems: 1, selectionLimit: 1};
    
    $scope.superheroSettings = {externalIdProp: '', displayProp: 'superheroName', idProp: 'superheroId', smartButtonMaxItems: 1};
    

    //Populate the dropdowns and multiselects
    $scope.publicSupportData = publicSupportFactory.getPublicSupport().then(
        function(success){
            $scope.publicSupports = success.data;
            if($scope.publicSupports.length == 0){
                $scope.show = true;
                $scope.showOne = false;
            }
        },
        function(error){
            $scope.publicSupports = error;
        })
    
    /*$scope.superheroData = superheroFactory.getSuperheroes().then(
        function(success){
            $scope.superheroArray = success.data;
            for( var i = 0; i < $scope.superheroArray.length; i++){
                if($scope.superheroArray[i].teamLead == false){
                    $scope.teamLeadArray.push($scope.superheroArray[i]);
                }
            }
        },
        function(error){
            $scope.superheroArray = error;
        })*/
        
      $scope.teamLeadData = superheroFactory.getSuperheroes().then(
    		  function(success){
    			  $scope.teamLeadArray = success.data;
    		  }
      )
      
      $scope.teamlessData = superheroFactory.getSuperheroes().then(
    		  function(success){
    			  $scope.teamlessSuperheroes = success.data;
    		  },
    		  function(error){
    			  console.log(error);
    		  }
    		  
      )
}])