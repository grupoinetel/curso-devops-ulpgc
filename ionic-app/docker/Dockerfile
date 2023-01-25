FROM ubuntu:20.04

LABEL Description="Instalación de framework Ionic"

ENV NODE_VERSION=18.13.0 \
    NPM_VERSION=9.3.0 \
    ANGULAR_CLI_VERSION=14.2.10 \
    IONIC_CLI_VERSION=6.20.8
    
RUN apt-get update &&  \
    apt-get install -y git wget curl unzip gcc make && \
    apt-get upgrade -y
    
RUN curl --retry 3 -SLO "http://nodejs.org/dist/v$NODE_VERSION/node-v$NODE_VERSION-linux-x64.tar.gz" && \
    tar -xzf "node-v$NODE_VERSION-linux-x64.tar.gz" -C /usr/local --strip-components=1 && \
    rm "node-v$NODE_VERSION-linux-x64.tar.gz" && \
    npm install -g npm@"$NPM_VERSION" && \
    npm install -g @angular/cli@"$ANGULAR_CLI_VERSION" && \
    npm install -g @ionic/cli@"$IONIC_CLI_VERSION" && \
    npm cache verify
    
WORKDIR /proyecto-ionic
EXPOSE 8100
CMD ["bash"]