import { gql } from "@apollo/client";

// Créer un compte
export const SAVE_COMPTE = gql`
  mutation CreerCompte($input: CompteInput!) {
    creerCompte(input: $input) {
      id
      solde
      dateCreation
      type
    }
  }
`;
