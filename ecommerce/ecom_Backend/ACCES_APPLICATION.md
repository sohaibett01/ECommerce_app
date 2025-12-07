# Guide d'accès à l'application

## 1. Démarrer l'application

```bash
mvn spring-boot:run
```

L'application démarre sur le port **8080** par défaut.

## 2. Accéder à l'API

### URL de base
```
http://localhost:8080
```

### Endpoint d'authentification (PUBLIC)
```
POST http://localhost:8080/authenticate
```

**Body (JSON):**
```json
{
  "username": "votre_email@example.com",
  "password": "votre_mot_de_passe"
}
```

**Réponse (succès):**
```json
{
  "userId": 1,
  "role": "ADMIN",
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Utiliser le token JWT

Pour accéder aux autres endpoints protégés, ajoutez le header :
```
Authorization: Bearer {votre_token_jwt}
```

**Exemple avec cURL:**
```bash
curl -X POST http://localhost:8080/authenticate \
  -H "Content-Type: application/json" \
  -d '{"username":"email@example.com","password":"password"}'
```

**Exemple avec Postman:**
1. Méthode: POST
2. URL: `http://localhost:8080/authenticate`
3. Headers: `Content-Type: application/json`
4. Body (raw JSON):
```json
{
  "username": "email@example.com",
  "password": "password"
}
```

## 3. Endpoints protégés

Tous les autres endpoints nécessitent le token JWT dans le header:
```
Authorization: Bearer {token}
```

## 4. Vérifier que l'application fonctionne

Ouvrez votre navigateur ou utilisez Postman/Insomnia pour tester l'endpoint `/authenticate`.

