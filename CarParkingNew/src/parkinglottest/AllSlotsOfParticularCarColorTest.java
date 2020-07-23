package parkinglottest;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import parkinglotclasses.ParkingLot;
import parkinglotfunctionality.AllSlotsOfParticularCarColor;
import parkinglotfunctionality.CreateParkingLot;
import parkinglotfunctionality.ParkCar;
import parkinglotfunctionality.RegNumberOfParticularColor;

public class AllSlotsOfParticularCarColorTest {

	@Test
	public void parkingLotAbsent() {
		CreateParkingLot.isParkingLotCreated=false;
		AllSlotsOfParticularCarColor allSlotsOfParticularCarColor=new AllSlotsOfParticularCarColor();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		String color="";
		assertEquals("Parking lot is not created! Please create parking lot first and try again.",allSlotsOfParticularCarColor.allSlotsOfParticularCarColor(color, parkingLotObject));
	}
	
	@Test
	public void emptyCarColor() {
		CreateParkingLot.isParkingLotCreated=true;
		AllSlotsOfParticularCarColor allSlotsOfParticularCarColor=new AllSlotsOfParticularCarColor();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		String color="";
		assertEquals("The color cannot be empty!! Please enter a color and try again.",allSlotsOfParticularCarColor.allSlotsOfParticularCarColor(color, parkingLotObject));
	}
	
	@Test
	public void colorDoesNotExist() {
		CreateParkingLot.isParkingLotCreated=true;
		AllSlotsOfParticularCarColor allSlotsOfParticularCarColor=new AllSlotsOfParticularCarColor();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		ParkCar parkCarObj=new ParkCar();
		parkingLotObject.setCapacity(5);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		regNumber="KA-09-123567";
		color="white";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		String testColor="green";
		assertEquals("There are no cars of that color in the parking lot! Please try again.",allSlotsOfParticularCarColor.allSlotsOfParticularCarColor(testColor, parkingLotObject));
	}
	
	@Test
	public void slotsBasedOnColor() {
		CreateParkingLot.isParkingLotCreated=true;
		AllSlotsOfParticularCarColor allSlotsOfParticularCarColor=new AllSlotsOfParticularCarColor();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		ParkCar parkCarObj=new ParkCar();
		parkingLotObject.setCapacity(5);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		regNumber="KA-09-123567";
		color="white";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		String testColor="black";
		assertEquals("1",allSlotsOfParticularCarColor.allSlotsOfParticularCarColor(testColor, parkingLotObject));
	}
	
	@Test
	public void regNumberBasedOnColorMultipleMatches() {
		CreateParkingLot.isParkingLotCreated=true;
		AllSlotsOfParticularCarColor allSlotsOfParticularCarColor=new AllSlotsOfParticularCarColor();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		ParkCar parkCarObj=new ParkCar();
		parkingLotObject.setCapacity(5);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		regNumber="KA-09-123567";
		color="black";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		String testColor="black";
		assertEquals("1, 2",allSlotsOfParticularCarColor.allSlotsOfParticularCarColor(testColor, parkingLotObject));
	}

}
