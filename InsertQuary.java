import java.sql.*;
import java.util.Scanner;
public class InsertQuary{
	Scanner sc=new Scanner(System.in);
	Data data=new Data();
	Menu menu=new Menu();
	public void insert(){
		System.out.println();
		System.out.print("Enter Your name:");
		data.setname(sc.next());
		while(true){
			System.out.print("Enter Your index number:");
			data.setindex(sc.next());
		    try{
		    	int num = Integer.parseInt(data.getindex());
				break;
			}catch(Exception e){
				System.out.println();
				System.out.println("-----------------------------------");
				System.out.println("Please enter correct interger index");
				System.out.println("-----------------------------------");
				System.out.println();
			}
		}
		while(true){
			System.out.print("Enter Your t_marks:");
			data.sett_marks(sc.next());
		    try{
		    	int num = Integer.parseInt(data.gett_marks());
				break;
			}catch(Exception e){
				System.out.println();
				System.out.println("-----------------------------------");
				System.out.println("Please enter correct interger marks");
				System.out.println("-----------------------------------");
				System.out.println();
			}
		}
		while(true){
			System.out.print("Enter Your p_marks:");
			data.setp_marks(sc.next());
		    try{
		    	int num = Integer.parseInt(data.getp_marks());
				break;
			}catch(Exception e){
				System.out.println();
				System.out.println("-----------------------------------");
				System.out.println("Please enter correct interger marks");
				System.out.println("-----------------------------------");
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("\t"+"|---Your details---|");
		System.out.println();
		System.out.println("Your Name:"+data.getname());
		System.out.println("Your Index:"+data.getindex());
		System.out.println("Your T_Marks:"+data.gett_marks());
		System.out.println("Your P_Marks:"+data.getp_marks());
		System.out.println();
		confData();
		}
		public void insertData(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("Connectivity is OK...");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatacli","root","");
				//System.out.println("MYSQL connection is OK...");
	            Statement stat=con.createStatement();
	            int i=stat.executeUpdate("INSERT INTO marks VALUES('"+data.getindex()+"','"+data.getname()+"','"+data.gett_marks()+"','"+data.getp_marks()+"')");
		    	System.out.println();
		    	System.out.println("---------------------------------");
		    	System.out.println("The record inserted successfully.");
		    	System.out.println("---------------------------------");
		    	System.out.println();
		    	con.close();
		    	menu.pause();
			}catch(Exception e){
				System.out.println(e);
				System.out.println("-------------------------------------");
				System.out.println("Error... ");
				System.out.println("You use this index number before..... ");
				System.out.println("-------------------------------------");
				insert();

			}
		}
		public void confData(){
			String conf;
			while(true){//while3
				System.out.print("Are you sure this details(Y/N):");
				conf=sc.next();
				System.out.println();
				if(conf.equals("y")||conf.equals("Y")||conf.equals("n")||conf.equals("N")){
					break;	
				}else{
					System.out.println("---------------------");
					System.out.println("Please press Y/N only");
					System.out.println("---------------------");
				}
			}//end of while3
			if(conf.equals("y")||conf.equals("Y")){
					insertData();
				}
				else{
					insert();
				}
		}
}
class Data{
	String name;
	String index;
	String t_marks;
	String p_marks;
	public void setname(String name){
		this.name=name;
	}
	public String getname(){
		return name;
	}
	public void setindex(String index){
		this.index=index;
	}
	public String getindex(){
		return index;
	}
	public void sett_marks(String t_marks){
		this.t_marks=t_marks;
	}
	public String gett_marks(){
		return t_marks;
	}
	public void setp_marks(String p_marks){
		this.p_marks=p_marks;
	}
	public String getp_marks(){
		return p_marks;
	}

}
