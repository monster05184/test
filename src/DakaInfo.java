
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DakaInfo implements Cloneable{
private int ID;
private Date signin;
private Date signoff;
public DakaInfo() {}
public DakaInfo(int ID,Date a,Date b) 
{
	this.ID=ID;
	this.signin=(Date) a;
	this.signoff=(Date)a;
}
public int getid()
{
	return ID; 
}
public void setid(int ID)
{
	this.ID=ID;
}
public Date getsignin()
{
	return signin;
}

public void setsignin(Date signin)
{
	this.signin=(Date) signin.clone();
}
public Date getsignoff()
{
	return signoff;
}
public void setsignoff(Date signoff)
{
	this.signoff=(Date) signoff.clone();
}
public static void main(String[] args) {
	
}
}
