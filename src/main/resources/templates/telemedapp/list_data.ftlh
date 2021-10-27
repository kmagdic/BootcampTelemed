<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <title>Zapisi pacijenta</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
<div class="container">
<form action="/telemedapp/select_patient">
        <div class="vieWForm">
        <div class="header">
        <img class="logo" src="../telemedapp/logoMegi.png">
        </div>
        <h2>Korisnik:</h2>
            ${patient.email}<br/>
        <div class="col-md-12">
            <a href="/telemedapp/" class="btn btn-secondary">Dodaj novi zapis</a>
        </div>
        <h1>Zapisi pacijenta</h1>
<table class="table table-striped table-hover">
     <thead><tr>
       <th>Datum</th>
       <th>Sistolički tlak</th>
       <th>Dijastolički tlak</th>
       <th>Opis</th>
    </tr></thead>
    <#list recordList as record>
        <tr>
            <td>${record.timestamp?string["dd.MM.yyyy hh:mm"]}</td>
            <td>${record.bloodPressure1}</td>
            <td>${record.bloodPressure2}</td>
            <td>${record.description}</td>
        </tr>
    </#list>
</table>
</body>
</html>