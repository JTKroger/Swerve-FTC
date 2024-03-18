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
    //revolution count
//    private static double cool;
//    // current encoder position
//    private double cblEnVal;
//
//    private double cflEnVal;
//    private double cbrEnVal;
//    private double cfrEnVal;
//    // Fixed Encoder Vals I guess
//    public double cblEnValReal;
//    public double cflEnValReal;
//    public double cbrEnValReal;
//    public double cfrEnValReal;
//    //desired encoder position
//    private double desEnVal1;
//    private double desEnVal2;
//    public double desEnValFZ;
//    private double desEnValBZ;
//    private double angle;
//    //difference in encoder values
//    public double blDiff;
//    public double flDiff;
//    public double brDiff;
//    public double frDiff;
//    private double blDiffSum;
//    private double flDiffSum;
//    private double brDiffSum;
//    private double frDiffSum;
//    private double blDiffSub;
//    private double flDiffSub;
//    private double brDiffSub;
//    private double frDiffSub;
//    private double difference1;
//    private double difference2;
    // time measurement stuff
//    public boolean active;
//    private long startTime;
//    private long endTime;



    public Drivetrain(Hardware hardware)
    {
        this.hardware = hardware;
        setModules();
//        desEnVal1 = 0;
//        active = false;
    }
    private void setModules()
    {
        backLeftMod = SwerveModule.getInstance(hardware.backLeft, hardware.backLeftServo, hardware.backLeftEn, 0);
        frontLeftMod = SwerveModule.getInstance(hardware.frontLeft, hardware.frontLeftServo, hardware.frontLeftEn, 1);
        frontRightMod = SwerveModule.getInstance(hardware.frontRight, hardware.frontRightServo, hardware.frontRightEn, 2);
        backRightMod = SwerveModule.getInstance(hardware.backRight, hardware.backRightServo, hardware.backRightEn, 3);
    }

//    public void drive(double power){
//
//        if(power < 0) {
//            hardware.backLeft.setPower( Math.cbrt(power)); //slows down the power in accordance to how far the joystick is pushed
//            hardware.frontLeft.setPower(Math.cbrt(power));
//            hardware.frontRight.setPower(Math.cbrt(power));
//            hardware.backRight.setPower(Math.cbrt(power));
//        }
//        else {
//            hardware.backLeft.setPower(Math.cbrt(power));
//            hardware.frontLeft.setPower(Math.cbrt(power));
//            hardware.frontRight.setPower(Math.cbrt(power));
//            hardware.backRight.setPower(Math.cbrt(power));
//        }
//    }
    public void drive(double powerX,double powerY){

//        if(powerX == 1 || powerX == -1 || powerY == 1 || powerY ==-1) {
//            hardware.backLeft.setPower(-1); //slows down the power in accordance to how far the joystick is pushed
//            hardware.frontLeft.setPower(-1);
//            hardware.frontRight.setPower(-1);
//            hardware.backRight.setPower(-1);
//        }
//        else
//        {
//            hardware.backLeft.setPower(0); //slows down the power in accordance to how far the joystick is pushed
//            hardware.frontLeft.setPower(0);
//            hardware.frontRight.setPower(0);
//            hardware.backRight.setPower(0);
//        }
    }
