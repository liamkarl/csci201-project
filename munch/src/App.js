import './App.css';

import React , { useState } from 'react'

import Home from './Home'
import Discover from './Discover'
import Lists from './Lists'
import Review from './Review'
import Account from './Account'
import Register from './Register'
import ViewAccount from './ViewAccount'
import Login from './Login'
import LandingPage from './LandingPage'

import Navbar from './components/Navbar'

import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'

function App() {

  	return (
		<Router>
			<div className="App">
				<Navbar />
				<div className="content">
					<Routes>
						<Route path='/' element={<Home />}></Route>
						<Route path="/account/:id" component={<ViewAccount/> }/><Route/>
						<Route path='/login' element={<Login />}></Route>
						<Route path='/discover' element={<Discover />}></Route>
						<Route path='/lists' element={<Lists />}></Route>
						<Route path='/review' element={<Review />}></Route>
						<Route path='/account' element={<Account />}></Route>
						<Route path='/register' element={<Register/>}></Route>
						<Route path='/landing' element={<LandingPage/>}></Route>
					</Routes>
				</div>

			</div>
		</Router>
	);
}

export default App;
