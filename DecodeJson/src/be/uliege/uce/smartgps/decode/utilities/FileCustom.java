package be.uliege.uce.smartgps.decode.utilities;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FileCustom {

	@SuppressWarnings("resource")
	public boolean writeFile(String json, String nomArchivo){
		FileWriter fichero = null;
        PrintWriter pw = null;
        //String filePath = "D:/tmp/data7.txt";
        String filePath = "D:/tmp/"+nomArchivo+".json";
        
        try {
            fichero = new FileWriter(filePath);
            pw = new PrintWriter(fichero);
            pw.println(json);
            
        } catch (Exception e) {
        	System.err.println(e.getMessage());
        	return false;
        } finally {
           try { 
        	   if (null != fichero){
	              fichero.close();
	  			  System.out.println("Archivo "+filePath+" generado.");
	           	  return true;
        	   }
           } catch (Exception e2) {
              System.err.println(e2.getMessage());
              return false;
           }
        }
        
        return false;
	}
}
