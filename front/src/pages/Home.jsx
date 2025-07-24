import React, { useEffect, useState } from "react";
import axios from "axios";
import TablePatient from "../components/TablePatient";
import ButtonAdd from "../components/ButtonAdd";
import Header from "../components/Header";

function Home() {
  const [patientDatas, setPatientDatas] = useState([]);

  useEffect(() => {
    getPatients();
  }, []);

  const getPatients = async () => {
    const res = await axios.get("/api/patients");
    setPatientDatas(res.data);
  };

  const deletePatient = async () => {
    getPatients();
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
