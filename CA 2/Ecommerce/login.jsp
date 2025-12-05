<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <h1>eCommerce Home</h1>
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <section>
            <form>
                <h1>Login Window</h1>
                <div>
                    <label for="username">Username:</label>
                    <input type="text" id="username" required />
                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" id="password" required />
                </div>
            </form>
        </section>
    </body>
</html>