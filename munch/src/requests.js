const requests = {
	getHome: 'http://localhost:8080/api/home/posts',
	getDiscover: 'http://localhost:8080/api/explore/posts',
	getUserFromID: 'http://localhost:8080/api/users/',
	followUser: 'http://localhost:8080/api/users/follow?username=',
	makeComment: 'http://localhost:8080/api/post/comment/create/',
	likePost: 'http://localhost:8080/api/post/like?postID=',
	search: 'http://localhost:8080/api/search'
}

export default requests