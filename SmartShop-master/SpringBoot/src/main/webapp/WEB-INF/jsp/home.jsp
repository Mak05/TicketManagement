<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<center>
	<h2 class="jumbotron" align="center">Home Page</h2>
	<c:choose>
		<c:when test="${fn:length(productList) > 0}">
			Sortby: <a href="/productSort?sort=name">Name</a>
			<a href="/productSort?sort=date">Purchase Date</a>
			<a href="/productSort?sort=price">Purchase Price</a>
			<a href="/productSort?sort=sDate">Selling Date</a>
			<a href="/productSort?sort=sPrice">Selling Price</a>
			<br />
			<table border=1>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Purchase Date</th>
				<th>Purchase Price</th>
				<th>Sale Date</th>
				<th>Sale Price</th>
				<th>Product Quantity</th>
				<th>Edit Product</th>
				<th>Sell Product</th>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.date}</td>
						<td>${product.price}</td>
						<td>${product.sDate}</td>
						<td>${product.sPrice}</td>
						<td>${product.quantity}</td>
						<td><a href="/product?id=${product.id}">Edit</a></td>
						<td><a href="/sale?id=${product.id}">Sell</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="8">No Products Found</td>
			</tr>
		</c:otherwise>
	</c:choose>
	<center>
		<br /> <a href="/products">Add products</a>
	</center>
</center>