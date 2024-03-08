package Sender;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFolder {

    public static void zipFolder(String sourceFolderPath, String zipFilePath) {
        try {
            FileOutputStream fos = new FileOutputStream(zipFilePath);
            ZipOutputStream zos = new ZipOutputStream(fos);
            File sourceFolder = new File(sourceFolderPath);

            // Nén từng tệp và thư mục trong thư mục nguồn
            zipFile(sourceFolder, sourceFolder.getName(), zos);

            zos.close();
            fos.close();
            System.out.println("Folder successfully compressed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }
    public static void main(String[] args) {
        // Đường dẫn thư mục nguồn
        String sourceFolderPath = "image";
        // Đường dẫn tệp nén
        String zipFilePath = "Zip\\imageUI.zip";

        zipFolder(sourceFolderPath, zipFilePath);
        String emailContent = "Đây là tệp zip image.";

        try {
            // Gửi email với tệp zip đính kèm
            EmailSender.sendEmail(zipFilePath, emailContent);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            System.out.println("Failed to send email. Error: " + e.getMessage());
        }
    }
    }

