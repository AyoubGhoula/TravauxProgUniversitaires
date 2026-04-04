# TP5 - Systeme de gestion de bibliotheque (Spring Boot)

Projet Spring Boot avec architecture en couches:
- `controller`
- `service`
- `repository`
- `entity`

## Fonctionnalites
- CRUD `Livre`
- CRUD `Membre`
- Emprunt d'un livre (si disponible)
- Retour d'un livre
- Authentification JWT (`/auth/login`)
- Securite stateless (tous les endpoints sauf `/auth/**` proteges)
- Validation des requetes et gestion centralisee des erreurs

## Stack
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (`jjwt`)
- H2 in-memory

## Compte de connexion par defaut
- Username: `admin`
- Password: `admin123`

## Endpoints principaux
- `POST /auth/login`
- `GET/POST/PUT/DELETE /api/livres`
- `GET/POST/PUT/DELETE /api/membres`
- `GET /api/emprunts`
- `POST /api/emprunts/borrow`
- `POST /api/emprunts/{id}/return`

## Lancer les tests
```bash
./mvnw test
```

## Lancer l'application
```bash
./mvnw spring-boot:run
```

## Exemple rapide
1. Appeler `POST /auth/login` pour recuperer un token JWT.
2. Utiliser `Authorization: Bearer <token>` pour les endpoints `/api/**`.

