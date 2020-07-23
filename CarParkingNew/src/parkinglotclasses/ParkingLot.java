package parkinglotclasses;

import java.util.List;

public class ParkingLot {
	
	private Integer parkingCapacity;
	private List<Car> carsInLot;
	private String message;
	
	public ParkingLot() {
		
	}
	public ParkingLot(List<Car> carsInLot) {
		this.carsInLot=carsInLot;
	}
	public Integer getCapacity() {
		return parkingCapacity;
	}

	public void setCapacity(Integer capacity) {
		this.parkingCapacity = capacity;
	}

	public List<Car> getCarsInLot() {
		return carsInLot;
	}

	public void setCarsInLot(List<Car> carsInLot) {
		this.carsInLot = carsInLot;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

