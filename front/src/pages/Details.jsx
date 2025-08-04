import * as React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import TablePatientDetails from "../components/TablePatientDetails";
import ButtonAdd from "../components/ButtonAdd";
import ButtonBack from "../components/ButtonBack";
import Header from "../components/Header";

const Details = () => {
  const { id } = useParams(); // Récupère l'ID du patient depuis l'URL
  const [notesDatas, setNotesDatas] = useState([]); // Stocke la liste des notes du patient
  const [risksDatas, setRisksDatas] = useState([]); // Stocke les données de risque associées au patient

  // Fonction pour récupérer les notes du patient via l'API
  const getNotes = async () => {
    try {
      const response = await axios.get("/api/notes/" + id);
      setNotesDatas(response.data);// Met à jour l'état avec les notes reçues
    } catch (error) {
      console.error("Erreur lors de la récupération des notes :", error);
    }
  };
  // Fonction pour récupérer les données de risque du patient via l'API
  const getRisk = async () => {
    try {
      const response = await axios.get("/api/risks/" + id);
      setRisksDatas([response.data]);
    } catch (error) {
      console.error("Erreur lors de la récupération du risque :", error);
    }
  };
  // useEffect qui se déclenche au chargement du composant ou quand l'id change
  useEffect(() => {
    if (id) {
      getNotes();// Charge les notes
      getRisk();// Charge les risques
    }
  }, [id]);

  return (
    <div>
      <div className="headerBlock">
        <Header />
        <ButtonAdd id={id} route="/addNote/" text="Add a note" />
      </div>
      <TablePatientDetails risksDatas={risksDatas} notesDatas={notesDatas} />
      <div className="footer">
        <ButtonBack id="" route="/" text="Back" />
      </div>
    </div>
  );
};

export default Details;
