CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    role VARCHAR(10)    NOT NULL,
    username VARCHAR(25)    UNIQUE NOT NULL,
    password VARCHAR(25)    NOT NULL,
    address VARCHAR(100)    NOT NULL,
    email VARCHAR(50)       NOT NULL,
    phone_num VARCHAR(20)   NOT NULL
);

CREATE TABLE Members (
    member_id SERIAL PRIMARY KEY,
    user_id INT,
    name VARCHAR(25)    NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES Users(user_id)
);

CREATE TABLE Exercise_Routines (
    routine_id SERIAL PRIMARY KEY,
    member_id INT,
    description VARCHAR(255)    NOT NULL,
    day VARCHAR(10) NOT NULL,
    time TIME   NOT NULL,
    FOREIGN KEY (member_id)
        REFERENCES Members(member_id)
);

CREATE TABLE Fitness_Goals (
    goal_id SERIAL PRIMARY KEY,
    member_id INT,
    exercise_type VARCHAR(25)   NOT NULL,
    weight FLOAT,
    reps INT,
    achieved BOOLEAN    NOT NULL,
    FOREIGN KEY (member_id)
        REFERENCES Members(member_id)
);

CREATE TABLE Health_Metrics (
    metric_id SERIAL PRIMARY KEY,
    member_id INT,
    weight FLOAT    NOT NULL,
    height FLOAT    NOT NULL,
    bmi FLOAT       NOT NULL, -- We will calculate this below.
    FOREIGN KEY (member_id) REFERENCES Members(member_id)
);

CREATE OR REPLACE FUNCTION calculate_bmi()
RETURNS TRIGGER AS $$
BEGIN
    NEW.bmi := NEW.weight / (NEW.height * NEW.height);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER bmi_trigger
BEFORE INSERT OR UPDATE ON Health_Metrics
FOR EACH ROW
EXECUTE FUNCTION calculate_bmi();

CREATE TABLE Bills (
    bill_id SERIAL PRIMARY KEY,
    member_id INT,
    name VARCHAR(255)    NOT NULL,
    amount FLOAT        NOT NULL,
    FOREIGN KEY (member_id)
        REFERENCES Members(member_id)
);

CREATE TABLE Trainers (
    trainer_id SERIAL PRIMARY KEY,
    user_id INT,
    name VARCHAR(25)    NOT NULL,
    specialization VARCHAR(25)  NOT NULL,
    experience INT  NOT NULL,
    description VARCHAR(255)    NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES Users(user_id)
);

CREATE TABLE Admins (
    admin_id SERIAL PRIMARY KEY,
    user_id INT,
    name VARCHAR(25)    NOT NULL,
    FOREIGN KEY (user_id)
        REFERENCES Users(user_id)
);

CREATE TABLE Equipment (
    equipment_id SERIAL PRIMARY KEY,
    admin_id INT,
    name VARCHAR(25)        NOT NULL,
    maintenance_date DATE   NOT NULL,
    FOREIGN KEY (admin_id)
        REFERENCES Admins(admin_id)
);

CREATE TABLE Fitness_Classes (
    class_id SERIAL PRIMARY KEY,
    name VARCHAR(25)            NOT NULL,
    description VARCHAR(255)    NOT NULL,
    curr_capacity INT           NOT NULL,
    max_capacity INT            NOT NULL
);

CREATE TABLE Members_Schedule (
    mem_schedule_id SERIAL PRIMARY KEY,
    member_id INT,
    class_id INT,
    description VARCHAR(255)    NOT NULL,
    date DATE                   NOT NULL,
    start_time TIME             NOT NULL,
    end_time TIME               NOT NULL,
    FOREIGN KEY (member_id)
        REFERENCES Members(member_id),
    FOREIGN KEY (class_id)
        REFERENCES Fitness_Classes(class_id)
);

CREATE TABLE Trainers_Schedule (
    trainer_schedule_id SERIAL PRIMARY KEY,
    trainer_id INT,
    class_id INT,
    description VARCHAR(255)    NOT NULL,
    date DATE                   NOT NULL,
    start_time TIME             NOT NULL,
    end_time TIME               NOT NULL,
    FOREIGN KEY (trainer_id)
        REFERENCES Trainers(trainer_id),
    FOREIGN KEY (class_id)
        REFERENCES Fitness_Classes(class_id)
);
