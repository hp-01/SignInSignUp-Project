/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validater;

/**
 *
 * @author harsh
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class DateVerify{

   public static boolean isValid(String strDate)
   {
	/* Check if date is 'null' */
	if (strDate.trim().equals("")) return true;

	else
	{
	    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/MM/dd");
	    sdfrmt.setLenient(false);
	    try
	    {
	        Date javaDate = sdfrmt.parse(strDate); 
	    }
	    catch (ParseException e)
	    {
	        return false;
            }
	    return true;
	}
   }
}
    
