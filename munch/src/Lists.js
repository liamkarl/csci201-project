import React from 'react'

import './Lists.css'

import ListsGallery from './components/Lists/ListsGallery'

export default function Lists() {
    return (
        <div className='lists'>
            <span className='header-span'><h1 className='header'>My Lists</h1></span>
            <ListsGallery />
        </div>
    )
}