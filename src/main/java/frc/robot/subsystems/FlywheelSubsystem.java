package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlywheelSubsystem extends SubsystemBase {
    
    private final WPI_VictorSPX flywheel1, flywheel2;
    /** Constructor. Creates a new ExampleSubsystem. */
    public FlywheelSubsystem() {
        flywheel1 = new WPI_VictorSPX(7);
        flywheel2 = new WPI_VictorSPX(13);
    }

    public void startFlywheels() {
        flywheel1.set(1);
        flywheel2.set(1);
    }

    public void stopFlywheels() {
        flywheel1.set(0);
        flywheel2.set(0);
    }



    /**
     * This method is called periodically by the CommandScheduler, about every 20ms.
     * It should be used for updating subsystem-specific state that you don't want to offload to a Command.
     * Try not to make it "do too much".
     */
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
