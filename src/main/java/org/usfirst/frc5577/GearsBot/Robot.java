package org.usfirst.frc5577.GearsBot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc5577.GearsBot.commands.*;
import org.usfirst.frc5577.GearsBot.subsystems.*;

public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<CommandGroup> autoChooser;

    public static OI oi;

    // Subsystems and Hardware
    public static DriveTrain driveTrain;
    public static Intake intake;
    public static Climber climber;
    // TODO: Replace with gyro code for 2019
    public static AnalogGyro gyro;
    public static Pneumatics pneumatics;
    public static Lift lift;

    // Camera and Vision
    public static CameraServer cameraServer1;
    public static CameraServer cameraServer2;
    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    public void robotInit() {
        RobotMap.init();

        driveTrain = new DriveTrain();
        intake = new Intake();
        climber = new Climber();
        gyro = new AnalogGyro(0);
        pneumatics = new Pneumatics();
        lift = new Lift();

        // OI must be constructed after subsystems. If the OI creates Commands
        // (which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        UsbCamera camera0 = CameraServer.getInstance().startAutomaticCapture(0);
        camera0.setResolution(IMG_WIDTH, IMG_HEIGHT);
    }

    // ************************************************************************************************************************************************************************

    public void autonomous() {

    }

    /**
     * This function is called when the disabled button is hit. You can use it to
     * reset subsystems before shutting down.
     */
    public void disabledInit() {

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called only once when autonomous begins. Creates a
     * SendableChooser Object that allows selection of Autonomous code. Adds
     * Autonomous options to the SmartDashboard.
     */
    public void autonomousInit() {
        autoChooser = new SendableChooser<CommandGroup>();
        autoChooser.setDefaultOption("Default program", new AutonDriveStraight());
        autoChooser.addOption("Left", new AutonDriveFromLeft());
        autoChooser.addOption("Center", new AutonDriveFromCenter());
        autoChooser.addOption("Right", new AutonDriveFromRight());
        SmartDashboard.putData("Autonomous mode chooser", autoChooser);

        autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This fucntion is called only once when teleop begins
     */
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
            autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        // LiveWindow.run();
    }

    public void operatorControl() {
        while (isOperatorControl() && isEnabled()) {
            Timer.delay(0.005); // wait for a motor update time
        }
    }

    @Override
    public void close() {
        oi.close();
    }

}
