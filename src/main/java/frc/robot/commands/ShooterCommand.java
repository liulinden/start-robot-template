package frc.robot.commands;

import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;

/** An example command that uses an example subsystem. */
public class ShooterCommand extends Command {
    private final FlywheelSubsystem flywheels;
    private final IntakeSubsystem intake;
    private final Timer timer = new Timer();
    private boolean intakeStarted = false;

    /**
     * The constructor creates a new command and is automatically called one time when the command is created (with 'new' keyword).
     * It should set up the initial state and properties of the object to ensure it's ready for use.
     * This can take in any arguments you need. It normally uses 1 subsystem (but an take multiple when necessary),
     * as wells as arguments for what to do, such as a joystick in the drive command or a desired position in an auto command.
     * Example uses include saving parameters passed to the command, creating and configuring objects for the class like PID controllers, and adding subsystem requirements
     */
    public ShooterCommand(IntakeSubsystem intake, FlywheelSubsystem flywheels) {
        // use "this" to access member variable subsystem rather than local subsystem
        this.flywheels = flywheels;
        this.intake = intake;
        
        

        // Use addRequirements() here to declare subsystem dependencies.
        // This makes sure no other commands try to do stuff with your subsystem while
        // you are using it.
        addRequirements(this.flywheels,this.intake);
    }

    /**
     * initialize() is used to prepare a command for execution and is called once when the command is scheduled.
     * It should reset the command's state since command objects can be used multiple times.
     * Example uses include setting motor to constant speed, setting a solenoid to a certain state, and resetting variables
     */
    @Override
    public void initialize() {
        timer.restart();
        flywheels.startFlywheels();
    }

    /**
     * execute() is called repeatedly while a command is scheduled, about every 20ms.
     * It should handle continuous tasks specific to the command, like updating motor outputs based on joystick inputs or utilizing control loop results.
     * Example uses include adjusting motor speeds for real-time control, processing sensor data within a scheduled command, and using the output of a control loop.
     */
    @Override
    public void execute() {
        if (!intakeStarted && timer.hasElapsed(1)) {
            intakeStarted = true;
            intake.startIntake();
        }
    }

    /**
     * isFinished() finished is called repeatedly while a command is scheduled, right after execute.
     * It should return true when you want the command to finish. end(false) is called directly after isFinished() returns true.
     * Example uses include checking if control loop is at set point, and always returning false to end after just 1 call to execute.
     */
    @Override
    public boolean isFinished() {
        return timer.hasElapsed(2);
    }

    /**
     * end(boolean interrupted) is called once when a command ends, regardless of whether it finishes normally or is interrupted.
     * It should wrap up the command since other commands might use the same subsystems.
     * Once end runs the command will no longer be in the command scheduler loop.
     * It takes in a boolean interrupted which is set to true when the command is ended without isFinished() returning true.
     * Example uses include setting motor speeds back to zero, and setting a solenoid back to a "default" state.
     */
    @Override
    public void end(boolean interrupted) {
        intake.stopIntake();
        flywheels.stopFlywheels();
    }
}