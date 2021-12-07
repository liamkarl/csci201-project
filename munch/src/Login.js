import React , {useState, useEffect} from "react";

import LoginPage from "./components/LoginPage";

import "./Login.css";

export default function Login() {
  const user = JSON.parse(localStorage.getItem('user'));

  useEffect(() => {
    if(user){
      window.history.pushState({}, '', '/');
      const navEvent = new PopStateEvent('popstate');
      window.dispatchEvent(navEvent);
    }
  });
  return (
    <div className="login">
      <div className="headerspan">
        <h1 className="header">Login Page</h1>
      </div>
      <LoginPage/>
    </div>
  );
}
