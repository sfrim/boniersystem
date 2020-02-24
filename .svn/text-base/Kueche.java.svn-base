import java.util.*;

/**
 * @author Sven Frimont
 * @version 28.01.2012
 */
public class Kueche
{

    private ArrayList<Bestellung> zBestellungenListe;

    // Konstruktor
    public Kueche()
    {
        zBestellungenListe = new ArrayList<Bestellung>();
    }

    // Dienste
    public void bestellungUebergeben(Bestellung pEineBestellung)
    {
        // Getraenke aus der Bestellung loeschen, da in der Kueche nur Essen bereitgestellt werden
        Bestellung essenBestellung = new Bestellung();
        essenBestellung.setTischNr(pEineBestellung.getTischNr());
        for (int i=0; i < pEineBestellung.size(); i++)
        {
            if (pEineBestellung.getArtikel(i) instanceof Essen)
            {
                essenBestellung.artikelHinzufuegen(pEineBestellung.getArtikel(i), pEineBestellung.getMenge(i));
            }
        }
            
        if (essenBestellung.size() != 0) zBestellungenListe.add(essenBestellung);
    }
    
    public void zurNaechstenBestellung()
    {
        if (zBestellungenListe.size() != 0)
        {
            zBestellungenListe.remove(0);
        }
    }
    
    public String toString()
    {
        String text="";
        if (zBestellungenListe.size()==0)
        {
            text += "Keine Bestellung bekannt.";
        }
        else
        {
            Bestellung ersteBestellung = zBestellungenListe.get(0);
            text += "Tisch Nr "+ersteBestellung.getTischNr()+"\n";
            for (int i=0;i<ersteBestellung.size();i++)
            {
                text += ersteBestellung.getMenge(i)+"x "+ersteBestellung.getArtikel(i).getBezeichnung();
                text += "\n";
            }
            
        }
        return text;
    }
}
