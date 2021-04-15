<%@page import="java.io.OutputStream"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Announcements</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
<style type="text/css">

body {
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.feeds{
width:45%;
box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
text-align:center;
margin-left:30%;
}

</style>
</head>
<body>
<h1>Your Feed</h1>
<% response.setHeader("Cache-Control", "no-cache"); %>

<% String authorized = (String)session.getAttribute("authorized");
     if(authorized == null){
    	 
    	 response.sendRedirect("/home.jsp");
     }else{

%>

<c:forEach items="${announcements }" var="ann">
<div class="feeds">
<ul class="list-group">
  <li class="list-group-item"><h3>${ann.title}</h3></li>
  <li class="list-group-item">${ann.subject}</li>
  <li class="list-group-item"><img src="/getPhoto/${ann.id}"  class="img-rounded" width="170" height="170"/></li>
  <li class="list-group-item"> ${ann.date}</li>
  <li class="list-group-item">${ann.description}</li>
  <li class="list-group-item">
  <a href="update/${ann.id}" class="btn btn-primary">Edit</a>&nbsp;&nbsp;
  <a href="/delete/${ann.id}" class="btn btn-danger">Delete</a>
  </li>
  </ul>
  </div>
</c:forEach>
<%} %>
</body>
</html>