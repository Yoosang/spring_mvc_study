<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <%--
        동일한 표현
        1. ${member.id}
        2. <%=((Member)request.getAttribute("member")).getId()%>
    --%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age }</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>

