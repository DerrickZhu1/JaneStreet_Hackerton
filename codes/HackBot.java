import java.io.*;
import java.net.*;

public class HackBot {

    public static void main(String[] args)
   {
      String serverName = args[0];
      int port = Integer.parseInt(args[1]);
      try
      {
         Socket echoSocket = new Socket(serverName, port);
         PrintWriter out =
              new PrintWriter(echoSocket.getOutputStream(), true);
         BufferedReader in =
             new BufferedReader(
               new InputStreamReader(echoSocket.getInputStream()));
         BufferedReader stdIn =
            new BufferedReader(
                new InputStreamReader(System.in));

         String userInput;
         while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("echo:" + in.readLine());
            String result = in.readLine();
            String[] words = result.split(" ");
            if (words[0].equals("BOOK")){
              for (int i=0; i<words.length; i++){
                if (words[i].equals("BUY")){
                  String s = words[i+1];
                  for (int j=0; j<s.length(); j++){
                    if (s.charAt(j)==':'){
                      out.println("ADD 3 "+words[1]+" BUY "+ s.substring(0, j)+" "+ s.substring(j+1));
                      break;
                    }
                  } 
                }
            }
          }
         }
         }catch(IOException e)
         {  
            System.err.println("Couldn't get I/O for the connection to " + serverName);
            System.exit(1);
            e.printStackTrace();
         }
    }

}