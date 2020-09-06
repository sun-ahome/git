package com.test.numone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtSCV {
    public static void main(String[] args) {
        List<String> resultList = readTxtMML();
        outFileCSV(resultList);
        System.out.println(System.getProperty("test.dir"));
    }

    private static List<String> readTxtMML() {
        String fileName = System.getProperty("test.dir") + "\\jacoco.txt";
        File file = new File(fileName);
        BufferedReader reader = null;
        List<String> resultList = new ArrayList<>();
        String[] tempStrs;
        String[] packageClassStrs;
        String packageClass = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("class")) {
                    tempString = tempString.substring(tempString.indexOf("class")).replaceAll("/", ".");
                    tempStrs = tempString.split(" ");
                    packageClass = tempStrs[0];
                } else if (tempString.contains(" method ") && !tempString.contains("<init>()V")) {
                    tempString = tempString.substring(tempString.indexOf("method")).replaceAll("/", ".");
                    tempStrs = tempString.split(" ");
                    packageClassStrs = packageClass.split("\\.");
                    String cla = packageClassStrs[packageClassStrs.length - 1];
                    String pac = packageClass.substring(0, packageClass.length() - cla.length() - 1);
                    resultList.add(pac + "," + cla + "," + tempStrs[1].substring(0, tempStrs[1].indexOf("(")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return resultList;
    }

    private static void outFileCSV(List<String> resultList) {
        FileOutputStream out = null;
        OutputStreamWriter osw = null;
        BufferedWriter bfw = null;
        String fileName = System.getProperty("user.dir") + "\\jacoco.csv";
        try {
            out = new FileOutputStream(fileName);
            osw = new OutputStreamWriter(out, "UTF8");
            bfw = new BufferedWriter(osw, 1024);

            if (resultList != null && !resultList.isEmpty()) {
                for (String result : resultList) {
                    bfw.write(result + "\r\n");
                }
            }
            bfw.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (osw != null) {
                    osw.close();
                }
                if (bfw != null) {
                    bfw.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
