
var cartApp = angular.module("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){
	
	$scope.refreshCart = function (cartId){
		$http.get('/eMuzicStore/rest/cart/'+ $scope.cartId).success(function(data){
			$scope.cart = data;
		})
	}
	$scope.clearCart = function(){
		$http.delete('/eMuzicStore/rest/cart' + $scope.cartId).succes($scope.refreshCart($scope.cartId));
	}
	
	$scope.initCartId = function (cartId){
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addToCart = function(productId){
		$http.put()
	}
});