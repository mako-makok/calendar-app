CREATE SCHEMA calendar;

CREATE TABLE IF NOT EXISTS calendar.users
(
    id serial,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS calendar.schedule
(
    id serial,
    user_id INTEGER NOT NULL,
    title text NOT NULL,
    description text NOT NULL,
    date_start DATE NOT NULL,
    date_end DATE NOT NULL,
    PRIMARY KEY (id)
);
 
INSERT INTO calendar.users VALUES (0);
INSERT INTO calendar.schedule VALUES (0, 0, 'hoge', 'figa', '2020-02-11', '2020-02-12');