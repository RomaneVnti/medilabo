import React, { useEffect, useState } from "react";
import axios from "axios";
import TablePatient from "../components/TablePatient";
import ButtonAdd from "../components/ButtonAdd";
import Header from "../components/Header";

function Home() {
  // État pour stocker la liste des patients récupérée depuis l'API
  const [patientDatas, setPatientDatas] = useState([]);

 // useEffect : appelé une seule fois au chargement du composant
  // pour récupérer la liste des patients
  useEffect(() => {
    getPatients();
  }, []);

  // Fonction asynchrone qui fait un appel GET pour récupérer tous les patients
  const getPatients = async () => {
    const res = await axios.get("/api/patients");
    setPatientDatas(res.data);// Mise à jour de l'état avec les données reçues
  };
  // Fonction appelée après suppression d'un patient pour rafraîchir la liste
  const deletePatient = async () => {
    getPatients();// Recharge la liste des patients depuis le serveur
  };

  return (
    <div>
      <div className="headerBlock">
        <Header />
        <ButtonAdd id="" route="/addPatient" text="Add a patient" />
      </div>
      <TablePatient patientDatas={patientDatas} onDelete={deletePatient} />
    </div>
  );
}

export default Home;
