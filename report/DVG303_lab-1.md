DVG303 :: Objektorienterad design och programmering
860224 Jonas Sjöberg
Högskolan i Gävle
tel12jsg@student.hig.se


1.
================================================================================

(a) Modellera klasserna som representerar konkreta geometriska figurer som ska
    kunna hanteras i programmet och därför ska ingå i programmets datamodell:
    
    Punkt, linje, triangel, cirkel, rektangel.

    Beskriv klasserna på ett liknande sätt som i kursboken, kap 2.2, på sida 65
    - tredje upplaga.  Skapa dessutom ett UML-klassdiagram för modellen.

    Motivera era beslut: 
    Varför skapade ni modellen som den är? 
    Varför har klasserna de attribut och operationer så som ni valde?


(b) Implementera klasserna som ingår i klassdiagrammet och skapa JUnit-tests
    för att testa koden!
    
    Tips:
    Filen oodp lab ht2015.zip innehåller ett Eclipse-projekt som ni ska använda
    för ert arbete. I projektet finns klassen Vertex2D (se ovan); använd 
    klassen när ni skapar modell-klasserna.
    Som redan sagts så roteras t.ex. en figur runt sin medelpunkt genom att 
    rotera figurens noder runt den. En linje kan alltså roteras runt sin 
    medelpunkt p genom att anropa rotate på start- och slutnod 
    (angle lagrar rotationsvinkeln i grader):

      // rotera startnod omkring positionen:
      v0 = v0.rotate (p, angle);

      // rotera slutnod omkring positionen:
      v1 = v1.rotate (p, angle);

    Samma princip går att använda vid stoleksändring (med scale) och flytt 
    (med moveBy - men här behövs ingen referenspunkt).

(c) Vilken relation ser ni mellan klassen Vertex2D och figurklasserna 
    resp. mellan instanser av Vertex2D och instanser av figurklasserna? 
    På vilket sätt återspeglas relationen i klassdiagrammet? Ge en förklaring!

2.
================================================================================

(a) En superklass kan inneh˚ alla attribut och operationer som a¨r gemensamma
f¨or ett antal klasser.
Beskriv en superklass till klasserna ni skapade i uppgift 1! Beskrivningen ska in-
neh˚alla information om vilka attribut det ska finnas i superklassen och vilka med-
delanden (kommandon och fr˚    agor) man kan skicka till instanser av superklass-
typen.
F¨orklara varf¨ or ni best¨ amde er f¨or just den upps¨attning attribut/operationer
som ni valde!

(b) Ska superklassen vara en abstrakt klass eller inte? Diskutera3 vad som talar
emot och vad som talar f¨or!

(c) Uppdatera klassdiagrammet från uppgift 1, så att den nya klassen ingår i
    modellen samt relationerna mellan superklassen och befintliga klasser!
(d) Implementera modellen som ni skapade i (c), dvs. aktualisera koden från 
    uppgift 1 så att den motsvarar klassdiagrammet från (c)!
    Använd testen som ni utvecklade i uppgift 1 för att visa att klasserna 
    fungerar som förut!

3.
================================================================================

(a) Betrakta nu modellen en gång till: Ser ni likheter när det gäller objektens
    beteenden? Vilka är dessa? Ge en beskrivning!
(b) Utöka nu klassdiagrammet en gång till: Lägg till minst ett interface som
    deklarerar någon metod som passar till det som ni beskrev ovan. 
    Låt klasserna implementera interfacet ifall det passar!
(c) Uppdatera koden från uppgift 2 så att den motsvarar den utökade modelleni
    från (b)!


4. (Bonus)
================================================================================

Uppgiften kan ge upp till tre bonuspo¨ang.
(a) En polygon ¨ar en figur som best˚  ar av ett godtyckligt antal noder med linje-
drag mellan noderna. Noderna ¨ar ordnade; ett linjedrag ritas ut bara mellan en
nod och nodens efterf¨ oljare (efterf¨oljare av sista noden ¨ar den f¨orsta) - f¨or ett
exempel se figur 6.
Modellera en klass Polygon (beskrivning, klassdiagram) och implementera klass-
en samt skapa l¨
               ampliga testfall p˚
                                 a ett liknande s¨att som i uppgifterna ovan!
Det finns tv˚
            a m¨
               ojligheter att tilldela noderna till en Polygon-instans: En ¨ar att
anv¨
   anda konstruktorn, den andra en metod som tar emot en position, skapar
en nod och l¨
            agger den till noderna som redan finns.
Vilken du v¨
           aljer best¨ammer du sj¨alv (kanske att det finns andra m¨ojligheter
ocks˚
    a), men du ska f¨
                    orklara ditt val och diskutera f¨or och nackdelar med det!
   3 Med utmaningen ’diskutera’ menas h¨ ar att ni ska skriva ner f¨
                                                                   or- och nackdelar och ¨
                                                                                         aven
slutsatserna som ni drar n¨
                          ar ni j¨
                                 amf¨
                                    or dem.



