package net.wind.utils.shell.shellError;

import net.wind.BoyLoader;

/**
 * createTime 2022/12/10 0010
 * fileName NoShellSession
 *
 * @author WindStream
 */

public class NoShellSession {
      public static boolean NoShellSession(String IP){
          for (String liveIP : BoyLoader.Host_List){
              if (liveIP.equals(IP)){
                  return false;
              }
          }
          return true;
      }
}
