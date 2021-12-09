import React from 'react'

import './ListsGallery.css'

import {ListsData} from './ListsData'
import ListBanner from './ListBanner'

export default function ListsGallery() {
    return (
        <div className='lists-gallery'>
            {ListsData.map((card, index) => {
                return (
                    <ListBanner category={card.category} image={card.image} />
                )
            })}
        </div>
    )
}
