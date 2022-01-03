import java.awt.*;
import java.io.*;
public class PieC
{
    private double data[ ];
    public double getData(int index)
    {
        return data[index];
    }
    public void setData(int index, double value)
    {
        data[index] = value;
    }
    public double[ ] getData( )
    {
        return data;
    }
    public void setData(double[ ] values)
    {
        data = new double[values.length];
        System.arraycopy(values, 0, data, 0, values.length);
    }
}
