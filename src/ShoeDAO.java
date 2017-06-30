import static java.lang.System.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoeDAO {

	public List<Shoe> getShoeList() {
		List<Shoe> shoes = new ArrayList<>();
		Shoe searchedShoe = null;
		int id = 0;
		String brand = null;
		String style = null;
		Float price = 0f;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			conn = ConnectionManager.getConnection();
			try {
				pstmt = conn.prepareStatement(
						"select * from experiment.shoe join experiment.price on shoe.id = price.shoe_id");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				res = pstmt.executeQuery();
				while (res.next()) {
					id = res.getInt("id");
					brand = res.getString("brand");
					style = res.getString("style");
					price = res.getFloat("price");
					searchedShoe = new Shoe(id, brand, style, price);
					shoes.add(searchedShoe);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			ConnectionManager.silentClose(conn);

		}
		return shoes;
	}

	public List<Shoe> editShoeList(int editId, String brand, String style, float price) {
		String sql = "UPDATE experiment.shoe s SET s.brand = ?, s.style = ? WHERE s.id = ?";
		String sql1 = "select id from experiment.shoe where brand = ? and style = ? limit 1";
		String sql2 = "UPDATE experiment.price p SET p.price = ? WHERE p.shoe_id = ?";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, brand);
			pstmt.setString(2, style);
			pstmt.setInt(3, editId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int shoe_id = findId(brand, style, sql1, editId);

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setFloat(1, price);
			pstmt.setInt(2, shoe_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Shoe> shoes = getShoeList();
		return shoes;
	}

	public List<Shoe> addShoeList(String brand, String style, float price) {
		String sql = "INSERT INTO experiment.shoe(brand,style) VALUES(?,?)";
		String sql2 = "INSERT INTO experiment.price(shoe_ID, price) VALUES((select id from experiment.shoe where brand = ? and style = ? limit 1), ?)";
		int shoe_id = 0;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, brand);
			pstmt.setString(2, style);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql2)) {
			pstmt.setString(1, brand);
			pstmt.setString(2, style);
			pstmt.setFloat(3, price);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Shoe> shoes = getShoeList();
		return shoes;
	}

	public int findId(String brand, String style, String sql1, int shoe_id) {
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql1)) {
			pstmt.setString(1, brand);
			pstmt.setString(2, style);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				shoe_id = res.getInt("id");
				if (shoe_id != -1) {
					break;
				}
			}
			out.println(shoe_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shoe_id;
	}

	public List<Shoe> getShoeByID(int id) {
		List<Shoe> shoeID = new ArrayList<>();
		Shoe shoe = null;
		String brand = null;
		String style = null;
		float price = 0f;
		String sql = "SELECT * FROM experiment.shoe join experiment.price on shoe.id = price.shoe_id WHERE id = ?";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				id = res.getInt("id");
				brand = res.getString("brand");
				style = res.getString("style");
				price = res.getFloat("price");
				shoe = new Shoe(id, brand, style, price);
				if (id != -1) {
					break;
				}
				shoeID.add(shoe);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shoeID;
	}

	public List<Shoe> deleteShoeList(int editId) {
		String sql = "DELETE FROM experiment.shoe WHERE id = ?";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, editId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getShoeList();
	}

}
