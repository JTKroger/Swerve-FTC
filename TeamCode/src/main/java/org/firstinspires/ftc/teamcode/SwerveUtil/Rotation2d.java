package org.firstinspires.ftc.teamcode.SwerveUtil;


public class Rotation2d
{
    private final double m_value;
    private final double m_cos;
    private final double m_sin;
    private static final double DEGREES_TO_RADIANS = 0.017453292519943295;

    /** Constructs a Rotation2d with a default angle of 0 degrees. */
    public Rotation2d() {
        m_value = 0.0;
        m_cos = 1.0;
        m_sin = 0.0;
    }


    /**
     * Constructs a Rotation2d with the given x and y (cosine and sine) components.
     *
     * @param x The x component or cosine of the rotation.
     * @param y The y component or sine of the rotation.
     */
    public Rotation2d(double x, double y) {
        double magnitude = Math.hypot(x, y);
        if (magnitude > 1e-6) {
            m_sin = y / magnitude;
            m_cos = x / magnitude;
        } else {
            m_sin = 0.0;
            m_cos = 1.0;
        }
        m_value = Math.atan2(m_sin, m_cos);
    }
    public Rotation2d(double value) {
        m_value = value;
        m_cos = Math.cos(value);
        m_sin = Math.sin(value);
    }
    /**
     * Constructs and returns a Rotation2d with the given degree value.
     *
     * @param degrees The value of the angle in degrees.
     * @return The rotation object with the desired angle value.
     */
    public static Rotation2d fromDegrees(double degrees) {
        return new Rotation2d(degrees * DEGREES_TO_RADIANS);
    }

    /**
     * Returns the radian value of the Rotation2d.
     *
     * @return The radian value of the Rotation2d.
     */
    public double getRadians() {
        return m_value;
    }

    /**
     * Returns the degree value of the Rotation2d.
     *
     * @return The degree value of the Rotation2d.
     *     within (-180, 180]
     */
    public double getDegrees() {
        return Math.toDegrees(m_value);
    }
    public double getCos()
    {
        return m_cos;
    }
    public double getSin()
    {
        return m_sin;
    }


    /**
     * Takes the inverse of the current rotation. This is simply the negative of the current angular
     * value.
     *
     * @return The inverse of the current rotation.
     */
    public Rotation2d unaryMinus() {
        return new Rotation2d(-m_value);
    }

}
