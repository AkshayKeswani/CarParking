package parkinglottest;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import parkinglotclasses.ParkingLot;
import parkinglotfunctionality.CreateParkingLot;
import parkinglotfunctionality.ParkCar;
import parkinglotfunctionality.RegNumberOfParticularColor;
import parkinglotfunctionality.SlotNumberForGivenRegNumber;

public class SlotNumberForGivenRegNumberTest {

	@Test
	public void parkingLotAbsent() {
		CreateParkingLot.isParkingLotCreated=false;
		SlotNumberForGivenRegNumber slotNumberForGivenRegNumber=new SlotNumberForGivenRegNumber();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		String regNumber="";
		assertEquals("Parking lot is not created! Please create parking lot first and try again.",slotNumberForGivenRegNumber.slotNumberForCarRegNumber(regNumber, parkingLotObject));
	}
	
	@Test
	public void emptyRegistrationNumber() {
		CreateParkingLot.isParkingLotCreated=true;
		SlotNumberForGivenRegNumber slotNumberForGivenRegNumber=new SlotNumberForGivenRegNumber();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		String regNumber="";
		assertEquals("The registration number cannot be empty!! Please enter a registration number and try again.",slotNumberForGivenRegNumber.slotNumberForCarRegNumber(regNumber, parkingLotObject));
	}
	
	@Test
	public void registrationNumberDoesNotExist() {
		CreateParkingLot.isParkingLotCreated=true;
		SlotNumberForGivenRegNumber slotNumberForGivenRegNumber=new SlotNumberForGivenRegNumber();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		ParkCar parkCarObj=new ParkCar();
		parkingLotObject.setCapacity(5);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		regNumber="KA-09-123567";
		color="white";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		String testRegistrationNumber="KA-09-12345";
		assertEquals("There are no cars of that registration number in the parking lot! Please try again.",slotNumberForGivenRegNumber.slotNumberForCarRegNumber(testRegistrationNumber, parkingLotObject));
	}
	
	@Test
	public void registrationNumberExists() {
		CreateParkingLot.isParkingLotCreated=true;
		SlotNumberForGivenRegNumber slotNumberForGivenRegNumber=new SlotNumberForGivenRegNumber();
		ParkingLot parkingLotObject=new ParkingLot(new ArrayList());
		ParkCar parkCarObj=new ParkCar();
		parkingLotObject.setCapacity(5);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		regNumber="KA-09-123567";
		color="white";
		parkCarObj.parkCar(regNumber, color, parkingLotObject);
		String testRegistrationNumber="KA-09-123567";
		assertEquals("2",slotNumberForGivenRegNumber.slotNumberForCarRegNumber(testRegistrationNumber, parkingLotObject));
	}
}
