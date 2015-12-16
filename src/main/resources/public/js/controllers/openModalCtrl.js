angular.module('mainModule').controller('openModalCtrl',['$scope', '$uibModal', function($scope, $uibModal){
    
    $scope.openPowerAdd = function(){
        
        var powerAddModalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'templates/powerAdd.tpl.html',
            controller: 'powerCtrl'
        });
    }
    
    $scope.openSuperheroAdd = function(){
        
        var superheroAddModalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'templates/superheroAdd.tpl.html',
            controller: 'superheroCtrl'
        });
    }
    
    $scope.openSuperheroTeamAdd = function(){
        
        var superheroTeamAddModalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'templates/teamAdd.tpl.html',
            controller: 'teamCtrl'
        });
    }
}])