import React, { Component, useState } from "react";
import axios from "axios";
import "./Form.css";
import AuthHeader from "../AuthHeader";

export default class Form extends Component {
  constructor(props) {
    super(props);

    this.state = {
      location: "",
      rating: 5,
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
    // const [selectedFile, setSelectedFile] = useState();
    // const [isFilePicked, setIsFilePicked] = useState(false);
    if (event.target.files && event.target.files[0]) {
      this.setState({
        image: URL.createObjectURL(event.target.files[0]),
      });
    }
  }

  handleRatingChange(event){
    this.setState({
      rating: Number(event.target.value),
    })
  }
  handleSubmit(event) {
    const user = JSON.parse(localStorage.getItem('user'));
    const { location, rating, image, postText } = this.state;

    console.log({
      user,
      headers: AuthHeader(),
      location: location,
      rating: rating,
      image: image,
      postText: postText,
    });

    axios
      .post("http://localhost:8080/api/post/create", {
          location: location,
          rating: rating,
          image: image,
          postText: postText,
      }, {headers: AuthHeader()})

      .then((response) => {
        console.log(response);
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
              type="number"
              min="1"
              max="5"
              name="rating"
              placeholder="type the rating from 1-5"
              value={this.state.rating}
              onChange={this.handleRatingChange}
            />
          </div>

          <div className="field">
              <input
                type="text"
                name="image"
                value={this.state.image}
                onChange={this.handleChange}
                placeholder="paste the photo address here:"
                required
              />
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
