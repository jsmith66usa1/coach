var app = angular.module('app',  ['ngRoute']);
app.config(function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl: '/view/home.html',
			controller: 'postusercontroller'
		})
		.when('/user', {
			templateUrl: '/view/user.html',
			controller: 'postusercontroller'
		})
		.when('/member', {
			templateUrl: '/view/member.html',
			controller: 'postusercontroller'
		})
		.when('/coach', {
			templateUrl: '/view/coach.html',
			controller: 'postcoachcontroller'
		})
		.otherwise({
			redirectTo: '/'
		});
});
app.controller('postusercontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
		
		 var phoneNumberRegex = /^\(?(\d{3})\)?[ .-]?(\d{3})[ .-]?(\d{4})$/;
		    $scope.phoneNumberPattern = phoneNumberRegex;
		var e = document.getElementById("coachSelect");
		var coachId = e.options[e.selectedIndex].value;
		coachId = coachId.slice(7);
		var url =  "/users/user";
		console.log($location.absUrl());
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
		    username: $scope.username,
            firstname: $scope.firstname,
            lastname: $scope.lastname,
            address: $scope.address,
            phonenumber: $scope.phonenumber,
            coaches: [ {
            	id:coachId,
            	firstname: null,
            lastname: null,
            address: null,
            phonenumber: null
            } ]
        };
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		$scope.username = "";
		$scope.firstname = "";
		$scope.lastname = "";
		$scope.address = "";
		$scope.phonenumber = "";
		$scope.customerForm.$setPristine();
	 
	    $scope.customerForm.$setUntouched();
	}
	$scope.getfunction = function(){
		var url = "/users/user";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
	$scope.getMemberfunction = function(){
		var url = "/users/user/"+ $scope.username;
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
	$scope.loadcombo = function(){
		var url = "/users/coaches/coach";
		
		$http.get(url).then(function (response) {
			$scope.coaches = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});




app.controller('postcoachcontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
		var url = "/users/coaches/coach";
		console.log($location.absUrl());
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
		    username: $scope.username,
            firstname: $scope.firstname,
            lastname: $scope.lastname,
            address: $scope.address,
            phonenumber: $scope.phonenumber
        };
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.data;
		});
		
		$scope.username = "";
		$scope.firstname = "";
		$scope.lastname = "";
		$scope.address = "";
		$scope.phonenumber = "";
		$scope.coachForm.$setPristine();
	    
	    $scope.coachForm.$setUntouched();
	}
	
	$scope.getcoaches = function(){
		var url ="/users/coaches/coach";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});

