<html>
<head>

</head>
<body>

<#list patientList as patients>
${patients.name} - ${patients.surname} - ${patients.email} - ${patients.date} <br>
</#list>


</body>
</html>