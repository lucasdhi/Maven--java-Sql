package application;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws SQLException {
	
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/Projeto";
		Connection conn	=DriverManager.getConnection(url, "root", "Marcela@18");
		System.out.println("deseja cadastrar algum produto ? sim/nao" );
		String responda = sc.next();
		String produto = "";
		Float valor = 0f;
		
		if(responda.equals("sim")) {
			System.out.println("Digite o produto:");
			produto = sc.next();
			System.out.println("Digite o valor:");
			valor= sc.nextFloat();
		} else {
			
		System.out.println("Obrigado");
		}
	try {
	PreparedStatement ps = conn.prepareStatement("INSERT INTO PRODUTO(Nome, valor)"
		+ " VALUES(?,?)" ); 

	ps.setString(1, produto);
	ps.setFloat(2, valor);
	ps.execute();
	
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("SELECT * FROM  PRODUTO");
	
	
	System.out.println("_____Banco hina_____");
	while (rs.next()) {
		System.out.println(rs.getInt("id") + " - " + rs.getString("nome") + " - "  + rs.getDouble("valor"));
	}
	
 } catch(SQLException e) {
	 System.out.println("sinal" +e.getMessage());	 
 }finally {
	  conn.close();
 }

}
	
}
