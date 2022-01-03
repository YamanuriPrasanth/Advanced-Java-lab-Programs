import java.beans.*;
public class PieCBeanInfo extends SimpleBeanInfo
{
    public PropertyDescriptor[] getPropertyDescriptors()
    {
        try
        {
            PropertyDescriptor data= new PropertyDescriptor("data",PieC.class);
            PropertyDescriptorp[] = {data};
            return p;
        }
        catch(Exception e)
        {

        }
        return null;
    }
}
