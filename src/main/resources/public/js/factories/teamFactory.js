angular.module('mainModule').factory('teamFactory', ['$http', function($http){
    return{
        addTeam : function(team){
            return $http.post("/superheroTeam", team);
        },
        getTeams : function(){
            return $http.get("/superheroTeam");
        },
        getTeamById : function(teamId){
            return $http.get("/superheroTeam/"+teamId)
        }
    }
}])