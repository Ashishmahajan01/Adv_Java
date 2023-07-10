<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User</title>
<style>
.errormsg {
	color: red;
}
</style>
</head>
<body>
	<form:form action="/insertuser" method="post" modelAttribute="registeruser">
      User Id: <form:input path="id" id="id" />
		<br>
      User Name:<form:input path="name" id="name" />
		<br>
		<small><form:errors path="name" cssClass="errormsg" /></small>
		<br>
     Address : <form:input path="address" id="address" />
		<br>
		<small><form:errors path="address" cssClass="errormsg" /></small>
		<br>
     Gender: <form:input path="gender" id="gender" />
		<br>
		<small><form:errors path="gender" cssClass="errormsg" /></small>
		<br>
     City : <form:input path="city" id="city" />
		<br>
		<small><form:errors path="city" cssClass="errormsg" /></small>
		<br>
		<button type="submit" name="btn" id="btn" value="add">Add new
			User</button>
	</form:form>
</body>
</html>