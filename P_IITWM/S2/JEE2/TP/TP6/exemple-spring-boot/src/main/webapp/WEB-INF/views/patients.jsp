<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Gestion des Patients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center mb-4">Gestion des Patients (JSP)</h2>

    <div id="alertBox" class="alert d-none" role="alert"></div>

    <div class="card p-4 mb-4 shadow-sm">
        <h5>Ajouter un patient</h5>
        <form id="patientForm" class="row g-2">
            <div class="col-md-3">
                <input id="nom" type="text" class="form-control" placeholder="Nom" required />
            </div>
            <div class="col-md-3">
                <input id="prenom" type="text" class="form-control" placeholder="Prenom" required />
            </div>
            <div class="col-md-3">
                <input id="email" type="email" class="form-control" placeholder="Email" required />
            </div>
            <div class="col-md-2">
                <input id="adresse" type="text" class="form-control" placeholder="Adresse" required />
            </div>
            <div class="col-md-1 d-grid">
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </div>
        </form>
    </div>

    <div class="card shadow-sm">
        <div class="card-body">
            <table class="table table-striped" id="patientsTable">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Email</th>
                    <th>Adresse</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody id="patientsBody"></tbody>
            </table>
        </div>
    </div>
</div>

<script>
    const apiUrl = '/patients';

    function showAlert(message, type) {
        const box = document.getElementById('alertBox');
        box.className = 'alert alert-' + type;
        box.textContent = message;
    }

    async function loadPatients() {
        const res = await fetch(apiUrl);
        if (!res.ok) {
            throw new Error('Chargement des patients impossible');
        }

        const patients = await res.json();
        const body = document.getElementById('patientsBody');
        body.innerHTML = '';

        patients.forEach(p => {
            const row = document.createElement('tr');
            row.innerHTML =
                '<td>' + p.id + '</td>' +
                '<td>' + p.nom + '</td>' +
                '<td>' + p.prenom + '</td>' +
                '<td>' + p.email + '</td>' +
                '<td>' + p.adresse + '</td>' +
                '<td><button class="btn btn-danger btn-sm" onclick="deletePatient(' + p.id + ')">Supprimer</button></td>';
            body.appendChild(row);
        });
    }

    async function deletePatient(id) {
        const res = await fetch(apiUrl + '/' + id, { method: 'DELETE' });
        if (!res.ok) {
            showAlert('Suppression impossible', 'danger');
            return;
        }
        showAlert('Patient supprime', 'success');
        await loadPatients();
    }

    document.getElementById('patientForm').addEventListener('submit', async (event) => {
        event.preventDefault();

        const payload = {
            nom: document.getElementById('nom').value,
            prenom: document.getElementById('prenom').value,
            email: document.getElementById('email').value,
            adresse: document.getElementById('adresse').value
        };

        const res = await fetch(apiUrl, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });

        if (!res.ok) {
            showAlert('Creation impossible', 'danger');
            return;
        }

        event.target.reset();
        showAlert('Patient ajoute', 'success');
        await loadPatients();
    });

    loadPatients().catch(() => showAlert('Erreur lors du chargement initial', 'danger'));
</script>
</body>
</html>

