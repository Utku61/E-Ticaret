<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="action" value="${ pageContext.request.contextPath }/formTest" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="row">
	<div class="col-lg-6">
		<form:form cssClass="form-horizontal" role="form" method="post" accept-charset="UTF-8" action="${ action }" commandName="Yetki">
			<div class="form-group">
				<label for="yetkiAdi" class="col-lg-3 control-label">Hizmet Noktası Adı</label>
				<div class="col-lg-9">
					<form:input path="yetkiAdi" cssClass="form-control" id="yetkiAdi" placeholder="Yetki Adı" />
					<p class="help-block"><form:errors path="yetkiAdi" /></p>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-3 col-lg-9">
					<button type="submit" class="btn btn-default">Ekle</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
</body>
</html>