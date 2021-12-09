import React from 'react'

import Form from './components/Review/Form'

import "./Login.css"

export default function Review() {
    return (
        <div className='review'>
            <div className = "headerspan">
            <h1 className = "header">Review Page</h1>
            </div>
            <Form/>
        </div>
    )
}
