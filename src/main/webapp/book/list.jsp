<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Minitest_3</title>
</head>
<body>
<center>
    <h1>Book Library</h1>
    <h2>
        <a href="/book?action=create">Add New Book</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Author</th>
            <th>Description</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${list}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.name}"/></td>
                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.description}"/></td>
                <td>
                    <a href="/book?action=edit&id=${book.id}">Edit</a>
                    <a href="/book?action=delete&id=${book.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5">
                <button type="submit" ><a href="/">Back</a></button>
            </td>
        </tr>
    </table>
</div>
</body>
</html>