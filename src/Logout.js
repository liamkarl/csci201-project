import React, { useState, useEffect } from "react";
import AuthService from "./AuthService";

import "./Login.css";

export default function Logout() {
  const user = JSON.parse(localStorage.getItem("user"));

  function handleClick() {
    AuthService.logout();
    window.history.pushState({}, "", "/landing");
    const navEvent = new PopStateEvent("popstate");
    window.dispatchEvent(navEvent);
  }
  return (
    <div className="login">
      <div className="headerspan">
        <h1 className="header">Logout</h1>
        <button onClick={handleClick}>Confirm Logout</button>
      </div>
    </div>
  );
}
