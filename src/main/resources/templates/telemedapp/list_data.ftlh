<html>


<body>
List patient records:
<br/>

<#list recordList as record>
${record.timestamp?string["dd.MM.yyyy HH:mm"]} -  ${record.email} - ${record.bloodPressure1} - ${record.bloodPressure2} - ${record.description} <br/>

</#list>
</table>

</body>

</html>