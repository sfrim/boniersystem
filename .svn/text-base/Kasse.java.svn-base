import java.util.*;
import java.text.*;

/**
 * Datentyp für die Speicherung eines Rechnungspostens, zu jedem bestellten
 * Artikel wird die Bestellanzahl gespeichert.
 */
class Rechnungsposten
{
    Artikel artikel;
    int anzahl;
    
    public Rechnungsposten(Artikel einArtikel, int dieAnzahl)
    {
        artikel = einArtikel;
        anzahl = dieAnzahl;
    }
}

/**
 * @author Sven Frimont
 * @version 20.02.2012
 */
public class Kasse
{
    // Bezugsobjekte
    private ArrayList tischRechnung[];
 
    // Attribute
    private int tischNr; // Der Tisch, fuer den eine Rechnung angezeigt werden soll
    private String datum; // das aktuelle Datum
    
    // Konstruktor
    public Kasse(int anzahlTische)
    {
        // das aktuelle Datum setzen
        datum = DateFormat.getDateInstance().format(new Date());
        
        // fuer jeden Tisch wird eine Artikelliste
        // mit der dazugehoerigen Mengenliste gespeichert
        tischRechnung = new ArrayList[anzahlTische];
        
        // Arraylists erstellen
        for(int i=0;i<anzahlTische;i++)
        {
            tischRechnung[i] = new ArrayList<Rechnungsposten>();
        }
        
        tischNr = 1; // Zu Beginn wird immer die Rechnung von Tisch 1 angezeigt
    }

    // Dienste
    public void bestellungHinzufuegen(Bestellung pEineBestellung)
    { 
        int tischNr = pEineBestellung.getTischNr();
        for (int i=0;i<pEineBestellung.size();i++)
        {
            tischRechnung[tischNr-1].add(new Rechnungsposten(pEineBestellung.getArtikel(i),
                                               pEineBestellung.getMenge(i)));
        }   
    }
    
    public void setTischNr(int pTischNr)
    {
        tischNr = pTischNr;
    }
    
    public int getTischNr()
    {
        return tischNr;
    }
    
    public void rechnungLoeschen(int tischNummer)
    {
        tischRechnung[tischNummer-1].clear();
    }
    
    public String toString()
    {
        String text="";
        // Nur eine Rechnung ausgeben, wenn bereits etwas bestellt wurde
        if (tischRechnung[tischNr-1].size()!=0)
        {
           // Die angezeigten BetrÔøΩge in das richtige Format bringen
           DecimalFormat euro = new DecimalFormat("#0.00");
           
           text+="Tisch #"+tischNr+"  "+datum;
           text+="\n==============================\n";
           for (int i=0;i<tischRechnung[tischNr-1].size();i++)
           {
               String preis = euro.format(artikel(i).getPreis());
               String gesamtpreis = euro.format(menge(i)*artikel(i).getPreis());
               text += gesamtpreis+" Euro: "+menge(i)+" x "+artikel(i).getBezeichnung();
               if (artikel(i) instanceof Getraenk)
               {
                  text += " ("+((Getraenk)artikel(i)).getGroesse()+")";  
               }
               text += " je "+preis+" Euro\n";
           }
           text+="==============================\n";
           text += euro.format(gesamtpreisBrutto())+" Euro Total\n\n"+
                   euro.format(gesamtpreisNetto())+" Euro Nettoumsatz\n"+
                   euro.format(gesamtpreisBrutto()-gesamtpreisNetto())+" Euro MwSt 19%";
        }
        return text;
    }
    
    // ------- ab hier fuer andere Klassen nicht sichtbar ---------------
    private double gesamtpreisNetto()
    {
        double summe = 0;
        for(int i=0;i<tischRechnung[tischNr-1].size();i++)
        {
            summe += preis(i);
        }
        return summe;
    }
    
    private double gesamtpreisBrutto()
    {
        return gesamtpreisNetto()*1.19;
    }
    
    private double preis(int pPosition)
    {
        return artikel(pPosition).getPreis() * menge(pPosition);
    }
    
    private Artikel artikel(int pPosition)
    {
        return ((Rechnungsposten) tischRechnung[tischNr-1].get(pPosition)).artikel;
    }
    
    private int menge(int pPosition)
    {
        return ((Rechnungsposten) tischRechnung[tischNr-1].get(pPosition)).anzahl;
    }    
    
}
