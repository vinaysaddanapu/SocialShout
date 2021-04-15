<%@page import="com.example.socialshout.entity.Announcement"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>Your Search</h1>
<br>
<% String authorized = (String)session.getAttribute("authorized");
     if(authorized == null){
    	 
    	 response.sendRedirect("/home.jsp");
     }else{

%>
<ul class="list-group">
 <c:forEach items="${searchedAnnouncement}" var="search">
 <li class="list-group-item">Posted on: ${search.date }</li>
 <li class="list-group-item"><img  src="/getPhoto/${search.id}" class="img-thumbnail" width="300" height="300"></li>
 <li class="list-group-item"><h4>${search.title}</h4></li>
 <li class="list-group-item">${search.subject }</li>
 <li class="list-group-item">${search.description }</li>
 <hr>
 </c:forEach>
 <%} %>
 </ul>
 
 <% String error = (String)request.getAttribute("errorMsg");
  if(error != null){%>
   <span style="color:red"><%=error %></span>
  <%}%>
</body>
</html>