import React from "react";

import LoginPage from "./components/LoginPage";

import "./Login.css";

export default function Login() {
  return (
    <div className="login">
      <div className="headerspan">
        <h1 className="header">Login Page</h1>
      </div>
      <LoginPage />
    </div>
  );
}
