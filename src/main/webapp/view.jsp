<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.crud.dao.MemberDAO, com.crud.bean.MemberVO"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>

<%
	MemberDAO memberDAO = new MemberDAO();
	String id=request.getParameter("sid");	
	MemberVO u=memberDAO.getOne(Integer.parseInt(id));
	request.setAttribute("vo", u) ;
%>

<h1>View</h1>

<table>
<tr><td>No :</td><td>${vo.getSid()}</td></tr>
<tr><td>User ID :</td><td>${ vo.getUserid()}</td></tr>
<tr><td>User Name:</td><td>${vo.getUsername()}</td></tr>
<tr><td>Email :</td><td>${vo.getEmail()}</td></tr>
<tr><td>Photo :</td><td><c:if test = "${vo.getPhoto() ne '' }"><br />
				<img src ="${pageContext.request.contextPath }/upload.${vo.getPhoto()}" class = "photo"></c:if></td></tr>
<tr><td>Detail :</td><td>${ vo.getDetail()}</td></tr>
<tr><td><a href="list.jsp">Back to List</a></td></tr>
</table>


</body>
</html>