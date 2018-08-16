<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login</title>

    <link href="<c:url value="/resources/css/main.css"/> " rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="main edit">
        <h2>Add new contact</h2>
        <form:form action="add" modelAttribute="newPhone">
            <form:errors path="lastName" class="error"/>
            <form:input path="lastName" class="form-control" placeholder="Last Name"/>

            <form:errors path="firstName" class="error"/>
            <form:input path="firstName" class="form-control" placeholder="First Name"/>

            <form:errors path="middleName" class="error"/>
            <form:input path="middleName" class="form-control" placeholder="Middle Name"/>

            <form:errors path="mobilePhone" class="error"/>
            <form:input path="mobilePhone" class="form-control" placeholder="Mobile Phone"/>

            <form:input path="homePhone" class="form-control" placeholder="Home Phone"/>

            <form:input path="address" class="form-control" placeholder="Address"/>

            <form:errors path="email" class="error"/>
            <form:input path="email" class="form-control" placeholder="Email"/>

            <form:hidden path="username" class="hdd" value="${newUser.username}"/>

            <div class="save"><input type="submit" value="Add"></div>
        </form:form>
        <a class="back" href="${pageContext.request.contextPath}/welcome">Back</a>
    </div>
</div>

</body>
</html>
