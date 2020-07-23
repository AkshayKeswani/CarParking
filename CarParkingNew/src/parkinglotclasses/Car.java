package parkinglotclasses;

public class Car {
	
	private String regNumber;
	private String carColor;
	private Integer assignedSlot;
	
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public Integer getAssignedSlot() {
		return assignedSlot;
	}
	public void setAssignedSlot(Integer assignedSlot) {
		this.assignedSlot = assignedSlot;
	}
}