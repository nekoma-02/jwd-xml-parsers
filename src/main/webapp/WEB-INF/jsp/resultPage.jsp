<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>Index page</title>
</head>
<body>
	

	<c:if test="${not empty application}">
		<div class="content">
			<table>
			<caption>Список заявок</caption>
				<thead>
					<tr>
						<th>Номер заявки</th>
						<th>Имя пользователя</th>
						<th>Почта пользователя</th>
						<th>Привелегия</th>
						<th>Название школы</th>
						<th>Специальность</th>
						

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${application}" var="app">
						<tr>
							<td>${app.getId()}</td>
							<td>${app.getName()}</td>
							<td>${app.getEmail()}</td>
							<td>${app.getPrivelege()}</td>
							<td>${app.getSchool()}</td>
							<td>${app.getSpecialty()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if test="${empty application}">
	<h1>${error_message}</h1>
	</c:if>
</body>
</html>