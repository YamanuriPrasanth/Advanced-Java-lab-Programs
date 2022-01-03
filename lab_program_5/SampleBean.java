import java.io.*;
public class SampleBean implements Serializable
{
    private String sname;
    private String gender;
    public SampleBean(){}
    public void setSname(String sname)
    {
        this.sname=sname;
    }
    public String getSname()
    {
        return sname;
    }
    public void setGender(String gender)
    {
        this.gender=gender;
    }
    public String getGender()
    {
        return gender;
    }
}
