import React from 'react'

import './GalleryCard.css'

import * as FAIcons from 'react-icons/fa'

const getRatingStars = (num) => {
    var stars = []

    var outOfTen = Math.round(num *= 2);
    num = outOfTen /= 2;
    
    for(var i = 0; i < num; ++i) {
        if(num - i > 0.5) stars.push(<FAIcons.FaStar className='star'/>)
        else stars.push(<FAIcons.FaStarHalf className='star' />)
    }
    return stars;
}

export default function GalleryCard(props) {
    return (
        <div className='gallery-card'>
            <div className='gallery-card-header'>
                <FAIcons.FaUserCircle className='gallery-user-icon' />
                <p className='gallery-username'>{props.user}</p>
            </div>
            <img src={props.image} alt='' className='gallery-image' />
            <div className='gallery-restaurant'>
                <FAIcons.FaMapMarkerAlt className='gallery-restaurant-icon' />
                <p className='gallery-restaurant-name'>{props.restaurant}</p>
            </div>
            <div className='gallery-rating'>
                {getRatingStars(props.rating)}
            </div>
            <div className='gallery-description'>
                <p className='gallery-description-text'>{props.description}</p>
            </div>
            <div className='gallery-links'>
                <FAIcons.FaHeart className='gallery-link'/>
                <FAIcons.FaComment className='gallery-link'/>
                <FAIcons.FaShare className='gallery-link'/>
                <FAIcons.FaBookmark className='gallery-link'/>
            </div>
        </div>
    )
}
