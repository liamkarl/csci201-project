import React, { Component } from "react";
import axios from "axios";

import "./RegisterPage.css";
import AuthService from "../AuthService";

export default class Register extends Component {
  constructor(props) {
    super(props);

    this.state = {
      //email: "",
      password: "",
      //registrationErrors: "",
      username: "",
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }

  handleSubmit(event) {
    const {username, password} = this.state;

    AuthService.register(
      username,
      //email,
      password
    ) 
      .then(() => {

      })
      .catch((error) => {
        console.log("registration error", error);
      });
    event.preventDefault();
  }

  render() {
    return (
      <div className="formcard">
        <form onSubmit={this.handleSubmit}>
          {/* <div className="field">
            <input
              type="email"
              name="email"
              placeholder="Email"
              value={this.state.email}
              onChange={this.handleChange}
              required
            />
          </div> */}
          <div className="field">
            <input
              type="text"
              name="username"
              placeholder="username"
              value={this.state.username}
              onChange={this.handleChange}
              required
            />
          </div>
          <div className="field">
            <input
              type="password"
              name="password"
              placeholder="Password"
              value={this.state.password}
              onChange={this.handleChange}
              required
            />
          </div>

          <button type="submit">Register</button>
        </form>
      </div>
    );
  }
}
