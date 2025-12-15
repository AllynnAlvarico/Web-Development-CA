<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Home</title>
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

    <main class="mx-auto max-w-6xl px-4 py-8">
        <h2 class="mb-6 text-lg font-semibold text-slate-800">Available Products</h2>

        <section class="grid gap-6 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
            <s:action name="listProducts" id="prodAction" />
            <s:iterator value="#prodAction.products">
                <article class="flex flex-col mx-auto items-stretch rounded-lg bg-sky-100/80 p-3">
                        <img src="https://placehold.co/200x100" alt="Product Image" width="200" height="100"/>
                        <h3 class="text-center font-semibold"><s:property value="name" /></h3>
                        <p class="text-center text-sm italic"><s:property value="description" /></p>
                        <p class="text-center text-sm italic"><s:property value="category" /></p>
                        <p class="text-center text-sm italic"><s:property value="price" /></p>
                    <s:form action="placeBid" method="post" cssClass="mt-2 flex justify-center">
                    <s:hidden name="itemId" value="%{id}" />
                    <s:submit value="Bid" cssClass="rounded bg-blue-600 px-3 py-1 text-xs font-medium text-white hover:bg-blue-700"/>
                    </s:form>
                </article>
            </s:iterator>
        </section>
    </main>
    </body>
</html>