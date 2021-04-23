/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

/**
 * @author Home
 */
public class Formatter {

    public String formatAsFileSize(long size) {
        if (size < 1024) {//true false
            return size + " B";
        } else if (size >= 1024 && size < 1024 * 1024) {//true false
            String result = String.valueOf((size / 1024.0));
            int index = result.indexOf('.');
            if (index != -1) {//always true
                int length = result.length();
                if (length - index > 2) {//false true
                    result = result.substring(0, index + 3);
                }
            }
            return result + " KB";
        } else if (size >= 1024 * 1024 && size < 1024 * 1024 * 1024) {//true false
            String result = String.valueOf((size / (1024 * 1024.0)));
            int index = result.indexOf('.');
            if (index != -1) {//always true
                int length = result.length();
                if (length - index > 2) {//false true
                    result = result.substring(0, index + 3);
                }
            }
            return result + " MB";
        } else {
            String result = String.valueOf((size / (1024 * 1024 * 1024.0)));
            int index = result.indexOf('.');
            if (index != -1) {//always true
                int length = result.length();
                if (length - index > 2) {//true false
                    result = result.substring(0, index + 3);
                }
            }
            return result + " GB";
        }

    }

    public String formatAsTimeLength(long length) {
        if (length < 1000) {
            return length + " milli seconds";
        } else if (length >= 1000 && length < 60 * 1000) {
            String result = String.valueOf((length / 1000));
            return result + " seconds";
        } else if (length >= 60 * 1000 && length < 60 * 1000 * 60) {
            long minutes = length / (60 * 1000);
            int seconds = (int) ((length / 1000) % 60);
            return minutes + " minutes " + seconds + " seconds";
        } else {
            long hours = length / (60 * 60 * 1000);
            long minutes = (int) ((length / 1000) % (60 * 60));
            if (minutes >= 60) {
                minutes = minutes / 60;
            }
            return hours + " hour " + minutes + " minutes";
        }
    }

}
