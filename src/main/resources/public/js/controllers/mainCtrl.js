angular.module('mainModule').controller('mainCtrl',['$scope', 'teamFactory', function($scope, teamFactory){
    

    $scope.getAllTeams = teamFactory.getTeams().then(
        function(success){
            $scope.results = success.data;
        },function(error){
            $scope.results = error;
        }
    );

}])