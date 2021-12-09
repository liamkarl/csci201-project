import React, { Component } from "react";
import axios from "axios";
import { userData } from "./userData.js";
import "./Account.css";
import { Form } from "react-bootstrap";

export default class ViewAccount extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: "",
      userBio: "",
      profPic: "",
      numPosts: "",
      numFollowers: "",
      numFollowing: "",
    };
  }


  handleSubmit(event) {}

  render() {
    const user = JSON.parse(localStorage.getItem('user'));
    let { username } = user;
    console.log(user);
    return (
      <div className="accountpage">
        {/* <img src={profPic} className="pfp"></img> */}
        <h2 className="textblock">{username}</h2>
        {/* <div className="follow">
          {numFollowers} followers {numFollowing} following
        </div>
        <div className="bio">{userBio}</div>

        <form onSubmit={this.handleSubmit}>
          <button type="submit"> Follow </button>
        </form> */}
      </div>
    );
  }
}
