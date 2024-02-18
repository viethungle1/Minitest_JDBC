<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>Tạo mới</h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Book Name:</th>
                <td><input type="text" name="name" size="45px"></td>
            </tr>
            <tr>
                <th>Author:</th>
                <td><input type="text" name="author" size="45px"></td>
            </tr>
            <tr>
                <th>Category: </th>
                <td>
                    <select name="categories" multiple>
                        <c:forEach items="${categories}" var="c">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Save</button>
                </td>
                <td>
                    <button type="submit"><a style="text-decoration: none" href="/">Back to Home Page</a></button>
                </td>
                </tr>
        </table>
    </form>
</div>
</body>
</html>
