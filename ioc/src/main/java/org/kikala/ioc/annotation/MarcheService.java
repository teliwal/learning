package org.kikala.ioc.annotation;

@Composant
public class MarcheService {

    @Inject
    private MessageService messageService;

    @Inject
    private AchatService achatService;

    public void trader(int montant) {
        messageService.print("je tente un trade a " + montant);
        String retour = this.achatService.acheter(montant);
        messageService.print(retour);
    }

}
