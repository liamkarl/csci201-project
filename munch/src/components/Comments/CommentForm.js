import React, { Component, useState } from "react";
import axios from "axios";

import "./CommentForm.css";
import AuthHeader from "../../AuthHeader";

export default class Form extends Component {
  constructor(props) {
    super(props);

    this.state = {
      comment: "",
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
    const { comment } = this.state;
    console.log(comment);
    // axios
    //   .post("http://localhost:8080/api/post/create", {
    //
    //     comment: comment
    //}

    //   .then((response) => {
    //     console.log(response);
    //   })
    //   .catch((error) => {
    //     console.log("login error", error);
    //   });
    // event.preventDefault();
  }

  render() {
    const user = JSON.parse(localStorage.getItem("user"));
    if (!user) {
      return <div></div>;
    } else {
      return (
        <div className="">
          <form onSubmit={this.handleSubmit}>
            <div className="commentfield">
              <input
                type="text"
                name="comment"
                placeholder="Your comment..."
                value={this.state.comment}
                onChange={this.handleChange}
              />
            </div>
            <button type="submit">Submit</button>
          </form>
        </div>
      );
    }
  }
}
