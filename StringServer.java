import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
  // A String that will be manipulated by various requests.
  String str = "";
  // A number that count number of requests.
  int num = 0;

    public String handleRequest(URI url) {
      if (url.getPath().contains("/add-message")) {
        String[] parameters = url.getQuery().split("=");
        if(parameters[0].equals("s")){
          num +=1;
          str = str + String.valueOf(num)+ ". " + parameters[1]+ "\n" ;
          return str;
        }
        return "404 Not Found!";
    }
}

class NumberServer {
  public static void main(String[] args) throws IOException {
    if(args.length == 0){
      System.out.println("Missing port number! Try any number between 1024 to 49151");
      return;
    }

    int port = Integer.parseInt(args[0]);
    
    Server.start(port, new Handler());
    }
}
