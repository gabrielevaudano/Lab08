package it.polito.tdp.extflightdelays.model;

public class Connectio {
	private Airport departureAirport;
	private Airport arrivalAirport;
	private Double avgDistance;
	
	public Connectio(Airport departureAirport, Airport arrivalAirport, Double avgDistance) {
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.avgDistance = avgDistance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalAirport == null) ? 0 : arrivalAirport.hashCode());
		result = prime * result + ((departureAirport == null) ? 0 : departureAirport.hashCode());
		return result;
	}
	
	

	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public Double getAvgDistance() {
		return avgDistance;
	}
	

	public void setAvgDistance(Double avgDistance) {
		this.avgDistance = (this.avgDistance + avgDistance) / 2;
	}

	@Override
	public boolean equals(Object obj) {
		Connectio other = (Connectio) obj;
		
		if (obj==null || !(obj instanceof Connectio))
			return false;
		
		if (departureAirport.getId()==other.getDepartureAirport().getId() &&
				arrivalAirport.getId()==other.getArrivalAirport().getId())
			return true;
		else if (departureAirport.getId() == other.getArrivalAirport().getId() && 
				arrivalAirport.getId() == other.getDepartureAirport().getId())
			return true;
		else
			return false;
	}
	
}
