import React, { useEffect, useState } from 'react'
import axios from 'axios'
import requests from '../../requests'
import AuthHeader from '../../AuthHeader'

import './Gallery.css'

// import {GalleryCardData} from './GalleryCardData'
import GalleryCard from './GalleryCard'

// const getGallery = () => {
//     axios.get(requests.getHome)
//     .then((response) => {
//         return(response.data)
//     })
//     .catch(error => console.error('Error: ' + error))
// }


export default function Gallery() {
    const [home, setHome] = useState([])

    useEffect(() => {
        axios.get(
            requests.getHome, 
            { headers: AuthHeader() })
        .then((response) => {
            setHome(response.data)
        })
        .catch(error => console.error('Error: ' + error))
    }, [])

    if(home.length == 0) {
        return (
            <div className='home-gallery'>
                <h1>No posts</h1>
            </div>
        )
    }

    return (
        <div className='home-gallery'>
            {home.map((card, index) => {
                return (
                    <GalleryCard key={index} postID={card.postID} user={card.user} username={card.username} image={card.image} restaurant={card.restaurant} rating={card.rating} description={card.description} comments={card.comments} likes={card.likes}/>
                )
            })}
        </div>
    )
}
