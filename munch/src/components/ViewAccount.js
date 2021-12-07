import React, { Component } from "react";
import axios from "axios";
import {userData} from "./userData.js"

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


  // componentDidMount() {
  //   axios
  //     .get("https://localhost:3000/user/name", {
  //       params: {
  //         id: this.props.match.params.id,
  //       },
  //     })
  //     .then((response) => {
  //       this.setState({ username: response.data });
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });

  //   axios
  //     .get("https://localhost:3000/user/bio", {
  //       params: {
  //         id: this.props.match.params.id,
  //       },
  //     })
  //     .then((response) => {
  //       this.setState({ userBio: response.data });
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });

  //   axios
  //     .get("https://localhost:3000/user/pfp", {
  //       params: {
  //         id: this.props.match.params.id,
  //       },
  //     })
  //     .then((response) => {
  //       this.setState({ profPic: response.data });
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });

  //   axios
  //     .get("https://localhost:3000/user/posts", {
  //       params: {
  //         id: this.props.match.params.id,
  //       },
  //     })
  //     .then((response) => {
  //       this.setState({ numPosts: response.data });
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });

  //   axios
  //     .get("https://localhost:3000/user/followers", {
  //       params: {
  //         id: this.props.match.params.id,
  //       },
  //     })
  //     .then((response) => {
  //       this.setState({ numFollowers: response.data });
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });

  //   axios
  //     .get("https://localhost:3000/user/following", {
  //       params: {
  //         id: this.props.match.params.id,
  //       },
  //     })
  //     .then((response) => {
  //       this.setState({ numFollowing: response.data });
  //     })
  //     .catch((error) => {
  //       console.log(error);
  //     });
  // }

  render() {

    let { username, userBio, numFollowers, numFollowing, profPic } = userData;
    console.log(userData);
    return (
      <div>
        <image src={profPic}></image>
        <div>username: {username}</div>
        <div>userbio: {userBio}</div>
        <div>{numFollowers} followers</div>
        <div>{numFollowing} following</div>
      </div>
    );
  }
}
