package parkinglotfunctionality;

import parkinglotclasses.ParkingLot;

public class SlotNumberForGivenRegNumber {

	public String slotNumberForCarRegNumber(String regNumber,ParkingLot parkingLotObject) {
		String message="";
		if(!CreateParkingLot.isParkingLotCreated) {
			message="Parking lot is not created! Please create parking lot first and try again.";
			return message;
		}
		boolean regNumberCheck=false;
		if(regNumber=="") {
			message="The registration number cannot be empty!! Please enter a registration number and try again.";
			return message;
		}
		for(int i=0;i<parkingLotObject.getCarsInLot().size();i++) {
			if(parkingLotObject.getCarsInLot().get(i).getRegNumber().equals(regNumber)) {
				regNumberCheck=true;
				message+=parkingLotObject.getCarsInLot().get(i).getAssignedSlot();
				break;
			}
		}
		if(!regNumberCheck) {
			message="There are no cars of that registration number in the parking lot! Please try again.";
			return message;
		}
		System.out.println();
		return message;
	}
}
