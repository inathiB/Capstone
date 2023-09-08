import Tutorial from "../Models/Class files/Tutorial";

export default class TutorialsController {
    constructor() {
        this.tutorials = {
            upcoming: [],
            past: []
        };
    }

    loadTutorials() {
        // Get tutorials from database logic here
        // ...
        this.tutorials = {
            upcoming: [
                new Tutorial('Practical Session', 'CSC3003S', '2023-08-15 10:00 AM', 'Senior Lab'),
                new Tutorial('Demo Project', 'ML1000S', '2023-08-15 10:00 AM', 'Menzies Building'),
                new Tutorial('Mentor Meetup', 'INFO2011S', '2023-08-15 10:00 AM', 'Commerce Building')
            ],
            past: [
                new Tutorial('Prac Session', 'CSC2002S', '2023-02-01 10:00 AM', 'Ishango Lab'),
                new Tutorial('Tutorial', 'MAM1000W', '2023-08-15 10:00 AM', 'Math. Building'),
                new Tutorial('Lab Session', 'INFO2009S', '2023-08-15 10:00 AM', 'Leslie Socials Building')
            ]
        };
        return this.tutorials;
    }

    getUpcoming() {
        return this.tutorials['upcoming'];
    }

    getPast() {
        return this.tutorials['past'];
    }

    updateTutorials(tutorials) {
        this.tutorials = tutorials;
    }

    addTutorial(tutorial) {
        if (tutorial.isPast()) {
            this.tutorials['past'].push(tutorial);
        } else {
            this.tutorials['upcoming'].push(tutorial);
        }
    }
}
