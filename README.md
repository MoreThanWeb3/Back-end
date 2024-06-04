# CAR SHOW

## Description

Ce projet est une application de showdown de voiture développée en Java avec le framework Spring Boot. 
## Fonctionnalités


- **Gestion des utilisateurs** : Inscription et authentification des utilisateurs.
- **Base de données** : Utilisation de JPA pour gérer les entités et les opérations CRUD sur les voitures et les utilisateurs.
- **API RESTful** : Fournit une API pour accéder aux fonctionnalités de l'application.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) ou version supérieure
- [Maven](https://maven.apache.org/install.html)
- [Postgresql](https://www.postgresql.org/download/) 

## Installation

1. Clonez le dépôt du projet :
    ```bash
    git clone https://github.com/MoreThanWeb3/Back-end
    ```

2. Accédez au répertoire du projet :
    ```bash
    cd car_show
    ```

3. Configurez la base de données dans le fichier `application.properties` :
    ```properties
    spring.datasource.url=jdbc:`your database link`
    spring.datasource.username=`your username`
    spring.datasource.password=`your_pass`
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Compilez et exécutez l'application :
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## Utilisation

Une fois l'application démarrée, elle sera accessible via `http://localhost:8080`.
Vous pouvez utiliser des outils comme Postman ou votre navigateur pour interagir avec l'API.

### Endpoints principaux

- **GET /cars** : Récupère la liste de toutes les voitures.
- **POST /cars** : Ajoute une nouvelle voiture.
- **GET /cars/{id}** : Récupère les détails d'une voiture spécifique.
- **PUT /cars/{id}** : Met à jour les informations d'une voiture.
- **DELETE /cars/{id}** : Supprime une voiture.

## Contribuer

Les contributions sont les bienvenues ! Pour contribuer :

1. Forkez le projet.
2. Créez votre branche de fonctionnalité (`git checkout -b feature/AmazingFeature`).
3. Commitez vos changements (`git commit -m 'Add some AmazingFeature'`).
4. Pushez sur la branche (`git push origin feature/AmazingFeature`).
5. Ouvrez une Pull Request.

## Auteurs

- **AndoKami** -  - [AndoKami](https://github.com/AndoKami)
- **Eclisher** -  - [Eclisher](https://github.com/Eclisher)

---