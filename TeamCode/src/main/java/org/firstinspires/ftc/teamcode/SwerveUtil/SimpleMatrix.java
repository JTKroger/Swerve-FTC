package org.firstinspires.ftc.teamcode.SwerveUtil;

public class SimpleMatrix
{
    public double[][] matrix;
    public double[][] test;

    public SimpleMatrix( int numRows, int numCols )
    {
        matrix = new double[numRows][numCols];
    }
    public SimpleMatrix(double[][] other)
    {
        matrix = new double[other.length][other[0].length];
        for(int r = 0; r < other.length; r++)
        {
            for(int c = 0; c < other[r].length; c++)
            {
                matrix[r][c] = test[r][c];
            }
        }
    }
    public int getRow()
    {
        return matrix.length;
    }
    public int getColumn()
    {
        return matrix[0].length;
    }
    public double get(int row, int column)
    {
        return matrix[row][column];
    }
    public void setRow( int row, int startColumn, double value1, double value2, double value3 )
    {
        for(int c = startColumn; c < matrix[row].length; c++)
        {
            if(c == 0)
            {
                matrix[row][c] = value1;
            }
            else if(c == 1)
            {
                matrix[row][c] = value2;
            }
            else
            {
                matrix[row][c] = value3;
            }
        }
    }
    public void setColumn( int row, int startColumn, double value1, double value2, double value3 )
    {
        for(int c = startColumn; c < matrix[row].length; c++)
        {
            if(c == 0)
            {
                matrix[row][c] = value1;
            }
            else if(c == 1)
            {
                matrix[row][c] = value2;
            }
            else
            {
                matrix[row][c] = value3;
            }
        }
    }
    public SimpleMatrix mult(SimpleMatrix other)
    {
        test = new double[getRow()][other.getColumn()];
        for (int i = 0; i < getRow(); i++)
        {
            for (int j = 0; j < other.getColumn(); j++)
            {
                for (int k = 0; k < other.getRow(); k++)
                    test[i][j] += matrix[i][k] * other.matrix[k][j];
            }
        }
        return new SimpleMatrix(test);
    }
}
