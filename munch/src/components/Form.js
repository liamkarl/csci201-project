import React, { Component } from "react";
import axios from 'axios'
import "./Form.css";

export class Form extends Component {
  constructor(props) {
    super(props);

    this.state = {
      Location: "",
      Comments: "",
    };

    this.handleRatingChange = this.handleRatingChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleLocationChange = (event) => {
    this.setState({
      Location: event.target.value,
    });
  };

  handleRatingChange = (event) => {
    this.setState({
      selectedRating: event.target.value,
    });
  };

  handleCommentsChange = (event) => {
    this.setState({
      Comments: event.target.value,
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    console.log(this.state)
    // axios.post('http://localhost:3000/review', this.state)
    // .then(response =>{
    //   console.log(response);
    // })
    // .catch(error=>{
    //   console.log(error);
    // })
  };

  render() {
    return (
      <div className="formcard">
        <form onSubmit={this.handleSubmit}>
          <div className="inputblock">
            <label>
              <div className="textblock">
                <label>Location :</label>
              </div>
              <input
                type="text"
                value={this.state.Location}
                onChange={this.handleLocationChange}
                className="location"
              />
            </label>
          </div>

          <div className="textblock">
            <label>Rating :</label>
          </div>
          
          <div className="radio">
            <label>
              <input
                type="radio"
                value="1"
                checked={this.state.selectedRating === "1"}
                onChange={this.handleRatingChange}
              />
              1
            </label>
          </div>

          <div className="radio">
            <label>
              <input
                type="radio"
                value="2"
                checked={this.state.selectedRating === "2"}
                onChange={this.handleRatingChange}
              />
              2
            </label>
          </div>

          <div className="radio">
            <label>
              <input
                type="radio"
                value="3"
                checked={this.state.selectedRating === "3"}
                onChange={this.handleRatingChange}
              />
              3
            </label>
          </div>

          <div className="radio">
            <label>
              <input
                type="radio"
                value="4"
                checked={this.state.selectedRating === "4"}
                onChange={this.handleRatingChange}
              />
              4
            </label>
          </div>

          <div className="radio">
            <label>
              <input
                type="radio"
                value="5"
                checked={this.state.selectedRating === "5"}
                onChange={this.handleRatingChange}
              />
              5
            </label>
          </div>
          <div className="inputblock">
            <label>
              <div className="textblock">
                <label>Comments :</label>
              </div>
              <textarea
                value={this.state.Comments}
                onChange={this.handleCommentsChange}
                className="comments"
              />
            </label>
          </div>

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default Form;
