
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
		Employee []a=new Employee[3];
		a[0]=new Employee();
		a[1]=new Employee();
		a[2]=new Employee();
		Date yushe1=new Date();
		Date yushe2=new Date();
		Date yushe3=new Date();
		Date yushe4=new Date();
		Date yushe5=new Date();
		Date yushe6=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		yushe1=sdf.parse("2008-8-8");
		yushe2=sdf.parse("2008-8-8");
		yushe3=sdf.parse("2008-8-8");
		yushe4=sdf.parse("2008-8-8");
		yushe5=sdf.parse("2008-8-8");
		yushe6=sdf.parse("2008-8-8");
		DakaInfo yusheda1 = new DakaInfo(1,yushe1,yushe2);
		DakaInfo yusheda2 = new DakaInfo(2,yushe3,yushe4);
		DakaInfo yusheda3 = new DakaInfo(3,yushe5,yushe6);
		a[0].setID(1);a[0].setname("张三");
		Company com=new Company();
		com.addem(a[0]);com.addda(yusheda1,0);
		a[1].setID(2);a[1].setname("李四");
		com.addem(a[1]);com.addda(yusheda2,1);
		a[2].setID(3);a[2].setname("王五");
		com.addem(a[2]);com.addda(yusheda3, 2);
		title();
		int choice=0;
		Scanner sca=new Scanner(System.in);
		choice=sca.nextInt();
		while(choice!=0) 
		{
		
		switch(choice) 
		{
		case 1:
			System.out.println("请输入签到员工ID：");
			int id=sca.nextInt()-1;
			signin(id,com);
			break;
		case 2:
			System.out.println("请输入签退员工ID");
			int id1=sca.nextInt()-1;
			signoff(id1,com);
			break;
		case 3:
			System.out.println("请输入要查询的员工号");
			int id2=sca.nextInt()-1;
			see(com,id2);
			break;
		default:
			System.out.println("输错了啊，还不快重新输");
			
		}
		title();
		choice=sca.nextInt();
		}
		
		System.out.println("退出");
		
	}
public static void signin(int id,Company com)
{
	Calendar instance=Calendar.getInstance();
	Date time=instance.getTime();
	SimpleDateFormat YMDsdf = new SimpleDateFormat("yyyy-MM-dd");
	String YMDnow = YMDsdf.format(time);
	DakaInfo jilu=com.listda.get(id);
	Date signinjilu=jilu.getsignin();
	
	String YMDjilu=YMDsdf.format(signinjilu);
	if(YMDnow.equals(YMDjilu))
	{System.out.println("已签到过，不可重复签到");}
	else 
	{
		DakaInfo tem = new DakaInfo();
		tem.setid(jilu.getid());
		tem.setsignoff(jilu.getsignoff());
		tem.setsignin(time);
		com.deleteda(id);
		com.addda(tem, id);
		System.out.println("卡号："+(id+1)+" 打卡成功");
	}
	
}

public static void signoff(int id,Company com)
{
	Calendar instance=Calendar.getInstance();
	Date time=instance.getTime();
	SimpleDateFormat YMDsdf = new SimpleDateFormat("yyyy-MM-dd");
	String YMDnow = YMDsdf.format(time);
	DakaInfo jilu=com.listda.get(id);
	Date signoffjilu=jilu.getsignoff();
	
	Date signinjilu=jilu.getsignin();
	String YMDinjilu=YMDsdf.format(signinjilu);
	String YMDoffjilu=YMDsdf.format(signoffjilu);
	if(YMDnow.equals(YMDoffjilu))
	{System.out.println("已签退过，不可重复签退");}
	else {if(!YMDnow.equals(YMDinjilu)) {System.out.println("未签到过，不可签退。");}
		else 
		{
			DakaInfo tem = new DakaInfo();
			tem.setid(jilu.getid());
			tem.setsignoff(time);
			tem.setsignin(jilu.getsignin());
			com.deleteda(id);
			com.addda(tem, id);
			System.out.println("签退成功");
		}
	}
}
public static void see(Company com,int id)
{
	System.out.println((id+1)+"号员工"+com.listem.get(id).getname()+"签到情况。");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
	String signinjilu = sdf.format(com.listda.get(id).signin);
	String signoffjilu = sdf.format(com.listda.get(id).signoff);
	Calendar a=Calendar.getInstance();
	a.setTime(com.listda.get(id).getsignin());
	int year1=a.get(Calendar.YEAR);
	a.setTime(com.listda.get(id).getsignoff());
	int year2=a.get(Calendar.YEAR);
	if(year1==2008)
	{System.out.println("未签到签退");}
	else {
		System.out.println("签到时间为"+signinjilu);
		if(year2==2008) {
			System.out.println("未签退");
			
		}
		else {System.out.println("签退时间为"+signoffjilu);}
		}
}
public static void title()
{
	
	
	
	
	System.out.println("----员工打卡系统----");
	System.out.println("输入 0--------退出");
	System.out.println("输入 1--------签到");
	System.out.println("输入 2--------签退");
	System.out.println("输入 3--------查看签到信息");
	
}
}
