import java.util.ArrayList;

/**
 * In dieser Klasse kann die Anbindung an eine Datenbank
 * (z.B. MySQL) programmiert werden. Zunaechst wird die Klasse vereinfacht mit Hilfe einer ArrayList
 * implementiert. Die Anbindung an eine Datenbank soll erst in einem
 * späteren Entwicklungsschritt erfolgen.
 * 
 * @author Sven Frimont
 * @version 10.02.2020
 */
public class Artikeldatenbank
{
    // Alle Artikel werden in einer ArrayList gespeichert
    private ArrayList<Artikel> artikeldb;
    
    public Artikeldatenbank()
    {
        artikeldb = new ArrayList<Artikel>();
    }
    
    /**
     * Speicherung eines neuen Essens in der Datenbank.
     */
    public void essenEinpflegen(Essen pEssen)
    {
        artikeldb.add(pEssen);
    }
    
    /**
     * Speicherung eines neuen Getraenks in der Datenbank.
     */
    public void getraenkEinpflegen(Getraenk pGetraenk)
    {
        artikeldb.add(pGetraenk);
    }
    
    /**
     * Suche des Essens mit der Nummer aus der Speisekarte
     * @param pNr die Nummer aus der Speisekarte
     * @return alle in der Datenbank vorhandenen Informationen zu dem Essen oder
     * "null", wenn kein passendes Essen gefunden wurde
     */
    public Essen sucheEssen(int pArtikelnummer)
    {
        for(Artikel aktuellesObjekt: artikeldb)
        {
            if(aktuellesObjekt.getNr()==pArtikelnummer)
            {
                if (aktuellesObjekt instanceof Essen)
                    return (Essen)aktuellesObjekt;
            }
        }
        return null;
    }
    
    /**
     * Suche des Getraenks mit der Nummer aus der Speisekarte
     * @param pNr die Nummer aus der Speisekarte
     * @return alle in der Datenbank vorhandenen Informationen zu dem Getraenk oder
     * "null", wenn kein passendes Getraenk gefunden wurde
     */
    public Getraenk sucheGetraenk(int pNr)
    {
        for(Artikel aktuellesObjekt: artikeldb)
        {
            if(aktuellesObjekt.getNr()==pNr)
            {
                if (aktuellesObjekt instanceof Getraenk)
                    return (Getraenk)aktuellesObjekt;
            }
        }
        return null;
    }
    
}
