import React, { useState } from 'react'
import Rating from 'react-simple-star-rating'

import './StarRating.css'

export default function StarRating() {
  const [rating, setRating] = useState(0) // initial rating value

  // Catch Rating value
  const handleRating = (rate) => {
    setRating(rate)
  }
  
  return (
    <div className='StarRating'>
      <Rating
        onClick={handleRating}
        ratingValue={rating}
        size={20}
        label
        transition
        fillColor='orange'
        emptyColor='gray'
        className='foo' // Will remove the inline style if applied
      />
      {/* Use rating value */}
      {rating}
    </div>
  )
}