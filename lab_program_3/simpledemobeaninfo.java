import java.beans.*;
public class simpledemobeaninfo extends SimpleBeanInfo
{
    private Class checkClass=Simpledemo.class;
    public PropertyDescriptor[] getPropertyDescriptor()
    {
        PropertyDescriptor str=null;
        try
        {
            str=new PropertyDescriptor("filled",checkClass);
            str.setDisplayName("Filled:");
        }
        catch (IntrospectionException e){}
        PropertyDescriptor[] result={str};
        return result;
    }

}