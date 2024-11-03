package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class MySql {
	Connection db_conn() {
		// Connection Establishment
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/vehicles";
			String username = "root";
			String password = "workBen_33#pass";

//			System.out.println("Connection is building...");
			Connection con = DriverManager.getConnection(url, username, password);

//			System.out.println("Connection Established...");
			return con;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void POST(String cat, String carName, int rph, int sc) {

		Connection con = db_conn();

		try {
//		Insert Data in Database
			Statement stm = con.createStatement();
//			System.out.println("Statement is created");
			String sql = "INSERT INTO `vehicles`.`vehicle` (`category`, `vehicleName`, `rentPerHour`, `seatingCapacity`) VALUES ('"
					+ cat + "', '" + carName + "', '" + rph + "', '" + sc + "');";

//			System.out.println("SQL Query is created");
			stm.executeUpdate(sql);
//			System.out.println("SQL Query is Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void GET() {
		try {
			Connection con = db_conn();
			String sql = "SELECT * FROM vehicles.vehicle";
//			PreparedStatement ps = con.prepareStatement("select * from vehicles.vehicle WHERE category=\"bike\"");
//			Get Data from Database SQL
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

//			Print Data 
			while (rs.next()) {
				int id = rs.getInt("id");
				String category = rs.getString("category");
				String vehicleName = rs.getString("vehicleName");
				int seatingCapacity = rs.getInt("seatingCapacity");
				int rentPerHour = rs.getInt("rentPerHour");
				System.out.println("ID: " + id + "\tCategory: " + category + "\tSeating Capacity: " + seatingCapacity
						+ "\tRent Per Hour: " + rentPerHour + "\tVehicle Name: " + vehicleName);
			}
		} catch (SQLException e) {
			System.out.println("SQL Connection Failed");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Database Connection Failed");
			System.out.println(e.getMessage());
		}
	}

	public void DELETE(int id) {
		try {
			Connection con = db_conn();
			String sql = "DELETE FROM vehicles.vehicle WHERE id=" + id;

//			Delete Data from Database SQL where id = user entered id
			PreparedStatement ps = con.prepareStatement(sql);
			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("Deletion Successfull. Count = " + count);
			} else {
				System.out.println("Deletion Failed");
			}
		} catch (SQLException e) {
			System.out.println("SQL Connection Failed");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Database Connection Failed");
			System.out.println(e.getMessage());
		}
	}

	public void UPDATE(int id, String cate, String vh, int rph, int sc) {
//public void UPDATE() {
		try {
			Connection con = db_conn();

//			First Get id and get the data of that id;

			String sql = "SELECT * FROM vehicles.vehicle WHERE id = " + id;
//			Get Data from Database SQL

			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);

			while (rs.next()) {
				if (cate == "n")
					cate = rs.getString("category");
				if (vh == "n")
					vh = rs.getString("vehicleName");
				if (sc == 0)
					sc = rs.getInt("seatingCapacity");
				if (rph == 0)
					rph = rs.getInt("rentPerHour");
			}

			System.out.println("Data is Get");

			String sql3 = "UPDATE `vehicles`.`vehicle` SET `category` = '" + cate + "', `vehicleName` = '" + vh
					+ "', `rentPerHour` = '" + rph + "', `seatingCapacity` = '" + sc + "' WHERE (`id` = '" + id + "')";

//			String sql1 = "UPDATE`vehicles`.`vehicle`SET category`='"+cate+"',`vehicleName`='"+vh+"', `rentPerHour` = '"+rph+"', `seatingCapacity` = '"+sc+"' WHERE (`id` = '"+id+"')";
//			System.out.println("SQL String created");
			ps = con.prepareStatement(sql3);
			System.out.println("Update Query is prepared");
//			System.out.println("PS Statement created");

			int count = ps.executeUpdate();
			System.out.println("Update Query is executed");

			if (count > 0) {
				System.out.println("Updation Successfull. Count = " + count);
			} else {
				System.out.println("Updation Failed");
			}
		} catch (SQLException e) {
			System.out.println("SQL Connection Failed");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Database Connection Failed");
			System.out.println(e.getMessage());
		}
	}

	public void addCustomer(String name, String email) {
	    Connection con = db_conn();
	    try {
	      String sql = "INSERT INTO customer (name, email) VALUES (?, ?)";
	      PreparedStatement ps = con.prepareStatement(sql);
	      ps.setString(1, name);
	      ps.setString(2, email);
	      ps.executeUpdate();
	      System.out.println("Customer added successfully!");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }

	  // Existing methods for getCustomerList and potentially UPDATE (if applicable)

	public void getCustomerList() {
		try {
			Connection con = db_conn();
			String sql = "SELECT * FROM customer";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String email = rs.getString("email");
				System.out.println("ID: " + id + ", Email: " + email);
			}
		} catch (SQLException e) {
			System.out.println("Error fetching customer list!");
			e.printStackTrace();
		}
	}
}
