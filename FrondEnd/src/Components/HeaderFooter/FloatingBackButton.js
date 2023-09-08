import React from 'react';
import './stylingHeader/backButton.css';
import { useNavigate } from 'react-router-dom';

const FloatingBackButton = () => {
    const navigate = useNavigate();
  return (
    <button onClick={()=>navigate(-1)} className="floating-back-button">
      &#8592; Back
    </button>
  );
};

export default FloatingBackButton;

