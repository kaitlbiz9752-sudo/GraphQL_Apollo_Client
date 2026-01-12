import CompteList from "./components/CompteList";
import CreateCompte from "./components/CreateCompte";

function App() {
  return (
    <div className="min-h-screen bg-gray-100 p-6">
      <h1 className="text-3xl font-bold text-center mb-6">
        Gestion des Comptes
      </h1>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        <CreateCompte />
        <CompteList />
      </div>
    </div>
  );
}

export default App;
