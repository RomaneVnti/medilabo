import React, { useState } from "react";
import axios from "axios";

const ButtonDeletePatient = ({ id, onDelete }) => {
  const [isOpen, setIsOpen] = useState(false);

  const handleDelete = async () => {
    try {
      await axios.delete(`/api/patients/${id}`);
      onDelete(); // ❗ on rafraîchit la liste dans Home
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
