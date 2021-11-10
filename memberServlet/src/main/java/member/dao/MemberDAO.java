package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
   private Connection conn=null;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private String username = "c##java";
   private String password = "bit";
   
   private static MemberDAO instance = null;
   
   public static MemberDAO getInstance() {
      if(instance == null) {
         synchronized (MemberDAO.class) {
            instance = new MemberDAO();//생성
         }
      }
      
      return instance;
   }
   
   public MemberDAO() {
      try {
         Class.forName(driver);
      }catch(ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   public void getConnection() {
      try {
         conn = DriverManager.getConnection(url, username, password);
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }

   public void write(MemberDTO memberDTO) {
      String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
      getConnection();
      
      try {
         pstmt = conn.prepareStatement(sql);//생성
         pstmt.setString(1, memberDTO.getName());
         pstmt.setString(2, memberDTO.getId());
         pstmt.setString(3, memberDTO.getPwd());
         pstmt.setString(4, memberDTO.getGender());
         pstmt.setString(5, memberDTO.getEmail1());
         pstmt.setString(6, memberDTO.getEmail2());
         pstmt.setString(7, memberDTO.getTel1());
         pstmt.setString(8, memberDTO.getTel2());
         pstmt.setString(9, memberDTO.getTel3());
         pstmt.setString(10, memberDTO.getZipcode());
         pstmt.setString(11, memberDTO.getAddr1());
         pstmt.setString(12, memberDTO.getAddr2());
         
         
         pstmt.executeUpdate();//실행

      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      
   }

}
