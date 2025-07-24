import * as React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { useEffect } from "react";

export default function TablePatientDetails({ risksDatas, notesDatas }) {
  useEffect(() => {
  }, [risksDatas, notesDatas]);

  const risk = risksDatas?.[0]?.[0];

  if (!risk || !notesDatas) {
    return <p>Chargement des données...</p>;
  }

  return (
    <TableContainer component={Paper}>
      <div className="patientDetails">Patient details</div>
      <Table
        sx={{ minWidth: 300, width: "50%", mx: "auto" }}
        aria-label="simple table"
        title="Patient Details"
      >
        <TableHead>
          <TableRow>
            <TableCell align="center">Age</TableCell>
            <TableCell align="center">Risk</TableCell>
            <TableCell>Notes</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          <TableRow key={risk.patId}>
            <TableCell align="center">{risk.age ?? "N/A"}</TableCell>
            <TableCell align="center">{risk.risk ?? "N/A"}</TableCell>
            <TableCell>
              {notesDatas.map((n, index) => (
                <p key={index}>- {n}</p>
              ))}
            </TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </TableContainer>
  );
}
