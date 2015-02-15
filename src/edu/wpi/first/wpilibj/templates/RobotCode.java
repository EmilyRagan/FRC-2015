/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotCode extends IterativeRobot {
    Joystick Xbox = new Joystick(1);
    Talon leftMotor = new Talon(0);
    Talon rightMotor = new Talon(1);
    /*RobotDrive does things together, and I'm pretty sure I need to delcare the
     *motors separately so that I can regulate speed not at the same for both
     *motors.*/
     RobotDrive mainDrive = new RobotDrive(0,1);
     
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        //when and where and how should throttle and turn be declared?
        
        //test to see if the robot can do anything
        mainDrive.tankDrive(1.0, 1.0);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        /* Tank drive is called as (left motor, right motor)
         * Tank drive requires two joysticks - could be done
         * with Xbox controller like it was for FTC
         * mainDrive.tankDrive(leftDrive, rightDrive);
         */

        /* Plans for arcade drive instead. Arcade drive uses
         * only one joystick - very simple, could be done on
         * Xbox controller or with joystick already mounted
         * to driver control station.
         */
        
        //http://wpilib.screenstepslive.com/s/3120/m/7912/l/95588-getting-your-robot-to-drive-with-the-robotdrive-class
        //unnecessary because teleopPeriodic is called 50x/sec
        /*while (isOperatorControl() && isEnabled()) {
            mainDrive.arcadeDrive(Xbox);
            Timer.delay(0.01);
        }*/
        
        //remember that "forward" on Y-axis is -1.0, while right on X-axis is 1.0
        mainDrive.arcadeDrive(Xbox);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
    /*Test by Mr. Johnson - unsuccessful
     *public static void main(String args[]) {
     *    System.out.print("hello");
        
    }
     */
}
