<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>All Users</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
</head>
<body class="bg-slate-50">
<header class="w-full border-b border-slate-200 bg-white">
    <div class="mx-auto flex max-w-6xl items-center justify-between px-4 py-4">
        <h1 class="text-xl font-semibold text-slate-800">eCommerce Home</h1>
        <nav class="flex items-center gap-4 text-sm font-medium text-blue-600">
            <a href="index.jsp" class="hover:underline">Home</a>
            <a href="dashboard.jsp" class="hover:underline">Dashboard</a>
            <a href="listUsers.action" class="hover:underline">View all users</a>

            <s:if test="#session.currentUser != null">
            <span class="text-black italic">
              User: <s:property value="#session.fullName" />
            </span>
                <span class="text-slate-300">|</span>
                <s:form action="logout" method="post" cssClass="inline">
                    <s:submit value="Log off"
                              cssClass="text-red-500 text-sm hover:underline cursor-pointer bg-transparent border-0 p-0" />
                </s:form>
            </s:if>
        </nav>
    </div>
</header>
<main class="mx-auto mt-8 max-w-6xl px-4">
    <section class="rounded-md bg-white p-6 shadow-sm border border-slate-200">
        <h2 class="mb-4 text-lg font-semibold text-slate-800">All Users</h2>

        <table class="min-w-full text-sm border border-slate-200">
            <thead class="bg-slate-100">
            <tr>
                <th class="px-3 py-2 text-left font-medium text-slate-700 border-b">Username</th>
                <th class="px-3 py-2 text-left font-medium text-slate-700 border-b">Full name</th>
                <th class="px-3 py-2 text-left font-medium text-slate-700 border-b">Email</th>
            </tr>
            </thead>
            <tbody>
            <s:action name="listUsers" id="userAction" />
            <s:iterator value="#userAction.users">
                <tr class="odd:bg-white even:bg-slate-50">
                    <td class="px-3 py-2 border-b">
                        <a href="viewUser.action?username=<s:property value='username' />"
                           class="text-blue-600 hover:underline">
                            <s:property value="username" />
                        </a>
                    </td>
                    <td class="px-3 py-2 border-b"><s:property value="fullname" /></td>
                    <td class="px-3 py-2 border-b"><s:property value="email" /></td>
                </tr>
            </s:iterator>

            </tbody>
        </table>
    </section>
</main>
</body>
</html>