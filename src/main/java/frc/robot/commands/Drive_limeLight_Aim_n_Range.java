/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class Drive_limeLight_Aim_n_Range extends CommandBase {
  private double kpAim = 0.05;
  private double kpDistance = 0.05;
  private double m_moveValue;
  private double m_rotateValue;
  /**
   * Creates a new Drive_limeLight_Aim_n_Range.
   */
  public Drive_limeLight_Aim_n_Range() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tx = Robot.drive.gLimeLight().getdegRotationToTarget();
    double ty = Robot.drive.gLimeLight().getdegVerticalToTarget();
    boolean targetfound = Robot.drive.gLimeLight().getIsTargetFound();
    
    if(targetfound){
      m_moveValue = ty * kpDistance;
      m_rotateValue = tx * kpAim;
    }else{
      m_moveValue = 0;
      m_rotateValue = 0;
    }

    Robot.drive.arcadeDrive(m_moveValue, m_rotateValue);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drive.arcadeDrive(0, 0);
    Robot.drive.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  private double Estimated_Distance(double a2){
    double h1 = 6.0;
    double h2 = 36.0;
    double a1 = 0.0;
    return (h2-h1)/Math.tan(a1+a2);
  }
}
