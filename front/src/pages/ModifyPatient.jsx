import { useEffect, useState } from "react";
import React from "react";
import axios from "axios";
import Header from "../components/Header";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import ButtonBack from "../components/ButtonBack";

const ModifyPatient = () => {
  const location = useLocation();
  const { state } = location;
  const patId = useParams();

  const [stateDatas, setStateDatas] = useState({
    firstName: state.row.firstName,
    lastName: state.row.lastName,
    birthdate: state.row.birthdate,
    gender: state.row.gender,
    address: state.row.address,
    phoneNumber: state.row.phoneNumber,
  });

  // Nouveau state pour les erreurs
  const [errors, setErrors] = useState({});

  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStateDatas({
      ...stateDatas,
      [name]: value,
    });

    if (errors[name]) {
      setErrors((prevErrors) => {
        const newErrors = { ...prevErrors };
        delete newErrors[name];
        return newErrors;
      });
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put("/api/patients/" + patId.id, stateDatas);
      setErrors({}); // Reset errors on success
      navigate("/");
    } catch (error) {
      if (error.response && error.response.status === 400) {
        setErrors(error.response.data); // Récupère les erreurs de validation du backend
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
