<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	.error {
		color: red;
		font-style: italic;
	}
	.jumbotron{
	    display: block;
    	text-align: center
	}
</style>
<form:form method="GET" action="" modelAttribute="product">
	<h2 class="jumbotron" height=100 align="center">Selling Product</h2>
	<a class="jumbotron" href="/home">Home</a>
	<div align="center">
		<table>
			<tr>
				<form:hidden path="id"></form:hidden>
				<td>Product Name * :</td>
				<form:hidden path="name"></form:hidden>
				<td>${product.name}</td>
			</tr>

			<tr>
				<td>Product Description :</td>
				<form:hidden path="description"></form:hidden>
				<td>${product.description}</td>
			</tr>
			<tr>
				<td>Purchase Price *:</td>
				<form:hidden path="price"></form:hidden>
				<td>${product.price}</td>
			</tr>
			<tr>
				<td>Selling Price *:</td>
				<form:hidden path="sPrice"></form:hidden>
				<td>${product.sPrice}</td>
			</tr>
			<tr>
				<td>Enter the required quantity to sell *:</td>
				<td><input id="quantity" onchange="valChange()" type="number"
					min=1 max=${product.quantity } value="${product.quantity}"></input></td>
			</tr>
			<tr>
				<td><br /></td>
				<td><a id="id_sell" href="" class="btn btn-success">Sell
						Product</a></td>
			</tr>
		</table>

	</div>
</form:form>

<script>
	function valChange() {
		var quantity = document.getElementById("quantity").value;
		var hrefVal = document.getElementById("id_sell");
		hrefVal.href = "/sold?id=${product.id}&quantity=" + quantity;
	}
	valChange();
</script>