#!/bin/bash

REPOSITORY=/home/ec2-user/NUTEE/crawl
DEPLOY=/home/ec2-user/NUTEE/crawl-jar

echo "> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f nutee-crawl)

echo "$CURRENT_PID"

if [ -z $CURRENT_PID ]; then
    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -15 $CURRENT_PID"
    kill -15 $CURRENT_PID
    sleep 5
fi

echo "> 새 어플리케이션 배포"

echo "> Build 파일 복사"

cp $REPOSITORY/build/libs/*.jar $DEPLOY/

JAR_NAME=$(ls $DEPLOY/ |grep 'nutee-crawl' | tail -n 1)

echo "> JAR Name: $JAR_NAME"

nohup java -jar $DEPLOY/$JAR_NAME 1>/dev/null 2>&1 &
