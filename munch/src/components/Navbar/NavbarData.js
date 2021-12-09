import React from 'react'
import * as MDIcons from 'react-icons/md'

export const NavbarData = [
    {
        title: 'Home',
        path: '/',
        icon: <MDIcons.MdHomeFilled />,
        className: 'nav-text'
    },
    {
        title: 'Discover',
        path: '/discover',
        icon: <MDIcons.MdRestaurant />,
        className: 'nav-text'
    },
    {
        title: 'Lists',
        path: '/lists',
        icon: <MDIcons.MdList />,
        className: 'nav-text'
    },
    {
        title: 'Login',
        path: '/login',
        icon: <MDIcons.MdPermIdentity />,
        className: 'nav-text'
    },
    {
        title: 'Register',
        path: '/register',
        icon: <MDIcons.MdAccountCircle />,
        className: 'nav-text'
    },
]