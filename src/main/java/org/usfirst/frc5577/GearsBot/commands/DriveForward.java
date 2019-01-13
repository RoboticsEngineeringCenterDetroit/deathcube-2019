package org.usfirst.frc5577.GearsBot.commands;

import org.usfirst.frc5577.GearsBot.Robot;
import org.usfirst.frc5577.GearsBot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

    double speed = 0.75;
    double distanceInInches = 24;
    double time = 0.5;

    public DriveForward() {
        requires(Robot.driveTrain);
    }

    public DriveForward(double distanceInFeet) {
        this();
        this.distanceInInches = 12 * distanceInFeet;
    }

    public DriveForward(double speed, double time) {
        this();
        this.speed = speed;
        this.time = time;
    }

    protected void initialize() {
        // setTimeout(time); //Or change back to 5 if something goes wrong
        RobotMap.leftWheelEncoder.reset();
        RobotMap.rightWheelEncoder.reset();
    }

    protected void execute() {
        // Robot.driveTrain.driveTrainForwardWithDistance(distance);
        Robot.driveTrain.driveTrainFoward(-speed);
    }

    protected boolean isFinished() {
        System.out.println("Left wheel encoder count: " + RobotMap.leftWheelEncoder.get());
        System.out.println("Left wheel encoder distance traveled: " + RobotMap.leftWheelEncoder.getDistance() / 12);

        if (RobotMap.leftWheelEncoder.getDistance() >= this.distanceInInches) {
            System.out.println("Finished the command!");
            return true;
        }
        return false;
    }

    protected void end() {
        Robot.driveTrain.stop();
        RobotMap.leftWheelEncoder.reset();
        RobotMap.rightWheelEncoder.reset();
    }

    protected void interrupted() {
        end();
    }
}
