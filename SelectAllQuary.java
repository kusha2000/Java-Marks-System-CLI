import java.sql.*;
public class SelectAllQuary{
	public static void selectall(){
        ResultSet r;
        Menu menu=new Menu();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Connectivity is OK...");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatacli","root","");
			//System.out.println("MYSQL connection is OK...");
            Statement stat=con.createStatement();
            r=stat.executeQuery("Select * from marks");
            //r=stat.executeQuery("Select * from marks where p_marks>=80");
            System.out.println("|Index no|"+"\t"+"|Name|"+"\t\t"+"|T_Marks|"+"\t"+"|P_Marks|");
            System.out.println("|--------|"+"\t"+"|----|"+"\t\t"+"|-------|"+"\t"+"|-------|");
            while(r.next()){
                System.out.println(r.getString(1)+"\t\t\t"+r.getString(2)+"\t\t\t"+r.getString(3)+"\t\t\t"+r.getString(4));
            }
            menu.pause();
		}catch(Exception e){
			System.out.println("ERROR : "+e);
		}
	}
}
