# Informations supplémentaires


## Membres du groupe :

* Enzo Amieva
* Adrien Depretz
* Noémie Lecherf


## Description des actions effectuées :

* Creation de tests unitaires permettant de tester plusieurs fonctions de notre projet.
* Liaison de notre projet avec sonarQube pour mesurer la qualité de notre code.
* Création d'un fichier jenkins représentant notre pipeline permettant de récupérer notre projet git, de le faire tourner lui et ses tests unitaires, de générer le site web, de lancer SonarQube ainsi que de publier sur Nexus. Le pipeline sera lancer sur Jenkins qui est un outil logiciel d'intégration continue permettant de tester et de signaler les modifications effectuées sur notre projet.


## Difficultées rencontrées :

Lors de l'ajout des tests unitaires, l'un des tests ne voulait pas bien encoder les accents lors de l'exécution de ce dernier. Cela a donc généré une erreur empechant le test de fonctionner. 
Cet événement s'est produit lors de l'intégration au pipeline alors que tout fonctionnait en local.


## Fonctionnalités supplémentaires mises en place :

* Mise en place de SonarQube
* Mise en place de Nexus
