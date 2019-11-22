package be.uliege.uce.smartgps.decode.utilities;

public class Constants {

	public static String driver = "com.mysql.jdbc.Driver";
	//public static String database = "gmoncayo_smart_gps";
        public static String database = "test";
	public static String hostname = "localhost";
	public static String port = "3306";

	public static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

	public static String username = "root";
	public static String password = "_Arsenal2011";
	 
	//public static String formatDate = "MMM dd, yyyy HH:mm:ss";
        public static String formatDate = "MMM dd, yyyy hh:mm:ss aa";
        public static String formatDate1 = "MMM dd, yyyy HH:mm:ss";
        public static String formatDateAux = "dd MMM, yyyy HH:mm:ss";
        
	public static String formatDateExport = "yyyy-MM-dd HH:mm:ss";
        
	//public static String selectPositions = "select * from posicion where DSP_ID = 152";
        //public static String selectPositions = "select * from posicion";
        
        public static int numFilas = 500000;
        
        public static String selectPositions = "select * from posicion where psc_id between ? and ?";
        
        public static String maxNumberPositions = "select count(*) from posicion";
        
        //public static String selectPositionsDevice = "select * from posicion where dsp_id in (650)";
        //public static String selectPositionsDevice = "select * from posicion where dsp_id in (248)";
        //public static String selectPositionsDevice = "select * from posicion where dsp_id in (756)";
        //public static String selectPositionsDevice = "select * from posicion where dsp_id in (247)";
        //public static String selectPositionsDevice = "select * from posicion where dsp_id in (293)";
        //public static String selectPositionsDevice = "select * from posicion where dsp_id in (577,792)";
        //public static String selectPositionsDevice = "select * from posicion where psc_id in (3786472,3786473)";
        
        
        public static String selectPositionsDevice = "select * from posicion";
        
        
        //public static String selectPositions = "select * from posicion where psc_id between 1 and 1000000";
	//public static String selectPositions = "select * from posicion where psc_id between 1000001 and 2000000"; 
        //public static String selectPositions = "select * from posicion where psc_id between 2000001 and 3000000"; 
        //public static String selectPositions = "select * from posicion where psc_id between 3000001 and 4000000";
        //public static String selectPositions = "select * from posicion where psc_id between 4000001 and 5000000";
        //public static String selectPositions = "select * from posicion where psc_id between 5000001 and 7000000";
        //public static String selectPositions = "select * from posicion where psc_id > 7000000";

}
