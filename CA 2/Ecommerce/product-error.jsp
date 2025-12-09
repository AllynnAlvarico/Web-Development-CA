<html>
    <head>
        <title>Product Not Added</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    </head>
    <body>
    <header class="w-full border-b border-slate-200 bg-white">
        <div class="mx-auto flex max-w-6xl items-center justify-between px-4 py-4">
            <h1 class="text-xl font-semibold text-slate-800">eCommerce Home</h1>
            <nav class="flex items-center gap-4 text-sm font-medium text-blue-600">
                <a href="index.jsp" class="hover:underline">Home</a>
                <a href="dashboard.jsp" class="hover:underline">Dashboard</a>
                <a href="all-users.jsp" class="hover:underline">View all users</a>

                <s:if test="#session.currentUser == null">
                    <a href="register.jsp" class="hover:underline">Register</a>
                    <a href="login.jsp" class="hover:underline">Login</a>
                </s:if>
                <s:else>
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

        <h1>Product Could Not Be Added</h1>

        <p>There was a problem saving the product. Please check the details and try again.</p>
        <nav>
            <a href="dashboard.jsp">Go to Dashboard</a>
        </nav>
</body>