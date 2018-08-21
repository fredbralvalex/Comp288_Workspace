package application;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * Lab5 Assignment
 *
 * @author Hyojin Kim (300950009), Frederico Alexandre (300974435)
 * @since  2018.04.11
 */
public class RowSetUtil {

	// Declaration & Initialization
	protected RowSetFactory rowSetFactory;

	private static String _url = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD";
	//private static String _url = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
	private static String _user = "COMP214_W18_004_10";
	private static String _password = "password";

	// Get instance
	public static RowSetUtil getInstance() {
		return new RowSetUtil();
	}

	// Builds and returns source row set
    public JdbcRowSet getRowSet() throws SQLException, ClassNotFoundException {

        if (rowSetFactory == null) {
            rowSetFactory = RowSetProvider.newFactory();
        }

        Class.forName("oracle.jdbc.OracleDriver");

        JdbcRowSet jrs = rowSetFactory.createJdbcRowSet();
        jrs.setUrl(_url);
        jrs.setUsername(_user);
        jrs.setPassword(_password);

        return jrs;
    }
}
