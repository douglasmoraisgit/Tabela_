<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font face="verdana" size="2px">
    <form action="OngetParameterNames" method="post">
       Name:<input type="text" name="name">
       Country:<input type="text" name="country"><br>
       Habits : <br>
           <input type="checkbox" name="habits" value="Reading">Reading<br>
           <input type="checkbox" name="habits" value="Movies">Movies<br>
           <input type="checkbox" name="habits" value="Writing">Writing<br>
       <input type="submit" value="Submit">
    </form>
</font>
</body>
</html>