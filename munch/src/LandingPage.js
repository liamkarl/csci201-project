import React , {useState, useEffect} from "react";

import "./Login.css";

export default function LandingPage() {

  function handleClick(){
      window.history.pushState({}, '', '/');
      const navEvent = new PopStateEvent('popstate');
      window.dispatchEvent(navEvent);
  };

  return (
    <div className="login">
      <div className="headerspan">
        <h1 className="header">Success!</h1>
      </div>
      <button onClick={handleClick}>Return Home</button>
    </div>
  );
}
