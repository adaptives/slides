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
				<div style="margin-left: 5px; margin-bottom: 10px;">
        			<span style="padding-bottom: 4px; font-family: Comic Sans, Comic Sans MS; font-size: 1.4em; font-weight: bold; color: green;">Slides for everyone, from DIYComputerScience.com !</span>
    			</div>
				<div>
					<c:forEach items="${slideShows}" var="entry">
						<p class="course-category-header">
							<c:out value="${entry.key}" />
						</p>
						<c:forEach items="${entry.value}" var="slideShow">
							<div class="post-box"></div>
        					<div class="comentwrap">
            					<div class="comentwrappost-title">
                					<div>
                						<c:url value="slideShow.do" var="slideShowUrl">
											<c:param name="title" value="${slideShow.title}" />
										</c:url>
										<a href="<c:out value="${slideShowUrl}"/>"> <c:out value="${slideShow.title}" /></a>
                					</div>
            					</div>
        					</div>
       					</c:forEach>
					</c:forEach>
				</div>
			</div> <!-- end padder -->
		</div> <!-- end content -->
	
	
		<div  id="sidebar">
			<div>
	            <div>&nbsp;</div>
	            <div>
	                <a href="http://diycomputerscience.com"><img src="images/everyone_orange.jpg"></a>
	            </div>
			</div>
		</div> <!-- end sidebar -->
	</div> <!-- end container -->
	<div style="clear: both;"></div>
	
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>
 
