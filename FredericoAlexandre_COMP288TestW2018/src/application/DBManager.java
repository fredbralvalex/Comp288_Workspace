package application;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * This class makes connection with the database
 */
public class DBManager {

	// Declaration and Initialization
	protected RowSetFactory rowSetFactory;

	private static String url = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
	// private static String url = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
	private static String user = "COMP214_W18_004_8";
	private static String password = "password";

	// Builds and returns source row set
	public JdbcRowSet getRowSet() throws SQLException, ClassNotFoundException {

		if (rowSetFactory == null) {
			rowSetFactory = RowSetProvider.newFactory();
		}

		Class.forName("oracle.jdbc.OracleDriver");

		JdbcRowSet jrs = rowSetFactory.createJdbcRowSet();
		jrs.setUrl(url);
		jrs.setUsername(user);
		jrs.setPassword(password);

		return jrs;
	}
}
