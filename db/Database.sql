-- Database: tbgames

-- DROP DATABASE tbgames;

CREATE DATABASE tbgames
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'French_France.1252'
    LC_CTYPE = 'French_France.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;


ALTER ROLE postgres PASSWORD 'admin'