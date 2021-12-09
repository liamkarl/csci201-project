import axios from 'axios'
import requests from '../requests'
import AuthHeader from '../AuthHeader'

export const HandleFollow = (username) => {
    axios.post(
        requests.followUser + username, 
        { headers: AuthHeader() })
        .catch(error => console.error('Error ' + error))
	console.log('here')
}

export const HandleLike = (postID) => {
    axios.post(
        requests.likePost + postID, 
        { headers: AuthHeader() })
        .catch(error => console.error('Error ' + error))
}

export const SearchRestaurant = (searchInput) => {
	axios.get(
		requests.search,
		{ RestaurantSearchRequest: searchInput },
		{ headers: AuthHeader() }).then((response) => {
			return response.data
		})
        .catch(error => console.error('Error ' + error))
}