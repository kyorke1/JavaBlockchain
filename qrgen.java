import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.Desktop;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class qrgen {
    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    private static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    public static void main(String[] args) throws IOException {
    	
    	File file = new File("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\MyQRCode.png");
    	Desktop desktop = Desktop.getDesktop();
    	String content = null;
		try{
			
	         DataInputStream dis = 
		    new DataInputStream (
		    	 new FileInputStream ("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\A.txt"));
		       
		 byte[] datainBytes = new byte[dis.available()];
		 dis.readFully(datainBytes);
		 dis.close();
		       
		 content = new String(datainBytes, 0, datainBytes.length);
		     
		 System.out.println(content);
		 content = content.replaceAll("\r\n", "    ");
		 
        try {
            generateQRCodeImage(content, 350, 350, QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
        
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		file = new File("C:\\Users\\kyle.yorke\\eclipse-workspace\\KyleBlockchain\\MyQRCode.png");
        if(file.exists()) desktop.open(file);
			
		}
    }
