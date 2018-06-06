<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>

<html lang="en">
<head>

<title>Date Totals</title>
<%@ include file="./parts/meta.jsp"%>
<%@ include file="./parts/header.jsp"%>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$('#loading').hide();
		$('.scrape-error').hide();
        
		$('#snap').click(function(e) {
			e.preventDefault();
			$(document).ajaxStart(function() {
                $('#loading').show();
            })
			$.ajax({
				url: '${pageContext.request.contextPath}/SnapshotServlet',
				type: 'GET',
				success:function() {
					//write a function to refresh page here.
					$(document).ajaxStop(function() {
						$('#loading').hide();
					})
					$("#snap-wait").html("Success! <br> Loading below in 3...2...").addClass("new-snapshot text-center");
					  setTimeout(function() {
						document.location.assign("list");
					}, 3000); 
				},
				fail:function() {
					$(document).ajaxStop(function() {
						$('#loading').hide();
						$('.scrape-error').show();
					});
				}
			});
		});
	});	
</script>
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
						<input type="submit" class="btn navbar-btn my-nav-btn"
							value="Logout" />
					</form:form>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container" id="jumbo">
		<div class="jumbotron" id="date-tron">
			<h1>
				We-B-Scraping <i class="fas fa-chart-line"></i>
			</h1>
			<p class="lead">A full stack Java application by Wil Trahan</p>

		</div>
	</div>

	<div class="container">
		<button class="btn btn-outline-primary mybtn" id="snap" value="snapshot">Get New Snapshot!</button>
		<br><br>
		<a href='${pageContext.request.contextPath}/welcome'><button type="button"
				class="btn btn-outline-primary mybtn">Back to home page</button></a>
		<hr>
		<p id="snap-wait">New snapshot will take approximately 10-15 seconds to load so Please-B-Patient <i class="far fa-clock"></i></p>
	</div>
	
	<div class="container text-center">
		<div id="loading">
    		<p>Scrape In Progress! <span><i class="fas fa-stopwatch"></i></span></p>
    		<p class="scrape-error">Something went wrong, please try again. </p>
		</div>
	</div>

	<div class="container">
		<table class="table table-striped table-bordered my-table">
			<thead class="thead-dark">
				<tr>
					<th>Date</th>
					<th>Time</th>
					<th>Total</th>
					<th>Day Gain/Loss</th>
					<th>More Info</th>
				</tr>
			</thead>
			
			<%-- Keep a reference to the size of the collection --%>
			<c:set var="num_dates" value="${fn:length(dates)}" />

			<%-- Iterate through items. Start at 1 to avoid array index out of bounds --%>
			<c:forEach var="i" begin="1" end="${num_dates}" step="1">
				<c:set var="tempDate" value="${dates[num_dates - i]}"/>
				<c:url var="portfolio" value="/date/portfolio">
					<c:param name="dateId" value="${tempDate.id}" />
				</c:url>

				<tr class="snapshot">
					<td>${tempDate.date}</td>
					<td>${tempDate.time}</td>
					<td>${tempDate.total}</td>
					<td>${tempDate.dayGain}</td>
					<td><a href="${portfolio}">
							<button type="button" class="btn btn-outline-primary btn-block mybtn">
								More Info</button>
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<footer class="footer">
		<div class="container">
			<span class="foot-text">Wil Trahan Designs</span>
		</div>
	</footer>
</body>
</html>