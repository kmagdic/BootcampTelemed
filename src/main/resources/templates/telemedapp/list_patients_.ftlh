<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <title>Popis pacijenata</title>
    <link rel="stylesheet" href="../telemedapp/style.css">
    <#setting date_format="dd-MM-yyyy">
</head>

<body>
<div class="container">
<form action="/telemedapp/select_patient">
        <div class="vieWForm">
        <div class="header">
        <img class="logo" src="../telemedapp/logoMegi.png">
        <h1>Popis pacijenata</h1>
        </div>

        <table class="table table-striped table-hover" id="Patients">
            <thead><tr>
                <th>Ime i prezime</th>
                <th>E-mail adresa</th>
                <th>Datum rođenja</th>
                <th class="action" colspan="2">Akcija</th>
                 </tr></thead>

            <#foreach patient in patientList>
            <tr>
                <td>${patient.name} ${patient.surname}</td>
                <td>${patient.email}</td>
                <td>${patient.dateOfBirth?string["dd.MM.yyyy"]}</td>
                <td><div class="action"><a class="btn btn-odabir" href="../telemedapp/delete_patient?email=${patient.email}">Obriši</a><a class="btn btn-odabir" href="../telemedapp/select_patient?email=${patient.email}">Odabir</a></div></td>
            </tr>
            </#foreach>

        </table>
    </div>
</form>

<form action="/telemedapp/add_patient">
    <div class="enterForm">
    <form class="row g-3" action="/telemedapp/save_data">

            <div class="col-md-6">
                <label class="form-label">Ime</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="col-md-6">
                <label class="form-label">Prezime</label>
                <input type="text" name="surname" class="form-control" required>
            </div>

            <div class="col-md-6">
                <label class="form-label">E-mail</label>
                <input type="email" name="email" class="form-control" #if(patient.getEmail().equals(email)) required>
            </div>

            <div class="col-md-6">
                 <label class="form-label">Datum rođenja</label>
                 <input type="date" name="date" class="form-control" required>
            </div>

            <div class="col-6">
                <button type="submit" class="btn btn-secondary">Dodaj</button>
            </div>
        </div>
    </div>
</form>
</div>

</body>
</html>

