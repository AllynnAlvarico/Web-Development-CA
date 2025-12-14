<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>User Profile</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <header class="w-full border-b border-slate-200 bg-white">
            <div class="mx-auto flex max-w-6xl items-center justify-between px-4 py-4">
                <h1 class="text-xl font-semibold text-slate-800">eCommerce Home</h1>
                <nav class="flex items-center gap-4 text-sm font-medium text-blue-600">
                    <a href="index.jsp" class="hover:underline">Home</a>
                    <a href="all-users.jsp" class="hover:underline">View all users</a>
                    <s:if test="#session.currentUser == null">
                        <a href="register.jsp" class="hover:underline">Register</a>
                        <a href="login.jsp" class="hover:underline">Login</a>
                    </s:if>
                    <s:else>
                        <a href="dashboard.jsp" class="hover:underline">Dashboard</a>
                        <span class="text-black italic">User: <s:property value="#session.fullName" /></span>
                        <span class="text-slate-300">|</span>
                        <s:form action="logout" method="post" cssClass="inline">
                            <s:submit value="Log off"
                                      cssClass="text-red-500 text-sm hover:underline cursor-pointer bg-transparent border-0 p-0" />
                        </s:form>
                    </s:else>
                </nav>
            </div>
        </header>
        <s:action name="viewUser" id="viewAction" />
        <s:iterator value="#viewAction.user">
            <h1>User Profile</h1>
            <p>Username: <s:property value="user.username" /></p>
            <p>Full name: <s:property value="user.fullName" /></p>
            <p>Email: <s:property value="user.email" /></p>
        </s:iterator>
    </body>
</html>
