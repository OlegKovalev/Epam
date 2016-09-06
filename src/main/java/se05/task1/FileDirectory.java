package se05.task1;

import java.io.File;
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
