package parkinglottest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import parkinglotclasses.ParkingLot;
import parkinglotfunctionality.CreateParkingLot;
import parkinglotfunctionality.LeaveParkingLot;
import parkinglotfunctionality.ParkCar;

public class LeaveParkingLotTest {

	@Test
	public void leaveCarWithoutParkingLotCreated() {
		CreateParkingLot.isParkingLotCreated=false;
		LeaveParkingLot leaveCar=new LeaveParkingLot();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		String slotToLeave="2";
		assertEquals("Parking lot is not created! Please create and try again.",leaveCar.leaveParkingLot(slotToLeave, parkingLotObj));
	}
	
	@Test
	public void leaveCarWithNegativeSlotNumber() {
		CreateParkingLot.isParkingLotCreated=true;
		LeaveParkingLot leaveCar=new LeaveParkingLot();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		String slotToLeave="-2";
		assertEquals("Please enter a slot number greater than zero and try again.",leaveCar.leaveParkingLot(slotToLeave, parkingLotObj));
	}
	
	@Test
	public void leaveCarWithZeroSlotNumber() {
		CreateParkingLot.isParkingLotCreated=true;
		LeaveParkingLot leaveCar=new LeaveParkingLot();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		String slotToLeave="0";
		assertEquals("Please enter a slot number greater than zero and try again.",leaveCar.leaveParkingLot(slotToLeave, parkingLotObj));
	}
	
	@Test
	public void leaveCarWithInvalidSlotNumber() {
		CreateParkingLot.isParkingLotCreated=true;
		LeaveParkingLot leaveCar=new LeaveParkingLot();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		String slotToLeave="abcd";
		assertEquals("Please enter a numeric slot number.",leaveCar.leaveParkingLot(slotToLeave, parkingLotObj));
	}
	
	@Test
	public void leaveCarWithNonExistantSlotNumber() {
		CreateParkingLot.isParkingLotCreated=true;
		LeaveParkingLot leaveCar=new LeaveParkingLot();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		parkingLotObj.setCapacity(3);
		String slotToLeave="4";
		assertEquals("Slot number does not exist! Please try again.",leaveCar.leaveParkingLot(slotToLeave, parkingLotObj));
	}
	
	@Test
	public void leaveCarEmptySlotNumber() {
		CreateParkingLot.isParkingLotCreated=true;
		LeaveParkingLot leaveCar=new LeaveParkingLot();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		parkingLotObj.setCapacity(5);
		String slotToLeave="3";
		assertEquals("No car is parked in that slot! Please try again.",leaveCar.leaveParkingLot(slotToLeave, parkingLotObj));
	}
	
	@Test
	public void leaveCarSuccessfully() {
		CreateParkingLot.isParkingLotCreated=true;
		LeaveParkingLot leaveCar=new LeaveParkingLot();
		ParkCar parkCarObj=new ParkCar();
		ParkingLot parkingLotObj=new ParkingLot(new ArrayList());
		parkingLotObj.setCapacity(3);
		String regNumber="KA-09-1234";
		String color="black";
		parkCarObj.parkCar(regNumber, color, parkingLotObj);
		regNumber="KA-09-123567";
		color="white";
		parkCarObj.parkCar(regNumber, color, parkingLotObj);
		String slotToLeave="2";
		assertEquals("The car in slot number-2 is removed.",leaveCar.leaveParkingLot(slotToLeave, parkingLotObj));
	}
}
