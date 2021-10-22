<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="style.css">
    <title>Korisnici</title>
</head>
<style>
form {
  margin: 50px 20px 10px;
}
table{max-width: none;
  height: 200px;
  margin-top: 20px;
  border: 1px solid black;}
td {
  border: 1px solid black;
  text-align:center;
}

th {
  border: 1px solid black;
}

table,
th,
td {
  border-collapse: collapse;
}
</style>
<body>
<form action="/telemed/selectPatient">
    <div class="container">
        <label><b>Odaberite pacijenta:</b></label>
        <table id="Patients">
            <tr>
                <th>Ime i prezime</th>
                <th>E-mail adresa</th>
                <th>Datum rođenja</th>
                <th>Akcija</th>
            </tr>
            <#foreach patient in patientList>
            <tr>
                <td>${patient.name} ${patient.surname}</td>
                <td>${patient.email}</td>
                <td>${patient.date}</td>
                <td><input type="submit" value="Odabir" style="width: 100px; height:25px;"></td>
            </tr>
            </#foreach>
        </table>
    </div>
</form>
<form action="/telemed/add_patient">
    <div class="container">
        <label>Ime</label>
        <br>
        <input style="margin-top:5px;" type="text" name="name">
        <br>
        <br>
        <label>Prezime</label>
        <br>
        <input style="margin-top:5px;" type="text" name="surname">
        <br>
        <br>
        <label>E-mail</label>
        <br>
        <input style="margin-top:5px;" type="email" name="email">
        <br>
        <br>
        <label>Datum rođenja</label>
        <br>
        <input style="margin-top:5px;" type="date" name="date">
        <br>
        <br>
        <input style="margin-left:20px; padding: 5px 15px; width:100px;
        color:purple; background:white; border-color:purple;" type="submit" value="Dodaj">

    </div>
</form>
</body>

</html>


