/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team1619.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author DanielHathcock
 */
public class RunChooChoo extends CommandBase {
    
    public RunChooChoo() {
        requires(chooChoo);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        this.setInterruptible(true);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            chooChoo.set(-1.0);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        try {
            chooChoo.stop();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        try {
            chooChoo.stop();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
