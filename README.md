# WorldFactory - Example AbstractFactory Pattern

https://lucid.app/lucidchart/d339c5fc-bcdd-4475-bd80-2f3db0a74a9a/edit?view_items=mcxtxq.352v5%2CVgxt9Vbt_zQG&invitationId=inv_6179644f-37c7-4f8d-9040-25a4b01f1989
## Ziel

Entwickle eine Desktop-Anwendung in Java, die eine Auswahl zwischen zwei Welten ermöglicht: einer mittelalterlichen und einer Science-Fiction-Welt. Jede Welt hat spezifische Charaktere, Waffen und ein passendes Bild, das dargestellt wird. Die Anwendung sollte eine ansprechende, moderne Benutzeroberfläche besitzen.

### Anforderungen:

1. **Architektur: Abstract Factory Pattern**
    - Verwende das **Abstract Factory Design Pattern**, um die Erstellung der Objekte für die beiden Welten zu kapseln.
    - Implementiere zwei konkrete Fabriken:
        - `MedievalWorldFactory` für die mittelalterliche Welt
        - `SciFiWorldFactory` für die Science-Fiction-Welt
2. **GUI: Moderne Benutzeroberfläche**
    - Entwickle eine grafische Oberfläche mit **Swing**.
3. **Charaktere und Waffen:**
    - Definiere eine gemeinsame Schnittstelle für Charaktere (`Character`) und Waffen (`Weapon`).
    - Implementiere mindestens zwei konkrete Klassen für jede Welt:
        - **Mittelalterliche Welt:**
            - Charakter: Ritter
            - Waffe: Schwert
        - **Science-Fiction-Welt:**
            - Charakter: Raumfahrer
            - Waffe: Laserkanone
        - (8-Bit Welt)
            - Character: Mario
            - Waffe: Pilzkanone
4. **Ressourcen:**
    - Integriere Bilder, die den Charakteren entsprechen
    - Lade die Bilder dynamisch basierend auf der Auswahl des Nutzers.

### Beispiel-Ausgabe:

Wenn der Nutzer auf "Mittelalterliche Welt" klickt, zeigt die Anwendung:

```java
Charakter: Tapferer Ritter in glänzender Rüstung  
Waffe: Scharfes Schwert  
```

Wenn der Nutzer "Science-Fiction-Welt" auswählt, zeigt die Anwendung

```java
Charakter: Futuristischer Raumfahrer mit Power-Rüstung  
Waffe: Laserkanone  
```

(Zusatz: “8-bit Welt” → Die Anwendung zeigt…)

```java
Charakter: 8-bit springender Mario  
Waffe: Münzkanone
```

> Made with <3 by Thomas; Repo:  https://github.com/muethb20/syp-abstractfactory
>
