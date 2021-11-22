import React from 'react'
import {Link} from 'react-router-dom'

import './Discover.css'

import {FaSort, FaSortAmountDownAlt} from 'react-icons/fa'

import DiscoverGallery from './components/DiscoverGallery'

export default function Discover() {
    return (
        <div className='discover'>
            <span class='dot'></span>
            <span class='dot'></span>
            <span class='dot'></span>
            <span className='header-span'>
                <h1 className='header'>Discover</h1>
                <Link to='#' className='sort'>
                    <h1 className='sort-text'>Sort</h1>
                    <FaSortAmountDownAlt className='sort-icon'/>
                </Link>
            </span>
            <DiscoverGallery />
            <span class='discover-circle1'></span>
            <span class='discover-circle2'></span>
            <span class='discover-circle3'></span>
        </div>
    )
}
