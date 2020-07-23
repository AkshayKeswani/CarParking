package parkinglotfunctionality;
import java.util.ArrayList;

import parkinglotclasses.ParkingLot;

public class CreateParkingLot {
	
	public static boolean isParkingLotCreated=false;
	@SuppressWarnings("finally")
	public ParkingLot  createParkingLot(String lotSize) {
		//checkParkingLotCreated();
		ParkingLot parkingLot=new ParkingLot(new ArrayList());
		String message="";
		try {
			Integer lotSizeInt=Integer.parseInt(lotSize);
			if(lotSizeInt<=0) {
				message="Please enter a parking lot size greater than zero";
			}		
			else {
				parkingLot.setCapacity(lotSizeInt);
				isParkingLotCreated=true;
				message="Parking lot created successfully with size-"+lotSize;
			}
			parkingLot.setMessage(message);
		}
		catch(Exception e) {
			message="Please enter a numeric parking lot size";
			parkingLot.setMessage(message);
		}

		finally {
			return parkingLot;
		}
}
	
	public boolean checkParkingLotCreated() {
		
		if(isParkingLotCreated) {
			return true;
		}
		return false;
	}
}
