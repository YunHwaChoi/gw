package com.dk.groupware.common;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
 * 전달 받은 파일을 삭제하는 프로그램
 */
public class FileDelete {

	// 전달 받은 파일을 삭제하는 메소드
	public static boolean delete(String pathFile) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("FileDelete.delete()");

		// 구해진 경로와 서버의 파일명을 File 객체로 연결합니다.
		File deleteFile = new File(pathFile);
		// 파일이 존재하면 연결된 삭제 파일을 삭제합니다.
		if (deleteFile.exists()) {
			System.out.println("파일이 존재합니다. 삭제를 진행합니다.");
			deleteFile.delete();
			System.out.println("파일" + deleteFile.getName() + "을(를) 삭제했습니다.");
			return true;
		} else {
			System.out.println("파일이 존재하지 않습니다.");
			return false;
		}

	}

	// 첨부된 파일을 지우는 프로그램
	public static void deleteFileColumn(Connection con, String table, String fileColumn,
			int no) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("FileDelete.deleteFile()");
		// 사용할 객체 선언
		PreparedStatement pstmt = null;
		// 처리
		// sql 작성
		String sql = " update " + table + " set "+fileColumn+" = null where no = ? ";
		// 상태
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		// 실행
		pstmt.executeUpdate();

		// 처리가 된 후 객체 닫기
		pstmt.close();
	}


}
