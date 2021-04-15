<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcements | Profile</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
 
 body {
 font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	
}
</style>
<script>
function goBack() {
  window.history.back();
}
</script>
</head>
<body>
<br>
<button class="btn btn-primary" onclick="goBack()">Go Back</button>

<% String authorized = (String)session.getAttribute("authorized");
     if(authorized == null){
    	 
    	 response.sendRedirect("/home.jsp");
     }else{

%>
<c:set var="profile"  value="${profile}"></c:set>
<div align="center">
<br>
<img width="200" height="200" class="img-thumbnail"></img>
<h1>${profile.name}</h1>
<p>Email Id: ${profile.email_id }</p>
<p>Password: ${profile.password }</p>
</div>
<%} %>
</body>
</html>