package org.usfirst.frc5577.GearsBot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static SpeedControllerGroup driveTrainRightMotor;
	public static SpeedControllerGroup driveTrainLeftMotor;
	public static DifferentialDrive driveTrainRobotDrive;

	public static TalonSRX talonSRX5;
	public static TalonSRX talonSRX6;
	public static TalonSRX talonSRX7;
	public static TalonSRX talonSRX8;
	public static TalonSRX talonSRX9;
	public static WPI_VictorSPX victorSPX1;
	public static WPI_VictorSPX victorSPX2;
	public static WPI_VictorSPX victorSPX3;
	public static WPI_VictorSPX victorSPX4;

	public static Compressor compressor;
	public static DoubleSolenoid driveTrainSwitch;
	public static Encoder leftWheelEncoder;
	public static Encoder rightWheelEncoder;
	public static DoubleSolenoid clawSwitch;

	static void init() {
		
		victorSPX1 = new WPI_VictorSPX(1);
		victorSPX2 = new WPI_VictorSPX(2);
		victorSPX3 = new WPI_VictorSPX(3);
		victorSPX4 = new WPI_VictorSPX(4);
		talonSRX5 = new TalonSRX(5);
		talonSRX6 = new TalonSRX(6);
	    talonSRX7 = new TalonSRX(7);
		talonSRX8 = new TalonSRX(8);
		talonSRX9 = new TalonSRX(9);

		driveTrainLeftMotor = new SpeedControllerGroup(victorSPX1, victorSPX2);
		driveTrainRightMotor = new SpeedControllerGroup(victorSPX3, victorSPX4);

		driveTrainRobotDrive = new DifferentialDrive(driveTrainLeftMotor, driveTrainRightMotor);
		driveTrainRobotDrive.setSafetyEnabled(true);
		driveTrainRobotDrive.setExpiration(0.1);
		driveTrainRobotDrive.setMaxOutput(1.0);

		compressor = new Compressor();
		compressor.setClosedLoopControl(true);

		driveTrainSwitch = new DoubleSolenoid(0, 1);
		driveTrainSwitch.set(DoubleSolenoid.Value.kOff);
		clawSwitch = new DoubleSolenoid(2, 3);
	    clawSwitch.set(DoubleSolenoid.Value.kOff);

		leftWheelEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		leftWheelEncoder.setDistancePerPulse(.147262);
		leftWheelEncoder.setSamplesToAverage(10);
		leftWheelEncoder.reset();
		rightWheelEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		rightWheelEncoder.setDistancePerPulse(.147262);
		rightWheelEncoder.setSamplesToAverage(10);
		rightWheelEncoder.reset();
	}
}
