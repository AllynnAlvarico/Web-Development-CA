<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>User Registration</title>
    </head>
    <body>
        <section>
            <h2>User Registration</h2>
            <form action="register.action" method="post">
                <div>
                    <label for="fullname">Full Name:</label>
                    <input type="text" id="fullname" name="fullname" required/><br/><br/>
                </div>
                <div>
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required/><br/><br/>
                </div>
                <div>
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" required/><br/><br/>
                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required/><br/><br/>
                </div>
                <input type="submit" value="Register"/>
            </form>
        </section>
        <p><a href="login.jsp">Already have account? Login</a></p>
    </body>
</html>
