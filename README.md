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
docker pull redis:5.0

## create a container with redis:5.0
docker run -itd --name test-redis5 -p 63791:6379 redis:5.0

## start / stop container
docker start test-redis5
docker stop test-redis5
```