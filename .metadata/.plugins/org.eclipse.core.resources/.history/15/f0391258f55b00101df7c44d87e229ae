<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
	<h2>${message}</h2>
	<form:form action="save" method="post" modelAttribute="sv" enctype="multipart/form-data">
		<div>
			<form:label path="name">Name:</form:label>
			<form:input path="name" />
			<form:errors path="name" cssClass="error" />
		</div>
		<div>
			<form:label path="email">Email:</form:label>
			<form:input path="email" />
			<form:errors path="email" />
		</div>
		<div>
			<form:label path="faculty">Faculty:</form:label>
			<form:select path="faculty">
				<form:options items="${faculties}" />
			</form:select>
			<form:errors path="faculty" />
		</div>
		<div>
			<form:label path="marks">Marks:</form:label>
			<form:input path="marks" />
			<form:errors path="marks" />
		</div>
		<div>
			<form:label path="gender">Gender:</form:label>
			<form:radiobuttons path="gender" items="${genders}" />
			<form:errors path="gender" />
		</div>
		<div>
			<form:label path="hobbies">Hobbies:</form:label>
			<form:checkboxes path="hobbies" items="${hobbies}" />
			<form:errors path="hobbies" />
		</div>
		<div>
			<form:label path="photo">Photo:</form:label>
			<input type="file" name="photo" /><br>
			<form:errors path="photo" />
		</div>
		<div>
			<input type="submit" value="Save" />
		</div>
	</form:form>
</body>
</html>
