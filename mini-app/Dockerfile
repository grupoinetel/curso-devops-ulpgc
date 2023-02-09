FROM node:19-alpine

ENV MYNAME="me"

WORKDIR /app

COPY package.json /app

RUN npm install

COPY . /app

EXPOSE 3000

CMD ["node", "app.js"]
