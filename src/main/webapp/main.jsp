<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.example.socialshout.entity.Announcement"%>
<%@page import="java.util.List"%>
<%@page import="com.example.socialshout.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcements | Home</title>
 <link rel="stylesheet" href="css/main.css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
</head>
<body>
<c:set var="user" value="${login}"></c:set>
<% String authorized = (String)session.getAttribute("authorized");

if(authorized == null){
   response.sendRedirect("/home.jsp");
   
}else{
	
%>
<nav class="navbar navbar-default">
<div class="container-fluid">

<!-- BRAND -->
<div class="navbar-header">
<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#alignment-example" aria-expanded="false">
<span class="sr-only">Toggle navigation</span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
<a class="navbar-brand" href="#">Social Shout</a>
</div>
<!-- COLLAPSIBLE NAVBAR -->
<div class="collapse navbar-collapse" id="alignment-example">

<!-- Links -->
<ul class="nav navbar-nav">
<li class="active"><a href="/getAnnouncements">News Feed<span class="sr-only">(current)</span></a></li>
<li><a href = "/profile/${user.id}">Profile</a></li>
<li><a href="/logout">Logout</a></li>
</ul>

<!-- Search -->
<form class="navbar-form navbar-right" role="search" action="/search" method="post">
<div class="form-group">
<input type="text" class="form-control" placeholder="search"  name="search">
</div>
<button type="submit" class="btn btn-default">Search</button>
</form>

</div>

</div>
</nav>
<strong>Hi, ${user.name}</strong>
<br>
<br>
<span style="color:green; font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">You'r Logged In</span>
<br>
<h2>Post</h2>
<br>
<div class= "post">
<form action= "announce" method="post" enctype="multipart/form-data">
<label>Title</label><br>
<input type="text" class="form-control" style="width:30%;" name="title"><br>
<label>Subject</label><br>
<input type = "text" class="form-control" style="width:30%;" name= "subject"><br>
<label>Description</label><br>
<textarea name="desc" class="form-control" style="width:30%;"></textarea><br>
<input type="file" name="image"><br><br>
<input type="submit" class="btn btn-primary bg block" value="Announce" id="annBtn">
</form>
</div>
<br>

<%}%>

<div>
<h3>Create Group</h3>
<input type="text" placeholder="Group Name"/>
<input type="submit" value="Create">
</div>

</body>
<style>
.navbar{
 color:white;
}
</style>
</html>