# Frontend JSP - Patients

Cette iteration ajoute une interface JSP qui consomme l'API REST existante des patients.

## Points d'entree

- Page JSP: `http://localhost:8080/patients-ui`
- API REST existante: `http://localhost:8080/patients`

## Fichiers ajoutes/modifies

- `pom.xml`: support JSP/JSTL + packaging `war`
- `src/main/resources/application.properties`: prefix/suffix des vues JSP
- `src/main/java/dev/exemple_spring_boot/controller/PatientPageController.java`: route MVC de page
- `src/main/webapp/WEB-INF/views/patients.jsp`: page CRUD (liste/ajout/suppression) via `fetch`
- `src/main/java/dev/exemple_spring_boot/entities/Patient.java`: `@JsonIgnore` sur `rendezVous`

## Lancer

Prerequis: MySQL en local avec la base `cabinet_db` accessible selon `application.properties`.

```powershell
.\mvnw.cmd spring-boot:run
```

Puis ouvrir:

- `http://localhost:8080/patients-ui`

## Validation rapide effectuee

- Packaging sans tests: `mvnw package -DskipTests` -> OK
- Tests `mvnw test` -> echec local (connexion MySQL refusee)

