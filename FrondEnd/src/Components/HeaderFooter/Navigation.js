import React from 'react';
import { Link } from 'react-router-dom';
import './stylingHeader/navigation.css';

const Navigation = () => {
  return (
    <nav className="navigation">
      <ul className="nav-pills">
        <li className="nav-pill">
          <Link to="/" className="nav-link" activeclassname="activeNav">
            Home
          </Link>
        </li>
        <li className="nav-pill">
          <Link to="/applications" className="nav-link" activeclassname="activeNav">
            Applications
          </Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navigation;

