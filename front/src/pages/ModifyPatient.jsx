import { useEffect, useState } from "react";
import React from "react";
import axios from "axios";
import Header from "../components/Header";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import ButtonBack from "../components/ButtonBack";

const ModifyPatient = () => {
  // Récupère les informations passées via la navigation (state)
  const location = useLocation();
  const { state } = location;
  // Récupère l'id du patient dans l'URL via useParams
  const patId = useParams();

  // État local pour stocker les données du formulaire initialisées avec les données du patient reçues via la navigation
  const [stateDatas, setStateDatas] = useState({
    firstName: state.row.firstName,
    lastName: state.row.lastName,
    birthdate: state.row.birthdate,
    gender: state.row.gender,
    address: state.row.address,
    phoneNumber: state.row.phoneNumber,
  });
  // État pour stocker les erreurs de validation retournées par le serveur
  const [errors, setErrors] = useState({});
  // Hook pour naviguer entre les pages
  const navigate = useNavigate();
  // Gestionnaire de changement dans les champs du formulaire
  const handleChange = (e) => {
    const { name, value } = e.target;
    // Mise à jour de la valeur du champ modifié dans l'état local
    setStateDatas({
      ...stateDatas,
      [name]: value,
    });

    // Si une erreur existe déjà sur ce champ, on la supprime au fur et à mesure que l'utilisateur modifie la valeur
    if (errors[name]) {
      setErrors((prevErrors) => {
        const newErrors = { ...prevErrors };
        delete newErrors[name];
        return newErrors;
      });
    }
  };
  // Gestionnaire de la soumission du formulaire
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Envoie une requête PUT pour modifier les données du patient sur le serveur
      await axios.put("/api/patients/" + patId.id, stateDatas);
      setErrors({});// Réinitialise les erreurs si la modification réussit
      navigate("/");// Redirige vers la page d'accueil après succès
    } catch (error) {
      if (error.response && error.response.status === 400) {
        setErrors(error.response.data);
      } else {
        alert("Erreur serveur, merci de réessayer plus tard.");
      }
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
            First name
            <input
              type="text"
              name="firstName"
              value={stateDatas.firstName}
              onChange={handleChange}
            />
            {errors.firstName && (
              <p style={{ color: "red" }}>{errors.firstName}</p>
            )}

            Last name
            <input
              type="text"
              name="lastName"
              value={stateDatas.lastName}
              onChange={handleChange}
            />
            {errors.lastName && (
              <p style={{ color: "red" }}>{errors.lastName}</p>
            )}

            Birthdate
            <input
              type="date"
              name="birthdate"
              value={stateDatas.birthdate}
              onChange={handleChange}
            />
            {errors.birthdate && (
              <p style={{ color: "red" }}>{errors.birthdate}</p>
            )}

            Gender
            <input
              type="text"
              name="gender"
              value={stateDatas.gender}
              onChange={handleChange}
            />
            {errors.gender && <p style={{ color: "red" }}>{errors.gender}</p>}

            Address
            <input
              type="text"
              name="address"
              value={stateDatas.address}
              onChange={handleChange}
            />
            {errors.address && <p style={{ color: "red" }}>{errors.address}</p>}

            Phone number
            <input
              type="text"
              name="phoneNumber"
              value={stateDatas.phoneNumber}
              onChange={handleChange}
            />
            {errors.phoneNumber && (
              <p style={{ color: "red" }}>{errors.phoneNumber}</p>
            )}
          </label>
          <button className="buttonGreen inputAddButton" type="submit">
            Modify
          </button>
        </form>
      </div>
      <div className="footer">
        <ButtonBack id="" route="/" text="back" />
      </div>
    </div>
  );
};

export default ModifyPatient;
