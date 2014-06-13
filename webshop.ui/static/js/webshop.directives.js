define(['angular'], function(angular) {
	angular.module('webshop.directives', [])
  		.directive('navbar', function() {
	  		return {
	  			restrict: 'E',
	  			controller: 'CategoriesCtrl',
	  			templateUrl: 'partials/navbar.html'
	  		}
  		}
  	);
 })