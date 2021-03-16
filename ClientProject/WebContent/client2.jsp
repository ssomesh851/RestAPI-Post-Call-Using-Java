<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>getting the details</title>
</head>
<body>
<form  action = "ClientServlet" method = "post" enctype = "application/json">
Reference_Id:<input type = "text" reference_id = "id"/>
Name:<input type = "text" name = "username"/> 
Amount:<input type = "text" amount = "amt"/>
Serial_No:<input type = "text" serial_no = "srno"/> 
<input type = "submit" value = "submit"/> 
</body>
</html>