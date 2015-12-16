angular.module('mainModule').controller('singleSuperheroViewCtrl',['$scope', 'superheroInfo', function($scope, superheroInfo){

	$scope.superhero = superheroInfo.data;
	
	$scope.goBack = function(){
		window.history.back();
	}
}])
