CREATE ROLE web_user WITH
    LOGIN
    SUPERUSER
    INHERIT
    NOREPLICATION
    PASSWORD '1234';

CREATE DATABASE PoopDB
    WITH
    OWNER = web_user
    ENCODING = 'UTF8'