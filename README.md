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
![Conceptual ER Diagram](https://github.com/UsmanIftikhar921/COMP-3005-Final-Project-V2/assets/95590916/98c59e15-90df-415d-9886-3c1bfb522c6f)


### Relational Schema:
![Database Relational Schema](https://github.com/UsmanIftikhar921/COMP-3005-Final-Project-V2/assets/95590916/7cd89601-907d-41f6-8a65-077020f24ce2)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
