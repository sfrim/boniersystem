
/**
 * @author Sven Frimont 
 * @version 18.03.2020
 */
public class Getraenk extends Artikel
{
    // Bezugsobjekte

    // Attribute
    private String groesse;

    // Konstruktor
    /**
     * @param pNr Nummer des Getraenks auf der Speisekarte
     * @param pBezeichnung der Name des Getraenks
     * @param pGroesse die Groesse des Getraenks ("klein", "mittel" oder "gross")
     * @param pPreis der Verkaufspreis laut Speisekarte
     */
    public Getraenk(int pNr, String pBezeichnung, String pGroesse, double pPreis)
    {
        super(pNr,pBezeichnung,pPreis);
        groesse = pGroesse;
    }

    // Dienste
    public String getGroesse()
    {
        return groesse;    
    }
    
}
