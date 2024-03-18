package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
public class Hardware
{
    // Drive Motors
    public DcMotorEx frontLeft;
    public DcMotorEx backLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backRight;
    private DcMotorEx[] driveMotors;

    // Drive Servos
    // 0- backleft, 1- frontleft, 2- frontright, 3- backright
    public CRServo frontLeftServo;

    public CRServo backLeftServo;
    public CRServo frontRightServo;
    public CRServo backRightServo;
    // Encoders
    // NOTE - backLeftEn is also connected to the motor for the flywheel
    // NOTE - frontLeftEn is also connected to hex motor for rotation of launcher
    public DcMotorEx frontLeftEn;
    public DcMotorEx backLeftEn;
    public DcMotorEx frontRightEn;
    public DcMotorEx backRightEn;
    private DcMotorEx[] encoders;
    // Launcher Servos
    public CRServo pushServo;
    public Servo liftServo;

    public void init(HardwareMap hardwareMap)
    {
        initMotors(hardwareMap);
        initServos(hardwareMap);
        initEncoders(hardwareMap);
        initLauncherServos(hardwareMap);
    }
    private void initMotors(HardwareMap hardwareMap)
    {
        // Set Drive Motors
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        driveMotors = new DcMotorEx[]{frontLeft,backLeft,frontRight,backRight};
        for(DcMotorEx motor : driveMotors)
        {
            motor.setPower(0);
            motor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        }

    }
    private void initServos(HardwareMap hardwareMap)
    {
        frontLeftServo = hardwareMap.get(CRServo.class, "frontLeftServo");
        frontLeftServo.setPower(0);
        backLeftServo = hardwareMap.get(CRServo.class, "backLeftServo");
        backLeftServo.setPower(0);
        frontRightServo = hardwareMap.get(CRServo.class, "frontRightServo");
        frontRightServo.setPower(0);
        backRightServo = hardwareMap.get(CRServo.class, "backRightServo");
        backRightServo.setPower(0);
    }
    private void initEncoders(HardwareMap hardwareMap)
    {
        frontLeftEn = hardwareMap.get(DcMotorEx.class, "frontLeftEn");
        backLeftEn = hardwareMap.get(DcMotorEx.class, "backLeftEn");
        frontRightEn = hardwareMap.get(DcMotorEx.class, "frontRightEn");
        backRightEn = hardwareMap.get(DcMotorEx.class, "backRightEn");
        encoders = new DcMotorEx[]{frontLeftEn,backLeftEn,frontRightEn,backRightEn};
        for(DcMotorEx motor : encoders)
        {
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        frontLeftEn.setPower(0);
        frontLeftEn.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backLeftEn.setPower(0);
        backLeftEn.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }
    private void initLauncherServos(HardwareMap hardwareMap)
    {
        pushServo = hardwareMap.get(CRServo.class, "pushServo");
        pushServo.setPower(0);
        liftServo = hardwareMap.get(Servo.class, "liftServo");
        liftServo.setPosition(0);
    }
}
