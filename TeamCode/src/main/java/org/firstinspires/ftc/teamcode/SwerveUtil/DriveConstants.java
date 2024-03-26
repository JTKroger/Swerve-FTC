package org.firstinspires.ftc.teamcode.SwerveUtil;

public final class DriveConstants
{
    public static final double kMaxSpeedMetersPerSecond = .72;
    public static final double kMaxAngularSpeed = 1.1 * Math.PI;
    public static final double kWidthAndLengthBase = .2994;
    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
            new Translation2d(kWidthAndLengthBase / 2, kWidthAndLengthBase / 2),
            new Translation2d(kWidthAndLengthBase / 2, -kWidthAndLengthBase / 2),
            new Translation2d(-kWidthAndLengthBase / 2, kWidthAndLengthBase / 2),
            new Translation2d(-kWidthAndLengthBase / 2, -kWidthAndLengthBase / 2));
}
