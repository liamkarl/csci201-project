import React from 'react'

import './ListView.css'

import ListCard from './ListCard'

export default function Gallery(props) {
    return (
        <div className='list-gallery'>
            {props.content.map((card, index) => {
                return (
                    <ListCard key={index} image={card.image} restaurant={card.restaurant} />
                )
            })}
        </div>
    )
}
