import React, { useState } from "react";
import axios from "axios";

// Bouton de suppression avec confirmation
const ButtonDeletePatient = ({ id, onDelete }) => {
  const [isOpen, setIsOpen] = useState(false);

// Envoie la requête de suppression puis ferme la confirmation
  const handleDelete = async () => {
    try {
      await axios.delete(`/api/patients/${id}`);
      onDelete();
    } catch (error) {
      console.error(error);
    }
    setIsOpen(false);
  };

  return (
    <>
      <button className="buttonRed" onClick={() => setIsOpen(true)}>
        Delete
      </button>
      {isOpen && (
        <div className="validationDelete">
          <div className="validationDeleteText">Are you sure ?</div>
          <button
            className="buttonRed buttonDeleteConfirm"
            onClick={handleDelete}
          >
            Yes
          </button>
          <button className="buttonBlue" onClick={() => setIsOpen(false)}>
            Cancel
          </button>
        </div>
      )}
    </>
  );
};

export default ButtonDeletePatient;
