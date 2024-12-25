import java.sql.*;
import java.util.Scanner;
public class UpdateQuary{
	public static void update(){
		try{
			Menu menu=new Menu();
			Scanner sc=new Scanner(System.in);
			SelectQuary sq=new SelectQuary();
			sq.select();
			System.out.println();
			//System.out.println(sq.getind());
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Connectivity is OK...");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatacli","root","");
			//System.out.println("MYSQL connection is OK...");
            Statement stat=con.createStatement();
            System.out.print("Enter your new index no:");
            int nindex=sc.nextInt();
            System.out.print("Enter your new name:");
            String nname=sc.next();
            System.out.print("Enter your new t_marks:");
            int nt_marks=sc.nextInt();
            System.out.print("Enter your new p_marks:");
            int np_marks=sc.nextInt();
            int i=stat.executeUpdate("UPDATE marks SET st_index='"+nindex+"' , name='"+nname+"' , t_marks='"+nt_marks+"' , p_marks='"+np_marks+"'  WHERE st_index='"+sq.getind()+"' ");
	    	//st_index='"+nindex+"' AND AND t_marks='"+nt_marks+"' AND p_marks='"+np_marks+"'
	    	System.out.println();
	    	System.out.println("--------------------------------");
	    	System.out.println("The record updated successfully.");
	    	System.out.println("--------------------------------");
	    	System.out.println();
	    	con.close();
	    	menu.pause();
		}catch(Exception e){
			System.out.println("ERROR : "+e);
		}
	}
}
