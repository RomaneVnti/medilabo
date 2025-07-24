import React from "react";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import AddPatient from "./pages/AddPatient";
import ModifyPatient from "./pages/ModifyPatient";
import "./App.css";
import "./styles/Home.css";

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/addPatient" element={<AddPatient />} />
      <Route path="/modify/:id" element={<ModifyPatient />} />
      <Route path="*" element={<Home />} />
    </Routes>
  );
};

export default App;
