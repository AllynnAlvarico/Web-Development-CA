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

<%--        <h1>eCommerce Dashboard</h1>--%>

<%--&lt;%&ndash;        <s:iterator value="#sessionInfo">&ndash;%&gt;--%>
<%--        <h1>Session Variable</h1>--%>
<%--        <p>Logged in as: <b><s:property value="#session.currentUser"/></b></p>--%>
<%--        <p>Fullname: <b><s:property value="#session.fullName"/></b></p>--%>
<%--        <p>User Email: <b><s:property value="#session.email"/></b></p>--%>
<%--        <section>--%>
<%--            <h2>Products</h2>--%>
<%--            <s:form action="addProduct" method="post">--%>
<%--                <s:textfield name="name" label="Product Name"/>--%>
<%--                <s:textfield  name="description" label="Description"/>--%>
<%--                <s:submit value="Add"/>--%>
<%--            </s:form>--%>
<%--        </section>--%>

    <main class="mx-auto mt-8 max-w-3xl px-4">
        <section class="rounded-md bg-white p-6 shadow-sm border border-slate-200">
            <h2 class="mb-4 text-lg font-semibold text-slate-800">My Profile</h2>

            <div class="space-y-2 text-sm text-slate-800">
                <p>
                    <span class="font-medium">Username:</span>
                    <span class="ml-1"><s:property value="#session.currentUser" /></span>
                </p>
                <p>
                    <span class="font-medium">Full name:</span>
                    <span class="ml-1"><s:property value="#session.fullName" /></span>
                </p>
                <p>
                    <span class="font-medium">Email:</span>
                    <span class="ml-1"><s:property value="#session.email" /></span>
                </p>
            </div>
            <div class="mt-6">
                <h2 class="text-center font-bold text-xl border-t-2 border-b-2 ">Add Products you want to sell</h2>
                <s:form action="addProduct" method="post">
                    <div class="flex gap-4">
                        <span class="my-2">Product Name: </span>
                        <s:textfield name="name" cssClass="my-2 w-full rounded-md border border-slate-300 px-3 py-1 text-sm"/>
                    </div>

                    <div class="flex gap-4">
                        <span class="my-2">Description: </span>
                        <s:textfield  name="description" cssClass="my-2 w-full rounded-md border border-slate-300 px-3 py-1 text-sm"/>
                    </div>
                    <s:submit value="Add" cssClass="my-2 inline-flex items-center rounded-md bg-blue-600 px-4 py-1 text-sm font-medium text-white hover:bg-blue-700"/>
                </s:form>
            </div>
        </section>
    </main>

<%--    <s:action name="viewBids" id="bidAction">--%>
        <s:iterator value="bids">
            Bid Id: <s:property value="bidId" />
            Item Id: <s:property value="bidItemId" />
            Username: <s:property value="bidderUsername" />
            <s:property value="amount" />
        </s:iterator>
<%--    </s:action>--%>


    <%--        <h1>Java Variable</h1>--%>
<%--        <p>Logged in as: <b><s:property value="username"/></b></p>--%>
<%--        <p>Fullname <b><s:property value="fullname"/></b></p>--%>
<%--        <p>Email: <b><s:property value="email"/></b></p>--%>
<%--        <p>Password: <b><s:property value="getPassword()"/></b></p>--%>


<%--        </s:iterator>--%>

    </body>
</html>
