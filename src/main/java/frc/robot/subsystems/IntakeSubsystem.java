package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    /** Constructor. Creates a new ExampleSubsystem. */
    private final CANSparkMax intakeEngine;

    public IntakeSubsystem() {
        intakeEngine = new CANSparkMax(12,MotorType.kBrushless);
    }

    public void startIntake() {
        intakeEngine.set(1);
    }

    public void stopIntake() {
        intakeEngine.set(0);
    }


    
    //not needed
    
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}


