package parkinglotfunctionality;

import parkinglotclasses.ParkingLot;

public class RegNumberOfParticularColor {

	public String regNumbersOfParticularColor(String color,ParkingLot parkingLotObject){
		String message="";
		if(!CreateParkingLot.isParkingLotCreated) {
			message="Parking lot is not created! Please create parking lot first and try again.";
			return message;
		}
		boolean colorCheck=false;
		if(color=="") {
			message="The color cannot be empty!! Please enter a color and try again.";
			return message;
		}
		for(int i=0;i<parkingLotObject.getCarsInLot().size();i++) {
			if(parkingLotObject.getCarsInLot().get(i).getCarColor().toLowerCase().equals(color.toLowerCase())) {
				colorCheck=true;
				message+=parkingLotObject.getCarsInLot().get(i).getRegNumber()+", ";
			}
		}
		if(!colorCheck) {
			message="There are no cars of that color in the parking lot! Please try again.";
			return message;
		}
		System.out.println();
		return message.substring(0,(message.length()-2));
	}
}
