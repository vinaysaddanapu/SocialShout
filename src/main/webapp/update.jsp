<%@page import="com.example.socialshout.entity.Announcement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcements | Update</title>
<style type="text/css">

body {
  font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
</style>
</head>
<body> 
<h1>Update Form</h1>
<form action="/update" method="post">
<label>Title</label><br>
<input type="text" name="title" value="${anm.title}"><br>
<label>Subject</label><br>
<input type="text" name="subject"><br>
<label>Description</label><br>
<input type="text" name="desc"><br>
<input type="submit" value="update">
</form>
</body>
</html>