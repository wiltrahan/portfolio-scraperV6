<!DOCTYPE html>

<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Access Denied</title>
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">
</head>

<body>

	<nav class="navbar navbar-light bg-light fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<span class="navbar-brand mb-0 h1" id="nav-text">We-B-Scraping!
					<i class="fas fa-chart-line"></i>
				</span>
			</div>
		</div>
	</nav>

	<div class="container" id="jumbo">
		<div class="jumbotron">
			<h1>
				We-B-Scraping <i class="fas fa-chart-line"></i>
			</h1>
			<p class="lead">A full stack Java application by Wil Trahan</p>

		</div>
	</div>

	<div class="container">

		<h3>
			Access Denied - You are not authorized to access this resource. <br>
			Please return to the home page and log in, or create a new account.
		</h3>

		<hr>

		<a href="${pageContext.request.contextPath}/"><button
				type="button" class="btn btn-outline-primary">Back to Home
				Page</button></a>

	</div>


</body>

</html>