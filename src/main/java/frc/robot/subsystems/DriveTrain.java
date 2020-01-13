/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {
  private final Spark rMotor1 = RobotMap.RIGHT_MOTOR_1;
  private final Spark rMotor2 = RobotMap.RIGHT_MOTOR_2;
  private final Spark lMotor1 = RobotMap.LEFT_MOTOR_1;
  private final Spark lMotor2 = RobotMap.LEFT_MOTOR_2;
  private final SpeedControllerGroup rightControllerGroup = new SpeedControllerGroup(rMotor1, rMotor2);
  private final SpeedControllerGroup leftControllerGroup = new SpeedControllerGroup(lMotor1, lMotor2);


  private final DifferentialDrive m_drive = new DifferentialDrive(leftMotor, rightMotor);
  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
