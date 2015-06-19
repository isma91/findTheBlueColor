int nbDeLignes=3;
int  nbDeColonnes=5;
int tailleCase=100;
color couleur;
int[][] tab=new int[nbDeLignes][nbDeColonnes];
int coordonneX=int(random(0,2));
int coordonneY=int(random(0,4));


//la fonction qui suit prend en argument un tableau 2D qui en pratique ne contient pour l'instant que des 0 et des 1. 
//Elle affiche dans la fenêtre graphique un rectangle pour chaque cellule du tableau : ce rectangle est rouge 
//si la cellue  contient un 0 et est vert si la cellule contient un 1.

void  afficher(int[][] tab){
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
           couleur=color(0,0,255);//La bleue pour la case coché qui est le bon
        fill(couleur);
        rect(numColonne*tailleCase,numLigne*tailleCase,tailleCase,tailleCase);}
      }
    }
  }

//la fonction mousePressed définit les actions suivantes : lorsqu'on clique dans un des rectangles, la valeur correspondante
//est modifiée dans le tableau : si c'était un 1, elle passe à 0 et inversement 
//Cette fonction est appelée à chaque fois qu'un clic est détecté.

void mousePressed(){
  int numColonneCliquee=floor(nbDeColonnes*mouseX/width);
  int indiceLigne=floor(nbDeLignes*mouseY/height);
  if(tab[indiceLigne][numColonneCliquee]==0){
    tab[indiceLigne][numColonneCliquee]=1;
  }
  if(tab[indiceLigne][numColonneCliquee]==2){
    tab[indiceLigne][numColonneCliquee]=3;
  }
}
  

void setup(){
  size(tailleCase*nbDeColonnes,tailleCase*nbDeLignes);//on dimensionne la fenêtre en fonction du nombre de case et de leur taille
  
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

void draw(){
  afficher(tab);
}
