import React, { Component } from "react";
import axios from "axios";

import './LoginPage.css'
import AuthService from "../AuthService";

export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {

      username: "",
      password: "",
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

    const { username, password } = this.state;

    AuthService.login(username, password)
      .then(() => {
        
      })
      .catch((error) => {
        console.log("login error", error);
      });
    event.preventDefault();
  }

  render() {
    return (
      <div className="formcard">
        <form onSubmit={this.handleSubmit}>
          <div className="field">
            <input
              type="text"
              name="username"
              placeholder="Username"
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
          <button type="submit">Login</button>
        </form>
      </div>
    );
  }
}
