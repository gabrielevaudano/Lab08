/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.extflightdelays;

import java.net.URL;
import java.util.ResourceBundle;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.extflightdelays.model.Airport;
import it.polito.tdp.extflightdelays.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	private Double minAvgDistance = -1.0;
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="distanzaMinima"
    private TextField distanzaMinima; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalizza"
    private Button btnAnalizza; // Value injected by FXMLLoader

    @FXML
    void doAnalizzaAeroporti(ActionEvent event) {
    	
    	txtResult.clear();
    	try {
    		Long start = System.currentTimeMillis();
    		model.createGraph(Double.parseDouble(distanzaMinima.getText()));
    		Long end = System.currentTimeMillis();
    		// Log
    		System.out.println(String.format("Il processo di creazione del grafo ha impiegato %d millisecondi.", (end-start)));
    		
    		
    		// Prima richiesta
    		txtResult.appendText(String.format("Il grafo ha %d vertici e %d archi.\n", model.getGrafo().vertexSet().size(), model.getGrafo().edgeSet().size()));
    		
    		// Seconda richiesta
	    	for (DefaultWeightedEdge e : model.getGrafo().edgeSet())
	    			txtResult.appendText(e.toString() + "\t" + model.getGrafo().getEdgeWeight(e) +"\n");
	    	
    	} catch (NumberFormatException ne) {
    		txtResult.setText("Campo inserito non valido: " + ne.getMessage());
    	} catch (Exception ex)
    	{
    		txtResult.setText("E' stato propagato un errore durante l'elaborazione. Di seguito la descrizione del problema: " + ex.getMessage());
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert distanzaMinima != null : "fx:id=\"distanzaMinima\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnalizza != null : "fx:id=\"btnAnalizza\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	try {
        	this.model = model;
    	}
    	catch (Exception ex)
    	{
    		txtResult.setText("E' stato propagato un errore durante l'elaborazione. Di seguito la descrizione del problema: " + ex.getMessage());
    	}
    }
}
