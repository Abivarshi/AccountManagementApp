/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanagement.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author acer
 */
public class BackUp {


    public static void getBackUp(String shopname) {
        File source = new File("C:\\AccountManagement_1.0\\"+shopname+".db");
        File dest = new File("G:\\My Drive\\"+shopname+".db");
        try {
            copyFile(source, dest);
        } catch (IOException e) {
            Logger.getLogger(BackUp.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static void copyFile(File sourceLocation, File targetLocation)
            throws IOException {

        InputStream in = new FileInputStream(sourceLocation);
        OutputStream out = new FileOutputStream(targetLocation);

        // Copy the bits from instream to outstream
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

}
