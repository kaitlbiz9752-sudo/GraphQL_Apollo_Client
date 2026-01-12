# Requêtes GraphQL pour le Service Bancaire

## Accès à l'interface GraphiQL
Une fois l'application démarrée, accédez à l'interface GraphiQL à l'adresse :
- **URL GraphiQL**: http://localhost:8086/graphiql
- **Endpoint GraphQL**: http://localhost:8086/graphql (POST)
- **Console H2**: http://localhost:8086/h2-console (JDBC URL: jdbc:h2:mem:banque)

## Requêtes (Queries)

### 1. Obtenir tous les comptes
```graphql
query {
  obtenirTousLesComptes {
    id
    solde
    dateCreation
    type
  }
}
```

### 2. Obtenir un compte par ID
```graphql
query {
  recupererCompteParId(id: 1) {
    id
    solde
    dateCreation
    type
  }
}
```

### 3. Obtenir les statistiques des soldes
```graphql
query {
  obtenirStatistiquesSoldes {
    nombreComptes
    totalSoldes
    moyenneSoldes
  }
}
```

### 4. Requête combinée (tous les comptes + statistiques)
```graphql
query {
  obtenirTousLesComptes {
    id
    solde
    dateCreation
    type
  }
  obtenirStatistiquesSoldes {
    nombreComptes
    totalSoldes
    moyenneSoldes
  }
}
```

## Mutations

### 5. Créer un nouveau compte courant
```graphql
mutation {
  creerCompte(input: {
    solde: 3000.0
    dateCreation: "2024-12-01"
    type: COURANT
  }) {
    id
    solde
    dateCreation
    type
  }
}
```

### 6. Créer un nouveau compte épargne
```graphql
mutation {
  creerCompte(input: {
    solde: 10000.0
    dateCreation: "2024-12-15"
    type: EPARGNE
  }) {
    id
    solde
    dateCreation
    type
  }
}
```

### 7. Créer un compte avec date automatique (laisser dateCreation vide)
```graphql
mutation {
  creerCompte(input: {
    solde: 7500.0
    type: COURANT
  }) {
    id
    solde
    dateCreation
    type
  }
}
```

## Exemples de requêtes avec variables

### 8. Query avec variables (recommandé)
```graphql
query GetCompteById($compteId: ID!) {
  recupererCompteParId(id: $compteId) {
    id
    solde
    dateCreation
    type
  }
}
```

**Variables JSON:**
```json
{
  "compteId": "1"
}
```

### 9. Mutation avec variables (recommandé)
```graphql
mutation CreateCompte($input: CompteInput!) {
  creerCompte(input: $input) {
    id
    solde
    dateCreation
    type
  }
}
```

**Variables JSON:**
```json
{
  "input": {
    "solde": 5000.0,
    "dateCreation": "2024-12-20",
    "type": "EPARGNE"
  }
}
```

## Notes importantes

1. **Format des dates**: Utilisez le format ISO-8601 (YYYY-MM-DD) pour les dates
2. **Types de comptes**: Les valeurs possibles sont `COURANT` ou `EPARGNE`
3. **ID**: Les IDs sont numériques, mais peuvent être passés comme chaînes dans GraphQL
4. **Données initiales**: Le DataInitializer crée 5 comptes de test au démarrage de l'application
5. **GraphiQL**: L'interface GraphiQL permet de tester les requêtes interactivement avec auto-complétion

## Erreurs courantes

- Si vous obtenez une erreur "Compte not found", vérifiez que l'ID existe
- Pour les mutations, assurez-vous que le type de compte est en majuscules (COURANT ou EPARGNE)
- Les dates doivent être au format "YYYY-MM-DD"

