<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Employee</title>
</head>
<div id="root">
        <div id="form">
            <form:form action="" method="post" modelAttribute="finddoctorbyid">
                <div>
					<label for="doctor_id">Doctor Id</label>
					<div>
						<form:input path="doctor_id" />
					</div>
				</div>
				<div>
					<label for="doctor_name">First Name</label>
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
				            </form:form>
        </div>
</body>
</html>