//    public void steer(double position)
//    {
//        if(position > 0.2)
//        {
//            hardware.backLeftServo.setPower(.954 * -1);
//            hardware.frontLeftServo.setPower(.805 * -1);
//            hardware.frontRightServo.setPower(.955 * -1);
//            hardware.backRightServo.setPower(-1);
//        }
//        else if(position < -0.2)
//        {
//            hardware.backLeftServo.setPower(.954 * 1);
//            hardware.frontLeftServo.setPower(.805 * 1);
//            hardware.frontRightServo.setPower(.955 * 1);
//            hardware.backRightServo.setPower(1);
//        }
//        else
//        {
//            hardware.backLeftServo.setPower(0);
//            hardware.backRightServo.setPower(0);
//            hardware.frontLeftServo.setPower(0);
//            hardware.frontRightServo.setPower(0);
//
//        }
//    }
//    public long rotate(boolean pressed,double power)
//    {
//       if(pressed && !active)
//       {
//            hardware.backLeft.setPower(power/2);
//            hardware.frontLeft.setPower(power/2);
//            hardware.backRight.setPower(power/2);
//            hardware.frontRight.setPower(power/2);
//            active = true;
//            startTime = System.currentTimeMillis();
//       }
//       else if(pressed && active)
//       {
//           active = false;
//           endTime = System.currentTimeMillis();
//       }
//       if(startTime > 0 && endTime > 0) {return (endTime - startTime) / 1000;}
//       else {return 0;}
//    }
//    public void steer(double position)
//    {
//
//        if (position > 0) {
//            position = Math.sqrt(position);
//            hardware.backLeftServo.setDirection(Servo.Direction.REVERSE);
//            hardware.backLeftServo.setPosition(position);
////            hardware.backRightServo.setDirection(Servo.Direction.REVERSE);
////            hardware.backLeftServo.setPosition(position);
////            hardware.frontLeftServo.setDirection(Servo.Direction.FORWARD);
////            hardware.frontLeftServo.setPosition(position);
////            hardware.frontRightServo.setDirection(Servo.Direction.FORWARD);
////            hardware.frontRightServo.setPosition(position);
//            pose1 = position; }
//
//        else if (position < 0) {
//            position = Math.sqrt(Math.abs(position));
//            hardware.backLeftServo.setDirection(Servo.Direction.FORWARD);
//            hardware.backLeftServo.setPosition(position);
////            hardware.backRightServo.setDirection(Servo.Direction.FORWARD);
////            hardware.backLeftServo.setPosition(position);
////            hardware.frontLeftServo.setDirection(Servo.Direction.REVERSE);
////            hardware.frontLeftServo.setPosition(position);
////            hardware.frontRightServo.setDirection(Servo.Direction.REVERSE);
////            hardware.frontRightServo.setPosition(position);
//            pose2 = position; }
//
//        else {
//            hardware.backLeftServo.setPosition(Math.abs(pose1));
////            hardware.backRightServo.setPosition(Math.abs(pose1));
////            hardware.frontLeftServo.setPosition(Math.abs(pose2));
////            hardware.frontRightServo.setPosition(Math.abs(pose2));
//        }
//    }
    public void servoControl(double xpos, double ypos, double zpos)
    {
//        setCurrentVals();
//        setDesiredVal(xpos, ypos);
//        editInRotation(zpos);
//        calculateShortestPath();
//        turn();
    }
