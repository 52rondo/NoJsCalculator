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
            <table>
            
            <tr>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="1" hidden><button>111</button></td></form>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="2" hidden><button>2</button></td></form>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="3" hidden><button>3</button></td></form>
            </tr>
            <tr>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="4" hidden><button>4</button></td></form>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="5" hidden><button>5</button></td></form>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="6" hidden><button>6</button></td></form>
            </tr>
            <tr>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="7" hidden><button>7</button></td></form>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="8" hidden><button>8</button></td></form>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="9" hidden><button>9</button></td></form>
            </tr>
            <tr>
                <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="0" hidden><button>0</button></td></form>
            </tr>
                
            </table>
        </div>
        <div>
            <table id="sTable">
                <tr>
                    <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="+" hidden><button>+</button></td></form>
                    <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="-" hidden><button>-</button></td></form>
                </tr>
                <tr>
                    <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="*" hidden><button>*</button></td></form>
                    <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="/" hidden><button>/</button></td></form>
                </tr>
                <tr>
                    <form action="${pageContext.request.contextPath}/Calculator"><td><input type="text" name="number" value="=" hidden><button>==</button></td></form>
                
                </tr>
            </table>
        </div>
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
        border: 1px solid black;
    }
    div#answerBox{
        border: 2px solid red;
    }

</style>
</html>