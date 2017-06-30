import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LaceDAO {

	public List<Lace> getLaceList() {
		List<Lace> laces = new ArrayList<>();
		Lace searchedLace = null;
		int id = 0;
		String style = null;
		String color = null;
		Float price = 0f;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		try {
			conn = ConnectionManager.getConnection();
			try {
				pstmt = conn.prepareStatement("select * from experiment.shoelace");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				res = pstmt.executeQuery();
				while (res.next()) {
					id = res.getInt("id");
					color = res.getString("color");
					price = res.getFloat("price");
					style = res.getString("style");
					searchedLace = new Lace(id, color, price, style);
					laces.add(searchedLace);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			ConnectionManager.silentClose(conn);

		}
		return laces;
	}

	public List<Lace> editLaceList(int id, String color, float price, String style) {
		String sql = "UPDATE experiment.shoelace s SET s.color = ?, s.price = ?, s.style = ? WHERE s.id = ?";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, color);
			pstmt.setFloat(2, price);
			pstmt.setString(3, style);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Lace> laces = getLaceList();
		return laces;
	}

	public List<Lace> addLaceList(String color, float price, String style) {
		String sql = "INSERT INTO experiment.shoelace(color,price,style) VALUES(?,?,?)";
		int id = 0;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, color);
			pstmt.setFloat(2, price);
			pstmt.setString(3, style);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Lace> laces = getLaceList();
		return laces;
	}

	public List<Lace> getLaceByID(int id) {
		List<Lace> laceID = new ArrayList<>();
		Lace lace = null;
		String color = null;
		float price = 0f;
		String style = null;
		String sql = "SELECT * FROM experiment.shoelace WHERE id = ?";
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				id = res.getInt("id");
				color = res.getString("color");
				price = res.getFloat("price");
				style = res.getString("style");
				lace = new Lace(id, color, price, style);
				if (id != -1) {
					break;
				}
				laceID.add(lace);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return laceID;
	}

	public List<Lace> deleteLaceList(int id) {
		String sql = "DELETE FROM experiment.shoelace WHERE id = ?";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getLaceList();
	}
}