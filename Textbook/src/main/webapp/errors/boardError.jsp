<%@ page contentType="text/html; charset=UTF-8"
    isErrorPage="true"
    import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<center>
			<h3><%= exception.getClass().getName() %>발생!</h3>
			<% Date currentTime = new Date(); %>
			예외 발생 시간 : <%= currentTime.toString() %>
			<hr>
			<% StackTraceElement[] elements = exception.getStackTrace(); %>
			예외위치 : <%= elements[0].toString() %>
		</center>
	</body>
</html>