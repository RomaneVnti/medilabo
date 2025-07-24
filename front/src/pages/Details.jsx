import * as React from "react";
import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import TablePatientDetails from "../components/TablePatientDetails";
import ButtonAdd from "../components/ButtonAdd";
import ButtonBack from "../components/ButtonBack";
import Header from "../components/Header";

const Details = () => {
  const [notesDatas, setNotesDatas] = useState([]);
  const { id } = useParams();

  const getNotes = async () => {
    try {
      const response = await axios.get("/api/notes/" + id);
      setNotesDatas(response.data);
    } catch (error) {
      console.error("Erreur lors de la récupération des notes :", error);
    }
  };

  React.useEffect(() => {
    if (id) getNotes();
  }, [id]);

  return (
    <div>
      <div className="headerBlock">
        <Header />
        <ButtonAdd id={id} route="/addNote/" text="Add a note" />
      </div>
      <TablePatientDetails notesDatas={notesDatas} />
      <div className="footer">
        <ButtonBack id="" route="/" text="Back" />
      </div>
    </div>
  );
};

export default Details;
