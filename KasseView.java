import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.text.Font;


/**
 * Write a description of class KuecheGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KasseView extends GridPane
{
    private Button bBezahlungErfolgt = new Button("Bezahlung erfolgt");

    
    private TextArea ausgabe = new TextArea();
    private ComboBox cbTischNr;
    
    public KasseView()
    {
       super();
       Label title = new Label("Kasse");
       title.setFont(new Font("Arial", 20));
       
       cbTischNr = new ComboBox();
       cbTischNr.getItems().addAll(
         "1",
         "2",
         "3",
         "4"
       );
       
       cbTischNr.getSelectionModel().selectFirst();
       
       this.add(title,0,0,3,1);
       this.add(new Label("Tisch-Nr."),0,1);
       this.add(cbTischNr,1,1);
       this.add(new Label("Rechnung:"),0,2);
       this.add(ausgabe,0,3,3,1);
       this.add(bBezahlungErfolgt,0,5,3,1);
       
       this.setPadding(new Insets(10,10,10,10));
       this.setVgap(10);
       this.setHgap(10);
       
       ausgabe.setEditable(false);
       ausgabe.setPrefColumnCount(20);
       ausgabe.setPrefRowCount(8);   
    }
    
    public void setView(Kasse kasse)
    {
        ausgabe.setText(kasse.toString());
    }
    
    public ComboBox getTischNrComboBox()
    {
        return cbTischNr;
    }
    
    public Button getBezahlungErfolgtButton()
    {
        return bBezahlungErfolgt;
    }
    
    public int getTischNr()
    {
        return Integer.parseInt((String) cbTischNr.getValue());
    }
}
