<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>User Registration</h2>

<s:if test="hasActionErrors()">
    <s:iterator value="actionErrors">
        <p><font color="red"><s:property/></font></p>
    </s:iterator>
</s:if>

<s:if test="hasActionMessages()">
    <s:iterator value="actionMessages">
        <p><font color="green"><s:property/></font></p>
    </s:iterator>
</s:if>

<form action="register.action" method="post">
    Full Name: <input type="text" name="fullname" required/><br/><br/>
    Username: <input type="text" name="username" required/><br/><br/>
    Email: <input type="email" name="email" required/><br/><br/>
    Password: <input type="password" name="password" required/><br/><br/>
    <input type="submit" value="Register"/>
</form>

<p><a href="login.jsp">Already have account? Login</a></p>
</body>
</html>
