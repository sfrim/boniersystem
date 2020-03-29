

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Der Controller für das Boniersystem
 *
 * @author Sven Frimont
 * @version 18.03.2020
 */
public class Controller extends Application
{
    
    BarView barView = new BarView();
    KasseView kasseView = new KasseView();
    KuecheView kuecheView = new KuecheView();
    HandgeraetView handgeraetView = new HandgeraetView();
    BoniersystemView boniersystemView = new BoniersystemView(barView,kasseView,kuecheView,handgeraetView);
    
    public Bestellung dieBestellung = new Bestellung();
    public Artikeldatenbank dieDatenbank;
    
    public Kueche dieKueche = new Kueche();
    public Bar dieBar = new Bar();
    public Kasse dieKasse = new Kasse(5);
    
    public Controller()
    {
        kuecheView.getKuecheButton().setOnAction(this::kuecheButtonClicked);
        barView.getBarButton().setOnAction(this::barButtonClicked);
        handgeraetView.getGetraenkBestellenButton().setOnAction(this::getraenkBestellenButtonClicked);
        handgeraetView.getEssenBestellenButton().setOnAction(this::essenBestellenButtonClicked);
        handgeraetView.getBestellungAbsendenButton().setOnAction(this::bestellungAbsendenButtonClicked);  
        kasseView.getTischNrComboBox().setOnAction(this::tischNrComboBoxChanged);
        kasseView.getBezahlungErfolgtButton().setOnAction(this::bezahlungErfolgtButtonClicked);
        
        
        this.dieDatenbank = new Artikeldatenbank();
        this.dieDatenbank.getraenkEinpflegen(new Getraenk(1, "Coca Cola", "klein", 2.00));
        this.dieDatenbank.getraenkEinpflegen(new Getraenk(2, "Rotwein", "Glas", 3.80));
        this.dieDatenbank.essenEinpflegen(new Essen(1, "Pizza Funghi", 6.00));
        this.dieDatenbank.essenEinpflegen(new Essen(2, "Lasagne", 7.00));
        this.dieDatenbank.essenEinpflegen(new Essen(3, "Spaghetti Bolognese", 7.00));
        
        aktualisiereViews();
    }
    
    public void start(Stage stage)
    {
        stage.setTitle("Kassensystem");
        boniersystemView.show(stage);
    }
    
    
    public void kuecheButtonClicked(Event event) {
        dieKueche.zurNaechstenBestellung();
        aktualisiereViews();
    }
    
    public void barButtonClicked(ActionEvent event) {
        dieBar.zurNaechstenBestellung();
        aktualisiereViews();
    }
    
    public void getraenkBestellenButtonClicked(ActionEvent event) {        
        Artikel auswahl = this.dieDatenbank.sucheGetraenk(handgeraetView.getGetraenkNr());
        this.dieBestellung.artikelHinzufuegen(auswahl, 1);
        handgeraetView.loescheEingabeGetraenk();
        aktualisiereViews();
    }
    
    public void essenBestellenButtonClicked(ActionEvent event) {
        Artikel auswahl = this.dieDatenbank.sucheEssen(handgeraetView.getEssenNr());
        this.dieBestellung.artikelHinzufuegen(auswahl, 1);
        handgeraetView.loescheEingabeEssen();
        aktualisiereViews();
    }
    
    public void bestellungAbsendenButtonClicked(ActionEvent event) {
        // Die Tischnummer zu der Bestellung abfragen
        // und zu der Bestellung speichern
        int tischNr = handgeraetView.getTischNr();
        dieBestellung.setTischNr(tischNr);

        // Die Bestellung an die Bar und an die Kueche senden
        dieBar.sendeBestellung(dieBestellung);
        dieKueche.bestellungUebergeben(dieBestellung);

        // Die Bestellung der Rechnung hinzufuegen
        dieKasse.bestellungHinzufuegen(dieBestellung);

        // Die alte Bestellung wird nun nicht mehr gebraucht und es kann
        // mit dem new-Operator eine neue Bestellung erstellt werden
       dieBestellung = new Bestellung();
        
       aktualisiereViews();
    }
    
    public void tischNrComboBoxChanged(Event event)
    {
        int tischNr = kasseView.getTischNr();
        dieKasse.setTischNr(tischNr);
        aktualisiereViews();
    }
    
    public void bezahlungErfolgtButtonClicked(Event event)
    {
        dieKasse.rechnungLoeschen(kasseView.getTischNr());
        aktualisiereViews();
    }
    
    public void aktualisiereViews() {
        handgeraetView.setView(dieBestellung);
        kuecheView.setView(dieKueche);
        barView.setView(dieBar);
        kasseView.setView(dieKasse);
    }
}
