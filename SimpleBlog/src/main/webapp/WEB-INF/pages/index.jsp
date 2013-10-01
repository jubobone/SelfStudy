<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Simple Blog</title>
</head>
<body>
 
<h1>List of users</h1>
 
<c:if test="${not empty userList}">
    <table class="table table-striped table-bordered table-condensed">
    	<tr>
    		<th>Account</th>
    		<th>Name</th>
    		<th>Email</th>
    	</tr>
    	
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.accountName}</td>
                <td>${user.fullName}</td>
                <td>${user.email}</td>   
            </tr>
        </c:forEach>
    </table>
</c:if>
 
</body>
</html>