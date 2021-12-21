
package javaexample107readdatafromfile;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author marka
 */
public class MyHelper {
  
    public static File CreateWorkingFolder(String folderName) {
        
        File folder = new File("." + File.separatorChar + folderName);
        
        folder.mkdir();
        
        return folder;
    }
    
    
    public static File CreateWorkingFile(File folder, String fileName) {
        
        File fil = new File(folder, fileName);
        try {
        fil.createNewFile();
        return fil;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void FolderCheck(File folder) {
        
        if(folder.isDirectory())
            System.out.println("A folder, named (" + folder.getName() + "), is created....");
        else System.out.println("Error....");
    }
    
    public static void FileCheck(File fil) {
        
        if(fil.isFile())
            System.out.println("A file, named (" + fil.getPath() + "), is created....");
        else System.out.println("Error....");
        
    }
    
    public static void ExceptionHandle(Exception e) {
      
        System.out.println(e.toString());
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
}
