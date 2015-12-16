angular.module('mainModule').controller('viewTeamCtrl',['$scope', 'teamInfo', function($scope, teamInfo){
    
        $scope.singleTeam = teamInfo.data;
        
        $scope.goBack = function(){
    		window.history.back();
    	}
    
}])