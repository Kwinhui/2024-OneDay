<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>이미지 갤러리</title>
  </head>
  <body>
    <h1>이미지 갤러리 2024</h1>
    
    <section>
    <article>
    	<a href="${ rootPath}/insert">이미지 업로드</a>
    	</article>
    	
    	<div>
    	<c:forEach items="${LIST }" var="L">
    		<div>
    		<img src="${rootPath }/upload/${L.g_up_image}">
    			
    		</div>
    		
    		<div></div>
    	</c:forEach>
    	</div>
    </section>
  </body>
</html>
