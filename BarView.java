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
public class BarView extends GridPane
{
    private Button bWeiter = new Button("weiter");
    
    private TextArea ausgabe = new TextArea();
    
    public BarView()
    {
       Label title = new Label("Bar");
       title.setFont(new Font("Arial", 20));
       this.add(title,0,0);
       this.add(ausgabe,0,1,1,3);
       this.add(bWeiter,1,1);
       
       this.setPadding(new Insets(10,10,10,10));
       this.setVgap(10);
       this.setHgap(10);
       
       ausgabe.setEditable(false);
       ausgabe.setPrefColumnCount(12);
       ausgabe.setPrefRowCount(3);
    }
    
    public Button getBarButton()
    {
        return bWeiter;
    }
    
    public void setView(Bar bar)
    {
        ausgabe.setText(bar.toString());
    }
}
