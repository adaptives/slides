<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>

<html>
<head>
	<title>Slides @ DiyComputerScience.com</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
	<link rel="shortcut icon" type="image/png" href="images/favicon.png" />
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />
	
	<div id="container">
		<div id="content">
			<div class="padder">
				<div>
					<c:url value="homepage.do" var="homeUrl" />
					<a href="<c:out value="${homeUrl}"/>">Home</a>
				</div>
				<div>
				<div>
					<c:out value="${slide.title}" />
				</div>
				<div>
					<c:out value="${slide.contents}" />
				</div>
		</div>
			</div> <!-- end padder -->
		</div> <!-- end content -->
	
	
		<div  id="sidebar">
			<div>
	            <div>&nbsp;</div>	         
				<div>
					<c:forEach items="${slideShow.slides}" var="theSlide">
						<c:url value="slideShow.do" var="slideUrl">
							<c:param name="title" value="${slideShow.title}" />
							<c:param name="slide" value="${theSlide.title}" />
						</c:url>
						<div>
							<a href="<c:out value="${slideUrl}"/>"> <c:out
									value="${theSlide.title}" />
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div> <!-- end sidebar -->
	</div> <!-- end container -->
	<div style="clear: both;"></div>
	
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
 
