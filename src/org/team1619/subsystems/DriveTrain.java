/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team1619.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1619.RobotMap;
import org.team1619.commands.Drive;

/**
 *
 * @author DanielHathcock
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANJaguar leftForeDrive;
    private CANJaguar leftRearDrive;
    private CANJaguar rightForeDrive;
    private CANJaguar rightRearDrive;
   
    private RobotDrive driveTrain; 
    
    public DriveTrain() throws CANTimeoutException 
    {
        leftForeDrive = new CANJaguar(RobotMap.motorID_leftForeDrive);
        leftRearDrive = new CANJaguar(RobotMap.motorID_leftRearDrive);
        rightForeDrive = new CANJaguar(RobotMap.motorID_rightForeDrive);
        rightRearDrive = new CANJaguar(RobotMap.motorID_rightRearDrive);
        System.out.println("Initialized Drive motors");

        driveTrain = new RobotDrive(leftForeDrive, leftRearDrive, rightForeDrive, rightRearDrive);

        //driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        //driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
    }
    
    public void initDefaultCommand() {
        this.setDefaultCommand(new Drive());
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(Joystick rightStick)
    {
        driveTrain.arcadeDrive(rightStick.getY(), rightStick.getZ());
    }
    
    public void stop()
    {
        driveTrain.stopMotor();
    }
}
