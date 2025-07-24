import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import AddPatient from "./pages/AddPatient";
import ModifyPatient from "./pages/ModifyPatient";
import Details from "./pages/Details";
import AddNote from "./pages/AddNote"; // n'oublie pas d'importer AddNote
import "./App.css";
import "./styles/Home.css";

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/addPatient" element={<AddPatient />} />
      <Route path="/modify/:id" element={<ModifyPatient />} />
      <Route path="/details/:id" element={<Details />} />
      <Route path="/addNote/:id" element={<AddNote />} /> {/* Ajout route pour AddNote */}
      <Route path="*" element={<Home />} />
    </Routes>
  );
};

export default App;
