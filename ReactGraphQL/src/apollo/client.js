import { ApolloClient, InMemoryCache, createHttpLink } from "@apollo/client";

// Lien vers l'API GraphQL (backend)
// En développement, utilise le proxy configuré dans package.json (localhost:8086)
// En production, vous pouvez utiliser directement l'URL du backend
const httpLink = createHttpLink({
  uri: process.env.REACT_APP_GRAPHQL_URI || "/graphql",
});

// Configuration du client Apollo pour la communication avec le backend
export const client = new ApolloClient({
  link: httpLink,
  cache: new InMemoryCache(),
  defaultOptions: {
    watchQuery: {
      errorPolicy: "all",
    },
    query: {
      errorPolicy: "all",
    },
    mutate: {
      errorPolicy: "all",
    },
  },
});
