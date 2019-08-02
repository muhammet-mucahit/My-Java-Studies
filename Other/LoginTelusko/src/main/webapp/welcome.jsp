<%--
  Created by IntelliJ IDEA.
  User: Muhammet Mucahit
  Date: 12/2/2017
  Time: 10:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

        if(session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }

        out.println("Welcome " + session.getAttribute("username"));
    %>

    <a href="videos.jsp">Videos here</a>

    <form action="Logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
