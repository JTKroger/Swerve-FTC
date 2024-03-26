package org.firstinspires.ftc.teamcode.SwerveUtil;

import java.util.Arrays;

public class SwerveDriveKinematics
{
    private final SimpleMatrix m_inverseKinematics;
//    private final SimpleMatrix m_forwardKinematics;

    private final int m_numModules;
    private final Translation2d[] m_modules;
    private Rotation2d[] m_moduleHeadings;
    private Translation2d m_prevCoR = new Translation2d();

    public SwerveDriveKinematics(Translation2d... moduleTranslationsMeters) {
        if (moduleTranslationsMeters.length < 2) {
            throw new IllegalArgumentException("A swerve drive requires at least two modules");
        }
        m_numModules = moduleTranslationsMeters.length;
        m_modules = Arrays.copyOf(moduleTranslationsMeters, m_numModules);
        m_moduleHeadings = new Rotation2d[m_numModules];
        Arrays.fill(m_moduleHeadings, new Rotation2d());
        m_inverseKinematics = new SimpleMatrix(m_numModules * 2, 3);

        for (int i = 0; i < m_numModules; i++)
        {
            m_inverseKinematics.setRow(i * 2 + 0, 0,  1, 0, -m_modules[i].getY());
            m_inverseKinematics.setRow(i * 2 + 1, 0,  0, 1, +m_modules[i].getX());
        }
//        m_forwardKinematics = m_inverseKinematics.pseudoInverse();

//        MathSharedStore.reportUsage(MathUsageId.kKinematics_SwerveDrive, 1);
    }
    public SwerveModuleState[] toSwerveModuleStates(ChassisSpeeds chassisSpeeds)
    {
        return toSwerveModuleStates(chassisSpeeds, new Translation2d());
    }
    public SwerveModuleState[] toSwerveModuleStates(ChassisSpeeds chassisSpeeds, Translation2d centerOfRotationMeters)
    {
        SwerveModuleState[] moduleStates = new SwerveModuleState[m_numModules];

        if (chassisSpeeds.vxMetersPerSecond == 0.0
                && chassisSpeeds.vyMetersPerSecond == 0.0
                && chassisSpeeds.omegaRadiansPerSecond == 0.0) {
            for (int i = 0; i < m_numModules; i++) {
                moduleStates[i] = new SwerveModuleState(0.0, m_moduleHeadings[i]);
            }

            return moduleStates;
        }

        if (!centerOfRotationMeters.equals(m_prevCoR)) {
            for (int i = 0; i < m_numModules; i++) {
                m_inverseKinematics.setRow(i * 2 + 0, 0, 1, 0, -m_modules[i].getY() + centerOfRotationMeters.getY());
                m_inverseKinematics.setRow(i * 2 + 1, 0, 0, 1, +m_modules[i].getX() - centerOfRotationMeters.getX());
            }
            m_prevCoR = centerOfRotationMeters;
        }

        SimpleMatrix chassisSpeedsVector = new SimpleMatrix(3, 1);
        chassisSpeedsVector.setColumn(0, 0, chassisSpeeds.vxMetersPerSecond, chassisSpeeds.vyMetersPerSecond, chassisSpeeds.omegaRadiansPerSecond);

        SimpleMatrix moduleStatesMatrix = m_inverseKinematics.mult(chassisSpeedsVector);

        for (int i = 0; i < m_numModules; i++) {
            double x = moduleStatesMatrix.get(i * 2, 0);
            double y = moduleStatesMatrix.get(i * 2 + 1, 0);

            double speed = Math.hypot(x, y);
            Rotation2d angle = new Rotation2d(x, y);

            moduleStates[i] = new SwerveModuleState(speed, angle);
            m_moduleHeadings[i] = angle;
        }

        return moduleStates;
    }
}
