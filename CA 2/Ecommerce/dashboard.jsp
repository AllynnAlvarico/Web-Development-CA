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
            <p>Logged in as: <b><s:property value="sessionInfo.currentUser"/></b></p>
            <p>Logged in as: <b><s:property value="username"/></b></p>
            <p>Password: <b><s:property value="getPassword()"/></b></p>
            <p>Fullname: <b><s:property value="sessionInfo.fullName"/></b></p>
            <p>Logged in as: <b><s:property value="sessionInfo.email"/></b></p>
<%--        </s:iterator>--%>

    </body>
</html>
