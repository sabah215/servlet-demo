<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employees</title>
</head>
<body>
		<h3>Employees</h3>
		
		<table class="table">
			  <thead class="thead-dark">
			    <tr>
			   
			      <th scope="col">Id</th>
			      <th scope="col">Name</th>
			      <th scope="col">Salary</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			   <c:forEach items="${empList}" var="employee">
				    <tr>
				      <td><c:out value="${employee.id}" /></td>
				      <td><c:out value="${employee.name}" /></td>
				      <td><c:out value="${employee.sal}" /></td>
				      <td><a href="delete">Delete</a></td>
				    </tr>
  			  </c:forEach>
			   
			  </tbody>
		</table>
</body>
</html>