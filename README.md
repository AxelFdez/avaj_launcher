# Aircraft Simulation Program

This is an aircraft simulation program developed in Java as a solution to the scenario provided. The program simulates aircraft behavior in different weather conditions at an airport.

## Objective

The objective of this program is to simulate aircraft behavior based on weather conditions. It takes a scenario file as input and generates a simulation output file depicting the outcome of the simulation.

## Features

Aircraft of three types: JetPlane, Helicopter, and Balloon
Four types of weather: RAIN, FOG, SUN, and SNOW
Aircraft behavior varies according to weather conditions
Simulation output includes messages from aircraft and the tower

## Getting Started
To run the simulation program, follow these steps:

1. Ensure you have Java installed on your system.

2. Clone this repository to your local machine, and navigate to the root of the project directory in your terminal.
```shell
   git clone https://github.com/AxelFdez/avaj_launcher.git
   cd avaj_launcher
```

3. Compile the project by running the following commands:
```shell
	find * -name "*.java" > sources.txt
	javac @sources.txt
```

4. Run the program by providing a scenario file as an argument:
```shell
	java avajLauncher ressources/scenario.txt
```


## Scenario File

The scenario file should contain the following information:

The number of times the simulation should be run.
Descriptions of aircraft participating in the simulation, including type, name, longitude, latitude, and height.
Example scenario file format:
```shell
	12
	Baloon B1 2 3 20
	Baloon B2 1 8 66
	JetPlane J1 23 44 32
	Helicopter H1 654 33 20
```


## Simulation Output

After running the simulation, a file named simulation.txt will be generated. This file contains the outcome of the simulation, including messages from the tower and aircraft.

Example simulation output:
```shell
	Tower says: Baloon#B1(1) registered to weather tower.
	...
```


Thank you for checking out this project!

Feel free to reach out if you have any questions or feedback.

Axel Fernandez