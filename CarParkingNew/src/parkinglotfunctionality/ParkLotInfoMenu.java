package parkinglotfunctionality;

import java.util.Scanner;

import parkinglotclasses.ParkingLot;
import parkinglothomepage.WelcomeToParkngLot;

public class ParkLotInfoMenu {
	
	public void parkLotInfo(ParkingLot parkingLotObj) {
		while(true) {
			Scanner choice=new Scanner(System.in);
			Scanner option=new Scanner(System.in);
			System.out.println("Welcome to the information section. Please select which details you want");
			System.out.println("");
			System.out.println("1-Registration numbers of all cars of a particular colour");
			System.out.println("");
			System.out.println("2-Slot number in which a car with a given registration number is parked");
			System.out.println("");
			System.out.println("3-Slot numbers of all slots where a car of a particular colour is parked");
			System.out.println("");
			System.out.println("4-Go back to the main menu");
			String userChoice=choice.nextLine();
			if("1".equals(userChoice)) {
				RegNumberOfParticularColor regNumbersOfParticularColor=new RegNumberOfParticularColor();
				System.out.println("Please enter the car color");
				String color=option.nextLine();
				System.out.println(regNumbersOfParticularColor.regNumbersOfParticularColor(color.trim(), parkingLotObj));
				System.out.println();
			}
			
			else if("2".equals(userChoice)) {
				SlotNumberForGivenRegNumber slotNumberForGivenRegNumber=new SlotNumberForGivenRegNumber();
				System.out.println("Please enter the car registration Number");
				String regNumber=option.nextLine();
				System.out.println(slotNumberForGivenRegNumber.slotNumberForCarRegNumber(regNumber.trim(), parkingLotObj));
				System.out.println();
			}
			
			else if("3".equals(userChoice)) {
				AllSlotsOfParticularCarColor allSlotsOfParticularCarColor=new AllSlotsOfParticularCarColor();
				System.out.println("Please enter the car color");
				String color=option.nextLine();
				System.out.println(allSlotsOfParticularCarColor.allSlotsOfParticularCarColor(color.trim(), parkingLotObj));
				System.out.println();
			}
			
			else if("4".equals(userChoice)) {
				break;
			}
			
			else {
				System.out.println("Please select a valid option! Please try again.\n");
				System.out.println();
			}
		}
		
	}
	
}