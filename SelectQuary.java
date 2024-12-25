import java.sql.*;
import java.util.Scanner;
public class SelectQuary{
	static String in;
	public static void select(){
        ResultSet r; 
        while(true){
	        Menu menu=new Menu();
			try{
				Scanner sc=new Scanner(System.in);
				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("Connectivity is OK...");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatacli","root","");
				//System.out.println("MYSQL connection is OK...");
	            Statement stat=con.createStatement();
	            System.out.print("Enter Your index no:");
	            in=sc.next();
	            r=stat.executeQuery("Select * from marks where st_index="+in+"");
	            System.out.println("|Index no|"+"\t"+"|Name|"+"\t\t"+"|T_Marks|"+"\t"+"|P_Marks|");
	            System.out.println("|--------|"+"\t"+"|----|"+"\t\t"+"|-------|"+"\t"+"|-------|");
	            r.next();
	            System.out.println(r.getString(1)+"\t\t\t"+r.getString(2)+"\t\t\t"+r.getString(3)+"\t\t\t"+r.getString(4));
	            menu.pause();
	            break;
			}catch(Exception e){
				System.out.println();
				System.out.println("-------------------------------");
				System.out.println("You Entered wrong index number.");
				System.out.println("-------------------------------");
				System.out.println();
			}
		}
	}
	public String getind(){
		return in;
	}
}

