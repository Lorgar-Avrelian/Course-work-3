-- liquibase formatted sql

-- changeset tokovenko:1
CREATE TABLE notification_task
(
    id              bigserial primary key,
    chat_id         bigint,
    text            varchar,
    execute_date    timestamp
);