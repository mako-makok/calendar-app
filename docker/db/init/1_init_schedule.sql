CREATE TABLE IF NOT EXISTS users
(
    id serial,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS schedule
(
    id serial,
    user_id INTEGER NOT NULL,
    title text NOT NULL,
    description text NOT NULL,
    date_start DATE NOT NULL,
    date_end DATE NOT NULL,
    PRIMARY KEY (id)
);
 
INSERT INTO users VALUES (0);
INSERT INTO schedule VALUES (0, 0, 'hoge', 'fuga', '2020-02-11', '2020-02-12');