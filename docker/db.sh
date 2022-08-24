ECHO OFF
ECHO Running Docker Database

docker run -t -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -e POSTGRES_DB=root -p 5432:5432 postgres:14