//    private void setCurrentVals()
//    {
//        cflEnVal = ((double)(hardware.frontLeftEn.getCurrentPosition()) % 20746) / 20746;
//        if(cflEnVal >= 0)
//        {
//            cblEnVal = ((double)(hardware.backLeftEn.getCurrentPosition()) % 20746) / 20746;
//            cbrEnVal = ((double)(hardware.backRightEn.getCurrentPosition()) % 20746) / 20746;
//            cfrEnVal = ((double)(hardware.frontRightEn.getCurrentPosition()) % 20746) / 20746;
//        }
//        else
//        {
//            cblEnVal = ((double)(hardware.backLeftEn.getCurrentPosition()) % 20746) / 20746;
//            cbrEnVal = ((double)(hardware.backRightEn.getCurrentPosition()) % 20746) / 20746;
//            cfrEnVal = ((double)(hardware.frontRightEn.getCurrentPosition()) % 20746) / 20746;
//        }
//        if(cflEnVal < 0)
//        {
//            cflEnValReal = (1 + cflEnVal) % 1;
//            cblEnValReal = (1 + cblEnVal) % 1;
//            cfrEnValReal = (1 + cfrEnVal) % 1;
//            cbrEnValReal = (1 + cbrEnVal) % 1;
//        }
//        else if(cflEnVal > 0)
//        {
//            cflEnValReal = cflEnVal;
//            cblEnValReal = cblEnVal;
//            cfrEnValReal = cfrEnVal;
//            cbrEnValReal = cbrEnVal;
//        }
//        else
//        {
//            cflEnValReal = 1;
//            cblEnValReal = 1;
//            cfrEnValReal = 1;
//            cbrEnValReal = 1;
//        }
//    }
//
//    private void setDesiredVal(double xpos, double ypos)
//    {
//        if(!((xpos < 1 && xpos > -1) && (ypos < 1 && ypos > -1)))
//        {
//            //Quadrant 1
//            if(xpos > 0 && ypos < 0)
//            {
//                if(xpos == 1 && ypos == -1)
//                {
//                    desEnVal1 = .125;
//                }
//                else if(xpos <= 1 && ypos == -1)
//                {
//                        desEnVal1 = (.125 * xpos);
//                }
//                else if(ypos >= -1 && xpos == 1)
//                {
//                        desEnVal1 = (.125 * (1 + ypos)) + .125;
//                }
//            }
//            // Quadrant 2
//            else if(xpos < 0 && ypos < 0)
//            {
//                if(xpos == -1 && ypos == -1)
//                {
//                        desEnVal1 = .875;
//                }
//                else if(ypos >= -1 && xpos == -1)
//                {
//                        desEnVal1 = (-.125 * (1 + ypos)) + .875;
//                }
//                else if(xpos >= -1 && ypos == -1)
//                {
//                        desEnVal1 = (.125 * (1 + xpos)) + .875;
//                }
//            }
//            // Quadrant 3
//            else if(xpos < 0 && ypos > 0)
//            {
//                if(xpos == -1 && ypos == 1)
//                {
//                        desEnVal1 = .625;
//                }
//                else if(xpos >= -1 && ypos == 1)
//                {
//                        desEnVal1 = (-.125 * (1 + xpos)) + .625;
//                }
//                else if(ypos <= 1 && xpos == -1)
//                {
//                        desEnVal1 = (.125 * (1 - ypos)) + .625;
//                }
//            }
//            // Quadrant 4
//            else if(xpos > 0 && ypos > 0)
//            {
//                if(xpos == 1 && ypos == 1)
//                {
//                        desEnVal1 = .375;
//                }
//                else if(ypos <= 1 && xpos == 1)
//                {
//                        desEnVal1 = (-.125 * (1 - ypos)) + .375;
//                }
//                else if(xpos <= 1 && ypos == 1)
//                {
//                        desEnVal1 = (.125 * (1 - xpos)) + .375;
//                }
//            }
//            else if(xpos == 0 && ypos < 0)
//            {
//                desEnVal1 = 1;
//            }
//            else if(xpos == 0 && ypos > 0)
//            {
//                    desEnVal1 = .5;
//            }
//            else if(xpos > 0 && ypos == 0)
//            {
//                    desEnVal1 = .25;
//            }
//            else if(xpos < 0 && ypos == 0)
//            {
//                    desEnVal1 = .75;
//            }
//        }
//    }
//    private void editInRotation(double zpos)
//    {
//        angle = zpos * .125;
//        if (zpos > 0)
//        {
//            desEnValFZ = desEnVal1 + angle;
//            desEnValBZ = desEnVal1 - angle;
//        } else if (zpos < 0)
//        {
//            desEnValFZ = desEnVal1 + angle;
//            desEnValBZ = desEnVal1 - angle;
//        } else
//        {
//            desEnValFZ = desEnVal1;
//            desEnValBZ = desEnVal1;
//        }
//    }
//    private void calculateShortestPath()
//    {
//        if(cflEnValReal >= .75 && desEnValFZ <= .25)
//        {
//            difference1 = 1;
//            difference2 = ((1-cflEnValReal) + (desEnValFZ)) % 1;
//        }
//        else if(cflEnValReal <= .25 && desEnValFZ >= .75)
//        {
//            difference1 = -((1-desEnValFZ) + cflEnValReal) % 1;
//            difference2 = 1;
//        }
//        else if(cflEnValReal >= .625 && desEnValFZ < .125)
//        {
//            difference1 = 1;
//            difference2 = ((1-cflEnValReal) + (desEnValFZ)) % 1;
//        }
//        else if(cflEnValReal <= .125 && desEnValFZ > .625)
//        {
//            difference1 = 1;
//            difference2 = -((1-cflEnValReal) + (desEnValFZ)) % 1;
//        }
//        else if(cflEnValReal <= .375 && desEnValFZ > .875)
//        {
//            difference1 = -((1-desEnValFZ) + cflEnValReal) % 1;
//            difference2 = 1;
//        }
//        else if(cflEnValReal >= .875 && desEnValFZ < .375)
//        {
//            difference1 = ((1-desEnValFZ) + cflEnValReal) % 1;
//            difference2 = 1;
//        }
//        else
//        {
//            difference1 = -(cflEnValReal - desEnValFZ) % 1;
//            difference2 = 1;
//        }
//            if(Math.abs(difference1) > Math.abs(difference2))
//            {
//                blDiff = difference2;
//                flDiff = difference2;
//                brDiff = difference2;
//                frDiff = difference2;
//            }
//            else
//            {
//                blDiff = difference1;
//                flDiff = difference1;
//                brDiff = difference1;
//                frDiff = difference1;
//            }
//
////        if(!((desEnVal1 == 0) && (xpos == 0) && (ypos ==0)))
////        {
////             // Finds the difference between the desired encoder value and the current encoder value
////            if(cflEnVal >= 0 && desEnVal1 > 0)
////            {
////                blDiff = desEnVal1 - cblEnVal;
////                flDiff = desEnVal1 - cflEnVal;
////                brDiff = desEnVal1 - cbrEnVal;
////                frDiff = desEnVal1 - cfrEnVal;
////            }
////            else if(cflEnVal >= 0 && desEnVal1 < 0)
////            {
////                blDiff = desEnVal2 - cblEnVal;
////                flDiff = desEnVal2 - cflEnVal;
////                brDiff = desEnVal2 - cbrEnVal;
////                frDiff = desEnVal2 - cfrEnVal;
////            }
////            else if(cflEnVal <= 0 && desEnVal1 < 0)
////            {
////                blDiff = desEnVal1 + cblEnVal;
////                flDiff = desEnVal1 + cflEnVal;
////                brDiff = desEnVal1 + cbrEnVal;
////                frDiff = desEnVal1 + cfrEnVal;
////            }
////            else if(cflEnVal <= 0 && desEnVal1 > 0)
////            {
////                blDiff = desEnVal2 + cblEnVal;
////                flDiff = desEnVal2 + cflEnVal;
////                brDiff = desEnVal2 + cbrEnVal;
////                frDiff = desEnVal2 + cfrEnVal;
////            }
////            else
////            {
////                blDiff = 0 - cblEnVal;
////                flDiff = 0 - cflEnVal;
////                brDiff = 0 - cbrEnVal;
////                frDiff = 0 - cfrEnVal;
////            }
////            if(Math.abs(flDiffSum) < Math.abs(flDiffSub))
////            {
////                blDiff = desEnVal1 - cblEnVal;
////                flDiff = desEnVal1 - cflEnVal;
////                brDiff = desEnVal1 - cbrEnVal;
////                frDiff = desEnVal1 - cfrEnVal;
////            }
////            else if(Math.abs(flDiffSub) < Math.abs(flDiffSum))
////            {
////                blDiff = desEnVal2 - cblEnVal;
////                flDiff = desEnVal2 - cflEnVal;
////                brDiff = desEnVal2 - cbrEnVal;
////                frDiff = desEnVal2 - cfrEnVal;
////            }
////            else if(Math.abs(Math.abs(flDiffSum)-Math.abs(flDiffSub)) < .03 && cflEnVal > 0 && desEnVal1 > 0)
////            {
////                blDiff = desEnVal1 - cblEnVal;
////                flDiff = desEnVal1 - cflEnVal;
////                brDiff = desEnVal1 - cbrEnVal;
////                frDiff = desEnVal1 - cfrEnVal;
////            }
////            else if(Math.abs(Math.abs(flDiffSum)-Math.abs(flDiffSub)) < .03 && cflEnVal > 0 && desEnVal1 < 0)
////            {
////                blDiff = desEnVal2 - cblEnVal;
////                flDiff = desEnVal2 - cflEnVal;
////                brDiff = desEnVal2 - cbrEnVal;
////                frDiff = desEnVal2 - cfrEnVal;
////            }
////            else if(Math.abs(Math.abs(flDiffSum)-Math.abs(flDiffSub)) < .03 && cflEnVal < 0 && desEnVal1 > 0)
////            {
////                blDiff = desEnVal2 - cblEnVal;
////                flDiff = desEnVal2 - cflEnVal;
////                brDiff = desEnVal2 - cbrEnVal;
////                frDiff = desEnVal2 - cfrEnVal;
////            }
////            else
////            {
////                blDiff = desEnVal1 - cblEnVal;
////                flDiff = desEnVal1 - cflEnVal;
////                brDiff = desEnVal1 - cbrEnVal;
////                frDiff = desEnVal1 - cfrEnVal;
//////                blDiff = 0 - cblEnVal;
//////                flDiff = 0 - cflEnVal;
//////                brDiff = 0 - cbrEnVal;
//////                frDiff = 0 - cfrEnVal;
////            }
////            blDiff = desEnValBZ - cblEnVal;
////            flDiff = desEnValFZ - cflEnVal;
////            brDiff = desEnValBZ - cbrEnVal;
////            frDiff = desEnValFZ - cfrEnVal;
////        }
////        else
////        {
////            blDiff = 0 - cblEnVal;
////            flDiff = 0 - cflEnVal;
////            brDiff = 0 - cbrEnVal;
////            frDiff = 0 - cfrEnVal;
////        }lo4
//    }
//    private void turn()
//    {
//
////        else {
////
////            // Back Left Difference
////            if (blDiff > .03) {
////                hardware.backLeftServo.setPower(.954 * -1);
////            } else if (blDiff < -.03) {
////                hardware.backLeftServo.setPower(.954 * 1);
////            } else
////                hardware.backLeftServo.setPower(0);
////            // Front Left Difference
////            if (flDiff > .03) {
////                hardware.frontLeftServo.setPower(.805 * -1);
////            } else if (flDiff < -.03) {
////                hardware.frontLeftServo.setPower(.805 * 1);
////            } else
////                hardware.frontLeftServo.setPower(0);
////            // Front Right Difference
////            if (frDiff > .03) {
////                hardware.frontRightServo.setPower(.955 * -1);
////            } else if (frDiff < -.03) {
////                hardware.frontRightServo.setPower(.955 * 1);
////            } else
////                hardware.frontRightServo.setPower(0);
////            // Back Right Difference
////            if (brDiff > .03) {
////                hardware.backRightServo.setPower(-1);
////            } else if (brDiff < -.03) {
////                hardware.backRightServo.setPower(1);
////            } else
////                hardware.backRightServo.setPower(0);
////        }
//        // Back Left Difference
//        if((blDiff) > .03)
//        {
//            hardware.backLeftServo.setPower(.954 * -1);
//        }
//        else if((blDiff) < -.03)
//        {
//            hardware.backLeftServo.setPower(.954 * 1);
//        }
//        else
//            hardware.backLeftServo.setPower(0);
//        // Front Left Difference
//        if((flDiff) > .03)
//        {
//            hardware.frontLeftServo.setPower(.805 * -1);
//        }
//        else if((flDiff) < -.03)
//        {
//            hardware.frontLeftServo.setPower(.805 * 1);
//        }
//        else
//            hardware.frontLeftServo.setPower(0);
//        // Front Right Difference
//        if((frDiff) > .03)
//        {
//            hardware.frontRightServo.setPower(.955 * -1);
//        }
//        else if((frDiff) < -.03)
//        {
//            hardware.frontRightServo.setPower(.955 * 1);
//        }
//        else
//            hardware.frontRightServo.setPower(0);
//        // Back Right Difference
//        if((brDiff) > .03)
//        {
//            hardware.backRightServo.setPower(-1);
//        }
//        else if((brDiff) < -.03)
//        {
//            hardware.backRightServo.setPower(1);
//        }
//        else
//            hardware.backRightServo.setPower(0);
//    }


    public static Drivetrain getInstance(Hardware hardware){
        if(instance == null){
            instance = new Drivetrain(hardware);
        }

        return instance;
    }
}
