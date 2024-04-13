# COMP 3005 Final Project V2
Design and implement an application for a Health and Fitness Club Management System. This system will serveas a comprehensive platform catering to the diverse needs of club members, trainers, and administrative staff.
<!-- ABOUT THE PROJECT -->
## Project Report
### Conceptual Design

Below are listed the assumption I have made during the creation of this project:
* Upon starting the application, you will be asked to log in or sign up.
  * While signing up, you may choose to be a Member, Trainer, or Admin
  * This functionality is only for the sake of simplicity and demonstrational purposes, as it is a rather dangerous permission to grant in practical usage. 
* The Member is a User
  * The User tables stores all of the personal information
* The Member has one set of health metrics
  * These health metrics turn into health statistics, depending on whether or not you are in the dashboard
  * BMI will be calculated based on the member’s weight and height
* Each Member can have as many fitness goals as they'd like
  * These goals are based on the member being able to lift a certain amount of weight (while doing a certain exercise) or doing a certain amount of reps (while doing a certain exercise)
  * These goals turn into achievements once the user changes their achieved status to ‘achieved’, and will be displayed on the dashboard.
* Members can have as many exercise routines as they'd like
  * They must however, set these routines manually
* Members may take as many personal training sessions & fitness classes as they wish
  * However, the timing must not conflict with pre-existing booked sessions/classes.
  * Signing up for a class/session will automatically add it to the member’s schedule
* Members have a schedule
  * Which is automatically filled when they sign up for a training session or a fitness class
* Members pay bills
  * These bills are provided to them by the admins

* Trainers are users
  * The User tables stores all of the personal information
* Trainers give fitness classes and personal training sessions
  *However, the timing must not conflict with pre-existing hosted sessions/classes.
  * They must assign them manually, after which the classes/sessions will be added onto their schedule automatically.
* Trainers have a schedule
  * Which is automatically filled when they host a training session or a fitness class.

* Admins are users
  * The User tables stores all of the personal information
* Admins maintain equipment
  * They must do so in person. After doing so, they will update the maintenance date on the respective equipment
* Admins send bills to members
  * They will calculate the amount in person, depending on the member’s purchased classes, they send them a bill amount.

* Fitness Classes and Personal Training Sessions are stored in a schedule (they are referrenced as foreign keys in the schedule table)
  * The only difference between Fitness Classes and Personal training in my database is that personal training sessions are just fitness classes with a capacity of 1, unlike classes which can have a set amount of capacity.

### Conceptual Database Design - Chen Diagram
Note: Arrows were used to indicate direction of relationships.
![Conceptual ER Diagram](https://github.com/UsmanIftikhar921/COMP-3005-Final-Project-V2/assets/95590916/744a73f4-11d5-43b8-8849-14b546d6df5e)

### Relational Schema:
![Database Relational Schema](https://github.com/UsmanIftikhar921/COMP-3005-Final-Project-V2/assets/95590916/204a3369-db40-4ccd-8f7d-ff90b5cd2271)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* npm
  ```sh
  npm install npm@latest -g
  ```

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
   ```sh
   git clone https://github.com/your_username_/Project-Name.git
   ```
3. Install NPM packages
   ```sh
   npm install
   ```
4. Enter your API in `config.js`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ROADMAP -->
## Roadmap

- [x] Add Changelog
- [x] Add back to top links
- [ ] Add Additional Templates w/ Examples
- [ ] Add "components" document to easily copy & paste sections of the readme
- [ ] Multi-language Support
    - [ ] Chinese
    - [ ] Spanish

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - email@example.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/othneildrew/Best-README-Template.svg?style=for-the-badge
[contributors-url]: https://github.com/othneildrew/Best-README-Template/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/othneildrew/Best-README-Template.svg?style=for-the-badge
[forks-url]: https://github.com/othneildrew/Best-README-Template/network/members
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
