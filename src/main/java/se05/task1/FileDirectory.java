package se05.task1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Math.pow;

public class FileDirectory {

    public void printDirectory(File currentPath) {

        System.out.printf("%-55s%-10s%-30s%-10s%-13s%-10s\n", "File name", "Size", "Last modified", "Access",
                "Enhanced", "Type");
        System.out.println("-------------------------------------------------------------------------------------" +
                "-------------------------------------");

        for (File obj : currentPath.listFiles()) {
            System.out.printf("%-55s%-10s%-30s%-10s%-13s%-10s\n", obj.getName(), fileSize(obj), lastModifies(obj),
                    fileAccess(obj), fileEnhanced(obj), fileType(obj));
        }
    }

    private String fileType(File obj) {
        return obj.isFile() ? "File" : "Catalog";
    }

    private String fileEnhanced(File file) {
        String name;
        if (file.isFile() && (name = file.getName()).contains(".")) {
            name = name.substring(name.lastIndexOf('.') + 1, name.length());
            return name;
        } else {
            return "-";
        }
    }

    private String fileAccess(File file) {
        String access;

        access = file.canRead() ? "r/" : "-/";
        access += file.canWrite() ? "w" : "-";
        return access;
    }

    private String lastModifies(File obj) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:MM:ss  dd.MM.yyyy");
        return dateFormat.format(new Date());
    }

    private String fileSize(File file) {

        if (file.isDirectory()) {
            return "-";
        } else {
            long size = file.length();

            if (size >= pow(1024, 3)) {
                return (size / (long) pow(1024, 3)) + " GB";
            }
            if (size >= pow(1024, 2)) {
                return (size / (long) pow(1024, 2)) + " MB";
            }
            if (size >= 1024) {
                return (size / 1024) + " kB";
            }
            return size + " b";
        }
    }
}
