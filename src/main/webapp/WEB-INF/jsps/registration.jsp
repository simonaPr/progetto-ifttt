<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
${msg }
<form action="registration.html" method="post">
            <input name="username" type="text" 
                   placeholder="Username" />
            <input name="password" type="password" 
                   placeholder="Password" />
           <input name="email" type="text"
                   placeholder="email" />
            <button type="submit" />
        </form>
</body>
</html>