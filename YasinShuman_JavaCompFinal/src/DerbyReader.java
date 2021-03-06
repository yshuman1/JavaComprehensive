import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author yasin
 *calss used to read from derby db
 */
public class DerbyReader {
	private	ArrayList<String> listNames;
	private ArrayList<Thread> listRunners;
	private CallBackFromThread callBackFromThread;

	/**
	 * @param listNames
	 * @param listRunners
	 * @param callBackFromThread
	 * main constructor
	 */
	public DerbyReader(ArrayList<String> listNames, ArrayList<Thread> listRunners,
			CallBackFromThread callBackFromThread) {
		// TODO Auto-generated constructor stub
		this.listNames = listNames;
		this.callBackFromThread = callBackFromThread;
		this.listRunners = listRunners;


		readDataFromDb();

	}
	private void readDataFromDb() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM RunnersStats";
		try {
			Connection connection = getConnection();
			java.sql.PreparedStatement ps = connection.prepareStatement(query);
			java.sql.ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int runnersSpeed = rs.getInt("runnersSpeed");
				int restPercentage = rs.getInt("restPercentage");
				listNames.add(name);
				ThreadRunner runner = new ThreadRunner(name, runnersSpeed, restPercentage);
				runner.delegate(callBackFromThread);
				Thread runnerThread = new Thread(runner);
				listRunners.add(runnerThread);
			}
			disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB read Eexception");
			e.printStackTrace();
		}

	}
	private Connection getConnection(){
		Connection connection = null;
		try {
			// if necessary, set the home directory for Derby
			String dbDirectory = ".";
			System.setProperty("derby.system.home",
					dbDirectory);
			// create and return the connection
			String dbUrl = "jdbc:derby:FinalDB";
			//String dbUrl = "jdbc:derby://localhost:1527/FinalDB";
			String userName = "";
			String password = "";
			connection = DriverManager.getConnection( dbUrl, userName, password);
			return connection;
		}
		catch (SQLException e) {
			System.out.println("Exception in getConnection Method");
			for (Throwable t : e)
				e.printStackTrace();
			return null;
		}
	}

	private boolean disconnect() {
		try {
			// On a successful shutdown, this throws
			// an exception
			String shutdownURL = "jdbc:derby:;shutdown=true";
			DriverManager.getConnection(shutdownURL);
		}
		catch (SQLException e) {
			if (e.getMessage().equals("Derby system shutdown."))
				return true;
		}
		return false;
	}
}
