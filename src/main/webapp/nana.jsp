<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String _temp = request.getParameter("n");
	int num = 100;
	if(_temp != null && !_temp.equals("")) {
		 num = Integer.parseInt(_temp);
	}
	
	String result;
	
	if(num%2 != 0)
		result = "홀수";
	else
		result = "짝수";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=result %>입니다.
</body>
</html>