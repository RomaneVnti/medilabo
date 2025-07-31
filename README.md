# 🧬 Medilabo
Ce projet Médilabo est une application en microservices permettant de gérer les dossiers patients, leurs historiques médicaux et d’évaluer les risques de diabète de type 2.

## ⚙️ Technologies & outils

Java 21

Spring Boot 3.1.0

Spring Security

MySQL / MongoDB

Maven

React + Vite


## 🚀 Installation
### 🛠️ Prérequis
Docker

Git

### 📥 Cloner le dépôt

```bash
git clone https://github.com/RomaneVnti/medilabo.git
cd medilabo
```

### Modifier informations de connection

Dans le .env :
```bash
DATABASE_USERNAME=root
DATABASE_PASSWORD=your_password
```

Dans le fichier patient/src/main/resources/application.properties :
```bash
spring.datasource.username=root
spring.datasource.password=your_password
```


### ▶️ Démarrer l'application avec Docker
```bash
docker-compose build
docker-compose up
docker-compose stop
```



### 🌐 Accès à l'application
http://localhost:5173

## 🧠 Architecture des microservices

```bash.
├── front         # Vite + React
├── patient       # Microservice Patient (MySQL)
├── notes         # Microservice Notes (MongoDB)
├── risk          # Microservice Risk Calculator
├── gateway       # API Gateway (Spring Cloud Gateway)
└── docker-compose.yml
```

## 🌿 Approche green coding
### 🔋 Efficacité énergétique
Le code est conçu pour minimiser la consommation d’énergie, notamment en :

- Utilisant des algorithmes optimisés (par exemple, une recherche binaire plutôt qu’un parcours linéaire),

- Évitant les calculs ou appels redondants,

### 🔁 Réduire, réutiliser, recycler
- Réduire la complexité du code : une méthode = une responsabilité.

- Réutiliser des composants front-end avec React et des fonctions métiers.

- Recycler du code en le refactorisant plutôt que de dupliquer.

### ♻️ Éco-conception logicielle
- Architecture modulaire avec microservices, permettant une scalabilité sans gaspillage de ressources.

- Utilisation de Docker pour isoler les services et optimiser leur déploiement.