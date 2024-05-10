<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- rootPath 라는 변수를 선언해서 value의 값을 담겠다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link href="rootPath/static/css/main.css?001" rel="stylesheet">
<style>
.single {
  display: none;
}
</style>
</head>
<body>
	<form method="POST" enctype="multipart/form-data">
		<input placeholder="email" name="g_email"/>
		
		<input placeholder="password" name="g_password"/>
		<input placeholder="작성자" name="g_author"/>
		<input placeholder="제목" name="g_title"/>
		<input placeholder="내용" name="g_content"/>
		<input type="file" accept="image/*" name="image_files" multiple />
		<input type="file" accept="image/*" class="single" name="image_file" multiple />
		
		<input type="submit" value="저장">
		
		
	</form>	
</body>
</html>
