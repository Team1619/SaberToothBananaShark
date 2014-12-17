/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team1619.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team1619.RobotMap;
import org.team1619.commands.RunChooChoo;

/**
 *
 * @author DanielHathcock
 */
public class ChooChoo extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private CANJaguar chooChoo;
    
    public ChooChoo() throws CANTimeoutException
    {
        chooChoo = new CANJaguar(RobotMap.motorID_chooChoo);
    }

    public void initDefaultCommand() {
        this.setDefaultCommand(new RunChooChoo());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void set(double speed) throws CANTimeoutException
    {
        chooChoo.setX(speed);
    }
    
    public void stop() throws CANTimeoutException
    {
        chooChoo.disableControl();
    }
}
