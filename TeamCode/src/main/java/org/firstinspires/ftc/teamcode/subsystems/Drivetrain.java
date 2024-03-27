package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.SwerveUtil.Rotation2d;
import org.firstinspires.ftc.teamcode.hardware.Hardware;
import org.firstinspires.ftc.teamcode.SwerveUtil.DriveConstants;
import org.firstinspires.ftc.teamcode.SwerveUtil.ChassisSpeeds;
import org.firstinspires.ftc.teamcode.SwerveUtil.SwerveModuleState;
public class Drivetrain {

    private Hardware hardware;

    private static Drivetrain instance;
    public SwerveModule backLeftMod;
    public SwerveModule frontLeftMod;
    public SwerveModule backRightMod;
    public SwerveModule frontRightMod;
    private double m_currentRotation;

    private Orientation angles;

    public SwerveModuleState[] swerveModuleStates;
//    public SwerveModuleState zero;
//    public SwerveModuleState one;
//    public SwerveModuleState two;
//    public SwerveModuleState three;

    public Drivetrain(Hardware hardware)
    {
        this.hardware = hardware;
        angles =   angles = hardware.gyro.getRobotOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS);
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

        swerveModuleStates = DriveConstants.kDriveKinematics.toSwerveModuleStates(ChassisSpeeds.fromFieldRelativeSpeeds(xSpeedDelivered, ySpeedDelivered,
                rotDelivered, new Rotation2d(getYawDegrees())));
        frontLeftMod.setDesiredState(swerveModuleStates[0]);
        frontRightMod.setDesiredState(swerveModuleStates[1]);
        backLeftMod.setDesiredState(swerveModuleStates[2]);
        backRightMod.setDesiredState(swerveModuleStates[3]);

    }
//    public void servoControl(double xpos, double ypos, double zpos)
//    {
//        backLeftMod.runTheCode(xpos, ypos, zpos);
//        frontLeftMod.runTheCode(xpos, ypos, zpos);
//        frontRightMod.runTheCode(xpos, ypos, zpos);
//        backRightMod.runTheCode(xpos, ypos, zpos);
//    }

    public double getYawDegrees(){
        return -hardware.gyro.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

    public double getYawRadians(){
        return -hardware.gyro.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }
    public static Drivetrain getInstance(Hardware hardware){
        if(instance == null){
            instance = new Drivetrain(hardware);
        }

        return instance;
    }
}
