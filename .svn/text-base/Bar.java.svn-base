import java.util.*;
import java.text.DateFormat;

/**
 * @author 
 * @version 
 */
public class Bar
{

    private ArrayList<Bestellung> bestellungen;

    // Konstruktor
    public Bar()
    {
        bestellungen = new ArrayList<Bestellung>();
    }

    // Dienste
    public void sendeBestellung(Bestellung pEineBestellung)
    {
        // Essen aus der Bestellung loeschen, da an der Bar nur Getraenke bereitgestellt werden
        Bestellung getraenkeBestellung = new Bestellung();
        getraenkeBestellung.setTischNr(pEineBestellung.getTischNr());
        for (int i=0; i < pEineBestellung.size(); i++)
        {
            if (pEineBestellung.getArtikel(i) instanceof Getraenk)
            {
                getraenkeBestellung.artikelHinzufuegen(pEineBestellung.getArtikel(i), pEineBestellung.getMenge(i));
            }
        }
            
        if (getraenkeBestellung.size() != 0) bestellungen.add(getraenkeBestellung);
            
    }
    
    
    public void zurNaechstenBestellung()
    {
        if (bestellungen.size()!=0) bestellungen.remove(0);
    }
    
    public String toString()
    {
        String text="";
        if (bestellungen.size()==0)
        {
            text += "Keine Bestellung bekannt.";
        }
        else
        {
            Bestellung ersteBestellung = bestellungen.get(0);
            text += "Tisch Nr "+ersteBestellung.getTischNr()+"\n";
            for (int i=0;i<ersteBestellung.size();i++)
            {            
                    text += ersteBestellung.getMenge(i)+"x "+ersteBestellung.getArtikel(i).getBezeichnung();
                    text += " ("+ ((Getraenk) ersteBestellung.getArtikel(i)).getGroesse()+")";
                    text += "\n";         
            }
            
        }
        return text;
    }
}
