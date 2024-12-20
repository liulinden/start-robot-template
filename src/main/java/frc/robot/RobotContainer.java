package frc.robot;

import frc.robot.Constants.DriverConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared.
 * Since Command-based is a "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot} periodic methods (other than the scheduler calls).
 * Instead, the structure of the robot (including subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    private final IntakeSubsystem intake = new IntakeSubsystem();
    private final FlywheelSubsystem flywheels = new FlywheelSubsystem();


    // Create joysticks
    private final CommandXboxController controller = new CommandXboxController(DriverConstants.DRIVER_JOYSTICK_PORT);
    // private final CommandJoystick operatorJoystick = new CommandJoystick(OperatorConstants.OPERATOR_JOYSTICK_PORT);

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {

        // Configure the trigger bindings
        configureBindings();
    }

    /** Use this method to define your trigger->command mappings. */
    private void configureBindings() {
        controller.leftTrigger().whileTrue(new IntakeCommand(intake));
        controller.rightTrigger().onTrue(new ShooterCommand(intake,flywheels));

        //controller.rightTrigger().onTrue(flywheels.runOnce(flywheels::startFlywheels).andThen()));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
    **/

    public Command getAutonomousCommand() {
        // An example command will be run in autonomous
        return Commands.none();
    }

}
