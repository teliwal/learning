package org.kikala.ioc.annotation;

@Composant
public class AchatService {

    @Inject
    private MessageService messageService;

    public String acheter(int montant) {
        if (montant > 10) {
            this.messageService.print("De l'oseille encore");
            return "achat reussi";
        }
        this.messageService.print("Quel radin celui la");
        return "ce n'est pas assez,je ne suis pas un rat";
    }

}
