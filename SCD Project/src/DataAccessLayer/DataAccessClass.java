package DataAccessLayer;

import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import BusinessLayer.BusinessClass;
import TransferObjects.ArabicNormalizer;
import TransferObjects.DatabaseData;

/**
 * @author usama
 */
public class DataAccessClass 
{
	public Connection connect = null;
	//static String pathMafoul, pathMasdar, pathFaeel;
	
	/**
	 * @author usama
	 * @throws SQLException
	 */
	public void databaseAccess() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/scd_project?useSSL=false";
		String user = "root";
        String password = "";
        connect = DriverManager.getConnection(url, user, password);
    	connect.setAutoCommit(false);
    	System.out.println("Database Connection Successful.");
	}
	
	
	
	
	
	public void mafoulInsert(String path)
	{
        try
        {
        	int batchSize = 20;
        	databaseAccess();
        	String query = "insert into mafoul(rakam, mashkool, sinf, asal, jins, adad, mashkool_vocalize, asal_vocalize) values(?,?,?,?,?,?,?,?)";
        	PreparedStatement statementMafoul = connect.prepareStatement(query);
        	BufferedReader lineReaderMafoul = new BufferedReader(new FileReader(path));
        	String lineText = null;
        	int count = 0;
        	
        	lineReaderMafoul.readLine();
            while ((lineText = lineReaderMafoul.readLine())!=null)
            {
            	count++;
                String [] data = lineText.split(",");
                String rakam = data[0];
                String mashkool = data[1];
                String sinf = data[2];
                String asal = data[3];
                String jins = data[4];
                String adad = data[5];
                String mashkool_vocalize = new ArabicNormalizer(mashkool).getOutput();
                String asal_vocalize = new ArabicNormalizer(asal).getOutput();

                statementMafoul.setInt(1,parseInt(rakam));
                statementMafoul.setString(2,mashkool);
                statementMafoul.setString(3,sinf);
                statementMafoul.setString(4,asal);
                statementMafoul.setString(5,jins);
                statementMafoul.setString(6,adad);
                statementMafoul.setString(7,mashkool_vocalize);
                statementMafoul.setString(8,asal_vocalize);
                statementMafoul.addBatch();
                if(count % batchSize == 0)
                	statementMafoul.executeBatch();
            }
            lineReaderMafoul.close();
            statementMafoul.executeBatch();
            connect.commit();
            connect.close();
            System.out.println("Mafoul Data has been inserted successfully.");
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	/**
	 * @author usama
	 */
	public void masdarInsert(String path)
	{
        try
        {
        	int batchSize = 20;
        	databaseAccess();
        	String query = "insert into masdar(rakam, mashkool, sinf, asal, jins, adad, mashkool_vocalize, asal_vocalize) values(?,?,?,?,?,?,?,?)";
        	PreparedStatement statementMasdar = connect.prepareStatement(query);
        	BufferedReader lineReaderMasdar = new BufferedReader(new FileReader(path));
        	String lineText = null;
        	int count = 0;

        	lineReaderMasdar.readLine();
            while ((lineText = lineReaderMasdar.readLine())!=null)
            {
            	count++;
                String [] data = lineText.split(",");
                String rakam = data[0];
                String mashkool = data[1];
                String sinf = data[2];
                String asal = data[3];
                String jins = data[4];
                String adad = data[5];
                String mashkool_vocalize = new ArabicNormalizer(mashkool).getOutput();
                String asal_vocalize = new ArabicNormalizer(asal).getOutput();

                statementMasdar.setInt(1,parseInt(rakam));
                statementMasdar.setString(2,mashkool);
                statementMasdar.setString(3,sinf);
                statementMasdar.setString(4,asal);
                statementMasdar.setString(5,jins);
                statementMasdar.setString(6,adad);
                statementMasdar.setString(7,mashkool_vocalize);
                statementMasdar.setString(8,asal_vocalize);
                
                statementMasdar.addBatch();
                if(count % batchSize == 0)
                	statementMasdar.executeBatch();
            }
            lineReaderMasdar.close();
            statementMasdar.executeBatch();
            connect.commit();
            connect.close();
            System.out.println("Masdar Data has been inserted successfully.");
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	public void faeelInsert(String path)
	{
        try
        {
        	int batchSize = 20;
        	databaseAccess();
        	String query = "insert into faeel(rakam, mashkool, sinf, asal, jins, adad, mashkool_vocalize, asal_vocalize) values(?,?,?,?,?,?,?,?)";
        	PreparedStatement statementFaeel = connect.prepareStatement(query);
        	BufferedReader lineReaderFaeel = new BufferedReader(new FileReader(path));
        	String lineText = null;
        	int count = 0;
        	
        	lineReaderFaeel.readLine();
        	
            while ((lineText = lineReaderFaeel.readLine())!=null)
            {
            	count++;
                String [] data = lineText.split(",");
                String rakam = data[0];
                String mashkool = data[1];
                String sinf = data[2];
                String asal = data[3];
                String jins = data[4];
                String adad = data[5];
                String mashkool_vocalize = new ArabicNormalizer(mashkool).getOutput();
                String asal_vocalize = new ArabicNormalizer(asal).getOutput();

                statementFaeel.setInt(1,parseInt(rakam));
                statementFaeel.setString(2,mashkool);
                statementFaeel.setString(3,sinf);
                statementFaeel.setString(4,asal);
                statementFaeel.setString(5,jins);
                statementFaeel.setString(6,adad);
                statementFaeel.setString(7,mashkool_vocalize);
                statementFaeel.setString(8,asal_vocalize);
                
                statementFaeel.addBatch();
                if(count % batchSize == 0)
                	statementFaeel.executeBatch();
            }
            lineReaderFaeel.close();
            statementFaeel.executeBatch();
            connect.commit();
            connect.close();
            System.out.println("Faeel Data has been inserted successfully.");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
	}
	

	public void addingColumn(int turn) throws SQLException
	{
		databaseAccess();
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Statement stmt = connect.createStatement();
        switch(turn)
        {
        case 1:
        	String queryMafoul1 = "ALTER TABLE mafoul ADD mashkool_vocalize VARCHAR(50) NOT NULL";
    	    String queryMafoul2 = "ALTER TABLE mafoul ADD asal_vocalize VARCHAR(50) NOT NULL";
    	    stmt.executeUpdate(queryMafoul1);
            stmt.executeUpdate(queryMafoul2);
            break;
        case 2:
        	String queryMasdar1 = "ALTER TABLE masdar ADD mashkool_vocalize VARCHAR(50) NOT NULL";
            String queryMasdar2 = "ALTER TABLE masdar ADD asal_vocalize VARCHAR(50) NOT NULL";
            stmt.executeUpdate(queryMasdar1);
            stmt.executeUpdate(queryMasdar2);
            break;
        case 3:
        	String queryFaeel1 = "ALTER TABLE faeel ADD mashkool_vocalize VARCHAR(50) NOT NULL";
            String queryFaeel2 = "ALTER TABLE faeel ADD asal_vocalize VARCHAR(50) NOT NULL";
            stmt.executeUpdate(queryFaeel1);
            stmt.executeUpdate(queryFaeel2);
            break;
        default:
            System.out.println("Wrong Entry..");
            break;
        }
        connect.close();
        System.out.println("Columns added......");
	}
	
	public void asalInsert(String pathMafoul, String pathMasdar, String pathFaeel)
	{
        int batchSize = 20;
        BusinessClass businessObject = new BusinessClass();
        ArrayList <String> faeelArray = new ArrayList<String>();
        ArrayList <String> masdarArray = new ArrayList<String>();
        ArrayList <String> mafoulArray = new ArrayList<String>();
        
        try
        {
        	databaseAccess();
        	String query = "insert into asal_new(asal_mafoul, asal_faeel, asal_masdar) values(?,?,?)";
        	PreparedStatement statement = connect.prepareStatement(query);
        	BufferedReader lineReaderMafoul = new BufferedReader(new FileReader(pathMafoul));
        	BufferedReader lineReaderFaeel = new BufferedReader(new FileReader(pathFaeel));
        	BufferedReader lineReaderMasdar = new BufferedReader(new FileReader(pathMasdar));
        	String lineText = null;
        	int count = 0;
        	
        	lineReaderMasdar.readLine();
        	lineReaderFaeel.readLine();
        	lineReaderMafoul.readLine();
            while ((lineText = lineReaderFaeel.readLine())!=null)
            {
                String [] data = lineText.split(",");
                faeelArray.add(data[3]);
            }
            lineReaderFaeel.close();
            while ((lineText = lineReaderMasdar.readLine())!=null)
            {
                String [] data = lineText.split(",");
                masdarArray.add(data[3]);
            }
            lineReaderMasdar.close();
            while ((lineText = lineReaderMafoul.readLine())!=null)
            {
                String [] data = lineText.split(",");
                mafoulArray.add(data[3]);
            }
            lineReaderMafoul.close();
            
            int sizeMafoulArray = mafoulArray.size();
            int sizeFaeelArray = faeelArray.size();
            int sizeMasdarArray = masdarArray.size();
            int max = businessObject.maxReturn(sizeMafoulArray, sizeFaeelArray, sizeMasdarArray);
            
            for(int i = 0; i < max; i++)
            {
            	count++;
            	statement.setString(1,mafoulArray.get(i));
            	statement.setString(2,faeelArray.get(i));
            	statement.setString(3,masdarArray.get(i));
            	statement.addBatch();
                if(count % batchSize == 0)
                	statement.executeBatch();
            }
            statement.executeBatch();
            connect.commit();
            connect.close();
            System.out.println("Data has been inserted successfully into Asal Table.");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	/**
	 * @author usama
	 * @param str
	 * @return
	 */
	public static ArrayList<DatabaseData> jTableInsert(String str)
	{
		String url = "jdbc:mysql://localhost:3306/scd_project?useSSL=false";
		String user = "root";
        String password = "";
        String query = null;
        if(str.equals("faeel"))
        	query = "SELECT * from faeel";
        else if(str.equals("masdar"))
        	query = "SELECT * from masdar";
        else if(str.equals("mafoul"))
        	query = "SELECT * from mafoul";
		
		ArrayList<DatabaseData> table= new ArrayList<DatabaseData>();
		try {
			Connection connect =DriverManager.getConnection(url, user, password);
			java.sql.Statement statement =  connect.createStatement();
			ResultSet result = statement.executeQuery(query);
			while(result.next()) 
			{
				DatabaseData row = new DatabaseData();
				row.setRakam(result.getString(1));
				row.setMashkool(result.getString(2));
				row.setSinf(result.getString(3));
				row.setAsal(result.getString(4));
				row.setJins(result.getString(5));
				row.setAdad(result.getString(6));
				row.setMashkool_vocalize(result.getString(7));
				row.setAsal_vocalize(result.getString(8));
		        table.add(row);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return table;
	}
	
	
	/**
	 * @author usama
	 * @throws SQLException
	 */
	/*public void key() throws SQLException
	{
		String url = "jdbc:mysql://localhost:3306/scd_project?useSSL=false";
		String user = "root";
        String password = "";
		
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();
        String queryFaeel = "ALTER TABLE faeel ADD FOREIGN KEY (rakam) REFERENCES asal_new(rakam)";
        String queryMafoul = "ALTER TABLE mafoul ADD FOREIGN KEY (rakam) REFERENCES asal_new(rakam)";
        String queryMasdar = "ALTER TABLE masdar ADD FOREIGN KEY (rakam) REFERENCES asal_new(rakam)";
        
        stmt.executeUpdate(queryFaeel);
        stmt.executeUpdate(queryMafoul);
        stmt.executeUpdate(queryMasdar);
        System.out.println("Foreign Key added......");
	}*/
	
	
}
