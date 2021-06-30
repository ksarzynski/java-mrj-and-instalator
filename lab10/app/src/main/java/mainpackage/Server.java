package mainpackage;

import encryption.Encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Server {

    private Encryption encryption;

    public void start(int port, JTextArea textArea) throws IOException, NoSuchAlgorithmException,
            InvalidKeySpecException {

        encryption = new Encryption();
        encryption.startServer(port);
        encryption.start(textArea);
    }

    public void sendMessage(String msg) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException,
            NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        encryption.sendMessage(msg, encryption.getClientSocket().getOutputStream());
    }
}
