'use strict';

angular.module('mainModule').config(['$stateProvider','$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/viewTeamList');
    
    $stateProvider.state('viewTeam',{
        url: '/singleTeam/{id}',
        templateUrl: 'templates/view.tpl.html',
        controller: 'viewTeamCtrl',
        resolve: {
            teamInfo: function($stateParams, teamFactory){
                return teamFactory.getTeamById($stateParams.id);
            }
        }
    })
    .state('viewSuperhero',{
        url: '/singleSuperhero/{id}',
        templateUrl: 'templates/viewSuperhero.tpl.html',
        controller : 'singleSuperheroViewCtrl',
        resolve: {
            superheroInfo: function($stateParams, superheroFactory){
                return superheroFactory.getSuperheroById($stateParams.id);
            }
        }
    })
    .state('viewTeamList',{
        url: '/viewTeamList',
        templateUrl: 'templates/teamList.tpl.html',
        controller: 'mainCtrl'
    })
    .state('viewPower',{
    	url: '/viewPower',
    	templateUrl: 'templates/viewPower.tpl.html',
    	controller: 'viewPowerCtrl'
    })
}])