angular.module('mainModule').controller('viewTeamCtrl',['$scope', 'teamInfo','teamFactory','$window', function($scope, teamInfo, teamFactory, $window){
    
        $scope.singleTeam = teamInfo.data;
        
        $scope.goBack = function(){
    		window.history.back();
    	}
        
        $scope.deleteTeam = function(teamId){
        	teamFactory.deleteTeam(teamId).then(
        			function(success){
        				$window.location.href = '/';
        				console.log(success);
        			},
        			function(error){
        				console.log(error);
        			}
        	)
        	
        }
    
}])