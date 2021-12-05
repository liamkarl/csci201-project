import React, { Component } from "react";
import axios from "axios";


export default class Account extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: "",
      userBio: "",
      profPic: "",
      numPosts: "",
      numFollowers: "",
      numFollowing: ""
    };
  }

  componentDidMount(){
      axios.get('https://localhost:3000/user/name')
      .then(response =>{
          this.setState({username:response.data})
      })
      .catch(error =>{
          console.log(error)
      })

      axios.get('https://localhost:3000/user/bio')
      .then(response =>{
          this.setState({userBio:response.data})
      })
      .catch(error =>{
          console.log(error)
      })

      axios.get('https://localhost:3000/user/pfp')
      .then(response =>{
          this.setState({profPic:response.data})
      })
      .catch(error =>{
          console.log(error)
      })

      axios.get('https://localhost:3000/user/posts')
      .then(response =>{
          this.setState({numPosts:response.data})
      })
      .catch(error =>{
          console.log(error)
      })

      axios.get('https://localhost:3000/user/followers')
      .then(response =>{
          this.setState({numFollowers:response.data})
      })
      .catch(error =>{
          console.log(error)
      })

      axios.get('https://localhost:3000/user/following')
      .then(response =>{
          this.setState({numFollowing:response.data})
      })
      .catch(error =>{
          console.log(error)
      })
  }
 


  render() {
      let{username, userBio, numFollowers, numFollowing, profPic} = this.state;
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
