package parkinglottest;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import parkinglotclasses.ParkingLot;
import parkinglotfunctionality.CreateParkingLot;
import parkinglotfunctionality.ParkCar;
import parkinglotfunctionality.ParkingLotStatus;

public class ParkingLotStatusTest {

	@Test
	public void printStatusWithoutParkingLot() {
		ParkingLotStatus parkingLotStatusObj=new ParkingLotStatus();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		CreateParkingLot.isParkingLotCreated=false;
		assertEquals("Please create parking lot first before checking status! Please try again.",parkingLotStatusObj.getStatus(parkingLotObj));
		
	}
	
	@Test
	public void printStatusWithoutCarsParked() {
		ParkingLotStatus parkingLotStatusObj=new ParkingLotStatus();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		CreateParkingLot.isParkingLotCreated=true;
		assertEquals("Currently no cars are parked!",parkingLotStatusObj.getStatus(parkingLotObj));
		
	}
	
	@Test
	public void checkStatus() {
		ParkingLotStatus parkingLotStatusObj=new ParkingLotStatus();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		CreateParkingLot.isParkingLotCreated=true;
		ParkCar parkCarObj=new ParkCar();
		parkingLotObj.setCapacity(2);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLotObj);
		regNumber="KA-09-12345";
		color="blue";
		parkCarObj.parkCar(regNumber, color, parkingLotObj);
		assertEquals("Parking lot status is displayed.",parkingLotStatusObj.getStatus(parkingLotObj));
		
	}
	
}
