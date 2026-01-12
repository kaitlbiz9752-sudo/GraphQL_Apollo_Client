import { useState } from "react";
import { useMutation } from "@apollo/client";
import { SAVE_COMPTE } from "../graphql/mutations";
import { GET_ALL_COMPTES } from "../graphql/queries";

const CreateCompte = () => {
  // États du formulaire
  const [solde, setSolde] = useState("");
  const [type, setType] = useState("COURANT");

  // Mutation GraphQL
  const [saveCompte] = useMutation(SAVE_COMPTE, {
    refetchQueries: [{ query: GET_ALL_COMPTES }], // Rafraîchir la liste
  });

  // Soumission du formulaire
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await saveCompte({
        variables: {
          input: {
            solde: parseFloat(solde),
            type,
          },
        },
      });

      // Réinitialiser le formulaire
      setSolde("");
      setType("COURANT");
    } catch (error) {
      console.error("Erreur lors de la création du compte:", error);
    }
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="bg-white p-4 rounded shadow"
    >
      <h2 className="text-xl font-bold mb-4">Créer un compte</h2>

      <input
        type="number"
        placeholder="Solde initial"
        value={solde}
        onChange={(e) => setSolde(e.target.value)}
        className="w-full p-2 border rounded mb-3"
        required
      />

      <select
        value={type}
        onChange={(e) => setType(e.target.value)}
        className="w-full p-2 border rounded mb-3"
      >
        <option value="COURANT">Courant</option>
        <option value="EPARGNE">Épargne</option>
      </select>

      <button
        type="submit"
        className="bg-blue-600 text-white px-4 py-2 rounded"
      >
        Créer
      </button>
    </form>
  );
};

export default CreateCompte;
