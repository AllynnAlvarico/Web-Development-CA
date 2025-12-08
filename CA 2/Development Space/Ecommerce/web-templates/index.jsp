<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
    <header>
        <h1>eCommerce Home</h1>
        <nav>
            <a href="register.jsp">Register</a>
            <a href="login.jsp">Login</a>
        </nav>
    </header>
    <main>
        <h2>Available Products</h2>
        <ul>
            <s:action name="listProducts" id="prodAction"/>
<%--            <s:property value="products.size()"/> products found.--%>

            <s:iterator value="#prodAction.products">
                <li>
                    <b><s:property value="name"/></b> -
                    <s:property value="description"/>
                </li>
            </s:iterator>
        </ul>
    </main>


    </body>
</html>