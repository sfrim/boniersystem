 import java.util.*;

/**
 * Datentyp für die Speicherung eines Bestellpostens, zu jedem bestellten
 * Artikel wird die Bestellanzahl gespeichert.
 */
class Bestellposten
{
    Artikel artikel;
    int anzahl;
    
    public Bestellposten(Artikel einArtikel, int dieAnzahl)
    {
        artikel = einArtikel;
        anzahl = dieAnzahl;
    }
}

/**
 * Eine Bestellung wird an einem Handgerät durch einen Kellner durchgeführt. Es werden alle bestellten
 * Artikel in der gewünschten Menge in der Bestellung gespeichert. Die Bestellung enthält zudem
 * die Nummer des Tisches an dem die Bestellung aufgenommen wurde.
 * 
 * @author Sven Frimont
 * @version 10.02.2020
 */
public class Bestellung
{
    // Zu jedem bestellten Artikel wird die Bestellanzahl gespeichert
    ArrayList<Bestellposten> bestellposten;

    // Der Tisch an dem die Bestellung aufgenommen wird
    private int tischNr;

    public Bestellung()
    {
        bestellposten = new ArrayList<Bestellposten>();
        tischNr = 1;
    }

    /**
     * Ein Artikel wird in der angegebenen Anzahl der Bestellung hinzugefügt
     */
    public void artikelHinzufuegen(Artikel pArtikel, int pBestellmenge)
    {
        // Ueberpruefen, ob der Artikel bereits Teil der Bestellung ist
        int artikelNr = pArtikel.getNr();
        
        for (int i=0; i < bestellposten.size(); i++)
        {
            int vorhandenerArtikelNr = bestellposten.get(i).artikel.getNr();
            boolean verweisAufGleicheUnterklasse = ((pArtikel instanceof Getraenk) && (bestellposten.get(i).artikel instanceof Getraenk)) ||  
                                                   ((pArtikel instanceof Essen) && (bestellposten.get(i).artikel instanceof Essen));
            if (verweisAufGleicheUnterklasse && artikelNr == vorhandenerArtikelNr)
            {
                int anzahl = bestellposten.get(i).anzahl;
                anzahl += pBestellmenge;
                bestellposten.get(i).anzahl = anzahl;
                return;
            }
        }
        bestellposten.add(new Bestellposten(pArtikel, pBestellmenge));
    }
    
    public void setTischNr(int pTischNr)
    {
        tischNr = pTischNr;
    }
    
    public int getTischNr()
    {
        return tischNr;
    }
    
    /**
     * den Artikel an der angebenen Bestellposition zurückgeben
     */
    public Artikel getArtikel(int pPosition)
    {
        return bestellposten.get(pPosition).artikel;
    }
    
    /**
     * die Bestellmenge des Artikels an der angebenen Bestellposition zurückgeben
     */
    public int getMenge(int pPosition)
    {
        return bestellposten.get(pPosition).anzahl;
    }    
    
    
    /**
     * Die Anzahl der vorhandenen Bestellpositionen zurückgeben
     */
    public int size()
    {
        return bestellposten.size();
    }
    
    /**
     * Die Bestellung wird ausführlich als Text zurückgegeben
     */
    public String toString()
    {
        String text="";
        for (int i=0; i<bestellposten.size(); i++)
        {
            text+=getMenge(i)+"x "+getArtikel(i).getBezeichnung();
            if (bestellposten.get(i).artikel instanceof Getraenk)
            {
                text+=" ("+((Getraenk)bestellposten.get(i).artikel).getGroesse()+")";   
            }
            text+="\n";
        }
        return text;
    }
        
}
