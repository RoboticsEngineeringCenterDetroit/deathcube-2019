package org.usfirst.frc5577.GearsBot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Run if robot is starting in the middle position. Gets Game Specific Message
 * to determine location of switches and scale.
 */
public class AutonDriveFromCenter extends CommandGroup {

	private String gameData;

	public AutonDriveFromCenter() {

		// Get string of three characters
		// Alliance Switch, Scale, and Opponents' Switch will be 0, 1, and 2
		// respectively
		// Each character will be either L or R for Left or Right respectively
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		if (gameData != null && gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				addSequential(new DriveForward(5));
				addSequential(new Turn(-90));
				addSequential(new DriveForward(6));
				addSequential(new Turn(90));
				// addSequential(new UpLift(0.2, 4));
				// addSequential(new UpLift(0, 1));
				addSequential(new DriveForward(3));
				// addSequential(new PlaceCube());
				// addSequential(new ShiftClaw());
			} else {
				addSequential(new DriveForward(5));
				addSequential(new Turn(90));
				addSequential(new DriveForward(4));
				addSequential(new Turn(-90));
				// addSequential(new UpLift(0.2, 4));
				// addSequential(new UpLift(0, 1));
				addSequential(new DriveForward(3));
				// addSequential(new PlaceCube());
				// addSequential(new ShiftClaw());
			}
		}
	}
}
