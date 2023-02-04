package net.wind.utils.shell.shellError;

import net.wind.core.window.ShellWindow;

/**
 * createTime 2022/12/10 0010
 * fileName NotInSession
 *
 * @author WindStream
 */

public class NotInSession {
    public static boolean NotInSession(){
        if (ShellWindow.Session_Status.equals("No Session")){
            return false;
        }else {
            return true;
        }
    }
}
