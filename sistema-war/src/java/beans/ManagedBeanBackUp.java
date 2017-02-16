/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author argos
 */
@SessionScoped
@ManagedBean
public class ManagedBeanBackUp implements Serializable{
private StreamedContent file;

    public ManagedBeanBackUp() {
        this.backupDB();
    }

public String Backups(){
        return "backups";
        }
public StreamedContent getFile() {
        if(file != null){
          System.out.println("SEGUNDA PARTE  Nombre "+ file.getName() +"Tipo de COntenido "+ file.getContentType());
        }
          return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
      public void backupDB() {
                     ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();



                  String ruta=    extContext.getRealPath("//BK//BK.sql");
        String executeCmd = "mysqldump -u root"+ " -psistema"+ " --add-drop-database -B sistema" + " -r " + ruta;
        Process runtimeProcess;
        try {

            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup created successfully");

            } else {
                System.out.println("Could not create the backup");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        SimpleDateFormat fecha1_11 = new SimpleDateFormat("dd-MM-yyyy");
           StringBuilder cadena_fecha1_11 = new StringBuilder();
           cadena_fecha1_11 = new StringBuilder( fecha1_11.format( new Date() ) );
                     String OUTPUT_ZIP_FILE ="";
    String SOURCE_FOLDER ="";
List<String> fileList = new LinkedList<String>();
fileList.add("BK.sql");
OUTPUT_ZIP_FILE = extContext.getRealPath("//BK//BACKUP_"+cadena_fecha1_11.toString()+".zip");
SOURCE_FOLDER = extContext.getRealPath("//BK");
this.zipIt(OUTPUT_ZIP_FILE,fileList,SOURCE_FOLDER);

InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("//BK//BACKUP_"+cadena_fecha1_11.toString()+".zip");
file = new DefaultStreamedContent(stream, "application/zip", "BACKUP_"+cadena_fecha1_11.toString()+".zip");
  System.out.println("PRIMERA PARTE  Nombre "+ file.getName() +"Tipo de COntenido "+ file.getContentType());
                 }

                  public void zipIt(String zipFile,List<String> fileList, String SOURCE_FOLDER){

     byte[] buffer = new byte[512];

     try{

    	FileOutputStream fos = new FileOutputStream(zipFile);
    	ZipOutputStream zos = new ZipOutputStream(fos);

   // 	System.out.println("Output to Zip : " + zipFile);

    	for(String file : fileList){


 //System.out.println("File Added : " + file);
    		ZipEntry ze= new ZipEntry(file);
        	zos.putNextEntry(ze);

        	FileInputStream in =   new FileInputStream(SOURCE_FOLDER + File.separator + file);

        	int len;
        	while ((len = in.read(buffer)) > 0) {
        		zos.write(buffer, 0, len);
        	}

        	in.close();

    	}

    	zos.closeEntry();
    	//remember close it
    	zos.close();

    	//System.out.println("Done");
    }catch(IOException ex){
       ex.printStackTrace();
    }
   }
}
