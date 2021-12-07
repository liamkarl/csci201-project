import React from 'react'
import {Link} from 'react-router-dom'

import './Discover.css'

import {FaSortAmountDownAlt} from 'react-icons/fa'

import DiscoverGallery from './components/Discover/DiscoverGallery'

export default function Discover() {
    return (
        <div className='discover'>
            <span className='dot'></span>
            <span className='dot'></span>
            <span className='dot'></span>
            <span className='header-span'>
                <h1 className='header'>Discover</h1>
                <Link to='#' className='sort'>
                    <h1 className='sort-text'>Sort</h1>
                    <FaSortAmountDownAlt className='sort-icon' onClick={()=>{console.log('oof')}}/>
                </Link>
            </span>
            <DiscoverGallery />
            <span className='discover-circle1'></span>
            <span className='discover-circle2'></span>
            <span className='discover-circle3'></span>
        </div>
    )
}
