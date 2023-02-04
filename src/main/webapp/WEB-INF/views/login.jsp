<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2/4/2023
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form action="${pageContext.request.contextPath }/login-processing"
                  method="POST">
                <div class="form-group">
                    <label>User Name</label>
                    <input type="text" name="email" class=" w3-input w3-border w3-margin-bottom" placeholder="email" required=""/>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" class=" w3-margin-top w3-text-black" name="password" placeholder="password"  required=""/>
                </div>
                <button type="submit" class="btn btn-black">Login</button>
                <button type="submit" class="btn btn-secondary">Register</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
