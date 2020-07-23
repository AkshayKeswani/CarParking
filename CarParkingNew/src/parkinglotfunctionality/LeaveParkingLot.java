package parkinglotfunctionality;

import java.util.List;

import parkinglotclasses.Car;
import parkinglotclasses.ParkingLot;

public class LeaveParkingLot {

	public String leaveParkingLot(String slotNumber,ParkingLot parkingLotObj) {
		
		String message="";
		if(!CreateParkingLot.isParkingLotCreated) {
			message="Parking lot is not created! Please create and try again.";
			return message;
		}
		try {
			Integer slotNumberInt=Integer.parseInt(slotNumber);
			if(slotNumberInt<=0) {
				message="Please enter a slot number greater than zero and try again.";
			}		
			else if(slotNumberInt>parkingLotObj.getCapacity()) {
				message="Slot number does not exist! Please try again.";
			}
			else {
				boolean slotCheckFlag=false;
				List parkedCars=parkingLotObj.getCarsInLot();
				for(int i=0;i<parkedCars.size();i++) {
					if(((Car) parkedCars.get(i)).getAssignedSlot().equals(slotNumberInt)) {
						parkingLotObj.getCarsInLot().remove(i);
						message="The car in slot number-"+slotNumberInt+" is removed.";
						slotCheckFlag=true;
					}
				}
				if(!slotCheckFlag) {
					message="No car is parked in that slot! Please try again.";
				}
			}
		}
		catch(Exception e) {
			message="Please enter a numeric slot number.";
		}
		return message;
	}
}
