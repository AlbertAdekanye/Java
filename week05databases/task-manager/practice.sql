-- SQL learning practices

-- 1. Create a table to store task
Create table IF NOT EXISTS task (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  title TEXT NOT NULL,
  description TEXT,
  completed INTEGER NOT NULL DEFAULT 0
);

-- 2. Add sample tasks
INSERT INTO task (title, description)
VALUES ('Learn Java', 'Practice Java basics');

INSERT INTO task (title, description)
VALUES ('Learn SQL', 'Practice SQL queries');

INSERT INTO task(title, description)
VALUES ('Build portfolio', 'Work on my developer portfolio');

INSERT INTO task (title, description)
VALUES ('Learn Java', 'Continue Task Manager');

-- 3. display all tasks

UPDATE task
SET completed = 0
WHERE id = 60;

SELECT * FROM task;