/*
Title: Football Simulation

Description: You are currently in the process of developing simulations that display how far a football will go when kicked on the ground with a 
certain velocity at a certain angle. For each simulation, keep in mind that there is a minimum angle above the ground at which the football must 
be kicked at. Otherwise if launched below this angle, it can never clear the bar regardless of how fast it is kicked.
Write a method that takes horizontal distance, vertical distance, angle values as input from the user and uses them to determine the initial
velocity the football must be kicked with. 

Equations given are:
Vertical Distance Traveled = (Velocity)(sin(θ))(Time) - (0.5)(9.8)(Time)^2
Horizontal Distance Traveled = (Velocity)(cos(θ))(Time)
θ = arctan(Vertical Distance Traveled / Horizontal Distance Traveled)

(Hint: Solve for time in the equation for Horizontal Distance Traveled. Does that make the equation for 
Vertical Distance Traveled solvable for velocity?)

By: Andy Trinh
Points: 1000
Difficulty: Hard


Answer: [
        [
            ["36""10""36", "24.51"],
            ["8""16""67", "26.86"],
            ["60""10""45", "26.56"],
        ],
        [
            ["80""60""15", "You cannot clear the bar with this angle."],
            ["40""20""15", "You cannot clear the bar with this angle."],
        ]
    ],
    "tags": ["Math", "Scanner", "String"],
    "samples": {
        "inAndOut": [
            ["36""10""36", "24.51"],
            ["40""20""15", "You cannot clear the bar with this angle."]
        ],
        "Explanation": "For Case 1, the angle the football is kicked at is sufficient enough to reach the goalpost since it is bigger 
        than the minimum angle. For Case 2, The minimum angle is too small to travel 40 meters horizontally or 20 meters vertically, 
        so the initial velocity the football is kicked at wouldn't matter."
    }
*/
import java.util.*;
import java.util.Scanner;
import java.lang.Math;

public class SimulationRunner
{
  public static void main(String[] args) 
  {
    System.out.println("Welcome to Football Simulator!");
    
    Scanner input = new Scanner(System.in);
    System.out.print("\nHow far is the football from the goal post horizontally in meters? : ");
    double hDistance = input.nextDouble();
    
    System.out.print("\nHow far is the football from the goal post vertically in meters? : ");
    double vDistance = input.nextDouble();
    
    System.out.print("\nAngle the football will be kicked at in degrees? : ");
    double angle = input.nextDouble();
    
    print(hDistance, vDistance, angle);
  }
  public static void print(double hDistanceFromGoal, double   
  vDistanceFromGoal, double degrees)
  {
    double acceleration = 9.8;
    double radians;
    double velocity;  
    boolean clearBar;
    
    radians = Math.toRadians(degrees);
    
    // Determines if the football can reach the goalpost with the given angle
    clearBar = Math.atan(vDistanceFromGoal / hDistanceFromGoal) <= radians;
    
    // Step 1 of Calculating Velocity
    velocity = (Math.tan(radians) * hDistanceFromGoal) - vDistanceFromGoal;
    
    // Step 2 of Calculating Velocity
    velocity = velocity * Math.pow(Math.cos(radians), 2) / (0.5 * acceleration 
    * Math.pow(hDistanceFromGoal, 2));

    // Step 3 of Calculating Velocity
    velocity = Math.pow(velocity, -0.5);
    
    if(clearBar)
    {
      System.out.println("\nTo kick a football at " + degrees + " ° above the horizontal,");
      
      System.out.print("kick with a initial velocity of ");
      System.out.println(String.format("%.2f",velocity) + " meters per second.");
    }
    else
    {
      System.out.println("\nYou cannot clear the bar with this angle.");
    }
  }
}
