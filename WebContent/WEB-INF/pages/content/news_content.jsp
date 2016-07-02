<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
	<jsp:directive.page language="java"
		contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<STYLE type="text/css">
.news_body {
	width: 80%;
	margin: auto;
}

.news_item {
	float: left;
	width: 40%;
	height: 150px;
	margin: 5% 5% 1% 5%;
	box-sizing: border-box;
	border-style: solid;
	border-width: 1px;
	border-color: rgba(76, 76, 76, 0.8);
	border-radius: 12px;
	background-color: rgba(76, 76, 76, 0.2);
	overflow: hidden;
	border-style: solid;
}

.news_text {
	height: 100%;
	overflow: scroll;
}

.news_body, .news_text_row {
	font-family: "Candara Bold", sans-serif;
	font-size: 13px;
}

.news_title {
	font-weight: 500;
	height: 100%;
	color: rgb(76, 76, 76);
	text-align: center;
	margin: 0px;
}

.news_text {
	visibility: hidden;
}

.news_img_ {
	width: 100%;
	height: 80%;
	border-radius: inherit;
}

.page_footer {
	padding-top: 3%;
	padding-bottom: 3%;
	text-align: center;
	display: block;
	clear: both;
	text-align: center
}

#footer_list {
	width: auto;
	margin: auto;
	padding: 0px;
	list-style: none;
}

#footer_list li {
	display: inline;
	padding: 5px;
}

#footer_list li:HOVER {
	background-color: rgba(76, 76, 76, 0.2);
}

.current_page {
	font-weight: bold;
	text-decoration: underline;
}

.annc_page_url a {
	text-decoration: none;
	color: black;
	font-size: 12px;
}
</STYLE>
</head>
<body>
	<c:choose>
		<c:when test="${requestScope.pageCount eq null}">
			No Announcements!
		</c:when>
		<c:otherwise>
			<div class="news_body">
				<c:forEach items="${requestScope.announcements}" var="announcement">
					<div class="news_item">
						<img class="news_img_" alt="Score Match Tomorrow!"
							src="image?id=${announcement.imgId }" />
						<p class="news_title"><c:out value="${announcement.title}"></c:out></p>
						<div class="news_text">
							<p class="news_text_row"><c:out value="${announcement.body}"></c:out></p>
						</div>
					</div>
				</c:forEach>
				<div class="page_footer">
					<ul id="footer_list">
						<c:choose>
							<c:when test="${param.page eq null}">
								<c:set var="page" value="1"></c:set>
								<c:set var="begin" value="1"></c:set>
								<c:set var="end" value="${requestScope.pageCount}"></c:set>
							</c:when>
							<c:otherwise>
								<c:set var="page" value="${param.page}"></c:set>
								<c:set var="begin"
									value="${pageScope.page > 4 ? pageScope.page - 3 : 1 }"></c:set>
								<c:set var="end"
									value="${pageScope.begin - 1 + requestScope.pageCount}"></c:set>
							</c:otherwise>
						</c:choose>

						<c:if test="${pageScope.page > 1}">
							<li class="annc_page_url"><a
								href="news?page=${pageScope.page-1}">Previous</a></li>
						</c:if>
						<c:forEach begin="${pageScope.begin}" var="i"
							end='${pageScope.end }'>
							<c:choose>
								<c:when test="${i eq pageScope.page}">
									<li class="current_page">${i}</li>
								</c:when>
								<c:otherwise>
									<li class="annc_page_url"><a href="news?page=${i}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${pageScope.page lt pageScope.end}">
							<li class="annc_page_url"><a
								href="news?page=${pageScope.page+1}">Next</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
</body>
	</html>
</jsp:root>