CREATE TABLE IF NOT EXISTS clans
(
    id           SERIAL       PRIMARY KEY,
    name         VARCHAR(200)    NOT NULL,
    gold         INTEGER         NOT NULL
);