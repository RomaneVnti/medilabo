import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import AddPatient from "./pages/AddPatient";
import ModifyPatient from "./pages/ModifyPatient";
import Details from "./pages/Details";
import AddNote from "./pages/AddNote";
import "./App.css";
import "./styles/Home.css";

const App = () => {
  return (
    <Routes>
          {/* Route pour la page d'accueil */}
      <Route path="/" element={<Home />} />
            {/* Route pour ajouter un nouveau patient */}
      <Route path="/addPatient" element={<AddPatient />} />
            {/* Route pour modifier un patient existant */}
      <Route path="/modify/:id" element={<ModifyPatient />} />
            {/* Route pour afficher les détails d'un patient avec son id */}
      <Route path="/details/:id" element={<Details />} />
            {/* Route pour ajouter une note à un patient spécifique */}
      <Route path="/addNote/:id" element={<AddNote />} />
            {/* Si aucune des routes précédentes ne correspond, redirige vers Home */}
      <Route path="*" element={<Home />} />
    </Routes>
  );
};

export default App;
