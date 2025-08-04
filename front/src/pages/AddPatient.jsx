import { useState } from "react";
import React from "react";
import axios from "axios";
import Header from "../components/Header";
import { useNavigate } from "react-router-dom";
import ButtonBack from "../components/ButtonBack";

// Formulaire d'ajout d'un nouveau patient
const AddPatient = () => {
  // État du formulaire
  const [state, setState] = useState({
    firstName: "",
    lastName: "",
    birthdate: "",
    gender: "",
    address: "",
    phoneNumber: "",
  });

  // État pour les erreurs de validation côté serveur
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  // Gère les changements dans les champs du formulaire
  const handleChange = (e) => {
    const { name, value } = e.target;
    setState({
      ...state,
      [name]: value,
    });

    // Supprime l'erreur associée au champ modifié (si existante)
    if (errors[name]) {
      setErrors((prevErrors) => {
        const newErrors = { ...prevErrors };
        delete newErrors[name];
        return newErrors;
      });
    }
  };

  // Soumission du formulaire
  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
const response = await axios.post("/api/patients", state);
      console.log(response.status, response.data);
      setErrors({});
      navigate("/");
    } catch (error) {
      if (error.response && error.response.status === 400) {
        setErrors(error.response.data);
      } else {
        alert("Erreur serveur, veuillez réessayer plus tard.");
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
              value={state.firstName}
              onChange={handleChange}
            />
            {errors.firstName && <p style={{ color: "red" }}>{errors.firstName}</p>}

            Last name
            <input
              type="text"
              name="lastName"
              value={state.lastName}
              onChange={handleChange}
            />
            {errors.lastName && <p style={{ color: "red" }}>{errors.lastName}</p>}

            Birthdate
            <input
              type="date"
              name="birthdate"
              value={state.birthdate}
              onChange={handleChange}
            />
            {errors.birthdate && <p style={{ color: "red" }}>{errors.birthdate}</p>}

            Gender
            <input
              type="text"
              name="gender"
              value={state.gender}
              onChange={handleChange}
            />
            {errors.gender && <p style={{ color: "red" }}>{errors.gender}</p>}

            Address
            <input
              type="text"
              name="address"
              value={state.address}
              onChange={handleChange}
            />
            {errors.address && <p style={{ color: "red" }}>{errors.address}</p>}

            Phone number
            <input
              type="text"
              name="phoneNumber"
              value={state.phoneNumber}
              onChange={handleChange}
            />
            {errors.phoneNumber && <p style={{ color: "red" }}>{errors.phoneNumber}</p>}
          </label>
          <button className="buttonGreen inputAddButton" type="submit">
            Add
          </button>
        </form>
      </div>
      <div className="footer">
        <ButtonBack id="" route="/" text="Back" />
      </div>
    </div>
  );
};

export default AddPatient;
