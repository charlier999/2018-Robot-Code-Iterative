package org.usfirst.frc.team1662.subsystems;

import org.usfirst.frc.team1662.robot.Constants;
import org.usfirst.frc.team1662.robot.Controls;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Climber {
	WPI_VictorSPX LeftWinch, RightWinch;
	DoubleSolenoid HookRelease, WingRelease;
	
	public Climber() {
		LeftWinch  = new WPI_VictorSPX(Constants.Climber.leftWinchNum);
		RightWinch = new WPI_VictorSPX(Constants.Climber.RightWinchNum);
		
		HookRelease = new DoubleSolenoid(Constants.Climber.pistonClosed[0], Constants.Climber.pistonOpen[1]);
		WingRelease = new DoubleSolenoid(Constants.Climber.WingOpen[0], Constants.Climber.WingClose[1]);
	}
	
	public void TeleopCode() {
		if(Controls.hookButton.get())
			climbLock.set(Constants.Climber.pistonOpen);
		
		if(Controls.wingButton.get())
			climbLock.set(Constants.Climber.WingOpen);
		
		double volts = 0;
		
		if(Controls.joy2.getRawAxis(3) > 0.25)//0.1
			volts = (Controls.joy2.getRawAxis(3));
		else
			volts = (-Controls.joy2.getRawAxis(2));
		
		volts = volts - 0.05;
	
		LeftWinch.set(volts);
		
		double volts2 = 0;
		
		if(Controls.joy2.getRawAxis(3) > 0.25)//0.1
			volts2 = (Controls.joy2.getRawAxis(3));
		else
			volts2 = (-Controls.joy2.getRawAxis(2));
		
		volts2 = volts2 - 0.05;
	
		RightWinch.set(volts2);
		
//		if(Controls.climbUp.get())
//			ClimbUp.set(1);
//		else 
//			ClimbUp.set(0);
	}
}
