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
    <title>${newUser.username}</title>

    <link href="<c:url value="/resources/css/main.css"/> " rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="main searching-result">
        <h2>Searching result</h2>
        <c:if test="${newFilter.list.size()!=0}">
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
                    <c:forEach items="${newFilter.list}" var="item">
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
        <c:if test="${newFilter.list.size()==0}">
            <p>
                <i class="fas fa-search-minus fa-10x"></i>
                <br>
                <br>
                No search result found
            </p>
        </c:if>
        <a class="back" href="${pageContext.request.contextPath}/welcome">Back</a>
    </div>
</div>

</body>
</html>
