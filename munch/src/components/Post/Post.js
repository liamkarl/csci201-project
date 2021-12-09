import React, { useState, useEffect } from 'react'
import AuthHeader from '../../AuthHeader'
import axios from 'axios'
import requests from '../../requests'
import { HandleFollow, HandleLike } from '../APIFunctions'

import './Post.css'

import * as FAIcons from 'react-icons/fa'

export default function Post(props) {
    const [username, setUsername] = useState(null)
    console.log(requests.getUserFromID+props.user)

    useEffect(() => {
        axios.get(
            requests.getUserFromID + props.user,
            { headers: AuthHeader() })
            .then((response) => {
            setUsername(response.data.username)
        })
        .catch(error => console.error('Error: ' + error))
    }, [])

    console.log(props.likes)

    return (
        <div className='post'>
                <img src={props.image} alt='missing' className='post-image' />
            <div className='post-text-container'>
                <div className='post-info-container'>
                    <h1 className='post-user' onClick={()=>{HandleFollow(props.username)}}>{props.username}</h1>
                    <h1 className='post-restaurant' >{props.restaurant}</h1>
                    <h1 className='post-rating'>-- {props.rating}/5 --</h1>
                </div>
                <div className='post-description-container'>
                    <p className='post-description'>{props.description}</p>
                </div>
                <div className='post-links'>
                    <h1>{props.likes}</h1>
                    <FAIcons.FaHeart className='post-link' onClick={()=>HandleLike(props.postID)}/>
                    <FAIcons.FaComment className='post-link'/>
                    <FAIcons.FaShare className='post-link'/>
                    <FAIcons.FaBookmark className='post-link'/>
                </div>
            </div>
        </div>
    )
}