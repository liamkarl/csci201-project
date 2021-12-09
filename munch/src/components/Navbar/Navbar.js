import "./Navbar.css";

import React, { useState } from "react";
import { Link } from "react-router-dom";

import { IconContext } from "react-icons";
import { FaBars } from "react-icons/fa";
import { AiOutlineClose } from "react-icons/ai";
import { MdRamenDining } from "react-icons/md";

import { NavbarData } from "./NavbarData";
import { NavbarDataLoggedIn } from "./NavbarDataLoggedIn";
export default function Navbar() {
  const [navbar, setNavbar] = useState(false);

  const showNavbar = () => setNavbar(!navbar);
  const user = JSON.parse(localStorage.getItem("user"));

  if (!user) {
    return (
      <>
        <IconContext.Provider value={{ color: "white" }}>
          <div className="navbar">
            <Link to="#" className="menu-open">
              <FaBars onClick={showNavbar} />
            </Link>
            <span className="title">
              <Link to="/" className="munch-link">
                <h2 className="munch">Munch</h2>
              </Link>
              <IconContext.Provider value={{ color: "#ed9b14" }}>
                <MdRamenDining className="logo" />
              </IconContext.Provider>
            </span>
          </div>
          <nav className={navbar ? "nav-menu active" : "nav-menu"}>
            <ul className="nav-menu-items" onClick={showNavbar}>
              <li className="navbar-toggle">
                <Link to="#" className="menu-close">
                  <AiOutlineClose />
                </Link>
              </li>
            </ul>
            {NavbarData.map((bar, index) => {
              return (
                <li className={bar.className} key={index} onClick={showNavbar}>
                  <Link to={bar.path}>
                    {bar.icon}
                    <span>{bar.title}</span>
                  </Link>
                </li>
              );
            })}
          </nav>
        </IconContext.Provider>
      </>
    );
  } else {
    return (
      <>
        <IconContext.Provider value={{ color: "white" }}>
          <div className="navbar">
            <Link to="#" className="menu-open">
              <FaBars onClick={showNavbar} />
            </Link>
            <span className="title">
              <Link to="/" className="munch-link">
                <h2 className="munch">Munch</h2>
              </Link>
              <IconContext.Provider value={{ color: "#ed9b14" }}>
                <MdRamenDining className="logo" />
              </IconContext.Provider>
            </span>
          </div>
          <nav className={navbar ? "nav-menu active" : "nav-menu"}>
            <ul className="nav-menu-items" onClick={showNavbar}>
              <li className="navbar-toggle">
                <Link to="#" className="menu-close">
                  <AiOutlineClose />
                </Link>
              </li>
            </ul>
            {NavbarDataLoggedIn.map((bar, index) => {
              return (
                <li className={bar.className} key={index} onClick={showNavbar}>
                  <Link to={bar.path}>
                    {bar.icon}
                    <span>{bar.title}</span>
                  </Link>
                </li>
              );
            })}
          </nav>
        </IconContext.Provider>
      </>
    );
  }
}
