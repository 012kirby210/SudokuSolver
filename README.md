# SudokuSolver
Sudoku solver

## NFP 136 

### En substance : 
Une grille est initialisée avec l'ensemble de ses valeurs potentielles.
Celles-ci sont représentées par l'indice d'un bit mis à 1 dans un chiffre dont le code est représenté sur au moins 10 bits.
(Ceci pour rester dans un type primitif et donc être passé par copie et pas par référence)

Ainsi l'ensemble {1,3,5} des valeurs potentielles pour une case donnée est représenté par ce nombre : 
0x2^0 + 1x2^1+ 0x2^2 + 1x2^3+ 0x2^4 + 1x2^5 + 0x2^6 + 0x2^7 + 0x2^8 +0x2^9 (+ 0... pour le reste des bits)
0 1 0 1 0 1 0 0 0 0 (0...)

En petit boutiste : (0...) 0 0 0 0 1 0 1 0 1 0

Si l'on souhaite passer des types primitifs plutôt que des références, c'est pour utiliser la pile d'appel de fonction plutôt que de réinventer la roue (en l'occurence une pile des possiblités).

- Algo :
```
Effectuer le chargement de la grille
Appeler résoudre en lui passant la grille en argument
```

Résoudre : (est une récurrence)
```
déterminer la case où commencer, s'il n'existe pas de cas : arrêt de la récurrence
déterminer par une heuristique simple par quelle valeur possible commencer
Définir la case précédemment choisie à la valeur précédemment choisie.
Propager la contrainte sur la valeur de la case aux 3 ensembles affiliés à cette case :
 - la ligne qui la contient (1)
 - la colonne qui la contient (2)
 - le carré qui la contient (3)
appeler résoudre avec la nouvelle grille (récurrence)
```  
Les trois fonctions (1), (2), (3) restent au même niveau de récurrence, prennent la grille du niveau de récurrence actuel en entrée en envoie une grille modifiée en sortie remplaçant celle en entrée. Exemple de signature :
```Grille propageValeurDansLigne(Grille g,int valeur,int x, int y)```    

La récurrence s'arrête lorsque la grille est remplie ou lorsque les fonctions de propagation de contrainte génère une exception de type "violation" qu'il faut définir.
Cet événement apparaît lorsqu'on insère une valeur déjà présente dans la ligne, la colonne ou le carré contenant la case.

Les grilles à solutions multiples sont anticipables avec des oracles. Je n'ai pas eu le temps de me pencher sur le sujet.

Amusez-vous bien

Luc
