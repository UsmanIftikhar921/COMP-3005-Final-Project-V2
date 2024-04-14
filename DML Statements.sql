INSERT INTO Users (role, username, password, address, email, phone_num)
VALUES
    ('member', 'AkaiFlame', 'mykimen', 'OG DND Street, Land of Kimen', 'flame@example.com', '123-456-7890'),
    ('member', 'TimpaNiko', 'childoflight', 'OG DND Street, Land of Light', 'niko@example.com', '987-654-3210'),
    ('trainer', 'DanDragno', 'zelzar', 'OG DND Street, Land of Dark', 'dan@example.com', '555-555-5555'),
    ('admin', 'Alex', 'animalfacts', 'OG DND Street, Greed Street', 'alex@example.com', '696-969-6969');

INSERT INTO Members (user_id, name)
VALUES
    (1, 'Flame Ouranos'),
    (2, 'Niko Ragna');

INSERT INTO Exercise_Routines (member_id, description, day, time)
VALUES
    (1, 'Morning jog', 'Monday', '06:00:00'),
    (1, 'Weightlifting', 'Wednesday', '18:00:00'),
    (2, 'Yoga', 'Tuesday', '08:00:00');

INSERT INTO Fitness_Goals (member_id, exercise_type, weight, reps, achieved)
VALUES
    (1, 'Pull Ups', NULL, 10, true),
    (1, 'Hammer Curls', 15.0, 14, false),
    (2, 'Squats', NULL, 10, false);

INSERT INTO Health_Metrics (member_id, weight, height)
VALUES
    (1, 60.0, 1.778),
    (2, 50.5, 1.651);

INSERT INTO Bills (member_id, name, amount)
VALUES
    (1, 'Initial Membership Fee', 50.00),
    (2, 'Personal Training Sesh w/ Dan', 35.60);

INSERT INTO Trainers (user_id, name, specialization, experience, description)
VALUES
    (3, 'Dan Dragno', 'Body Building', 5, 'Dan Dragno, warrior of Zelzar will now teach you how to be just like him! All for the low price of 35.6$ per session!');

INSERT INTO Admins (user_id, name)
VALUES
    (3, 'AlexTheMod');

INSERT INTO Equipment (admin_id, name, maintenance_date)
VALUES
    (1, 'Treadmill', '2024-04-10'),
    (1, 'Dumbells', '2024-02-24');

INSERT INTO Fitness_Classes (name, description, curr_capacity, max_capacity)
VALUES
    ('Draconian Training', 'Train the mind and soul.', 0, 5),
    ('Zelzarian Training', 'Go through hell and back in order to reforge yourself', 0, 10);

INSERT INTO Members_Schedule (member_id, class_id, description, date, start_time, end_time)
VALUES
    (1, 1, 'Draconian Training', '2024-04-15', '08:00:00', '09:00:00'),
    (2, 2, 'Zelzarian Training', '2024-04-16', '16:00:00', '17:00:00');

INSERT INTO Trainers_Schedule (trainer_id, class_id, description, date, start_time, end_time)
VALUES
    (1, 1, 'Draconian Training', '2024-04-15', '08:00:00', '09:00:00'),
    (1, 2, 'Zelzarian Training', '2024-04-16', '16:00:00', '17:00:00');
