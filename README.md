﻿# ElavatorManagementSystem


Problem Statement: Elevator Management System

You are tasked with developing an Elevator Management System to control two elevators in a building. The goal is to ensure that Elevator A and Elevator B do not open their doors simultaneously on the same floor to avoid congestion and improve efficiency.

Requirements:

Implement an abstract class Elevator with the following attributes and methods:


currentFloor (integer): Represents the current floor where the elevator is located.

getCurrentFloor(): Returns the current floor of the elevator.

moveToFloor(int floor): An abstract method that moves the elevator to the specified floor.

openDoors(): An abstract method that opens the elevator doors.

Implement two concrete classes ElevatorA and ElevatorB that extend the Elevator class:


ElevatorA should avoid stopping at the same floor as ElevatorB, and vice versa.

The moveToFloor method in each elevator should ensure coordination with the other elevator to avoid simultaneous door openings.

The elevator movement should be simulated, and actions like moving to a floor and opening doors should be printed to the console.
