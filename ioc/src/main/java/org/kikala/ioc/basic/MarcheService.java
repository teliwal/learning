package org.kikala.ioc.basic;

public class MarcheService {

    private MessageService messageService;

    private AchatService achatService;

    public void trader(int montant) {
        this.messageService.print("je tente un trade a " + montant);
        String retour = this.achatService.acheter(montant);
        this.messageService.print(retour);
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void setAchatService(AchatService achatService) {
        this.achatService = achatService;
    }
}
