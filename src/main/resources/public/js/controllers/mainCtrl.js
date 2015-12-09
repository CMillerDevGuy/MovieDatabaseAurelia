angular.module('mainModule').controller('mainCtrl',['$scope', 'teamFactory', function($scope, teamFactory){
    
    $scope.hello = "hello";
    $scope.example9model = []; 
    $scope.example9data =
    	teamFactory.getTeams().then(
    			function(success){
    				$scope.result = success.data;
    			},function(error){
    				$scope.result = error;
    			}
    			);
        /*[ 
        {id: 1, label: "David"}, 
        {id: 2, label: "Jhon"}, {id: 3, label: "Danny"}
    ]; */
    $scope.example9settings = {externalIdProp: '', displayProp: 'teamName', idProp:'teamId'};
}])