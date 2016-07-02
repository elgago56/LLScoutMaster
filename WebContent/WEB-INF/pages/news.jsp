<?xml version='1.0' encoding='UTF-8'?>
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <html>
        <head>
            <title>Love Live Scout Master</title>
            <style>
                body {
                    background-image: url("resources/nico1.png");
                    background-position: center;
                    background-clip: border-box;
                    background-size: 100.0%;
                    background-attachment: fixed;
                    
                    background-repeat: no-repeat;
                    background-size: cover;
                    font-family: "Candara Bold", sans-serif;
                    padding: 0px;
                    margin: 0px;
                }
            </style>
        </head>
        <body>
            <jsp:include page="/WEB-INF/pages/nav_header.jsp"/>
            <jsp:include page="/WEB-INF/pages/content/news_content.jsp" />
        </body>
    </html>
