package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.Hardware;

public class Drivetrain {

    private Hardware hardware;

    private static Drivetrain instance;
    private SwerveModule backLeftMod;
    private SwerveModule frontLeftMod;
    private SwerveModule backRightMod;
    private SwerveModule frontRightMod;

    public Drivetrain(Hardware hardware)
    {
        this.hardware = hardware;
        setModules();
    }
    private void setModules()
    {
        backLeftMod = SwerveModule.getBackLeftMod(hardware.backLeft, hardware.backLeftServo, hardware.backLeftEn, 0);
        frontLeftMod = SwerveModule.getFrontLeftMod(hardware.frontLeft, hardware.frontLeftServo, hardware.frontLeftEn, 1);
        frontRightMod = SwerveModule.getFrontRightMod(hardware.frontRight, hardware.frontRightServo, hardware.frontRightEn, 2);
        backRightMod = SwerveModule.getBackRightMod(hardware.backRight, hardware.backRightServo, hardware.backRightEn, 3);
    }
    public void drive(double powerX,double powerY)
    {
        backLeftMod.drive(powerX, powerY);
        frontLeftMod.drive(powerX, powerY);
        frontRightMod.drive(powerX, powerY);
        backRightMod.drive(powerX, powerY);
    }
    public void servoControl(double xpos, double ypos, double zpos)
    {
        backLeftMod.runTheCode(xpos, ypos, zpos);
        frontLeftMod.runTheCode(xpos, ypos, zpos);
        frontRightMod.runTheCode(xpos, ypos, zpos);
        backRightMod.runTheCode(xpos, ypos, zpos);
    }
    public static Drivetrain getInstance(Hardware hardware){
        if(instance == null){
            instance = new Drivetrain(hardware);
        }

        return instance;
    }
}
