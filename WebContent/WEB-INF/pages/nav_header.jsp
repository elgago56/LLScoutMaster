<?xml version='1.0' encoding='UTF-8'?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.1" xmlns:f="http://java.sun.com/jsf/core"
          xmlns:c="http://java.sun.com/jsp/jstl/core" xmlns:af="http://xmlns.oracle.com/adf/faces/rich">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <div id="nav_login">
        <ul id="nav_menu">
            <li>
                <a href="">Home</a>
            </li>
            <c:if test="${not empty pageContext.request.remoteUser}">
                <li>
                    <a href="/my_cards">Cards</a>
                </li>
            </c:if>
        </ul>
        <c:choose>
            <c:when test="${not empty pageContext.request.remoteUser}">
                <span id="welcome_text">Welcome, ${pageContext.request.remoteUser}</span>
            </c:when>
            <c:otherwise>
                <form name="login_form" action="login" method="post" id="login_form">
                    <input id="username_field" type="text" name="user" value="${empty param['login_failed'] ? 'username' : 'try again' }"/>
                    <input id="pass_field" type="password" name="pass" value="password"/>
                    <input id="login_submit" type="submit" value="Login"/>
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</jsp:root>
