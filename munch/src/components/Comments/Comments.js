import React from 'react'

import './Comments.css'

import Comment from './Comment'
import CommentForm from './CommentForm'

export default function Comments(props) {
	if(!props.comments) {
		return (
			<div className='commentz'>
				<h2>No comments</h2>
				<CommentForm/>
			</div>
		)
	}
	
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