<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 
<title>Access Denied</title>
 <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
 
   <jsp:include page="_header.jsp" />
   <jsp:include page="_menu.jsp" />
 
   <div class="page-title">Access Denied!</div>
  
   <h3 style="color:red;">Sorry, you can not access this page!</h3>
  
  
   <jsp:include page="_footer.jsp" />
 
</body>
</html>