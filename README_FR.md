![][mont-saint_michel]


Projet Horaires des Marées
==============================================================

Description
--------------------------------------------------------------

Tout d'abord, nous avons effectué cette application dans le cadre d'un projet tuteuré.
Cette application a été codé en Java.

##### Quel est le but de cette application? 

Le but de cette application est d'afficher les informations des marées d'un port, suivant la date, sélectionnée à partir du calendrier de 2021. Il est possible de choisir parmi 10 ports de la Manche et de l'Atlantique. Une marée est identifiée par 4 informations : son horaire, sa hauteur d'eau, son coefficient et son type.

Installation
--------------------------------------------------------------
##### Première étape

Vous devez télécharger le dossier de l'application. Pour cela cliquer sur le logo Github ci-dessous.

[<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Octicons-mark-github.svg/2048px-Octicons-mark-github.svg.png" alt="drawing" width="40" heigth="40"/>](https://github.com/arthurpellegrini/tide-schedule)

Ensuite aller sur le bouton vert "code" et sélectionner "download zip".

##### Deuxième étape

Enfin, il faudra exécuter cette suite de commandes dans un terminal pour lancer l'application :

```sh
$ javac -cp build/classes -d build/classes \
$ (find src -name "*.java")
$ java -cp build/classes Fenetre
```
Si tout s'est bien déroulé, l'application doit s'être lancée, il ne vous reste plus qu'à tester notre application !

Usage
--------------------------------------------------------------

L'application a trois onglets sur la fenêtre principale. 
Le premier onglet permet de choisir une date sur un calendrier.
Le deuxième onglet permet de choisir le port et affiche un tableau contenant les données sur les 4 marées de la journée.
Et le dernier onglet affiche les hauteurs d'eau heure par heure pour la date et le port choisit précédemment.

Support
--------------------------------------------------------------

Si vous avez une question ou un problème, n'hésitez pas à nous contacter à l'adresse mail suivante : arthur.pellegrini2002@gmail.com

Feuille de route 
--------------------------------------------------------------

* Fixer les bugs connus
* Ajouter un graphique qui met en relation l'heure d'une marée et sa hauteur d'eau
* Améliorer l'interface de l'application

Contributions
--------------------------------------------------------------

Nous sommes ouverts à tout type de contributions. Les personnes qui le souhaitent peuvent proposer des changements par l'intermédiaire de Github en proposant des "commits".

Auteurs et remerciements
--------------------------------------------------------------

Les auteurs de ce projet sont les suivants : 

* GACHE Antoine 
* PELLEGRINI Arthur

Nous remercions aussi les personnes suivantes de nous avoir aidées lors du développement de cette application : 

* DELORME Nathan
* ROBBA Isabelle 
* WANG Lin Yu

Statut du projet
--------------------------------------------------------------

Le développement de ce projet a été stoppé après la transmission de celui-ci au jury de notre Université. Mais il est possible que l'application soit améliorée par la suite.


[//]: # (Lien de référence utilisé dans le corps du Markdown)
[mont-saint_michel]: https://1yupfa6inz37h6sb1hrjfp1c-wpengine.netdna-ssl.com/wp-content/uploads/2019/01/2880px-Mont-Saint-Michel_Drone.jpg