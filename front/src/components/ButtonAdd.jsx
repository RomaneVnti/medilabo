import * as React from "react";

const ButtonAdd = ({ id, route, text }) => {

  return (
    <a className="linkButton ButtonAdd buttonGreen" href={route + id}>
      {text}
    </a>
  );
};
export default ButtonAdd;