import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler2 implements URLHandler {
    ArrayList<String> stored = new ArrayList<String>();

    @Override
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return ("null path, try again with a different URL");
        } else if (url.getPath().equals("/add-message")) {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    String appendObject = "\n" + parameters[1];
                    this.stored.add(appendObject);
                    //this.stored.add(parameters[1]);
                    return this.stored.toString();
                }
            }
            return "null string";
        } else {
            System.out.println("Path: " + url.getPath());
            return "404 Not Found!";
        }
    }
}

public class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler2());
    }
}
