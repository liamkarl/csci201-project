import React, { Component } from "react";
import axios from "axios";

import "./Form.css";

export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      location: "",
      rating: "",
      image: "",
      comments: "",
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
    const { location, rating, image, comments } = this.state;

    axios
      .post(
        "http://localhost:3000/review",
        {
          // user: {
          //   email: email,
          //   password: password,
          // },

          review: {
            location: location,
            rating: rating,
            image: image,
            comments: comments,
          },
        },
        { withCredentials: true }
      )
      .then((response) => {
        if (response.data.success) {
          this.props.handleSuccessfulAuth(response.data);
        }
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
              name="location"
              placeholder="type the location you want to review"
              value={this.state.location}
              onChange={this.handleChange}
              required
            />
          </div>
          <div className="field">
            <input
              type="text"
              name="rating"
              placeholder="type the rating from 1-5"
              value={this.state.rating}
              onChange={this.handleChange}
              required
            />
          </div>
          <div className="field">
            <input
              type="text"
              name="image"
              placeholder="paste the image url here"
              value={this.state.url}
              onChange={this.handleChange}
              required
            />
          </div>
          <div className="field">
            <input
              type="text"
              name="comments"
              placeholder="any additional comments"
              value={this.state.comments}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}
