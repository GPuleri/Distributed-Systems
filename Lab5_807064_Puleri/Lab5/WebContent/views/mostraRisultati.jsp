<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%!int index = 0;%>
</head>
<body>

	<c:forEach items="${risultato}" var="ris" varStatus="loop">
		<a href="${ris}"> <c:out value="http://localhost:8080/Lab5/${ris}" /><br></a>
		
	</c:forEach>
	
</body>
</html>