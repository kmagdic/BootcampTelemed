<html>
<head>

</head>
<body>
    <h3>List ToDo elemenata:</h3>
    <br/>

    <#list todoList as todo>
        ${todo} <br/>
    </#list>

    <br/><br/>
    <a href="/todoapp/" >Add new item</a>

</body>


</html>