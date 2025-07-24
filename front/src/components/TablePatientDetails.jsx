import React from "react";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

export default function TablePatientDetails({ notesDatas }) {
  return (
    notesDatas && (
      <TableContainer component={Paper}>
        <div className="patientDetails">Patient notes</div>
        <Table
          sx={{ minWidth: 300, width: "50%", mx: "auto" }}
          aria-label="notes table"
        >
          <TableHead>
            <TableRow>
              <TableCell>Notes</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {notesDatas.map((note, index) => (
              <TableRow key={index}>
                <TableCell>{note}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    )
  );
}
