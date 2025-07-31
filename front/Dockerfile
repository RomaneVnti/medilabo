# Étape 1 : Build de l'app avec Node.js
FROM node:18-alpine AS build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build

# Étape 2 : Servir avec nginx
FROM nginx:alpine

COPY --from=build /app/dist /usr/share/nginx/html

# Copier la config nginx personnalisée si tu en as besoin (optionnel)
# COPY nginx.conf /etc/nginx/nginx.conf

EXPOSE 5173

CMD ["nginx", "-g", "daemon off;"]
