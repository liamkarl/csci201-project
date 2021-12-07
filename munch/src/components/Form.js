import React, { Component } from "react";
import axios from "axios";
import "./Form.css";
import AuthHeader from "../AuthHeader";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

import { isEmail } from "validator";


export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      location: "",
      rating: "",
      image: "",
      postText: "",
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.onImageChange = this.onImageChange.bind(this);
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }

  onImageChange(event) {
    if (event.target.files && event.target.files[0]) {
      this.setState({
        image: URL.createObjectURL(event.target.files[0]),
      });
    }
  }

  handleSubmit(event) {
    const { location, rating, image, comments } = this.state;
    this.form.validateAll();
    console.log({
      location: location,
      rating: rating,
      image: image,
      comments: comments,
    });
    axios
      .post("http://localhost:3000/review", {
        headers: AuthHeader(),
        post: {
          location: location,
          rating: rating,
          image: image,
          comments: comments,
        },
      })

      .then((response) => {})
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
              type="number"
              pattern="[1-5]"
              min="1"
              max="5"
              name="rating"
              placeholder="type the rating from 1-5"
              value={this.state.rating}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <label className="custom-file-upload">
              <input
                type="file"
                name="image"
                onChange={this.onImageChange}
                className="choose-file"
                required
              />
              Upload Image
            </label>
            <div className="imageinfo">{this.state.image}</div>
          </div>
          <div className="field">
            <input
              type="text"
              name="postText"
              placeholder="any additional comments"
              value={this.state.postText}
              onChange={this.handleChange}
            />
          </div>
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}
