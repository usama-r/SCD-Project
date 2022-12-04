package BusinessLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import DataAccessLayer.DataAccessClass;
import TransferObjects.DatabaseData;

/**
 * 
 * @author usama
 *
 */
public class BusinessClass 
{
	static int count = 0;
	static String pathMafoul = null, pathMasdar = null, pathFaeel = null;
	public String chosenFile;
	
	
	public void setFilePath(String chosenFile) throws SQLException
	{
		this.chosenFile = chosenFile;
		String fileName = characters(chosenFile);
		chooseFile(fileName);
	}
	
	public String characters(String str)
	{
		String reverseString = "", fileName = "";
        char ch;
        for (int i=0; i<str.length(); i++)
        {
          ch= str.charAt(i);
          reverseString= ch+reverseString;
        }
        for (int i=0; i<reverseString.length(); i++)
        {
      	  ch = reverseString.charAt(i);
      	  if(ch == '\\')
      		  break;
      	  else
      		  fileName = ch+fileName;
        }
        return fileName;
	}
	
	/**
	 * @author usama
	 * @param chosenFile
	 * @throws SQLException
	 */
	public void chooseFile(String fileName) throws SQLException
	{
		if(fileName.equals("Mafoul.csv"))
		{
			pathMafoul = chosenFile;
			new DataAccessClass().addingColumn(1);
			new DataAccessClass().mafoulInsert(chosenFile);
			count++;
		}
		else if(fileName.equals("Masdar.csv"))
		{
			pathMasdar = chosenFile;
			new DataAccessClass().addingColumn(2);
			new DataAccessClass().masdarInsert(chosenFile);
			count++;
		}
		else if(fileName.equals("Faeel.csv"))
		{
			pathFaeel = chosenFile;
			new DataAccessClass().addingColumn(3);
			new DataAccessClass().faeelInsert(chosenFile);
			count++;
		}
		else
		{
			System.out.println("Wrong File Chosen..");
		}
		uploadAsalTable();
	}
	
	/**
	 * @author usama
	 */
	public void uploadAsalTable()
	{
		if(count == 3)
		{
			new DataAccessClass().asalInsert(pathMafoul, pathMasdar, pathFaeel);
		}
		else
		{
			System.out.println("Others Files not uploaded..");
		}
	}
	
	/**
	 * @author usama
	 * @param sizeMafoulArray
	 * @param sizeFaeelArray
	 * @param sizeMasdarArray
	 * @return
	 */
	public int maxReturn(int sizeMafoulArray, int sizeFaeelArray, int sizeMasdarArray)
	{
		int max = 0;
		if(sizeMafoulArray < sizeFaeelArray)
        {
        	if(sizeMafoulArray < sizeMasdarArray)
        	{
        		max = sizeMafoulArray;
        	}
        	else
        	{
        		max = sizeMasdarArray;
        	}
        }
        else if(sizeFaeelArray < sizeMasdarArray)
        {
        	max = sizeFaeelArray;
        }
        else
        {
        	max = sizeMasdarArray;
        }
		return max;
	}
	
	/**
	 * @author usama
	 * @param str
	 * @return
	 * @throws SQLException
	 */
	public static ArrayList<DatabaseData> getRow(String str) throws SQLException {
		ArrayList<DatabaseData> word = null;
		try {
			word = DataAccessClass.jTableInsert(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}
}
