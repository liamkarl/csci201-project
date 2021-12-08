import React from 'react'
import { useParams } from 'react-router-dom'

import './List.css'

import ListView from './components/Lists/ListView'
import { ListsData } from './components/Lists/ListsData'

const getListContent = (category) => {
	for(var i = 0; i < ListsData.length; ++i) {
		if(ListsData[i]['category'] == category) {
			console.log('success')
			return ListsData[i]['content']
		}
	}
}

export default function List() {
	let { category } = useParams()
	let restaurants = getListContent(category)

    return (
        <div className='list'>
            <span className='header-span'><h1 className='header'>{category}</h1></span>
			<ListView content={restaurants}/>
        </div>
    )
}