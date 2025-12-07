<%--
  Created by IntelliJ IDEA.
  User: allynn
  Date: 06/12/2025
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>User Dashboard</title>
    </head>
    <body>
        <h1>eCommerce Dashboard</h1>

<%--        <s:iterator value="#sessionInfo">--%>
        <h1>Session Variable</h1>
        <p>Logged in as: <b><s:property value="#session.currentUser"/></b></p>
        <p>Fullname: <b><s:property value="#session.fullName"/></b></p>
        <p>Logged in as: <b><s:property value="session.email"/></b></p>

        <h1>Java Variable</h1>
        <p>Logged in as: <b><s:property value="username"/></b></p>
        <p>Fullname <b><s:property value="fullname"/></b></p>
        <p>Email: <b><s:property value="email"/></b></p>
        <p>Password: <b><s:property value="getPassword()"/></b></p>


<%--        </s:iterator>--%>

    </body>
</html>
