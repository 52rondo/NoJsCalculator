<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
   	<%@ page isELIgnored = "false" %>
    
</head>
<body>
    <h1>This is Frontpage of te Calculator</h1>
    <h3>Maven project using Java, Servlet, JSP(EL) </h3>
    <br>
    <div id="mainDiv">
        <div>
          	 <input type="text" name="number" value="1" hidden>
           	 <table>
        		<form action="${pageContext.request.contextPath}/Calculator">
	           	<tr>
	                <td><button type="submit" name="digit" value="7">7</button></td>
	                <td><button type="submit" name="digit" value="8">8</button></td>
	                <td><button type="submit" name="digit" value="9">9</button></td>
	            </tr>
	            <tr>
	                <td><button type="submit" name="digit" value="4">4</button></td>
	                <td><button type="submit" name="digit" value="5">5</button></td>
	                <td><button type="submit" name="digit" value="6">6</button></td>
	            </tr>
	            <tr>
	                <td><button type="submit" name="digit" value="1">1</button></td>
	                <td><button type="submit" name="digit" value="2">2</button></td>
	                <td><button type="submit" name="digit" value="3">3</button></td>
	            </tr>
	            <tr>
	                <td><button type="submit" name="digit" value="0">0</button></td>
	            </tr>
           	</table>
        </div>
        <div>
            <table id="sTable">
                <tr>
	                <td><button type="submit" name="digit" value="+">+</button></td>
	                <td><button type="submit" name="digit" value="-">-</button></td>
                </tr>
                <tr>
	                <td><button type="submit" name="digit" value="*">*</button></td>
	                <td><button type="submit" name="digit" value="/">/</button></td>
                </tr>
                <tr>
	                <td><button type="submit" name="digit" value="C">C</button></td>
	                <td><button type="submit" name="digit" value="=">=</button></td>
                </tr>
            </table>
        </div>
        </form>
        <div id="answerDiv">
            <div id="answerBox">
                <input type="text" name="answer" value="${result}">
            </div>
        </div>
        <div>
        	<input name="calcTotal" value="${numTotal}">
        </div>
    </div>

</body>
<style>
    #mainDiv{
        display: flex;
    }
    div{
        display: flex;
    }
    table, th, td{
        border: 1px solid black;
    }
    td{
        padding: 20px;
    }
    table{
        padding: 40px;
        margin: 2px;
    }
    input{
        /* border: 1px solid black; */
    }
    div#answerBox{
        border: 2px solid red;
    }

</style>
</html>