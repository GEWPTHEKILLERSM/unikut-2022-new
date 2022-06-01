package Controller;

import Controller.Exceptions.*;
import Model.*;
import java.util.LinkedList;

public class Messages {
    // Exibir menssagens de um usuario
    private static void printMessages(LinkedList<String> texts) {
        for (String s : texts) {
            System.out.println(s);
        }
    }

    // Metodo para exibir menssagens
    public static void showMessages(User user) throws Exception {
        if (user.getMessages().size() == 0) {
            throw new EmptyInbox();
        } else {
            for (User key : user.getMessages().keySet()) {
                System.out.println("[Menssagems de: " + key.getLogin() + "]");
                printMessages(user.getMessages().get(key));
            }
        }
    }

    // Metodo para enviar depoimentos
    public static void sendMessage(String message, User whosends, String loginFromReceptor) throws Exception {
        User receptor = SocialNetwork.search(loginFromReceptor);

        if (receptor == null) {
            throw new UserDoNotExist();
        } else {
            if (!receptor.getMessages().containsKey(whosends)) {
                receptor.getMessages().put(whosends, new LinkedList<>());
                receptor.getMessages().get(whosends).addFirst(message);
            } else {
                receptor.getMessages().get(whosends).addLast(message);
            }
        }

    }

}
