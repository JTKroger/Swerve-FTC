package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.Hardware;
import org.firstinspires.ftc.teamcode.SwerveUtil.DriveConstants;
import org.firstinspires.ftc.teamcode.SwerveUtil.ChassisSpeeds;
import org.firstinspires.ftc.teamcode.SwerveUtil.SwerveModuleState;
public class Drivetrain {

    private Hardware hardware;

    private static Drivetrain instance;
    private SwerveModule backLeftMod;
    private SwerveModule frontLeftMod;
    private SwerveModule backRightMod;
    private SwerveModule frontRightMod;
    private double m_currentRotation;
    public SwerveModuleState zero;
    public SwerveModuleState one;
    public SwerveModuleState two;
    public SwerveModuleState three;

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
//    public void drive(double powerX,double powerY)
//    {
//        backLeftMod.drive(powerX, powerY);
//        frontLeftMod.drive(powerX, powerY);
//        frontRightMod.drive(powerX, powerY);
//        backRightMod.drive(powerX, powerY);
//    }
    public void drive(double xSpeed, double ySpeed, double rot)
    {
        double xSpeedCommanded;
        double ySpeedCommanded;

        xSpeedCommanded = xSpeed;
        ySpeedCommanded = ySpeed;
        m_currentRotation = rot;

        // Convert the commanded speeds into the correct units for the drivetrain
        double xSpeedDelivered = xSpeedCommanded * DriveConstants.kMaxSpeedMetersPerSecond;
        double ySpeedDelivered = ySpeedCommanded * DriveConstants.kMaxSpeedMetersPerSecond;
        double rotDelivered = m_currentRotation * DriveConstants.kMaxAngularSpeed;

        SwerveModuleState[] swerveModuleStates = DriveConstants.kDriveKinematics.toSwerveModuleStates(new ChassisSpeeds(xSpeedDelivered, ySpeedDelivered, rotDelivered));
        zero = backLeftMod.funny(swerveModuleStates[0]);
        one = frontLeftMod.funny(swerveModuleStates[1]);
        two = frontRightMod.funny(swerveModuleStates[2]);
        three = backRightMod.funny(swerveModuleStates[3]);

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
