package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Hardware;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Launcher;

@TeleOp(name = "Jackie Chan, William the Conqueror, Charles LXIV, and Jonathan the Judge")
public class Swerve extends OpMode {

    private Hardware hardware;
    private Drivetrain drivetrain;
    private Launcher launcher;
    @Override
    public void init() {
        hardware = new Hardware();

        hardware.init(hardwareMap);

        drivetrain = Drivetrain.getInstance(hardware);

        launcher = Launcher.getInstance(hardware);


    }

    @Override
    public void loop()
    {
            drivetrain.drive(gamepad1.left_stick_x, gamepad1.left_stick_y);
            //drivetrain.steer(gamepad1.left_stick_x);
            drivetrain.servoControl(gamepad1.left_stick_x , gamepad1.left_stick_y, gamepad1.right_stick_x);
            launcher.changeLiftPosition(gamepad2.a);
            launcher.rotateLauncher(gamepad2.left_stick_x);
            launcher.pushBalls(gamepad2.left_trigger);
            launcher.runFlywheel(gamepad2.right_trigger);



//        telemetry.addData("BLEncoder::", ((double)(hardware.backLeftEn.getCurrentPosition()) % 20746) / 20746);
//        telemetry.addData("FLEncoder::", ((double)(hardware.frontLeftEn.getCurrentPosition()) % 20746) / 20746);
//        telemetry.addData("BREncoder::", ((double)(hardware.backRightEn.getCurrentPosition()) % 20746) / 20746);
//        telemetry.addData("FREncoder::", ((double)(hardware.frontRightEn.getCurrentPosition()) % 20746) / 20746);
//        telemetry.addData("BLEncoder::", (drivetrain.cblEnValReal));
//        telemetry.addData("FLEncoder::", drivetrain.cflEnValReal);
//        telemetry.addData("BREncoder::", drivetrain.cbrEnValReal);
//        telemetry.addData("FREncoder::", drivetrain.cfrEnValReal);
//        telemetry.addData("BLEncoderO::", hardware.backLeftEn.getCurrentPosition());
//        telemetry.addData("FLEncoderO::", hardware.frontLeftEn.getCurrentPosition());
//        telemetry.addData("BREncoderO::", hardware.backRightEn.getCurrentPosition());
//        telemetry.addData("FREncoderO::", hardware.frontRightEn.getCurrentPosition());
//        telemetry.addData("BLEncoderO::", drivetrain.blDiff);
//        telemetry.addData("FLEncoderO::", drivetrain.flDiff);
//        telemetry.addData("BREncoderO::", drivetrain.brDiff);
//        telemetry.addData("FREncoderO::", drivetrain.frDiff);
//        telemetry.addData("Desired En::", drivetrain.desEnValFZ);
        telemetry.addData("xpos::", gamepad1.left_stick_x);
        telemetry.addData("ypos::", gamepad1.left_stick_y);
        telemetry.addData("trigger", gamepad1.left_trigger);
        telemetry.update();
    }
}
