FROM node:20-alpine

WORKDIR /app/miniTwitter

COPY package*.json ./
RUN npm install

COPY . .

ENV MONGO_URL=mongodb://root:example@mongo:27017/minitwitter?authSource=admin

EXPOSE 3000
CMD ["node", "index.js"]