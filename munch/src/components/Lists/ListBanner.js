import React from 'react'
import { useNavigate } from 'react-router-dom'

import './ListBanner.css'

export default function ListBanner(props) {
    let navigate = useNavigate()

    return (
        <div className='list-banner' onClick={()=>{(navigate('/lists/' + props.category))}}>
            <img src={props.image} alt='missing' className='list-image' />
            <div className='list-name-container'>
                <h1 className='list-name'>{props.category}</h1>
            </div>
        </div>
    )
}
