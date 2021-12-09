import React from 'react'

import './Comments.css'
import * as FAIcons from 'react-icons/fa'

import Comment from './Comment'
import CommentForm from './CommentForm'

export default function Comments(props) {
	
    return (
		<div className='commentz'>
			{props.comments.map((comment, index) => {
				return (
					<Comment key={index} user={comment.user} body={comment.body} />
				)
			})}
			<CommentForm/>
		</div>
    )
}