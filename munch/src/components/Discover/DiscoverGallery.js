import React from 'react'

import './DiscoverGallery.css'

import {DiscoverCardData} from './DiscoverCardData'
import DiscoverCard from './DiscoverCard'

export default function Gallery() {

    return (
        <div className='discover-gallery'>
            {DiscoverCardData.map((card, index) => {
                return (
                    <DiscoverCard key={index} user={card.user} image={card.image} restaurant={card.restaurant} rating={card.rating} description={card.description}/>
                )
            })}
        </div>
    )
}
