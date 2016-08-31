package se05.task1;

import java.io.File;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class FileManager {

    Scanner sc;

    private static final String[] columnNames = {"File name", "Size", "Last modified", "Access", "Enhanced", "Type"};
    private File currentPath;


    public FileManager(File currentPath) {
        this.currentPath = currentPath;
    }

    

    private void printDirectory() {
        for (String colum : columnNames) {
            System.out.print(colum + "\t");
        }
        for (File obj : currentPath.listFiles()) {
            System.out.printf("%10%6%15%5%5%8n", obj.getName(), fileSize(obj), lastModifies(obj), fileAccess(obj), fileEnhanced(obj), fileType(obj));
        }
    }

    private String fileType(File obj) {
        if (obj.isFile()) {
            return "File";
        } else {
            return "Catalog";
        }
    }

    private String fileEnhanced(File file) {
        if (file.isFile()) {
            String name = file.getName();
            if (name.contains(".")) {
                name = name.substring(name.lastIndexOf('.') + 1, name.length());
                return name;
            } else {
                return "-";
            }
        } else {
            return "-";
        }

    }

    private String fileAccess(File file) {
        String access = "";
        if (file.canRead()) {
            access += "r";
        } else {
            access += "-";
        }
        access += "/";
        if (file.canWrite()) {
            access += "w";
        } else {
            access += "-";
        }
        return access;
    }

    private Formatter lastModifies(File obj) {
        Date date = new Date(obj.lastModified());
        Formatter formatter = new Formatter();
        formatter.format("%tH:%tM:%tS %td %tB %tY", date, date, date, date, date, date);
        return formatter;
    }

    private String fileSize(File file) {
        long size = file.length();
        String result;

        if (size >= 1024) {
            if (size >= 1024 * 1024) {
                if (size >= 1024 * 1024 * 1024) {
                    if (size >= 1024 * 1024 * 1024 * 1024) {
                        size = (long) size / 1024;
                        size = (long) size / 1024;
                        size = (long) size / 1024;
                        size = (long) size / 1024;
                        result = Long.toString(size) + " TB";
                        return result;
                    }
                    size = (long) size / 1024;
                    size = (long) size / 1024;
                    size = (long) size / 1024;
                    result = Long.toString(size) + " GB";
                    return result;
                }
                size = (long) size / 1024;
                size = (long) size / 1024;
                result = Long.toString(size) + " MB";
                return result;
            }
            size = (long) size / 1024;
            result = Long.toString(size) + " kB";
        }
        if (size == -1) {
            return "";
        } else {
            result = Long.toString(size) + " b";
        }
        return result;
    }
}

