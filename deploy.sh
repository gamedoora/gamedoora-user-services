#!/bin/bash

JAR_FILE=target/*.jar
REMOTE_DIRECTORY=/opt/gamedoora/
REMOTE_JAR_FILE=gamedoora-user-services.jar

echo $SSH_USERNAME
echo $SSH_HOST

# connect to the Server instance and set up the remote directory 
 sshpass -p $SSH_PASS ssh -o StrictHostKeyChecking=no "$SSH_USERNAME@$SSH_HOST" "
  if [ -d $REMOTE_DIRECTORY ]; then
    cd $REMOTE_DIRECTORY
    if [ -f $REMOTE_JAR_FILE ]; then
      rm -f $REMOTE_JAR_FILE
    fi
  else
    mkdir -p $REMOTE_DIRECTORY
  fi"

#COPY SYSTEMD INTO LOCAL
DEST_PATH="/usr/lib/systemd/system/"
echo "Copying files"
sshpass -p $SSH_PASS scp gamedoora-user-service.services -o StrictHostKeyChecking=no "$SSH_USERNAME@$SSH_HOST:$DEST_PATH"
echo "Restarting service"
# Stop the service
sshpass -p $SSH_PASS ssh -o StrictHostKeyChecking=no "$SSH_USERNAME@$SSH_HOST" 'sudo systemctl daemon-reload; sudo systemctl stop gamedoora-user-services'

# copy the new JAR file to the remote directory and rename it
sshpass -p $SSH_PASS scp $JAR_FILE -o StrictHostKeyChecking=no "$SSH_USERNAME:$SSH_HOST:$REMOTE_DIRECTORY/$REMOTE_JAR_FILE"
sshpass -p $SSH_PASS ssh $SSH_USERNAME@host 'sudo chown gamedoora:gamedoora /opt/gamedoora/\*.jar; sudo systemctl restart gamedoora-user-services'

# Check the exit status of the previous command and set an output variable accordingly
if [ $? -eq 0 ]; then
  echo "::set-output name=status::success"
else
  echo "::set-output name=status::failure"
fi
