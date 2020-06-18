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

.jumbotron {
	display: block;
	text-align: center
}
</style>
<form:form method="POST" action="inventory" modelAttribute="product">
	<h2 class="jumbotron" height=100 align="center">Edit Product</h2>
	<a class="jumbotron" href="/home">Home</a>
	<div align="center">
		<table>
			<tr>
				<form:hidden path="id"></form:hidden>
				<td>Product Name * :</td>
				<td><form:input path="name" id="name" value="${product.name}"
						size="35" maxlength="30" /> <form:errors path="name"
						cssClass="error" /></td>
			</tr>

			<tr>
				<td>Product Description :</td>
				<td><form:input path="description" id="description"
						value="${product.description}" size="35" maxlength="30" /> <form:errors
						path="description" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Quantity *:</td>
				<td><form:input path="quantity" id="quantity"
						value="${product.quantity}" size="6" maxlength="5" /> <form:errors
						path="quantity" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Purchase Price *:</td>
				<td><form:input path="price" id="price" size="8"
						value="${product.price}" maxlength="6" /> <form:errors
						path="price" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Selling Price *:</td>
				<td><form:input path="sPrice" id="sPrice" size="8"
						value="${product.sPrice}" maxlength="6" /> <form:errors
						path="sPrice" cssClass="error" /></td>
			</tr>
			<tr>
				<td><br /></td>
				<td><input type="submit" class="btn btn-success"
					value="Update Product" /></td>
			</tr>
		</table>

	</div>
</form:form>