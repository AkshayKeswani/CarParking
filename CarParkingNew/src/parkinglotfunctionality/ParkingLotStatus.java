package parkinglotfunctionality;

import parkinglotclasses.ParkingLot;

public class ParkingLotStatus {

	public String getStatus(ParkingLot parkingLotObj) {
		
		String message="";
		if(!CreateParkingLot.isParkingLotCreated) {
			message="Please create parking lot first before checking status! Please try again.";
		}
		else if(parkingLotObj.getCarsInLot().size()==0){
			message="Currently no cars are parked!";
		}
		else {
			System.out.print("Slot number	");
			System.out.print("Registration number	");
			System.out.print("Color");
			System.out.println();
			for(int i=0;i<parkingLotObj.getCarsInLot().size();i++) {
				System.out.print(parkingLotObj.getCarsInLot().get(i).getAssignedSlot()+"		");
				System.out.print(parkingLotObj.getCarsInLot().get(i).getRegNumber()+"		 ");
				System.out.print(parkingLotObj.getCarsInLot().get(i).getCarColor());
				System.out.println();
			}
			message="Parking lot status is displayed.";
		}
		return message;
	}
}
