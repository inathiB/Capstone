import './App.css';
import HomePage from './Components/Pages/HomePage';
import Header from './Components/HeaderFooter/Header';
import { Routes ,Route } from 'react-router-dom';
import Tutorials from './Components/Pages/tutorials/Tutorials';
import ErrorPage from './Components/Pages/ErrorPage';
import SignUp from './Components/Pages/tutorials/SignUp';
import Applications from './Components/Pages/applications/Applications';
import { useState } from 'react';
import Login from './Components/Pages/Login';
import Navigation from './Components/HeaderFooter/Navigation';
import CoursePage from './Components/Pages/courses/CoursePage';
import ManageCourse from './Components/Pages/courses/ManageCourse';
import FloatingBackButton from './Components/HeaderFooter/FloatingBackButton';

function App() {
  let [loggedIn, setLoggedIn] = useState(false);
  
  return (
    <div className="App">
      
      {loggedIn === false? <Login setLoggedIn={setLoggedIn}/> :
      <>
      <Header/>
      <Navigation/>
      <Routes>
        <Route path='/' element={<HomePage/>}/>
        <Route path='/tutorials' element={<Tutorials/>}/>
        <Route path='/signup' element={<SignUp/>}/>
        <Route path='/applications/*' element={<Applications/>}/>
        <Route path='/manageCourse' element={<ManageCourse courseinfo={{
      courseName: "Information Systems 2",
      courseCode: "INF2011S",
      id: "5lp6pqtz",
      duration: "June - October",
      year: "2023",
      creator: "John Smith"
    }}/>}/>
        <Route path='/coursePage' element={<CoursePage/>}/>
        <Route path='*' element={<ErrorPage/>}/>
      </Routes>
      <FloatingBackButton/>
      </>}
      
    </div>
  );
}

export default App;
