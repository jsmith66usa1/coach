var app = angular.module('app', []);
var self = this;
app.controller('postusercontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
		
		 var phoneNumberRegex = /^\(?(\d{3})\)?[ .-]?(\d{3})[ .-]?(\d{4})$/;
		    $scope.phoneNumberPattern = phoneNumberRegex;
		var e = document.getElementById("coachSelect");
		var coachId = e.options[e.selectedIndex].value;
		coachId = coachId.slice(7);
		var url = $location.absUrl() + "//user";
		console.log($location.absUrl());
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
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
		
		$scope.firstname = "";
		$scope.lastname = "";
		$scope.address = "";
		$scope.phonenumber = "";
	}
});

app.controller('getusercontroller', function($scope, $http, $location) {
	$scope.getfunction = function(){
		var url = $location.absUrl() + "//user";
		
		$http.get(url).then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});

app.controller('myCtrl', function($scope, $http, $location) {
	$scope.loadcombo = function(){
		var url = $location.absUrl() + "//coaches//coach";
		self.selectCoach = $scope.selectedCoach;
		$http.get(url).then(function (response) {
			$scope.coaches = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
	 $scope.loadcombo();
});