package AirlineManager;

public class Flight {
	private int ID = 0; 
	private String StartingPoint; 
	private String Destination; 
	private String DepartureTime; 
	private String TicketClass; 
	private String TicketType; 
	
	public Flight() {
		
	}
	
	public Flight(int ID, String StartingPoint, String Destination, String DepartureTime, String TicketClass, String TicketType) {
		this.setID(ID); 
		this.setStartingPoint(StartingPoint); 
		this.setDestination(Destination); 
		this.setDepartureTime(DepartureTime); 
		this.setTicketClass(TicketClass); 
		this.setTicketType(TicketType); 
	}

	public String getStartingPoint() {
		return StartingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		StartingPoint = startingPoint;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(String departureTime) {
		DepartureTime = departureTime;
	}

	public String getTicketClass() {
		return TicketClass;
	}

	public void setTicketClass(String ticketClass) {
		TicketClass = ticketClass;
	}

	public String getTicketType() {
		return TicketType;
	}

	public void setTicketType(String ticketType) {
		TicketType = ticketType;
	}
	
	
}
	
	
	
	
	
