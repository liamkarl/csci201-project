import React from 'react'

import './Home.css'

import Gallery from './components/Gallery'

export default function Home() {
    return (
        <div className='home'>
            <span class='dot'></span>
            <span class='dot'></span>
            <span class='dot'></span>
            <span className='header-span'><h1 className='header'>Recent Activity</h1></span>
            <Gallery />
            <span class='circle1'></span>
            <span class='circle2'></span>
        </div>
    )
}
