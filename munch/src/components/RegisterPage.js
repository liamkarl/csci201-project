import React, { Component } from "react";

import "./RegisterPage.css";
import AuthService from "../AuthService";

export default class Register extends Component {
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
    AuthService.register(username, password)
      .then(() => {
        AuthService.login(username, password);
      })
      .then(({ response }) => {
        localStorage.setItem("user", JSON.stringify(response.data));
        window.history.pushState({}, "", "/landing");
        const navEvent = new PopStateEvent("popstate");
        window.dispatchEvent(navEvent);
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
