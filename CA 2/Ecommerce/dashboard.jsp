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
        <p>User Email: <b><s:property value="#session.email"/></b></p>
        <section>
            <h2>Products</h2>
            <s:form action="addProduct" method="post">
                <s:textfield name="name" label="Product Name"/>
                <s:textfield  name="description" label="Description"/>
                <s:submit value="Add"/>
            </s:form>
        </section>

<%--        <h1>Java Variable</h1>--%>
<%--        <p>Logged in as: <b><s:property value="username"/></b></p>--%>
<%--        <p>Fullname <b><s:property value="fullname"/></b></p>--%>
<%--        <p>Email: <b><s:property value="email"/></b></p>--%>
<%--        <p>Password: <b><s:property value="getPassword()"/></b></p>--%>


<%--        </s:iterator>--%>

    </body>
</html>
