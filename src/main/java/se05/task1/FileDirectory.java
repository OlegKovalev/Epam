package se05.task1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

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
            String result;
            long size = file.length();

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
}

    /* java.lang.StackOverflowError
    
    private long fileSize(File file) {
        long size = 0;
        String result;

        if (file.isFile()) {
            size = file.length();
        } else {
            File[] subFiles = file.listFiles();
            for (File innerFile : subFiles) {
                if (innerFile.isFile()) {
                    size += file.length();
                } else {
                    size += fileSize(file);
                }
            }
        }
        return size;
    }
   
    private String formatFileSize(long size) {
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
    }*/
