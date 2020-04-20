<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%! int index = 0; %>
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${message}" var="x" varStatus="loop">
 <a href="/Lab2/es3?index=${loop.index}"> <c:out value="${x}"/><br></a>
</c:forEach>

<br><a href="./views/es3-form.jsp">Return to form</a>
</body>
</html>