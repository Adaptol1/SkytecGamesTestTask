CREATE TABLE IF NOT EXISTS users
(
    id            SERIAL       PRIMARY KEY,
    clan_id       BIGINT          NOT NULL
);