package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.teamcode.hardware.Hardware;

public class SwerveModule
{
    private static SwerveModule instance0;
    private static SwerveModule instance1;
    private static SwerveModule instance2;
    private static SwerveModule instance3;
    private DcMotorEx motor;
    private CRServo servo;
    private DcMotorEx encoder;
    private boolean isFront;
    private int posOnDT;
    private double reverse;
    private double encoderVal;
    private double desEnVal;
    private double desEnValRot;
    private double oppEnVal;
    private double angle;
    private double diff1;
    private double diff2;
    private double diffFinal;
    private double servoFrac;

    public SwerveModule(DcMotorEx cMotor, CRServo cServo, DcMotorEx cEncoder, int position)
    {
        motor = cMotor;
        servo = cServo;
        encoder = cEncoder;
        posOnDT = position;
        desEnVal = 1;
        reverse = 1;
        if(posOnDT == 1 || posOnDT == 2)
        {
            isFront = true;
        }
        else
        {
            isFront = false;
        }
        if(posOnDT == 0)
        {
            servoFrac = .954;
        }
        else if(posOnDT == 1)
        {
            servoFrac = .805;
        }
        else if(posOnDT == 2)
        {
            servoFrac = .955;
        }
        else
        {
            servoFrac = 1;
        }
    }
    public void drive(double powerX, double powerY)
    {
        if(powerX == 1 || powerX == -1 || powerY == 1 || powerY ==-1)
        {
            motor.setPower(-1 * reverse);
        }
        else
        {
            motor.setPower(0);
        }
    }
    public void runTheCode(double xpos, double ypos, double zpos)
    {
        getCurrentVal();
        setDesiredEncoderVal(xpos, ypos);
        editInRotation(zpos);
        calucateShortestPath();
        turnModule(zpos);
    }
    private void getCurrentVal()
    {
        // determines if the encoder value is positive or not, if not then it turns it positive
        if((((double)(encoder.getCurrentPosition()) % 20746) / 20746) > 0)
        {
            encoderVal = ((double)(encoder.getCurrentPosition()) % 20746) / 20746;
        }
        else if((((double)(encoder.getCurrentPosition()) % 20746) / 20746) < 0)
        {
            encoderVal = (1 + (((double)(encoder.getCurrentPosition()) % 20746) / 20746)) % 1;
        }
        else
        {
            encoderVal = 1;
        }
    }
    private void setDesiredEncoderVal(double xpos, double ypos)
    {
        if(!((xpos < 1 && xpos > -1) && (ypos < 1 && ypos > -1)))
        {
            //Quadrant 1
            if(xpos > 0 && ypos < 0)
            {
                if(xpos == 1 && ypos == -1)
                {
                    desEnVal = .125;
                }
                else if(xpos <= 1 && ypos == -1)
                {
                    desEnVal = (.125 * xpos);
                }
                else if(ypos >= -1 && xpos == 1)
                {
                    desEnVal = (.125 * (1 + ypos)) + .125;
                }
            }
            // Quadrant 2
            else if(xpos < 0 && ypos < 0)
            {
                if(xpos == -1 && ypos == -1)
                {
                    desEnVal = .875;
                }
                else if(ypos >= -1 && xpos == -1)
                {
                    desEnVal = (-.125 * (1 + ypos)) + .875;
                }
                else if(xpos >= -1 && ypos == -1)
                {
                    desEnVal = (.125 * (1 + xpos)) + .875;
                }
            }
            // Quadrant 3
            else if(xpos < 0 && ypos > 0)
            {
                if(xpos == -1 && ypos == 1)
                {
                    desEnVal = .625;
                }
                else if(xpos >= -1 && ypos == 1)
                {
                    desEnVal = (-.125 * (1 + xpos)) + .625;
                }
                else if(ypos <= 1 && xpos == -1)
                {
                    desEnVal = (.125 * (1 - ypos)) + .625;
                }
            }
            // Quadrant 4
            else if(xpos > 0 && ypos > 0)
            {
                if(xpos == 1 && ypos == 1)
                {
                    desEnVal = .375;
                }
                else if(ypos <= 1 && xpos == 1)
                {
                    desEnVal = (-.125 * (1 - ypos)) + .375;
                }
                else if(xpos <= 1 && ypos == 1)
                {
                    desEnVal = (.125 * (1 - xpos)) + .375;
                }
            }
            else if(xpos == 0 && ypos < 0)
            {
                desEnVal = 1;
            }
            else if(xpos == 0 && ypos > 0)
            {
                desEnVal = .5;
            }
            else if(xpos > 0 && ypos == 0)
            {
                desEnVal = .25;
            }
            else if(xpos < 0 && ypos == 0)
            {
                desEnVal = .75;
            }
        }
    }
    private void editInRotation(double zpos)
    {
//        if(posOnDT == 0)
//        {
//            desEnValRot = .375;
//        }
//        else if(posOnDT == 1)
//        {
//            desEnValRot = .625;
//        }
//        else if(posOnDT == 2)
//        {
//            desEnValRot = .875;
//        }
//        else
//        {
//            desEnValRot = .125;
//        }
        angle = zpos * .125;
        if(zpos == 0)
        {
            desEnValRot = desEnVal;
        }
        else if(isFront)
        {
            desEnValRot = desEnVal + angle;
        }
        else if(!isFront)
        {
            desEnValRot = desEnVal - angle;
        }
    }
    private void calucateShortestPath()
    {
        // Finds the opposite angle in revolutions
        if(desEnValRot > .5)
        {
            oppEnVal = desEnValRot - .5;
        }
        else
        {
            oppEnVal = desEnVal + .5;
        }
        // Calculates the difference
        if(encoderVal >= .75 && desEnValRot <= .25)
        {
            diff1 = ((1-encoderVal) + (desEnValRot)) % 1;
        }
        else if(encoderVal <= .25 && desEnValRot >= .75)
        {
            diff1 = -((1-desEnValRot) + encoderVal) % 1;
        }
        else if(encoderVal >= .625 && desEnValRot < .125)
        {
            diff1 = ((1-encoderVal) + (desEnValRot)) % 1;
        }
        else if(encoderVal <= .125 && desEnValRot > .625)
        {
            diff1 = -((1-encoderVal) + (desEnValRot)) % 1;
        }
        else if(encoderVal <= .375 && desEnValRot > .875)
        {
            diff1 = -((1-desEnValRot) + encoderVal) % 1;
        }
        else if(encoderVal >= .875 && desEnValRot < .375)
        {
            diff1 = ((1-desEnValRot) + encoderVal) % 1;
        }
        else if(encoderVal < .5 && desEnValRot == 1)
        {
            diff1 = -(encoderVal) % 1;
        }
        else
        {
            diff1 = -(encoderVal - desEnValRot) % 1;
        }
        if(encoderVal >= .75 && oppEnVal <= .25)
        {
            diff2 = ((1-encoderVal) + (oppEnVal)) % 1;
        }
        else if(encoderVal <= .25 && oppEnVal >= .75)
        {
            diff2 = -((1-oppEnVal) + encoderVal) % 1;
        }
        else if(encoderVal >= .625 && oppEnVal < .125)
        {
            diff2 = ((1-encoderVal) + (oppEnVal)) % 1;
        }
        else if(encoderVal <= .125 && oppEnVal > .625)
        {
            diff2 = -((1-encoderVal) + (oppEnVal)) % 1;
        }
        else if(encoderVal <= .375 && oppEnVal > .875)
        {
            diff2 = -((1-oppEnVal) + encoderVal) % 1;
        }
        else if(encoderVal >= .875 && oppEnVal < .375)
        {
            diff2 = ((1-oppEnVal) + encoderVal) % 1;
        }
        else if(encoderVal < .5 && oppEnVal == 1)
        {
            diff2 = -(encoderVal) % 1;
        }
        else
        {
            diff2 = -(encoderVal - oppEnVal) % 1;
        }
        if(Math.abs(diff1) > Math.abs(diff2))
        {
            diffFinal = diff2;
            reverse = -1;
        }
        else
        {
            diffFinal = diff1;
            reverse = 1;

        }
    }
    private void turnModule(double zpos)
    {
        if(!(diffFinal < .02 || diffFinal > -.02))
        {
            if((diffFinal) > .02)
            {
                servo.setPower(servoFrac * -1);
            }
            else if((diffFinal) < -.02)
            {
                servo.setPower(servoFrac * 1);
            }
            else
                servo.setPower(0);
        }
        else if(zpos > 0)
        {

        }
        else if(zpos < 0)
        {

        }
    }
    public static SwerveModule getBackLeftMod(DcMotorEx cMotor, CRServo cServo, DcMotorEx cEncoder, int position)
    {
        if(instance0 == null){
            instance0 = new SwerveModule(cMotor, cServo, cEncoder, position);
        }

        return instance0;
    }
    public static SwerveModule getFrontLeftMod(DcMotorEx cMotor, CRServo cServo, DcMotorEx cEncoder, int position)
    {
        if(instance1 == null){
            instance1 = new SwerveModule(cMotor, cServo, cEncoder, position);
        }

        return instance1;
    }
    public static SwerveModule getFrontRightMod(DcMotorEx cMotor, CRServo cServo, DcMotorEx cEncoder, int position)
    {
        if(instance2 == null){
            instance2 = new SwerveModule(cMotor, cServo, cEncoder, position);
        }

        return instance2;
    }
    public static SwerveModule getBackRightMod(DcMotorEx cMotor, CRServo cServo, DcMotorEx cEncoder, int position)
    {
        if(instance3 == null){
            instance3 = new SwerveModule(cMotor, cServo, cEncoder, position);
        }

        return instance3;
    }
}
