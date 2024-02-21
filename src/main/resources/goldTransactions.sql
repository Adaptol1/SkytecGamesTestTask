CREATE TABLE IF NOT EXISTS gold_transactions
(
    id                  BIGINT       PRIMARY KEY,
    clan_id             BIGINT          NOT NULL,
    gold_source         VARCHAR(200)    NOT NULL,
    source_id           BIGINT          NOT NULL,
    transferred_gold    INTEGER         NOT NULL,
    total_gold          INTEGER         NOT NULL
);