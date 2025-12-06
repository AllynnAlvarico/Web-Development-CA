<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>User Login</title>
    </head>
    <body>
        <h1>eCommerce Home</h1>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <section>
            <s:form action="login" method="post">
                <h1>Login Window</h1>
                <div>
<%--                    <label for="username">Username:</label>--%>
                    Username: <s:textfield id="username" />
                </div>
                <div>
<%--                    <label for="password">Password:</label>--%>
                    Password: <s:password id="password" />
                </div>
                <s:submit value="Login"/>
            </s:form>
        </section>
    </body>
</html>