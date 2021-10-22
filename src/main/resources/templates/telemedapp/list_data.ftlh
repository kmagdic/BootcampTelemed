<html>

<body>

List patient records:
<br/>
<p>Korisnik:</p>

    ${mail}<br/>

<table>
    <tr>
       <th>Datum</th>
       <th>Sistolički tlak</th>
       <th>Dijastolički tlak</th>
       <th>Opis</th>
    </tr>
    <#list recordList as record>

        <tr>
            <td>${record.timestamp?string["dd.MM.yyyy HH:mm"]}</td>
            <td>${record.bloodPressure1}</td>
            <td>${record.bloodPressure2}</td>
            <td>${record.description}</td>
        </tr>
    </#list>

</table>
</body>

</html>