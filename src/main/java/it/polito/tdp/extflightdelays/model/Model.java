package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private Map<Integer, Airport> airportMap;
	private ConnectionMap connectionMap;
	
	public Model() {
		this.dao = new ExtFlightDelaysDAO();
		this.airportMap = new HashMap<>();
		this.connectionMap = new ConnectionMap();
		
		for (Airport a : dao.loadAllAirports())
			airportMap.put(a.getId(), a);
	
		dao.loadConnections(this.airportMap, this.connectionMap);
				
	}
	
	public void createGraph(double minAvgDistance) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		Graphs.addAllVertices(this.grafo, airportMap.values());
		
		for(Connectio c : connectionMap.getConnessioni())
			if (c.getAvgDistance() >= minAvgDistance)
				Graphs.addEdge(grafo, c.getArrivalAirport(), c.getDepartureAirport(), c.getAvgDistance());
	}

	public Graph<Airport, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}	
	
}
