package org.firstinspires.ftc.teamcode.SwerveUtil;

public class ChassisSpeeds
{
    /** Velocity along the x-axis. (Fwd is +) */
    public double vxMetersPerSecond;

    /** Velocity along the y-axis. (Left is +) */
    public double vyMetersPerSecond;

    /** Represents the angular velocity of the robot frame. (CCW is +) */
    public double omegaRadiansPerSecond;
    public ChassisSpeeds(double vxMetersPerSecond, double vyMetersPerSecond, double omegaRadiansPerSecond)
    {
        this.vxMetersPerSecond = vxMetersPerSecond;
        this.vyMetersPerSecond = vyMetersPerSecond;
        this.omegaRadiansPerSecond = omegaRadiansPerSecond;
    }
}
