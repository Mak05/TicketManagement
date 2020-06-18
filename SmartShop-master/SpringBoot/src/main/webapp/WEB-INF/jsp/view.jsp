<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<center>
	<h2 class="jumbotron" align="center">Product List Page</h2>
	<a class="jumbotron" href="/home">Home</a>
	<c:choose>
		<c:when test="${fn:length(productList) > 0}">
			<table border=1>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Product Date</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
				<th>Edit Product</th>
				<th>Sell Product</th>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.date}</td>
						<td>${product.price}</td>
						<td><input type="number" min=1 max=${product.quantity
							} value="${product.quantity}"></input></td>
						<td><a href="/product?id=${product.id}">Edit</a></td>
						<td><a href="/sale?id=${product.id}">Sell</a></td>
					</tr>
				</c:forEach>
			</table>
			<center>
				<p align="center">${message}</p>
				<br /> <a href="/products">Add more products</a>
			</center>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8">No Products Found</td>
			</tr>
		</c:otherwise>
	</c:choose>
</center>