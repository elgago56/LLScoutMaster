<?xml version='1.0' encoding='UTF-8'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1" xmlns:f="http://java.sun.com/jsf/core"
          xmlns:af="http://xmlns.oracle.com/adf/faces/rich">
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

                #nav_login {
                    background-color: #4c4c4c;
                    width: 100.0%;
                    background-clip: content-box;
                    border-bottom-left-radius: 6px;
                    border-bottom-right-radius: 6px;
                    overflow: auto;
                }

                #nav_menu {
                    list-style-type: none;
                    border: 2px;
                    padding: 0.0px;
                    margin: 0.0px;
                }

                #nav_menu li {
                    float: left;
                    border: 1px solid #595959;
                }

                #nav_menu li a {
                    display: block;
                    padding: 10.0px 10.0px;
                    text-decoration: none;
                    color: White;
                    font-weight: bold;
                    text-align: center;
                    font-size: 12px;
                    text-shadow: 1px 1px #000000;
                }

                #nav_menu li a:hover {
                    background-color: #9a77a0;
                }

                #login_form {
                    padding: 5.0px 10px 5px 0px;
                    margin: 0px;
                    float: right;
                }

                #login_form input {
                    width: 100px;
                    margin: 5px 2px 0px 0px;
                    font-size: 10px;
                    border-radius: 4px;
                    border: none;
                }

                #login_form input[type="submit"] {
                    background: none;
                    color: White;
                    margin: 0px;
                    width: 50px;
                }

                #welcome_text {
                    font-size: 10px;
                    color: White;
                    float: right;
                    margin: 12px 10px 0px 0px;
                }
            </style>
        </head>
        <body>
            <jsp:include page="/WEB-INF/pages/nav_header.jsp"/>
            <jsp:include page="/WEB-INF/pages/content/nav_header.jsp"/>
        </body>
    </html>
</jsp:root>
