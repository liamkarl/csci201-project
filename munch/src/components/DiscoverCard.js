import React from 'react'

import './DiscoverCard.css'

import * as FAIcons from 'react-icons/fa'

export default function DiscoverCard(props) {
    return (
        <div className='discover-card' style={{backgroundImage: `url('${props.image}')`}}>
            <div className='discover-restaurant'>
                <FAIcons.FaMapMarkerAlt className='discover-restaurant-icon' />
                <p className='discover-restaurant-name'>{props.restaurant}</p>
            </div>
            <div className='discover-rating'>
                <FAIcons.FaStar className='discover-star'/>
                <p className='discover-num-rating'>{props.rating}</p>
            </div>
        </div>
    )
}
