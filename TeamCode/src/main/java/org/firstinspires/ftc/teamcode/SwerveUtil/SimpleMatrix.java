package org.firstinspires.ftc.teamcode.SwerveUtil;

public class SimpleMatrix
{
    public double[][] matrix;
    public double[][] test;

    public SimpleMatrix( int numRows, int numCols )
    {
        matrix = new double[numRows][numCols];
        for(int r = 0; r < matrix.length ; r++)
        {
            for(int c = 0; c < matrix[r].length ; c++)
            {
                matrix[r][c] = 0;
            }
        }
    }
    public SimpleMatrix(double[][] other)
    {
        matrix = new double[other.length][other[0].length];
        for(int r = 0; r < other.length; r++)
        {
            for(int c = 0; c < other[r].length; c++)
            {
                matrix[r][c] = other[r][c];
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
    public void setColumn( int column, int startRow, double value1, double value2, double value3 )
    {
        for(int r = startRow; r < matrix.length; r++)
        {
            if(r == 0)
            {
                matrix[r][column] = value1;
            }
            else if(r == 1)
            {
                matrix[r][column] = value2;
            }
            else
            {
                matrix[r][column] = value3;
            }
        }
    }
    public SimpleMatrix mult(SimpleMatrix other)
    {
        test = new double[getRow()][other.getColumn()];
        for(int r = 0; r < test.length ; r++)
        {
            for(int c = 0; c < test[r].length ; c++)
            {
                test[r][c] = 0;
            }
        }
        for (int i = 0; i < getRow(); i++)
        {
            for (int j = 0; j < other.getColumn(); j++)
            {
                for (int k = 0; k < getColumn(); k++)
                    test[i][j] += matrix[i][k] * other.matrix[k][j];
            }
        }
        SimpleMatrix cool = new SimpleMatrix(test);
        return cool;
    }
}
