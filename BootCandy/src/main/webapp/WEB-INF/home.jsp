<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="getCandy.do" method="GET">
  Candy ID: <input type="text" name="candyId" />
  <input type="submit" value="Show Candy" />
</form>


</body>
</html>