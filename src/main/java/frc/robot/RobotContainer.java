/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Drive_limeLight_Aim;
import frc.robot.commands.Drive_limeLight_Aim_n_Range;
import frc.robot.commands.Drive_limeLight_Range;
import frc.robot.subsystems.DriveTrain;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_DriveTrain = new DriveTrain();

  private final XboxController x_jstick = new XboxController(Constants.XBOX_PORT_ID);
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_DriveTrain.setDefaultCommand(new ArcadeDrive(() -> x_jstick.getRawAxis(Constants.L_Y_AXIS), () -> x_jstick.getRawAxis(Constants.R_X_AXIS), m_DriveTrain));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton a_Button = new JoystickButton(x_jstick, Constants.A_BUTTON);
    final JoystickButton b_Button = new JoystickButton(x_jstick, Constants.B_BUTTON);
    final JoystickButton x_Button = new JoystickButton(x_jstick, Constants.X_BUTTON);

    a_Button.whileHeld(new Drive_limeLight_Aim());
    b_Button.whileHeld(new Drive_limeLight_Range());
    x_Button.whileHeld(new Drive_limeLight_Aim_n_Range());
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
}
