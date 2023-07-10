<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
	<table border="2">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>gender</th>
			<th>address</th>
			<th>city</th>

		</tr>
		<c:forEach var="prod" items="${ulist}">
			<tr>
				<td>${prod.id}</td>
				<td>${prod.name}</td>
				<td>${prod.gender}</td>
				<td>${prod.address}</td>
				<td>${prod.city}</td>
				<td><a href="updateuser/${prod.id}">edit </a>/ <a
					href="delete/${prod.id}">delete </a></td>
			</tr>

		</c:forEach>
	</table>
	<br>

	<a href="adduser">Add new User</a>&nbsp;&nbsp;
	<a href="logout">logout</a>

</body>
</html>