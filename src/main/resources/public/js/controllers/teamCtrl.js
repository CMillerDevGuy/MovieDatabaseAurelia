angular.module('mainModule').controller('teamCtrl',['$scope', 'teamFactory', function($scope, teamFactory){
    
    $scope.hello = "team";
    
    $scope.team = {};
    
    $scope.addTeam = function(team/*teamName, headquarters, publicSupport, teamLead, superheroName*/){
    	console.log("addTeam")
        /*var team = {};
        var superheroes = [];
        var superhero = {};
        var publicSupportObj = {};
        var teamLeadObj = {};
        
        publicSupportObj.publicSupport = publicSupport;
        teamLeadObj.superheroName = teamLead;
        superhero.superheroName = superheroName;
        superheroes.push(superhero);
        
        team.teamName = teamName;
        team.headquarters = headquarters;
        team.publicSupport = publicSupportObj;
        team.teamLead = teamLeadObj;
        team.superheros = superheroes;*/
        
        teamFactory.addTeam(team).then(
                function(success) {
                    $scope.postResult = success;
                },
                function(error){
                    $scope.postResult = error;
                }
            );
    }
}])