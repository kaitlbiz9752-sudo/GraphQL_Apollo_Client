import { useQuery } from "@apollo/client";
import { GET_ALL_COMPTES } from "../graphql/queries";

const CompteList = () => {
  // Exécution de la requête GraphQL
  const { loading, error, data } = useQuery(GET_ALL_COMPTES);

  // Pendant le chargement
  if (loading) return <p>Chargement...</p>;

  // En cas d’erreur
  if (error) return <p>Erreur : {error.message}</p>;

  return (
    <div className="bg-white p-4 rounded shadow">
      <h2 className="text-xl font-bold mb-4">Liste des comptes</h2>

      {data.obtenirTousLesComptes.map((compte) => (
        <div
          key={compte.id}
          className="border p-3 mb-3 rounded bg-gray-50"
        >
          <p><b>ID :</b> {compte.id}</p>
          <p><b>Solde :</b> {compte.solde} DH</p>
          <p><b>Type :</b> {compte.type}</p>
        </div>
      ))}
    </div>
  );
};

export default CompteList;
