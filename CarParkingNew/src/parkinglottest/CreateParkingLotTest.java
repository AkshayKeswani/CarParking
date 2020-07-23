package parkinglottest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import parkinglotclasses.ParkingLot;
import parkinglotfunctionality.CreateParkingLot;

public class CreateParkingLotTest {

	CreateParkingLot createPlotObj=new CreateParkingLot();
	@Test
	public void createParkingLotZeroSize() {
		ParkingLot parkLot=createPlotObj.createParkingLot("0");
		assertEquals("Please enter a parking lot size greater than zero",parkLot.getMessage());
	}
	
	@Test
	public void createParkingLotNegativeSize() {
		ParkingLot parkLot=createPlotObj.createParkingLot("-2");
		assertEquals("Please enter a parking lot size greater than zero",parkLot.getMessage());
	}
	
	@Test
	public void createParkingLotValidSize() {
		ParkingLot parkLot=createPlotObj.createParkingLot("5");
		assertEquals("Parking lot created successfully with size-5",parkLot.getMessage());
	}
	
	@Test
	public void createParkingLotInvalidSize() {
		ParkingLot parkLot=createPlotObj.createParkingLot("abcd");
		assertEquals("Please enter a numeric parking lot size",parkLot.getMessage());
	}
	
	@Test
	public void checkParkingLotAlreadyCreated() {
		CreateParkingLot.isParkingLotCreated=true;
		assertEquals(true,createPlotObj.checkParkingLotCreated());
	}
	
	@Test
	public void checkParkingLotNotAlreadyCreated() {
		CreateParkingLot.isParkingLotCreated=false;
		assertEquals(false,createPlotObj.checkParkingLotCreated());
	}
}
