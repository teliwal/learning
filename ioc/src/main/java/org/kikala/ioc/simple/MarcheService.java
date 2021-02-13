package org.kikala.ioc.simple;

public class MarcheService {

    private MessageService messageService;

    private AchatService achatService;

    public void trader(int montant) {
        if (messageService == null) {
            messageService = getMessageService();
        }
        if (achatService == null) {
            achatService = getAchatService();
        }
        messageService.print("je tente un trade a " + montant);
        String retour = this.achatService.acheter(montant);
        messageService.print(retour);
    }

    private MessageService getMessageService() {
        return (MessageService) DIFactory.getBean(MessageService.class);
    }

    private AchatService getAchatService() {
        return (AchatService) DIFactory.getBean(AchatService.class);
    }
}
