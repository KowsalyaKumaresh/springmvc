<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<div id="root">
		<div id="form">
			<form:form action="" method="post" modelAttribute="getdoc">
				<div>
					<label for="doctor_id">Doctor Id</label>
					<div>
						<form:input path="doctor_id" />
					</div>
				</div>
				<div>
					<label for="doctor_name">Doctor Name</label>
					<div>
						<form:input path="doctor_name" />
					</div>
				</div>
				<div>
					<label for="dob">Date of Birth</label>
					<div>
						<form:input path="dob" />
					</div>
				</div>
				<div>
					<label for="speciality">Speciality</label>
					<div>
						<form:input path="speciality" />
					</div>
				</div>
				<div>
					<label for="city">City</label>
					<div>
						<form:input path="city" />
					</div>
				</div>
				<div>
					<label for="phone_no">Phone Number/label>
					<div>
						<form:input path="phone_no" />
					</div>
				</div>
				<div>
					<label for="standard_fees">Standard Fees</label>
					<div>
						<form:input path="standard_fees" />
					</div>
				</div>
			</form:form>
		</div>
		<div id = "applist">
		<table>
			<thead>
				<tr>
					<th>Appointment Id</th>
					<th>Appointment Date</th>
					<th>Doctor Id</th>
					<th>Patient name</th>
					<th>Fees</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="app" items="${applist}">
					<tr>
						<td>${app.app_id}</td>
						<td>${app.app_date}</td>
						<td>${app.doctor_id}</td>
						<td>${app.patient_name}</td>
						<td>${app.fees_collected}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>