'use strict';

angular.module('mainModule').config(['$stateProvider','$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/viewTeam');
    
    $stateProvider.state('powerAdd',{
        url: '/powerAdd',
        templateUrl: 'templates/powerAdd.tpl.html',
        controller: 'powerCtrl'
    })
    .state('superheroAdd',{
        url: '/superheroAdd',
        templateUrl: 'templates/superheroAdd.tpl.html',
        controller: 'superheroCtrl'
    })
    .state('teamAdd',{
        url: '/teamAdd',
        templateUrl: 'templates/teamAdd.tpl.html',
        controller: 'teamCtrl'
    })
    .state('viewTeam',{
        url: '/viewTeam',
        templateUrl: 'templates/view.tpl.html',
        controller: 'mainCtrl'
    })
}])