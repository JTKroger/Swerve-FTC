package org.firstinspires.ftc.teamcode.SwerveUtil;

public class SwerveModuleState
{
    /** Speed of the wheel of the module. */
    public double speedMetersPerSecond;

    /** Angle of the module. */
    public Rotation2d angle = Rotation2d.fromDegrees(0);
    public SwerveModuleState(double speedMetersPerSecond, Rotation2d angle)
    {
        this.speedMetersPerSecond = speedMetersPerSecond;
        this.angle = angle;
    }
    public double getSpeed(){
        return (speedMetersPerSecond/ 0.0254) * 15;
    }
    public double getAngleCos(){
        return angle.getCos();
    }
    public double getAngleSin(){
        return angle.getSin();
    }
}
