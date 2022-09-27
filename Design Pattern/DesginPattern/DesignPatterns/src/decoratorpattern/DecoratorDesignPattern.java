package decoratorpattern;

interface Vehicle{
	void start();
}

class Car implements Vehicle{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Car started.");
	}
	
}

class SportsCar implements Vehicle{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Sports car started.");
	}
	
}

class VehicleDecorator implements Vehicle{
	
	protected Vehicle decoratedVehicle;
	
	public VehicleDecorator(Vehicle decoratedVehicle) {
		this.decoratedVehicle = decoratedVehicle;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		decoratedVehicle.start();
	}
	
}

class AlloyWheelVehicleDecorator extends VehicleDecorator{
	
	public AlloyWheelVehicleDecorator(Vehicle decoratedVehicle) {
		super(decoratedVehicle);
	}
	
	@Override
	public void start() {
		setAlloyWheels(decoratedVehicle);
		decoratedVehicle.start();
	}
	
	public void setAlloyWheels(Vehicle decoratedVehicle) {
		System.out.println("Alloy wheels applied");
	}
}

public class DecoratorDesignPattern {

	public static void main(String[] args) {
		Vehicle car = new Car();
		Vehicle alloyCar = new AlloyWheelVehicleDecorator(new Car());
		
		car.start();
		alloyCar.start();
	}
}













