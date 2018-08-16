<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/> " rel="stylesheet">

    <title>Registration</title>
</head>
<body>


<div class="container">

    <div class="login-form">
        <div class="panel">
            <h2>Welcome to registration</h2>
            <p>Please enter username, full name, and password</p>
        </div>
        <form:form action="register" modelAttribute="newUser">
            <form:errors path="username" cssClass="error"/>
            <div class="form-group">
                <form:input path="username" class="form-control" placeholder="Username"/>
            </div>
            <form:errors path="fio" cssClass="error"/>
            <div class="form-group">
                <form:input path="fio" class="form-control" placeholder="Full name"/>
            </div>
            <form:errors path="password" cssClass="error"/>
            <div class="form-group">
                <form:input path="password" type="password" class="form-control" placeholder="Password"/>
            </div>
            <div class="dont">
                <a href="${pageContext.request.contextPath}/">I have an account!</a>
            </div>
            <input type="submit" class="btn" value="Register">
        </form:form>
    </div>
</div>

<%--<form:form action="register" modelAttribute="newUser">--%>
    <%--Username--%>
    <%--<form:errors path="username" cssClass="error"/>--%>
    <%--<form:input path="username"/>--%>
    <%--FIO--%>
    <%--<form:textarea path="fio"/>--%>
    <%--Password--%>
    <%--<form:errors path="password" cssClass="error"/>--%>
    <%--<form:textarea path="password"/>--%>

    <%--<input type="submit" value="Register">--%>
<%--</form:form>--%>

</body>
</html>
