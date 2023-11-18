FROM maven:3.8.5-openjdk-17
ENV TZ="Asia/Tehran"
COPY . .
CMD [ "mvn","test" ]
