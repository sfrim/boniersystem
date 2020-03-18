
/**
 * @author Sven Frimont
 * @version 18.03.2020
 */
public abstract class Artikel
{

    // Attribute
    private int nr; 
    private String bezeichnung;
    private double preis;

    // Konstruktor
    public Artikel(int pNr, String pBezeichnung, double pPreis)
    {
        nr = pNr;
        bezeichnung = pBezeichnung;
        preis = pPreis;
    }

    
    public int getNr()
    {
        return nr;
    }
    
    public String getBezeichnung()
    {
        return bezeichnung;
    }
    
    public double getPreis()
    {
        return preis;
    }
    
}
