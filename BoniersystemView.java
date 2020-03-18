

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * View des gesamten Boniersystems. Dieser View enthaelt die vier anderen Views
 *
 * @author Sven Frimont
 * @version 18.03.2020
 */
public class BoniersystemView
{
    
    GridPane pane = new GridPane();
     
    public BoniersystemView(BarView barView,KasseView kasseView, KuecheView kuecheView, HandgeraetView handTerminalView)
    {
        pane.add(handTerminalView,0,0);
        pane.add(kasseView,1,0);
        pane.add(kuecheView,0,1);
        pane.add(barView,1,1);
        pane.setGridLinesVisible(true);
    }

    public void show(Stage stage)
    {
        Scene scene = new Scene(pane,557,440);
        stage.setScene(scene);
        stage.show();
    }
}
