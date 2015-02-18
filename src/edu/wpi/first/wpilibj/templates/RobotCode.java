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
    //individual motors need to be delcared because we are using Talons, and RobotDrive assumes Jaguars
    Talon leftMotor = new Talon(0);
    Talon rightMotor = new Talon(1);
    RobotDrive mainDrive = new RobotDrive(leftMotor, rightMotor);
    //joystick numbers correspond with USB channels
    Joystick move = new Joystick(1);
    Joystick lift = new Joystick(2);
     
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        mainDrive.setSafetyEnabled(false);
        mainDrive.drive(-0.5, 0.0);
        Timer.delay(2.0);
        mainDrive.drive(0.0, 0.0);
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
        mainDrive.setSafetyEnabled(true);
        while (isOperatorControl() && isEnabled()) {
            mainDrive.arcadeDrive(move);
            Timer.delay(0.01);
        }
        
        //remember that "forward" on Y-axis is -1.0, while right on X-axis is 1.0
        mainDrive.arcadeDrive(move);
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
