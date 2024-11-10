# Utiliser l'image officielle Node.js comme base
FROM node:20.9.0

# Créer un répertoire de travail dans le conteneur
WORKDIR /usr/src/app

# Copier le fichier package.json et package-lock.json dans le conteneur
COPY package*.json ./

# Installer les dépendances du projet
RUN npm install

# Copier tout le code source dans le conteneur
COPY . .

# Exposer le port sur lequel ton application écoute
EXPOSE 3000

# Lancer le microservice MS-User
CMD ["npm", "start"]
