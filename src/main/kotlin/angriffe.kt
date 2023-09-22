open class angriffe(var name: String,
               var schaden: IntRange,
               var heilung: Int,
               var schild: Int) {
}
    //Angriffe Ork
    //"Normaler Angriff","Angriff Block","Selbst Heilung","Schild "
    var angriffOrk: angriffe= angriffe("Normaler Angriff",10..25,0,0)       //
    var angriffBlock: angriffe= angriffe("Angriff Block",0..0,0,0)
    var selbstHeilung: angriffe= angriffe("Selbst Heilung",0..0,200,0)      //
    var schildStoß: angriffe= angriffe("Schildstoß",20..40,0,0)

    //Angriffe Barde
    //"Alle heilen","Normaler Angriff","Selbst heilen","Alle schilden für 3 Runden"
    var alleHeilen: angriffe= angriffe("Alle Heilen",0..0,200,0)
    var angriffBarde: angriffe= angriffe("Normaler Angriff",8..15,0,0)
    var selbstHeilung2: angriffe= angriffe("Selbst Heilen",0..0,150,0)
    var alleSchilden: angriffe= angriffe("Alle Schilden",0..0,0,80)

    //Angriffe Zwerg
    //"Normaler Angriff","Blutung zufügen für 3 Runden","Schwerer Angriff","Lebensraub"
    var angriffZwerg: angriffe= angriffe("Normaler Angriff",35..60,0,0)
    var blutungZufügen:angriffe= angriffe("Blutung zufügen",30..45,0,0)
    var schwererAngriff:angriffe= angriffe("Schwerer Angriff",80..120,0,0)
    var lebensRaub:angriffe= angriffe("Lebensraub",40..45,40,0)

    //Angriffe Boss
    //"Biss ein Ziel","Biss alle Ziele","Stampfen","Ruten hieb","Heilung um 3%","Heuler"
    var bissEinZiel:angriffe= angriffe("Biss ein Ziel",50..60,0,0)
    var bissAlleZiele:angriffe= angriffe("Biss alle Ziele",30..40,0,0)
    var stampfen:angriffe= angriffe("Stampfen",15..20,0,0)
    var rutenHieb:angriffe= angriffe("Rutenhieb",40..60,0,0)
    var heilen:angriffe= angriffe("Heilung",0..0,100,0)
    var heuler:angriffe= angriffe("Heuler",0..0,0,0)

    //Angriffe BossHelfer
    //"Gift Biss","Gift Spritze (AOE)","Schrei","Kopfnuss"
    var giftBiss:angriffe= angriffe("Gift Biss",30..40,0,0)
    var giftSpritze:angriffe =angriffe("Gift Spritze",15..25,0,0)
    var schrei:angriffe= angriffe("Schrei",0..0,0,0)
    var kopfNuss:angriffe= angriffe("Kopfnuss",30..40,0,0)
