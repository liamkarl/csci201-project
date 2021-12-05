import React from "react";

import RegisterPage from "./components/RegisterPage";
import "./Register.css";

export default function Register() {
  return (
    <div>
      <div className="headerspan">
        <h1 className="header">Register</h1>
      </div>
      <RegisterPage />
    </div>
  );
}
