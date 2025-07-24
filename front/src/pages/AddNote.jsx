import { useEffect, useState } from "react";
import React from "react";
import axios from "axios";
import Header from "../components/Header";
import { useNavigate, useParams } from "react-router-dom";
import ButtonBack from "../components/ButtonBack";

const AddNote = () => {
  const { id } = useParams(); // id du patient
  const navigate = useNavigate();

  const [patientDatas, setPatientDatas] = useState(null);

  useEffect(() => {
    const getPatient = async () => {
      try {
        // Correction : ajout slash avant api
        const res = await axios.get("/api/patients/" + id);
        setPatientDatas(res.data);
      } catch (error) {
        console.error("Erreur récupération patient:", error);
      }
    };

    if (id) getPatient();
  }, [id]);

  const [state, setState] = useState({
    patId: "",
    patient: "",
    note: "",
  });

  const handleChange = (e) => {
    const value = e.target.value;
    setState({
      ...state,
      [e.target.name]: value,
    });
  };

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
      navigate("/details/" + id);
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
