import * as React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import TablePatientDetails from "../components/TablePatientDetails";
import ButtonAdd from "../components/ButtonAdd";
import ButtonBack from "../components/ButtonBack";
import Header from "../components/Header";

const Details = () => {
  const { id } = useParams(); // Récupère l'ID du patient
  const [notesDatas, setNotesDatas] = useState([]);
  const [risksDatas, setRisksDatas] = useState([]);

  const getNotes = async () => {
    try {
      const response = await axios.get("/api/notes/" + id);
      setNotesDatas(response.data);
    } catch (error) {
      console.error("Erreur lors de la récupération des notes :", error);
    }
  };

  const getRisk = async () => {
    try {
      const response = await axios.get("/api/risks/" + id); // endpoint via gateway
      setRisksDatas([response.data]); // on enveloppe dans un tableau pour compatibilité avec TablePatientDetails
    } catch (error) {
      console.error("Erreur lors de la récupération du risque :", error);
    }
  };

  useEffect(() => {
    if (id) {
      getNotes();
      getRisk();
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
