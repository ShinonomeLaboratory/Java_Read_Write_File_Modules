import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yuan Yifan
 *  Function: Read large text file line by line.
 * Usage: 
 * Firstly, new a object  TxtFileLineWrite and initial it by your filename:
 * 	TxtFileLineWrite FWL = new TxtFileLineWrite(FileName);
 * Secondly, the function in this object fWrite to write a String.
 *  For example:
 *  FWL.fWrite("This is a test!\r\n");
 * 	You have to use "\r\n" in Win to shift a new line.
 * Last but not least:
 * 	You have to free file before terminating your program like this:
 * 	FWL.FreeFile();
 * Have fun!
 * 
 */
public class TxtFileLineWrite {
    
    private FileWriter fp = null;
    private BufferedWriter bw = null;
    private int Flag_Loaded = 0;
    
    public TxtFileLineWrite(){
    	//Do nothing
    }
    
    public TxtFileLineWrite(String FileName){
        LoadFile(FileName);
    }
    
    public void LoadFile(String FileName){
        try{
            if (Flag_Loaded==1){
                FreeFile();
            }else{
                fp = new FileWriter(FileName);
                bw = new BufferedWriter(fp);
                Flag_Loaded = 1;
            }
        }catch(IOException e) {
            System.out.println("Error While Opening the File to Write.");
        }
    }
    
    public void fWrite(String StrWrite){
        try{
            bw.write(StrWrite,0,StrWrite.length());
        }catch(IOException e) {
            System.out.println("Error While Writing the File.");
        }
    }
    
    public void FreeFile(){
        try {
            if (Flag_Loaded==1){
                bw.close();
                fp.close();
                Flag_Loaded = 0;
            }
        } catch (IOException ex) {
            System.out.println("Error While Closing the File.");
        }
    }
    
    @Override
    protected void finalize() throws Throwable{
        FreeFile();
    }
}
