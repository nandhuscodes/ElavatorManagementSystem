abstract class Elevator {
    private int currentFloor;

    public Elevator() {
        this.currentFloor = 0; // Assume ground floor is 0
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    // Abstract method for moving the elevator to a specific floor
    public abstract void moveToFloor(int floor);

    // Abstract method for opening the elevator doors
    public abstract void openDoors();

    public abstract void closeDoors();
}
class ElevatorA extends Elevator {
    private Elevator otherElevator;

    public ElevatorA(Elevator otherElevator) {
        this.otherElevator = otherElevator;
    }

    @Override
    public void moveToFloor(int floor) {
        if (floor != super.getCurrentFloor()) {
            System.out.println("Elevator A moving to floor " + floor);
            super.setCurrentFloor(floor);
            otherElevator.closeDoors(); // Ensure other elevator's doors are closed
        }
    }

    @Override
    public void openDoors() {
        System.out.println("Elevator A doors opening at floor " + super.getCurrentFloor());
    }

    public void closeDoors() {
        System.out.println("Elevator A doors closing.");
    }
}
class ElevatorB extends Elevator {
    private Elevator otherElevator;

    public ElevatorB(Elevator otherElevator) {
        this.otherElevator = otherElevator;
    }

    @Override
    public void moveToFloor(int floor) {
        if (floor != super.getCurrentFloor()) {
            System.out.println("Elevator B moving to floor " + floor);
            super.setCurrentFloor(floor);
            otherElevator.closeDoors(); // Ensure other elevator's doors are closed
        }
    }

    @Override
    public void openDoors() {
        System.out.println("Elevator B doors opening at floor " + super.getCurrentFloor());
    }

    public void closeDoors() {
        System.out.println("Elevator B doors closing.");
    }
}

public class Main {
    public static void main(String[] args) {
        ElevatorA elevatorA = new ElevatorA(new ElevatorB(null));
        ElevatorB elevatorB = new ElevatorB(new ElevatorA(null));

        elevatorA.moveToFloor(5); // Elevator A moves to floor 5
        elevatorA.openDoors();    // Elevator A opens doors

        elevatorB.moveToFloor(5); // Elevator B tries to move to floor 5, but doors are closed.
        elevatorB.openDoors();    // Elevator B opens doors after moving to floor 5

        elevatorA.moveToFloor(6); // Elevator A moves to floor 6
        elevatorA.openDoors();    // Elevator A opens doors

        elevatorB.moveToFloor(6); // Elevator B moves to floor 6
        elevatorB.openDoors();
    }
}