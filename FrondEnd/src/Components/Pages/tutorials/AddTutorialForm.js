import React from 'react';
import './styling/addtutorialform.css';
import Tutorial from '../../../Models/Class files/Tutorial';
import {convertDatetimeFormat} from '../../../Service/TimeandDate';

const AddTutorialForm = ({ setTutorials, tutorials, setToggle }) => {
    const handleSubmit = (e) => {
        e.preventDefault();

        // Get input values
        const title = e.target.title.value;
        const dateTime = convertDatetimeFormat(e.target.dateTime.value);
        const venue = e.target.venue.value;
        const courseCode = 'CSC3003S';

        // Create a new tutorial object
        const newTutorial = new Tutorial(title,courseCode,dateTime,venue)

        const newUpcoming = [...tutorials['upcoming'], newTutorial];
        // Update the tutorials list with the new tutorial
        setTutorials({ upcoming: newUpcoming, past: tutorials['past'] });

        // Close the modal and reset form
        e.target.reset();
        setToggle('upcoming');
    };

    return (
        <div>
            <div id="addModal" className="tut-modal">
                <div className="tut-modal-content">
                    <span className="tut-close" id="closeButton" onClick={() => setToggle('upcoming')}>
                        &times;
                    </span>
                    <h2>Add Tutorial</h2>
                    <form id="addForm" onSubmit={handleSubmit}>
                        <label htmlFor="title">Title:</label>
                        <input type="text" id="title" name="title" required />
                        <br />
                        <label htmlFor="dateTime">Date and Time:</label>
                        <input type="datetime-local" id="dateTime" name="dateTime" required />
                        <br />
                        <label htmlFor="venue">Venue:</label>
                        <input type="text" id="venue" name="venue" required />
                        <br />
                        <button type="submit">Add Tutorial</button>
                        <button type="button" onClick={() => setToggle('upcoming')}>
                            Cancel
                        </button>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default AddTutorialForm;
