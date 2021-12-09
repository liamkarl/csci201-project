import React, { useState} from 'react'
import Modal from 'react-modal'

import './DiscoverCard.css'

import * as FAIcons from 'react-icons/fa'
// import {AiOutlineClose} from 'react-icons/ai'

import Post from '../Post/Post'

export default function DiscoverCard(props) {
    const [post, setPost] = useState(false)

    console.log('here')
    console.log(props.likes)

    return (
        <>
            <div className='discover-card' style={{backgroundImage: `url('${props.image}')`}} onClick={()=>{setPost(!post)}} >
                <div className='discover-restaurant'>
                    <FAIcons.FaMapMarkerAlt className='discover-restaurant-icon' />
                    <p className='discover-restaurant-name'>{props.restaurant}</p>
                </div>
                <div className='discover-rating'>
                    <FAIcons.FaStar className='discover-star'/>
                    <p className='discover-num-rating'>{props.rating}</p>
                </div>
            </div>
            <Modal isOpen={post} className={post ? 'post-modal active' : 'post-modal'} overlayClassName='post-modal-overlay' closeTimeoutMS={100} shouldCloseOnOverlayClick={true} onRequestClose={() => {
         setPost(!post)}} ariaHideApp={false}>
                <Post username={props.username} postID={props.postID} image={props.image} restaurant={props.restaurant} rating={props.rating} description={props.description} likes={props.likes}/>
            </Modal>
        </>
    )
}
