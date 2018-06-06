<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>


<html lang="en">
<head>
<title>Portfolio Information</title>
<%@ include file="./parts/meta.jsp"%>

<%@ include file="./parts/header.jsp"%>

</head>
<body>
	<nav class="navbar navbar-light bg-light fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<span class="navbar-brand mb-0 h1" id="nav-text">We-B-Scraping
					<i class="fas fa-chart-line"></i>
				</span>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="login_name">Welcome: <security:authentication
						property="principal.username" />!
				</li>
				<li><form:form
						action="${pageContext.request.contextPath}/logout" method="POST">
						<input type="submit" class="btn navbar-btn my-nav-btn" value="Logout" />
					</form:form></li>
			</ul>
		</div>
	</nav>



	<div class="container">
		<c:forEach var="tempDate" items="${date}">
			<h1 class="text-center stock-info-date">
				Stock Information For: <br> <span id="date">
					${tempDate.date} <span id="time"> ${tempDate.time}</span>
				</span>
			</h1>
		</c:forEach>

		<table class="table table-striped table-bordered animated zoomInUp">
			<thead class="thead-dark">
				<tr>
					<th>Symbol</th>
					<th>Value</th>
					<th>$ Change</th>
					<th>% Change</th>
					<th>Total Shares</th>
				</tr>
			</thead>
			<c:forEach var="tempStock" items="${stocks}">

				<tr>
					<td>${tempStock.symbol}</td>
					<td>$${tempStock.value}</td>
					<td>${tempStock.dayAmtChg}</td>
					<td>${tempStock.dayPctChg}</td>
					<td>${tempStock.totalShrs}</td>
				</tr>

			</c:forEach>

		</table>

		<a href="list"><button type="button"
				class="btn btn-outline-primary mybtn">Back to daily listings</button></a>
	</div>
	<footer class="footer">
		<div class="container">
			<span class="foot-text">Wil Trahan Designs</span>
		</div>
	</footer>
</body>
</html>