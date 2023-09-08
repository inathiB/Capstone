import React, { useEffect, useState } from 'react';
import axios from "axios";
import './styling/Tutorials.css';
import AddTutorialForm from './AddTutorialForm';
import TutorialsController from '../../../Controllers/TutorialController';

const Tutorials = () => {
    const [tutorials, setTutorials] = useState({
        upcoming: [],
        past: []
    });
    useEffect(() => {
        const tutorialController = new TutorialsController();
        setTutorials(tutorialController.loadTutorials());
    }, []);

    const baseURL = "https://196.47.228.182:8080/api/v1/courses/CSC2015";

    

    useEffect(()=>{
        axios.get(`${baseURL}/1`)
            .then((response) => {
                console.log(response.data);
            })
            .catch((error) => {
                console.error(error);
            });

    },[])
    const [toggle, setToggle] = useState('upcoming');
    const role = sessionStorage.getItem("userRole");

    return (
        <div className="tut-container">
            <div className="tut-tabs">
            {role === 'tutor'? "":<button className="tut-tab-button" id="addButton" onClick={() => setToggle("add")}>+ Add Tutorial</button>}
                <button className="tut-tab-button" id="viewPastButton" style={{ display: toggle === "past" ? 'none' : 'block' }} onClick={(e) => setToggle("past")}>Past Tutorials</button>
                <button className="tut-tab-button" id="viewUpcoming" style={{ display: toggle === "upcoming" ? 'none' : 'block' }} onClick={() => setToggle("upcoming")}>View Upcoming</button>
            </div>

            <div className="tut-content">
                <h2>Tutorial Sessions</h2>
                {toggle === "add" ? <AddTutorialForm setTutorials={setTutorials} tutorials={tutorials} setToggle={setToggle} /> : <div>Viewing {toggle} tutorials</div>}
                {toggle === "add" ? "Please complete the form" : <div className="tut-tab-content active">
                    {tutorials[toggle].length === 0 ? (
                        <div>No tutorials available</div>
                    ) : (
                        <table className="tut-tutorial-table">
                            <thead>
                                <tr>
                                    <th>Tutorial Title</th>
                                    <th>Date Time</th>
                                    <th>Venue</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                {tutorials[toggle].map((tutorial, index) => (
                                    <tr key={index}>
                                        <td className="tut-tut-name">{tutorial.title}</td>
                                        <td>{tutorial.datetime}</td>
                                        <td>{tutorial.venue}</td>
                                        <td><button className="tut-update-button">Options</button></td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    )}
                </div>}
            </div>
        </div>
    );
};

export default Tutorials;
