package org.kikala.ioc.simple;

public class AchatService {

    private MessageService messageService;

    public String acheter(int montant) {
        if (messageService == null) {
            messageService = getMessageService();
        }
        if (montant > 10) {
            this.messageService.print("De l'oseille encore");
            return "achat reussi";
        }
        this.messageService.print("Quel radin celui la");
        return "ce n'est pas assez,je ne suis pas un rat";
    }

    private MessageService getMessageService() {
        return (MessageService) DIFactory.getBean(MessageService.class);
    }
}
