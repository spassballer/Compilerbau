
# Java Mini-Compiler

### Gruppenaufteilung

- Scannen - Daniel Maurer
- Parsen - Fabio Knappe, Oskar Eulitz, Leo Stadler
- Semantische Analyse - Nico Wenzelmann, Matthias Heilmann
- ASM - Jarred Maidhof, Daniel Selensky
- Testen - Kari Zepernik (exmatrikuliert) -> **jeder hat seinen Teil getestet**

### Bedienungsanleitung Java Compiler

1. Projekt klonen
2.  Im Terminal des Linux Servers `make`  aufrufen. (Testsuit wird kompiliert und ausgeführt)

Um eigene Java-Klassen zu testen, können die zu testenden Java-Klassen im Ordner "testfiles" eingefügt werden. Zudem muss folgende Zeile im Makefile unter dem Punkt ```Test``` eingefügt werden:
```
java -cp "asm-7.1.jar:." Main < testfiles/Testklasse.java
```
(wobei Testklasse.java zum Namen der zu Testenden Klasse angepasst werden soll).

Anschließend kann wieder der Befehl `make` ausgeführt werden. Die von unserem Compiler kompilierte Class-Datei ist im Ordner `codegenerierung` zu finden.

### UML-Diagramm

![Das UML-Diagramm des Projektes](/UML_Diagramm.svg "UML-Diagramm")
