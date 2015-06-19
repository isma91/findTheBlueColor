import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class premierJeu extends PApplet {

int nbDeLignes=3;
int  nbDeColonnes=5;
int tailleCase=100;
int couleur;
int[][] tab=new int[nbDeLignes][nbDeColonnes];
int coordonneX=PApplet.parseInt(random(0,2));
int coordonneY=PApplet.parseInt(random(0,4));


//la fonction qui suit prend en argument un tableau 2D qui en pratique ne contient pour l'instant que des 0 et des 1. 
//Elle affiche dans la fen\u00eatre graphique un rectangle pour chaque cellule du tableau : ce rectangle est rouge 
//si la cellue  contient un 0 et est vert si la cellule contient un 1.

public void  afficher(int[][] tab){
  for(int numLigne=0;numLigne<tab.length;numLigne++){
    for(int numColonne=0;numColonne<tab[0].length;numColonne++){
      if(tab[numLigne][numColonne]==0){
        couleur=color(255,0,0);
        fill(couleur);
        rect(numColonne*tailleCase,numLigne*tailleCase,tailleCase,tailleCase);
      }
        if(tab[numLigne][numColonne]==1){
        couleur=color(0,255,0);//La verte pour les cases cocher mais pas le bon
        fill(couleur);
        rect(numColonne*tailleCase,numLigne*tailleCase,tailleCase,tailleCase);}
      if(tab[numLigne][numColonne]==2){
        couleur=color(255,0,0);//Le rouge pour les cases non toucher
        fill(couleur);
        rect(numColonne*tailleCase,numLigne*tailleCase,tailleCase,tailleCase);}
         if(tab[numLigne][numColonne]==3){
           couleur=color(0,0,255);//La bleue pour la case coch\u00e9 qui est le bon
        fill(couleur);
        rect(numColonne*tailleCase,numLigne*tailleCase,tailleCase,tailleCase);}
      }
    }
  }

//la fonction mousePressed d\u00e9finit les actions suivantes : lorsqu'on clique dans un des rectangles, la valeur correspondante
//est modifi\u00e9e dans le tableau : si c'\u00e9tait un 1, elle passe \u00e0 0 et inversement 
//Cette fonction est appel\u00e9e \u00e0 chaque fois qu'un clic est d\u00e9tect\u00e9.

public void mousePressed(){
  int numColonneCliquee=floor(nbDeColonnes*mouseX/width);
  int indiceLigne=floor(nbDeLignes*mouseY/height);
  if(tab[indiceLigne][numColonneCliquee]==0){
    tab[indiceLigne][numColonneCliquee]=1;
  }
  if(tab[indiceLigne][numColonneCliquee]==2){
    tab[indiceLigne][numColonneCliquee]=3;
  }
}
  

public void setup(){
  size(tailleCase*nbDeColonnes,tailleCase*nbDeLignes);//on dimensionne la fen\u00eatre en fonction du nombre de case et de leur taille
  
  //initialisation du tableau : on le remplit de 0
  for(int i=0;i<nbDeLignes;i++){
    for(int j=0;j<nbDeColonnes;j++){
      tab[i][j]=0;
      tab[coordonneX][coordonneY]=2;
    }
  }
  afficher(tab); 
  System.out.println(tailleCase);
}

public void draw(){
  afficher(tab);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "premierJeu" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
