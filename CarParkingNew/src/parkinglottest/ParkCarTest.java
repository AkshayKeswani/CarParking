package parkinglottest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import parkinglotclasses.ParkingLot;
import parkinglotfunctionality.CreateParkingLot;
import parkinglotfunctionality.ParkCar;

public class ParkCarTest {
	
	@Test
	public void parkCarWhenParkingLotAbsent() {
		CreateParkingLot.isParkingLotCreated=false;
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLot=new ParkingLot();
		String regNumber="KA-09-1234";
		String color="black";
		assertEquals("The parking lot is not created. Please create parking lot first!!",parkCarObj.parkCar(regNumber, color, parkingLot));
	}
	
	@Test
	public void blankRegNumber() {
		CreateParkingLot.isParkingLotCreated=true;
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLot=new ParkingLot();
		String regNumber="";
		String color="black";
		assertEquals("The registration number or the car color cannot be empty!!",parkCarObj.parkCar(regNumber, color, parkingLot));
	}
	
	@Test
	public void blankColor() {
		CreateParkingLot.isParkingLotCreated=true;
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLot=new ParkingLot();
		String regNumber="KA-09-1234";
		String color="";
		assertEquals("The registration number or the car color cannot be empty!!",parkCarObj.parkCar(regNumber, color, parkingLot));
	}
	
	@Test
	public void blankRegNumberAndColor() {
		CreateParkingLot.isParkingLotCreated=true;
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLot=new ParkingLot();
		String regNumber="";
		String color="";
		assertEquals("The registration number or the car color cannot be empty!!",parkCarObj.parkCar(regNumber, color, parkingLot));
	}
	
	@Test
	public void parkCarEmptyParkingLot() {
		CreateParkingLot.isParkingLotCreated=true;
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLot=new ParkingLot(new ArrayList());
		parkingLot.setCapacity(5);
		String regNumber="KA-09-1234";
		String color="black";
		assertEquals("Your car has been assigned slot number-1",parkCarObj.parkCar(regNumber, color, parkingLot));
	}
	
	@Test
	public void parkCarWhenParkingLotFull() {
		CreateParkingLot.isParkingLotCreated=true;
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLot=new ParkingLot(new ArrayList());
		parkingLot.setCapacity(2);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLot);
		regNumber="KA-09-12345";
		color="blue";
		parkCarObj.parkCar(regNumber, color, parkingLot);
		regNumber="KA-09-123456";
		color="green";
		assertEquals("The parking is already full!!",parkCarObj.parkCar(regNumber, color, parkingLot));
	}
	
	@Test
	public void parkCarAtLastEmptySlot() {
		CreateParkingLot.isParkingLotCreated=true;
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLot=new ParkingLot(new ArrayList());
		parkingLot.setCapacity(5);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLot);
		regNumber="KA-09-123567";
		color="white";
		parkCarObj.parkCar(regNumber, color, parkingLot);
		regNumber="KA-09-123567";
		color="red";
		assertEquals("Your car has been assigned slot number-3",parkCarObj.parkCar(regNumber, color, parkingLot));
	}
	
	@Test
	public void parkCarAtInBetweenSlot() {
		CreateParkingLot.isParkingLotCreated=true;
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLot=new ParkingLot(new ArrayList());
		parkingLot.setCapacity(5);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLot);
		regNumber="KA-09-123567";
		color="white";
		parkCarObj.parkCar(regNumber, color, parkingLot);
		regNumber="KA-09-123567";
		color="red";
		parkCarObj.parkCar(regNumber, color, parkingLot);
		parkingLot.getCarsInLot().remove(1);
		regNumber="KA-09-1235678";
		color="Teal";
		assertEquals("Your car has been assigned slot number-2",parkCarObj.parkCar(regNumber, color, parkingLot));
		
	}
}
