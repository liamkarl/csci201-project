import './App.css';

import Login from './Login'
import Home from './Home'
import Discover from './Discover'
import Lists from './Lists'
import Friends from './Friends'
import Review from './Review'
import Account from './Account'

import Navbar from './components/Navbar/Navbar'

import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'

function App() {
  	return (
		<Router>
			<div className="App">
				<Navbar />
				<div className="content">
					<Routes>
						<Route path='/' element={<Home />}></Route>
						<Route path='/login' element={<Login />}></Route>
						<Route path='/discover' element={<Discover />}></Route>
						<Route path='/lists' element={<Lists />}></Route>
						<Route path='/friends' element={<Friends />}></Route>
						<Route path='/review' element={<Review />}></Route>
						<Route path='/account' element={<Account />}></Route>
					</Routes>
				</div>
			</div>
		</Router>
	);
}

export default App;
