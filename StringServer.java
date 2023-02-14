
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    
    String record;

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("End of path");
        } else {
            if (url.getPath().contains("/add-message"){
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    // add the string to next line
                    record += "\n";
                    record += parameters[1];
                    return record;
                }
            }
            return "404 Not Found!";
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
