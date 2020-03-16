# BME-MIT-BRSZT-TETRIS


Egy játékosnak a tömbje 10 blokk széles, és 24 blokk magas. Két játékosunk van.
Ergo a megbeszéltek alapján két 2D int-es tömböt foglalunk le, a fenti dimenziók szerint.

Az int értékek alapján legyen:

  0: Üres  
  1: Piros  
  2: Narancssárga  
  3: Sárga  
  4: Zöld  
  5: Világoskék  
  6: Sötétkék  
  7: Lila  
A specifikációl látható, melyik színhez milyen szabványméretű blokkok tartozzanak.

A játékos int tömbje [24][10] dimenziójú.

Annak függvényében, hogy melyik képernyőn vagyunk éppen, várok a GUI-hoz egy értéket, amit a .setScreen-el lehet beállítani (az alapértelmezett 0-t és kezdőképernyőt Én biztosítom);
  
  0: Belépő Screen  
  1: Menü  
  2: Single  
  3: Multi  
  4: Highscore  
  
