# Informations supplémentaires


## Membres du groupe :

* Enzo Amieva
* Adrien Depretz
* Noémie Lecherf


## Description des actions effectuées :

* Creation de tests unitaires permettant de tester plusieurs fonctions de notre projet.
* Liaison de notre projet avec SonarQube pour mesurer la qualité de notre code.
* Création d'un fichier jenkins représentant notre pipeline permettant de récupérer notre projet git, de le faire tourner lui et ses tests unitaires, de générer le site web, de lancer SonarQube ainsi que de publier sur Nexus. Le pipeline sera lancer sur Jenkins qui est un outil logiciel d'intégration continue permettant de tester et de signaler les modifications effectuées sur notre projet.
* Création de notre projet avec Nexus, pour permettre de stocker notre fichier jar avec ses différentes version


## Difficultées rencontrées :

Lors de l'ajout des tests unitaires, l'un des tests ne voulait pas bien encoder les accents lors de l'exécution de ce dernier. Cela a donc généré une erreur empechant le test de fonctionner. 
Cet événement s'est produit lors de l'intégration au pipeline alors que tout fonctionnait en local.


## Fonctionnalités supplémentaires mises en place :

* Mise en place de SonarQube
* Mise en place de Nexus

## Aide mise en place
Si vous voulez reprendre ce projet avec une Pipeline Jenkins fonctionnel, il vous ajouter dans le credentials de jenkins:
    - Identifiant SonarQube ou Clé
    - Identifiant Nexus

Une fois ceci fait, il faut aller sur nexus et dans Repositories et crée un nouveau repository en Maven(Hosted), avec :
    - ID : TPJenkins
    - Name : TPJenkins

Si vous ne l'avez pas déja fait, aller dans les paramètres de Jenkins et renommer votre maven en => 'MAVEN'

Une fois ceci fait, la pipeline sera operationelle

## A propos du projet 
Ce projet fonctionne tant sur les fonctionnalité de l'appli que sur le déroulement de la pipeline

(Si vous avez un problème sur la pipeline au niveau de nexus, changer votre numéro de version dans votre Pom.xml)
