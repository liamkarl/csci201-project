import React from 'react'

import './Home.css'

import Gallery from './components/Home/Gallery'

export default function Home() {
    return (
        <div className='home'>
            <span className='dot'></span>
            <span className='dot'></span>
            <span className='dot'></span>
            <span className='header-span'><h1 className='header'>Recent Activity</h1></span>
            <Gallery />
            <span className='circle1'></span>
            <span className='circle2'></span>
        </div>
    )
}
