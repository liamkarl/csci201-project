import React, { useState } from 'react'

import { SearchRestaurant } from './components/APIFunctions'

import './Search.css'

export default function Search() {
	const [searchTerm, setSearchTerm] = useState('')

	const handleSubmit = (event) => {
		console.log(SearchRestaurant(searchTerm))
	}

	return (
		<div className='search'>
			<form onSubmit={handleSubmit()}>
				<label>
					<h1>Search:</h1>
					<input type="text" onChange={(e) => setSearchTerm(e.target.value)} />
				</label>
				<input type="submit" value="Submit"/>
			</form>
		</div>
	)
}

