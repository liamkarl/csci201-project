import React from 'react'

import './ListBanner.css'

export default function ListBanner(props) {
    return (
        <div className='list-banner'>
            <img src={props.image} alt='missing' className='list-image' />
            <div className='list-name-container'>
                <h1 className='list-name'>{props.category}</h1>
            </div>
        </div>
    )
}
