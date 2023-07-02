BINARY="/home/ec2-user/server/user-services/gamedoora-user-services.jar"
LOGGING="-Dlogging.path=//home/ec2-user/server/user-services/logs"
PORT=8081
java -Duser.timezone=UTC $LOGGING $JAVA_OPTS -Dserver.port=${PORT} -jar $BINARY
