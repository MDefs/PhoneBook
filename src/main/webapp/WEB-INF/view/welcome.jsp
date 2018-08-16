<%--
  Created by IntelliJ IDEA.
  User: George
  Date: 08.08.2018
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css"/> " rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
    <title>${newUser.username}</title>
</head>
<body>

    <div class="container">
        <div class="main">
            <h2>Welcome ${newUser.username}</h2>
            <div class="logout">
               <a href="${pageContext.request.contextPath}/"> <i class="fas fa-sign-out-alt"></i> Log out</a>
            </div>

            <c:if test="${phoneList.size()!=0}">
                <form:form action="/search" modelAttribute="newFilter">
                    <div class="search">
                        <div class="form-group">
                            <form:input path="searchFirstName" class="form-control" placeholder="First Name"/>
                        </div>
                        <div class="form-group">
                            <form:input path="searchLastName" class="form-control" placeholder="Last Name"/>
                        </div>
                        <div class="form-group">
                            <form:input path="searchPhone" class="form-control" placeholder="Phone"/>
                        </div>
                        <div class="form-group">
                            <input class="form-control btn" type="submit" value="Search">
                        </div>
                    </div>
                </form:form>
                <div class="table">
                    <table>
                        <tr>
                            <th>Last Name</th>
                            <th>First Name</th>
                            <th>Middle Name</th>
                            <th>Mobile Phone</th>
                            <th>Home Phone</th>
                            <th>Address</th>
                            <th>Email</th>
                        </tr>
                        <c:forEach items="${phoneList}" var="item">
                            <tr>
                                <td><c:out value="${item.lastName}"/></td>
                                <td><c:out value="${item.firstName}"/></td>
                                <td><c:out value="${item.middleName}"/></td>
                                <td><c:out value="${item.mobilePhone}"/></td>
                                <td><c:out value="${item.homePhone}"/></td>
                                <td><c:out value="${item.address}"/></td>
                                <td><c:out value="${item.email}"/></td>
                                <td>
                                    <span><a href="<c:url value="/edit/${item.id}"/>"><i class="fas fa-edit"></i> Edit</a></span>
                                    <span><a href="<c:url value="/remove/${item.id}"/>"><i class="fas fa-trash-alt"></i> Remove</a></span>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </c:if>

            <div class="add"><a href="<c:url value="/add"/>">Add new contact</a></div>
        </div>


    </div>

</body>
</html>
