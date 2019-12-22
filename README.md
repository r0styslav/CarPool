#Run MySQL docker container:

##MAC:
docker run --restart always --name mysql8.0
-v /Users/rosty/Development/API/mysql/8.0:/var/lib/mysql
-p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=root mysql:8.0

##Windows
##MAC:
docker run --restart always --name mysql8.0
-v "D:/Dev/API/mysql/8.0:/var/lib/mysql"
-p 3306:3306 -d -e MYSQL_ROOT_PASSWORD=root mysql:8.0