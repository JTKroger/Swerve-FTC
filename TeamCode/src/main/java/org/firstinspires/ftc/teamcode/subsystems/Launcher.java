package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.teamcode.hardware.Hardware;
public class Launcher
{
    private Hardware hardware;
    private static Launcher instance;
    private boolean highPosition;

    public Launcher(Hardware hardwareNew)
    {
        hardware = hardwareNew;
        highPosition = false;
    }
    public void changeLiftPosition(boolean pressed)
    {
        if(pressed && highPosition)
        {
            hardware.liftServo.setPosition(0);
            highPosition = false;
        }
        else if(pressed && !highPosition)
        {
            hardware.liftServo.setPosition(1);
            highPosition = true;
        }
    }
    public void pushBalls(float pressed)
    {
        if(pressed > 0)
        {
            hardware.pushServo.setPower(-1);
        }
        else
        {
            hardware.pushServo.setPower(0);
        }
    }
    public void runFlywheel(float pressed)
    {
        if(pressed > 0)
        {
            hardware.backLeftEn.setPower(-1);
        }
        else
        {
            hardware.backLeftEn.setPower(0);
        }
    }
    public void rotateLauncher(double xpos)
    {
        if(xpos < 0)
        {
            hardware.frontLeftEn.setPower(.5);
        }
        else if(xpos > 0)
        {
            hardware.frontLeftEn.setPower(-.5);
        }
        else
        {
            hardware.frontLeftEn.setPower(0);
        }
    }
    public static Launcher getInstance(Hardware hardware){
        if(instance == null){
            instance = new Launcher(hardware);
        }

        return instance;
    }
}
