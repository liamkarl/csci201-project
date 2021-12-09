import React from 'react'

import './Comment.css'

import * as FAIcons from 'react-icons/fa'

export default function Comment(props) {

    return (
		<div className='comment'>
            <div className='comment-header'>
				<FAIcons.FaUserCircle className='comment-user-icon' />
				<h3 className='comment-poster'>{props.user}</h3>
			</div>
			<p className='comment-body'>{props.body}</p>
		</div>
    )
}