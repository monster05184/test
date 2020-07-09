
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
		a[0].setID(1);a[0].setname("����");
		Company com=new Company();
		com.addem(a[0]);com.addda(yusheda1,0);
		a[1].setID(2);a[1].setname("����");
		com.addem(a[1]);com.addda(yusheda2,1);
		a[2].setID(3);a[2].setname("����");
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
			System.out.println("������ǩ��Ա��ID��");
			int id=sca.nextInt()-1;
			signin(id,com);
			break;
		case 2:
			System.out.println("������ǩ��Ա��ID");
			int id1=sca.nextInt()-1;
			signoff(id1,com);
			break;
		case 3:
			System.out.println("������Ҫ��ѯ��Ա����");
			int id2=sca.nextInt()-1;
			see(com,id2);
			break;
		default:
			System.out.println("����˰���������������");
			
		}
		title();
		choice=sca.nextInt();
		}
		
		System.out.println("�˳�");
		
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
	{System.out.println("��ǩ�����������ظ�ǩ��");}
	else 
	{
		DakaInfo tem = new DakaInfo();
		tem.setid(jilu.getid());
		tem.setsignoff(jilu.getsignoff());
		tem.setsignin(time);
		com.deleteda(id);
		com.addda(tem, id);
		System.out.println("���ţ�"+(id+1)+" �򿨳ɹ�");
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
	{System.out.println("��ǩ�˹��������ظ�ǩ��");}
	else {if(!YMDnow.equals(YMDinjilu)) {System.out.println("δǩ����������ǩ�ˡ�");}
		else 
		{
			DakaInfo tem = new DakaInfo();
			tem.setid(jilu.getid());
			tem.setsignoff(time);
			tem.setsignin(jilu.getsignin());
			com.deleteda(id);
			com.addda(tem, id);
			System.out.println("ǩ�˳ɹ�");
		}
	}
}
public static void see(Company com,int id)
{
	System.out.println((id+1)+"��Ա��"+com.listem.get(id).getname()+"ǩ�������");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
	String signinjilu = sdf.format(com.listda.get(id).signin);
	String signoffjilu = sdf.format(com.listda.get(id).signoff);
	Calendar a=Calendar.getInstance();
	a.setTime(com.listda.get(id).getsignin());
	int year1=a.get(Calendar.YEAR);
	a.setTime(com.listda.get(id).getsignoff());
	int year2=a.get(Calendar.YEAR);
	if(year1==2008)
	{System.out.println("δǩ��ǩ��");}
	else {
		System.out.println("ǩ��ʱ��Ϊ"+signinjilu);
		if(year2==2008) {
			System.out.println("δǩ��");
			
		}
		else {System.out.println("ǩ��ʱ��Ϊ"+signoffjilu);}
		}
}
public static void title()
{
	
	
	
	
	System.out.println("----Ա����ϵͳ----");
	System.out.println("���� 0--------�˳�");
	System.out.println("���� 1--------ǩ��");
	System.out.println("���� 2--------ǩ��");
	System.out.println("���� 3--------�鿴ǩ����Ϣ");
	
}
}
