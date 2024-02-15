<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Minitest_3</title>
</head>
<body>
<center>
    <h2>Edit Book Information</h2>
    <h3>
        <a href="book">Return Book List</a>
    </h3>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <c:if test="${book != null}">
                <input type="hidden" name="id" value="<c:out value='${book.id}' />"/>
            </c:if>
            <tr>
                <th>Book Name:</th>
                <td>
                    <input type="text" name="name" size="45" value="<c:out value='${book.name}' />"/>
                </td>
            </tr>
            <tr>
                <th>Book Author:</th>
                <td>
                    <input type="text" name="author" size="45" value="<c:out value='${book.author}' />"/>
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="description" size="45" value="<c:out value='${book.description}'/>"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">Save</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
