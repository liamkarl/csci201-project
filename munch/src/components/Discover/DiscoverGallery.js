import React, { useState, useEffect } from 'react'
import axios from 'axios'
import requests from '../../requests'
import AuthHeader from '../../AuthHeader'

import './DiscoverGallery.css'

// import {DiscoverCardData} from './DiscoverCardData'
import DiscoverCard from './DiscoverCard'

export default function Gallery() {
    const [discover, setDiscover] = useState([])

    useEffect(() => {
            // setDiscover(getDiscoverGallery())
        axios.get(
            requests.getDiscover, 
            { headers: AuthHeader() })
        .then((response) => {
            console.log(response.data)
            setDiscover(response.data)
            // return response.data
        })
        .catch(error => console.error('Error: ' + error))
    }, [])

    return (
        <div className='discover-gallery'>
            {discover.map((card, index) => {
                return (
                    <DiscoverCard key={index} user={card.user} image={card.image} restaurant={card.restaurant} rating={card.rating} description={card.description}/>
                )
            })}
        </div>
    )
}
