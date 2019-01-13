package org.usfirst.frc5577.GearsBot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    public Climber() {
    }

    public void initDefaultCommand() {

    }

    public void moveArm(double velocity) {
        // RobotMap.talonSRX5.set(ControlMode.PercentOutput, velocity);
    }

    public void upElevator(double speed) {
        // RobotMap.talonSRX5.set(ControlMode.PercentOutput, speed);
    }

    public void downElevator(double speed) {
        // RobotMap.talonSRX5.set(ControlMode.PercentOutput, -speed);
    }

    public void stop() {
        // RobotMap.talonSRX5.set(ControlMode.PercentOutput, 0);
    }

}
