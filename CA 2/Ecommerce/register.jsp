<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>User Registration</title>
    </head>
    <body>
        <section>
            <h2>User Registration</h2>
            <s:form action="register" method="post">
                <div>
                    <label for="fullname">Full Name:</label>
                    <s:textfield id="fullname" name="fullname"/>
                </div>
                <div>
                    <label for="username">Username:</label>
                    <s:textfield id="username" name="username"/>
                </div>
                <div>
                    <label for="email">Email:</label>
                    <s:textfield id="email" name="email"/>
                </div>
                <div>
                    <label for="password">Password:</label>
                    <s:password id="password" name="password"/>
                </div>
                <s:submit value="Register"/>
            </s:form>
        </section>
        <p><a href="login.jsp">Already have account? Login</a></p>
    </body>
</html>
