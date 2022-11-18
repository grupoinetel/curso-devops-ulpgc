FROM tomcat:9.0.35-jdk11-openjdk

WORKDIR /usr/local/tomcat

COPY conf/server.xml conf/
COPY conf/tomcat-users.xml conf/
COPY conf/keystore.jks conf/
COPY conf/truststore.jks conf/

RUN cp -r webapps.dist/manager webapps/manager

COPY conf/manager-context.xml webapps/manager/META-INF/context.xml

#https
EXPOSE 8443
#http
EXPOSE 8080

#debug port
EXPOSE 8000 

ENV JPDA_ADDRESS *:8000
CMD ["bin/catalina.sh", "jpda", "run"]




