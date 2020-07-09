import java.util.ArrayList;
import java.util.Iterator;

public class Company {
ArrayList<Employee> listem=new ArrayList();
ArrayList<DakaInfo> listda=new ArrayList();
Iterator <Employee>iteem=listem.iterator();
Iterator <DakaInfo>iteda=listda.iterator();
public void addem(Employee e)
{  
	listem.add(e);
}
public void deleteem(int id)
{
	boolean found=true;
	for(int i=1;i<=id;i++)
	{
		if(iteem.hasNext()) 
		{
			iteem.next();
		}else {System.out.println("没有这一号员工");found=false;break;}
		
	}
	if(found)
	iteem.remove();
}
public void addda(DakaInfo e,int id)
{
	listda.add(id, e);
}
public void deleteda(int id)
{
	boolean found=false;
	listda.remove(id);
}

}
