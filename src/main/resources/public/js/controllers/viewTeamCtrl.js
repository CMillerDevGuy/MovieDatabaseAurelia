angular.module('mainModule').controller('viewTeamCtrl',['$scope', 'teamInfo','teamFactory','$window','$uibModal', function($scope, teamInfo, teamFactory, $window, $uibModal){
    
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
        $scope.openEditModal = function(teamId){
            
            var teamEditModalInstance = $uibModal.open({
                animation: true,
                templateUrl: 'templates/teamEdit.tpl.html',
                controller: 'teamEditCtrl',
                resolve: {
                    teamEditInfo: function(superheroFactory){
                        return teamFactory.getTeamById(teamId);
                    }
                }
            });
        }
    
}])