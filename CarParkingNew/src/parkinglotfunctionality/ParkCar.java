package parkinglotfunctionality;

import java.util.List;
import parkinglotclasses.Car;
import parkinglotclasses.ParkingLot;

public class ParkCar {

	public String parkCar(String regNumber,String color,ParkingLot parkingLot) {
		String message="";
		if(!CreateParkingLot.isParkingLotCreated) {
			message="The parking lot is not created. Please create parking lot first!!";
		}
		else if(regNumber.trim().isEmpty()||color.trim().isEmpty()) {
			message="The registration number or the car color cannot be empty!!";
		}
		else {
			Car car=new Car();
			car.setCarColor(color.trim());
			car.setRegNumber(regNumber.trim());
			if(parkingLot.getCarsInLot().isEmpty()) {
				car.setAssignedSlot(1);
				parkingLot.getCarsInLot().add(car);
				message="Your car has been assigned slot number-1";
			}
			else if(parkingLot.getCarsInLot().size()==parkingLot.getCapacity()){
				message="The parking is already full!!";
			}
			else {
				List<Car> parkedCars=parkingLot.getCarsInLot();
				boolean checkFlag=false;
				for(int i=0;i<parkedCars.size();i++) {
					if(i==(parkedCars.get(i).getAssignedSlot()-1)) {
						continue;
					}
					car.setAssignedSlot(i+1);
					parkingLot.getCarsInLot().add(i,car);
					checkFlag=true;
					break;
				}
				if(!checkFlag) {
					car.setAssignedSlot(parkedCars.size()+1);
					parkingLot.getCarsInLot().add(car);
				}
				message="Your car has been assigned slot number-"+car.getAssignedSlot();
			}
		}
		return message;
	}
}
