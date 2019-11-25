## 数据库

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