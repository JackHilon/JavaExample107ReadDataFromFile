
package javaexample107readdatafromfile;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class JavaExample107ReadDataFromFile {

    // Data are byte, short, int, long, float, double, char, string , string(UTF-format), ........

    
    public static void main(String[] args) {
        
        File folder = MyHelper.CreateWorkingFolder("myWorkingFolder");
        
        MyHelper.FolderCheck(folder);
        
        File fil = MyHelper.CreateWorkingFile(folder, "myData.dat");
        
        MyHelper.FileCheck(fil);
        
        try{
            
            FileInputStream fis = new FileInputStream(fil);
            
            DataInputStream dis = new DataInputStream(fis);
            
            // reading
            byte b = dis.readByte();
            short s = dis.readShort();
            int i = dis.readInt();
            long l = dis.readLong();
            float f = dis.readFloat();
            double d = dis.readDouble();
            boolean bv = dis.readBoolean();
            char c = dis.readChar();
            
            // read string with UTF-Format
            String s1 = dis.readUTF();
            
            // read string as a series of unicode-chars, with given string-end (|)
            StringBuilder sb = new StringBuilder();
            
            char ch = dis.readChar();
            
            while (ch != '|') // | is string-end
            {                
                sb.append(ch);
                ch = dis.readChar();
            }// end-while
            
            String s2 = sb.toString();
            
            // -----------------------------------------------------------------
            
            System.out.println(b);
            System.out.println(s);
            System.out.println(i);
            System.out.println(l);
            System.out.println(f);
            System.out.println(d);
            System.out.println(bv);
            System.out.println(c);
            System.out.println(s1);
            System.out.println(s2);
            


            
            // close
            dis.close();
            fis.close();
            
        }
        catch(EOFException e)
        {
            /*
            Signals that an end of file or end of stream has been reached
            unexpectedly during input.
            
            This exception is mainly used by data input streams to signal end 
            of stream. Note that many other input operations return a special 
            value on end of stream rather than throwing an exception.
            */
            MyHelper.ExceptionHandle(e);
        }
        catch(IOException e)
        {
            MyHelper.ExceptionHandle(e);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
        
    }
    
}
