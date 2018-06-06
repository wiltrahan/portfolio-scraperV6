<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login Page</title>
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>

<body>

	<nav class="navbar navbar-light bg-light fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<span class="navbar-brand mb-0 h1" id="nav-text">We-B-Scraping!
					<i class="fas fa-chart-line"></i>
				</span>
			</div>
			<c:if test="${not empty pageContext.request.userPrincipal}">
				<ul class="nav navbar-nav navbar-right">
					<li class="login_name">Welcome: <security:authentication
							property="principal.username" />!
					</li>
					<li><form:form
							action="${pageContext.request.contextPath}/logout" method="POST">
							<input type="submit" class="btn navbar-btn my-nav-btn"
								value="Logout" />
						</form:form></li>
				</ul>
			</c:if>
		</div>
	</nav>

	<div class="container" id="jumbo">
		<div class="jumbotron">
			<h1>
				Welcome To We-B-Scraping <i class="fas fa-chart-line"></i>
			</h1>
			<p class="lead">A full stack Java application by Wil Trahan</p>

		</div>
	</div>
	<!-- LOGIN CONTAINER -->

	<div class="container">
		<div class="row">
			<div id="loginbox" class="col-md-4">
				<div class="col-md-12">

					<c:choose>
						<c:when test="${not empty pageContext.request.userPrincipal}">
							<a href='${pageContext.request.contextPath}/date/list'><button
									type="button" class="btn btn-outline-primary mybtn">Back to
									daily listings</button></a>
						</c:when>
						<c:otherwise>
							<div class="panel panel-info">
								<div class="panel-heading">
									<div class="panel-title">Sign In</div>
								</div>
								
								<div class="panel-body">
									<!-- Login Form -->
									<form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST" class="form-horizontal">
										<!-- Place for messages: error, alert etc ... -->
										<div class="form-group">
											<div class="col-xs-15">
												<div>
													<!-- Check for login error -->
													<c:if test="${param.error != null}">
														<div class="alert alert-danger col-xs-offset-1 col-xs-10">
															Invalid username and password.</div>
													</c:if>
													<!-- Check for logout -->
													<c:if test="${param.logout != null}">

														<div class="alert alert-success col-xs-offset-1 col-xs-10">
															You have been logged out.</div>
													</c:if>
												</div>
											</div>
										</div>

										<!-- User name -->
										<div style="margin-bottom: 25px" class="input-group">
											<input type="text" name="username" placeholder="username"
												class="form-control">
										</div>
										<!-- Password -->
										<div style="margin-bottom: 25px" class="input-group">
											<input type="password" name="password" placeholder="password"
												class="form-control">
										</div>
										<!-- Login/Submit Button -->
										<div class="form-group">
											<div class="col-sm-6 controls">
												<button type="submit" class="btn btn-success">Login</button>
											</div>
										</div>

										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
									</form>
								</div>
							</div>

							<div>
								<a href="${pageContext.request.contextPath}/register/showRegistrationForm"
									class="btn btn-primary" role="button" aria-pressed="true">Register New User</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<!-- APP INFORMATION -->
			<div class="col-md-8">
				<div class="col-md-12" id="app-info-box">
					<p class="text-justify">
						I was tasked with creating a full stack Java application for my
						final project at the CareerDevs Computer Science Academy. While
						most of the implementation was left up to me to decide upon there
						were a few requirements that had to be met. First of which, was
						that the application scraped financial information from a site,
						such as Yahoo Finance. Once the information was obtained, it was
						to be put into a database of my choice, then retrieved from the
						database and displayed to the user. Please log in, or register a
						new account and have a look around. No personal information is
						needed to register a new account. <br> <br> Technologies
						used in this application are as follows:
					</p>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Java 9</li>
						<li class="list-group-item">Maven</li>
						<li class="list-group-item">Spring</li>
						<li class="list-group-item">Spring Security</li>
						<li class="list-group-item">Hibernate</li>
						<li class="list-group-item">JavaScript</li>
						<li class="list-group-item">jQuery</li>
						<li class="list-group-item">MySql</li>
						<li class="list-group-item">Selenium</li>
						<li class="list-group-item">JSP</li>
						<li class="list-group-item">Bootstrap</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<span class="foot-text">Wil Trahan Designs</span>
		</div>
	</footer>
</body>
</html>