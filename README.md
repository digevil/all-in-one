## DataBase(Mysql8)

简单说明

```bash
## pull image
docker pull mysql:8

## create a container with mysql:8
run -itd --name mysql-8-test -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql:8

## start / stop container
docker start mysql-8-test
docker stop mysql-8-test

## then creat a user test/test and create db for test
```

## DataBase(Postgres12)

```bash
## pull image
docker pull postgres:12.0

## create a container with postgres:12.0
docker run --name test-pg12 -p 54321:5432 -d postgres:12.0

## start / stop container
docker start test-pg12
docker stop test-pg12

## then creat a user test/test and create db for test
```

## Redis

```bash
## pull image
docker pull redis:6

## create a container with redis:5.0
docker run -itd --name redis-6-test -p 6379:6379 -d redis:6 redis-server --save 60 1 --loglevel warning

## start / stop container
docker start redis-6-test
docker stop redis-6-test
```