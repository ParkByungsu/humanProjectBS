package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ShoesShop_DTO;

public class ShoesShop_DAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";
	private ResultSet rs = null;
	private static ShoesShop_DAO sdao = null;

	public static ShoesShop_DAO getInstance() {
		sdao = new ShoesShop_DAO();
		return sdao;
	}

	private ShoesShop_DAO() {

	}

	public Connection conn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB연결이 되었습니다.");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 1. 제품 전체 목록
	public ArrayList<ShoesShop_DTO> selectAll() {
		String sql = "select * from shoesshop";
		Statement st = null;
		ArrayList<ShoesShop_DTO> shoeslist = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					ShoesShop_DTO tempDTO = new ShoesShop_DTO();
					System.out.println("-----------제품정보------------");
					tempDTO.setNo(rs.getInt("no"));
					tempDTO.setCode(rs.getString("code"));
					tempDTO.setName(rs.getString("name"));
					tempDTO.setMaker(rs.getString("maker"));
					tempDTO.setPrice(rs.getInt("price"));
					tempDTO.setShosesize(rs.getInt("shosesize"));
					tempDTO.setCnt(rs.getInt("cnt"));
					shoeslist.add(tempDTO);
				}
			} catch (SQLException e) {
				System.out.println("SQL예외발생");
				e.printStackTrace();
			} finally {
				try {
					if (st != null)
						st.close();
					if (conn != null)
						conn.close();
				} catch (Exception e) {
					System.out.println("예외발생");
					e.printStackTrace();
				}
			}
		}
		return shoeslist;

	}

	// 2. 제품등록하기
	public void insertShoes(ShoesShop_DTO shoes) {
		String sql = "insert into shoesshop values (seq_shoesshop.nextval, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, shoes.getCode());
				ppst.setString(2, shoes.getName());
				ppst.setString(3, shoes.getMaker());
				ppst.setInt(4, shoes.getShosesize());
				ppst.setInt(5, shoes.getPrice());
				ppst.setInt(6, shoes.getCnt());
				ppst.executeQuery();
			} catch (SQLException e) {
				System.out.println("SQL예외발생");
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (ppst != null)
						ppst.close();
				} catch (Exception e) {
					System.out.println("예외발생");
				}
			}
		}

	}

	// 3.수량 수정
	public void cntUpdate(int no, int cnt) {
		String sql = "update shoesshop set cnt = cnt - ? where no = ?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, cnt);
				ppst.setInt(2, no);
				ppst.executeUpdate();
				System.out.println("kkkk");

			} catch (Exception e) {
				System.out.println("예외 발생");
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (ppst != null)
						ppst.close();
				} catch (Exception e2) {
					System.out.println("예외발생");
					e2.printStackTrace();
				}
			}
		}
	}

	// 4. 제품 번호로 정보찾기
	public ShoesShop_DTO selectOne(int no) {
		String sql = "select * from shoesshop where no = ?";
		PreparedStatement ppst = null;
		ShoesShop_DTO temp = new ShoesShop_DTO();
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, no);
				ppst.executeUpdate();
				rs = ppst.executeQuery(sql);

				if (rs.next()) {
					System.out.println("----------------------------");
					System.out.println("-----------제품정보------------");
					temp.setCode(rs.getString("code"));
					temp.setName(rs.getString("name"));
					temp.setMaker(rs.getString("maker"));
					temp.setPrice(rs.getInt("price"));
					temp.setShosesize(rs.getInt("shosesize"));
					temp.setCnt(rs.getInt("cnt"));
				}
			} catch (Exception e) {
				System.out.println("예외발생");
				e.printStackTrace();
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					System.out.println("예외발생");
					e.printStackTrace();
				}
			}
		}
		return temp;
	}
	//5. 상품 삭제
	public void ShoesDelete(int no) {
		String sql = "delete from shoesshop where no = ?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, no);
				ppst.executeUpdate();

			} catch (Exception e) {
				System.out.println("예외발생");
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (ppst != null)
						ppst.close();
				} catch (Exception e2) {
					System.out.println("예외발생");
				}
			}

		}
	}

}
