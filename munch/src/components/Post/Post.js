import React from 'react'

import './Post.css'

import * as FAIcons from 'react-icons/fa'

export default function Post(props) {

    return (
        <div className='post'>
                <img src={props.image} alt='missing' className='post-image' />
            <div className='post-text-container'>
                <div className='post-info-container'>
                    <h1 className='post-user'>{props.user}</h1>
                    <h1 className='post-restaurant'>{props.restaurant}</h1>
                    <h1 className='post-rating'>-- {props.rating}/5 --</h1>
                </div>
                <div className='post-description-container'>
                    <p className='post-description'>{props.description}</p>
                </div>
                <div className='post-links'>
                    <FAIcons.FaHeart className='post-link'/>
                    <FAIcons.FaComment className='post-link'/>
                    <FAIcons.FaShare className='post-link'/>
                    <FAIcons.FaBookmark className='post-link'/>
                </div>
            </div>
        </div>
    )
}