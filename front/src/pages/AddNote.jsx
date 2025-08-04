import { useEffect, useState } from "react";
import React from "react";
import axios from "axios";
import Header from "../components/Header";
import { useNavigate, useParams } from "react-router-dom";
import ButtonBack from "../components/ButtonBack";

// Composant pour ajouter une note à un patient
const AddNote = () => {
  const { id } = useParams(); // Récupère l'identifiant du patient depuis l'URL
  const navigate = useNavigate();

  const [patientDatas, setPatientDatas] = useState(null); // Stocke les données du patient

  // Récupère les infos du patient au chargement du composant
  useEffect(() => {
    const getPatient = async () => {
      try {
        const res = await axios.get("/api/patients/" + id);
        setPatientDatas(res.data);
      } catch (error) {
        console.error("Erreur récupération patient:", error);
      }
    };

    if (id) getPatient();
  }, [id]);

  // État local pour le formulaire
  const [state, setState] = useState({
    patId: "",
    patient: "",
    note: "",
  });
  // Gère les changements dans le champ de saisie
  const handleChange = (e) => {
    const value = e.target.value;
    setState({
      ...state,
      [e.target.name]: value,
    });
  };
  // Envoie de la note au backend
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const noteData = {
        patId: id,
        patient: patientDatas ? patientDatas.firstName : "",
        note: state.note,
      };
      const response = await axios.post("/api/notes", noteData);
      console.log(response.status, response.data);
      navigate("/details/" + id); // Redirige vers la page de détails du patient
    } catch (error) {
      console.error("Erreur lors de l'ajout de note :", error);
    }
  };

  return (
    <div>
      <div className="headerBlock">
        <Header />
      </div>
      <div className="inputPage">
        <form onSubmit={handleSubmit}>
          <label>
            <p>Notes</p>
            <textarea
              className="inputNote"
              type="text"
              name="note"
              value={state.note}
              onChange={handleChange}
              required
            />
          </label>
          <button className="buttonGreen inputAddButton" type="submit">
            Add
          </button>
        </form>
      </div>
      <div className="footer">
        <ButtonBack id={id} route="/details/" text="Back to details" />
      </div>
    </div>
  );
};

export default AddNote;
