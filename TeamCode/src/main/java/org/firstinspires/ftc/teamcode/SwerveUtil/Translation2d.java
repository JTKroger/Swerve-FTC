package org.firstinspires.ftc.teamcode.SwerveUtil;

public class Translation2d
{
    private final double m_x;
    private final double m_y;

    public Translation2d() {
        this(0.0, 0.0);
    }
    public Translation2d(double x, double y)
    {
        m_x = x;
        m_y = y;
    }
    public double getX()
    {
        return m_x;
    }
    public double getY()
    {
        return m_y;
    }

    public Translation2d rotateBy(Rotation2d other) {
        return new Translation2d(
                m_x * other.getCos() - m_y * other.getSin(), m_x * other.getSin() + m_y * other.getCos());
    }
}
