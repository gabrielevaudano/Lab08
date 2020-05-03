package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.List;

public class ConnectionMap {
	private List<Connectio> connessioni;

	public ConnectionMap() {
		connessioni = new ArrayList<Connectio>();
		}
	
	public void add(Connectio connessione) {
		if (connessioni.contains(connessione))
			connessioni.get(connessioni.indexOf(connessione)).setAvgDistance(connessione.getAvgDistance());
		else
			connessioni.add(connessione);
	}

	public List<Connectio> getConnessioni() {
		return connessioni;
	}

	
	
	
}
