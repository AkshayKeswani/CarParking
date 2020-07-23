package parkinglothomepage;

import java.util.Scanner;
import parkinglotclasses.ParkingLot;
import parkinglotfunctionality.CreateParkingLot;
import parkinglotfunctionality.LeaveParkingLot;
import parkinglotfunctionality.ParkCar;
import parkinglotfunctionality.ParkLotInfoMenu;
import parkinglotfunctionality.ParkingLotStatus;


public class WelcomeToParkngLot {
	
	public static void main(String[] args) {
		ParkingLot parkingLotObj=new ParkingLot();
	    CreateParkingLot createPlotObj=new CreateParkingLot();
	    ParkCar parkCarFuncObj=new ParkCar(); 
	    LeaveParkingLot leaveParkingLotObj=new LeaveParkingLot();
	    ParkingLotStatus parkingLotStatusObj=new ParkingLotStatus();
	    ParkLotInfoMenu parkLotInfoMenu=new ParkLotInfoMenu();
		System.out.println("-------------Welcome to Parking Lot Management System---------------");
		while(true) {
			System.out.println("");
			System.out.println("Please select what you would like to do:");
			System.out.println("");
			System.out.println("Available choices-");
			System.out.println("");
			System.out.println("1-Create parking lot");
			System.out.println("2-Park a car");
			System.out.println("3-Leave parking lot");
			System.out.println("4-Parking lot information section");
			System.out.println("5-Parking Status");
			System.out.println("6-Exit");
			
			Scanner command=new Scanner(System.in);
			String userChoice=command.nextLine();
			if("1".equals(userChoice)) {
				if(createPlotObj.checkParkingLotCreated()) {
					System.out.println("The parking lot is already created!!");
				}
				else {
					System.out.println("Please enter the parking lot size");
					Scanner size=new Scanner(System.in);
					String lotSize=size.nextLine();
					parkingLotObj=createPlotObj.createParkingLot(lotSize);
					System.out.println(parkingLotObj.getMessage());
				}
			}
			else if("2".equals(userChoice)) {
				if(CreateParkingLot.isParkingLotCreated) {
					Scanner carDetails=new Scanner(System.in);
					System.out.println("Please enter the Registration number of the car");
					String regNumber=carDetails.nextLine();
					System.out.println("Please enter the color of the car");
					String color=carDetails.nextLine();
					System.out.println(parkCarFuncObj.parkCar(regNumber,color,parkingLotObj));
				}
				else {
					System.out.println("Please create parking lot first! And then try again.");
				}
				
				}
			else if("3".equals(userChoice)) {
				if(CreateParkingLot.isParkingLotCreated) {
					System.out.println("Please enter the slot number you want to leave.");
					Scanner slotInput=new Scanner(System.in);
					String slot=slotInput.nextLine();
					System.out.println(leaveParkingLotObj.leaveParkingLot(slot,parkingLotObj));
				}
				else {
					System.out.println("Please create parking lot first! And then try again.");
				}
			}
			
			else if("4".equals(userChoice)) {
				if(CreateParkingLot.isParkingLotCreated) {
					parkLotInfoMenu.parkLotInfo(parkingLotObj);
				}
				else {
					System.out.println("Please create parking lot first before viewing information! Please try again.");
				}
			}
			
			else if("5".equals(userChoice)) {
				System.out.println(parkingLotStatusObj.getStatus(parkingLotObj));
			}
			
			else if("6".equals(userChoice)) {
				System.out.println("Goodbye, please visit again");
				break;
			}
			else {
				System.out.println("Please select a valid option and try again.");
			}
	    }
}
}	
	

