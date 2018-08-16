<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/> " rel="stylesheet">

    <title>Login</title>
</head>
<body>
<div class="container">

    <div class="login-form">
        <div class="panel">
            <h2>Welcome to phone BOOK</h2>
            <p>Please enter your username and password</p>
        </div>
        <form:form action="${pageContext.request.contextPath}" modelAttribute="newUser">
            <form:errors path="username" cssClass="error"/>
            <div class="form-group">
                <form:input path="username" class="form-control" placeholder="Username"/>
            </div>
            <div class="form-group">
                <form:input path="password" type="password" class="form-control" placeholder="Password"/>
            </div>
            <div class="dont">
                <a href="${pageContext.request.contextPath}/register">Don’t have an account?</a>
            </div>
            <input type="submit" class="btn" value="Login">
        </form:form>
    </div>
</div>

</body>
</html>
