/**
 *
 * @author Yuan Yifan
 *  Function: Read large text file line by line.
 * Usage: 
 * Firstly, new a object  TxtFileLineRead and initial it by your filename:
 * 	TxtFileLineRead FRL = new TxtFileLineRead(FileName);
 * Secondly, the function in this object fReadln to return a line.
 *  For example:
 *  String Exper = FRL.fReadln();
 * 	If the text file has N lines you have to execute this function for N times to read it all
 * Last but not least:
 * 	You have to free file before terminating your program like this:
 * 	FRL.FreeFile();
 * Have fun!
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TxtFileLineRead {
    //public static void main(){
    //  You can write Usage in main or a new function.
    //  Such as：
    //  System.out.println("Firstly, new a object  TxtFileLineRead and initial it by your filename:");
    //  And so on
    //}
    
    private FileReader fp = null;
    private BufferedReader br = null;
    private int Flag_Loaded = 0;
    
    public TxtFileLineRead(String FileName){
        LoadFile(FileName);   
    }
    
    public TxtFileLineRead(){
    	//Do nothing
    }
    public int LoadFile(String FileName){
    	//Using for debug
        System.out.println("Try to load " + FileName);
        try{
            if (Flag_Loaded==1){
                FreeFile();
            }
            fp = new FileReader(FileName);
            br = new BufferedReader(fp);
            Flag_Loaded = 1;
            return(0);
        }catch (FileNotFoundException e){
            System.out.println("Error while loading file.");
            return(-1);
        }
    }
    
    public String fReadln(){
        try {
            String Str = br.readLine();
            return(Str);
        } catch (IOException ex) {
            System.out.println("Error while get the line");
            Logger.getLogger(TxtFileLineRead.class.getName()).log(Level.SEVERE, null, ex);
            return(null);
        }
    }

    public void FreeFile(){
        try {
        	if (Flag_Loaded != 0){
        		br.close();
                fp.close();
                Flag_Loaded = 0;
        	}
        } catch (IOException ex) {
            Logger.getLogger(TxtFileLineRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void finalize() throws Throwable{
        FreeFile();
    }
}
