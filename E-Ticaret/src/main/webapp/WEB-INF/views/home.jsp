<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello world!</h1>
	<table border="1" style="width: 100%">
		<tr>
			<td>Yetki No</td>
			<td>Yetki Adı</td>
		</tr>
		<c:forEach items="${allYetkis}" var="u">
			<tr>
				<td>${u.yetkiNo}</td>
				<td>${u.yetkiAdi}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>