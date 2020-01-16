/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import limelightvision.LimeLight;

public class DriveTrain extends SubsystemBase {
  private LimeLight _limelight;
  private XboxController x_joystick = new XboxController(Constants.XBOX_PORT_ID);

  private Spark leftM1 = new Spark(Constants.LEFT_MOTOR_1_ID);
  private Spark leftM2 = new Spark(Constants.LEFT_MOTOR_2_ID);
  private Spark rightM1 = new Spark(Constants.RIGHT_MOTOR_1_ID);
  private Spark rightM2 = new Spark(Constants.RIGHT_MOTOR_2_ID);

  SpeedControllerGroup leftControllerGroup = new SpeedControllerGroup(leftM1, leftM2);
  SpeedControllerGroup rightControllerGroup = new SpeedControllerGroup(rightM1, rightM2);
  
  DifferentialDrive drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  public void tankDrive(double l, double r){
    drive.tankDrive(l, r);
  }
  public void tankDrive(double lr){
    drive.tankDrive(lr, lr);
  }
  
  public void tankdrivewithjoystick(double sensitivity ){
    tankDrive(x_joystick.getRawAxis(Constants.L_Y_AXIS) * sensitivity, x_joystick.getRawAxis(Constants.R_Y_AXIS) * sensitivity);
  }
  public void tankdrivewithjoystick(){
    tankDrive(x_joystick.getRawAxis(Constants.L_Y_AXIS) , x_joystick.getRawAxis(Constants.R_Y_AXIS));
  }

  public void arcadeDrive(double l, double r){
    drive.arcadeDrive(l, r);
  }
  public void arcadeDrivewithjoystick(double sensitivity){
    arcadeDrive(x_joystick.getRawAxis(Constants.L_Y_AXIS)*sensitivity, x_joystick.getRawAxis(Constants.R_X_AXIS)*sensitivity);
  }
  public void arcadeDrivewithjoystick(){
    arcadeDrive(x_joystick.getRawAxis(Constants.L_Y_AXIS), x_joystick.getRawAxis(Constants.R_X_AXIS));
  }

  public void stopMotors(){
    drive.stopMotor();
  }

  public void setLeftSpeed(double s){
    leftM1.setSpeed(s);
    leftM2.setSpeed(s); 
  }

  public void setRightSpeed(double s){
    rightM1.setSpeed(s);
    rightM2.setSpeed(s); 
  }

  public LimeLight gLimeLight(){
    return _limelight;
  }
  

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
