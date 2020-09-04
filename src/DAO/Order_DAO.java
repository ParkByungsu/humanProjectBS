package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Order_DTO;

public class Order_DAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";
	private ResultSet rs = null;
	
	private static Order_DAO odao = null;

	public static Order_DAO getInstance() {
		odao =new Order_DAO();
		return odao;
	}
	private Order_DAO() {
		
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

	

	// 1. 구매하기
	public Order_DTO OrderInsert(Order_DTO order) {
		 ArrayList<Order_DTO> olist = new ArrayList<>();
		String sql = "insert into sorder values(?,?,?,?)";
		PreparedStatement ppst = null;
		Order_DTO temp = new Order_DTO();
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, order.getno());
				ppst.setInt(2, order.getShsize());
				ppst.setInt(3, order.getShprice());
				ppst.setInt(4, order.getShcnt());
				rs = ppst.executeQuery();
				
				if (rs.next()) {
						temp.setno(rs.getInt("no"));
						temp.setShsize(rs.getInt("shsize"));
						temp.setShprice(rs.getInt("shprice"));
						temp.setShcnt(rs.getInt("shcnt"));
						olist.add(temp);
					}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (ppst != null)
						ppst.close();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("예외발생");
				}
			}
		}
		return temp;
	}
	//2. 구매 내역
	public ArrayList<Order_DTO> OrderSelectAll() {
		String sql = "select * from sorder";
		Statement st = null;
		ArrayList<Order_DTO> olist = new ArrayList<>();
		if (conn != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				while (rs.next()) {
					Order_DTO ordertemp = new Order_DTO();
					System.out.println("-----------제품정보------------");
					ordertemp.setno(rs.getInt("no"));
					ordertemp.setShsize(rs.getInt("shsize"));
					ordertemp.setShprice(rs.getInt("shprice"));
					ordertemp.setShcnt(rs.getInt("shcnt"));
					olist.add(ordertemp);
				}
			} catch (SQLException e) {
				System.out.println("SQL예외발상");
			} finally {
				try {
					if (st != null)
						st.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					System.out.println("예외발생");
				}
			}

		}
		return olist;
	}

	// 3. 구매 수량 추가
	public void CntUpdate(int num, int no) {
		String sql = "update sorder set shcnt = cnt + ? where no = ?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, no);
				ppst.setInt(2, num);
				ppst.executeUpdate();

			} catch (Exception e) {
				System.out.println("예외 발생");
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
	//4. 주문 취소
	public void OrderDelete(int no) {
		String sql = "delete from sorder where no = ?";
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
