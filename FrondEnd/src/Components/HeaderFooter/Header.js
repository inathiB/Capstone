import React from 'react'
import './stylingHeader/HeaderStyles.css'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <div>
        <nav className="navbar">
            <div className="navbar-logo">
                <Link to={'/'}><img src="https://upload.wikimedia.org/wikipedia/en/thumb/7/7c/University_of_Cape_Town_logo.svg/1200px-University_of_Cape_Town_logo.svg.png" alt="MyTutor Logo"/>
                </Link>
                <span>MyTutor App</span>
            </div>
            <div className="navbar-buttons">
                <button className="round-button profile-button">
                    <img src="https://t3.ftcdn.net/jpg/05/17/79/88/360_F_517798849_WuXhHTpg2djTbfNf0FQAjzFEoluHpnct.jpg" alt="Profile"/>
                </button>
                <button className="round-button help-button">Help</button>
                <button className="round-button logout-button">Log Out</button>
            </div>
        </nav>
    </div>
  )
}

export default Header
