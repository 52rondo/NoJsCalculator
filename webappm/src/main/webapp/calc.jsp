<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<%@ page isELIgnored = "false" %>
</head>
<body>
	<form  action="${request.contextPath}/MainController" name="" method="POST">
        <input type="text" name="action" value="postinfo" hidden>
        <label for="number">type in a number</label>
        
        <input type="text" name="number" id="number">
        <button>Submit</button>

    </form>
    <form action="<%=request.getContextPath()%>/MainController" method="POST">
        <input type="text" name="action" value="getinfo" hidden>
        <label for="">What is lucky number</label>
		<div>
			${attr1}
		</div>       
        <button>Get Number</button>
    </form>
</body>
</html>