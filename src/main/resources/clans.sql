CREATE TABLE IF NOT EXISTS clans
(
    id           BIGINT       PRIMARY KEY,
    name         VARCHAR(200)    NOT NULL,
    gold         INTEGER         NOT NULL
);