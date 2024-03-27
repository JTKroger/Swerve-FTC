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
    /**
     * Converts a user provided robot-relative set of speeds into a field-relative ChassisSpeeds
     * object.
     *
     * @param vxMetersPerSecond The component of speed in the x direction relative to the robot.
     *     Positive x is towards the robot's front.
     * @param vyMetersPerSecond The component of speed in the y direction relative to the robot.
     *     Positive y is towards the robot's left.
     * @param omegaRadiansPerSecond The angular rate of the robot.
     * @param robotAngle The angle of the robot as measured by a gyroscope. The robot's angle is
     *     considered to be zero when it is facing directly away from your alliance station wall.
     *     Remember that this should be CCW positive.
     * @return ChassisSpeeds object representing the speeds in the field's frame of reference.
     */
    public static ChassisSpeeds fromRobotRelativeSpeeds(
            double vxMetersPerSecond,
            double vyMetersPerSecond,
            double omegaRadiansPerSecond,
            Rotation2d robotAngle) {
        // CCW rotation out of chassis frame
        Translation2d rotated = new Translation2d(vxMetersPerSecond, vyMetersPerSecond).rotateBy(robotAngle);
        return new ChassisSpeeds(rotated.getX(), rotated.getY(), omegaRadiansPerSecond);
    }

    /**
     * Converts a user provided field-relative set of speeds into a robot-relative ChassisSpeeds
     * object.
     *
     * @param vxMetersPerSecond The component of speed in the x direction relative to the field.
     *     Positive x is away from your alliance wall.
     * @param vyMetersPerSecond The component of speed in the y direction relative to the field.
     *     Positive y is to your left when standing behind the alliance wall.
     * @param omegaRadiansPerSecond The angular rate of the robot.
     * @param robotAngle The angle of the robot as measured by a gyroscope. The robot's angle is
     *     considered to be zero when it is facing directly away from your alliance station wall.
     *     Remember that this should be CCW positive.
     * @return ChassisSpeeds object representing the speeds in the robot's frame of reference.
     */
    public static ChassisSpeeds fromFieldRelativeSpeeds(
            double vxMetersPerSecond,
            double vyMetersPerSecond,
            double omegaRadiansPerSecond,
            Rotation2d robotAngle) {
        // CW rotation into chassis frame
        Translation2d rotated =
                new Translation2d(vxMetersPerSecond, vyMetersPerSecond).rotateBy(robotAngle.unaryMinus());
        return new ChassisSpeeds(rotated.getX(), rotated.getY(), omegaRadiansPerSecond);
    }

}
