import React from 'react'

import './Gallery.css'

import {GalleryCardData} from './GalleryCardData'
import GalleryCard from './GalleryCard'

export default function Gallery() {
    return (
        <div className='home-gallery'>
            {GalleryCardData.map((card, index) => {
                return (
                    <GalleryCard key={index} user={card.user} image={card.image} restaurant={card.restaurant} rating={card.rating} description={card.description} />
                )
            })}
        </div>
    )
}
