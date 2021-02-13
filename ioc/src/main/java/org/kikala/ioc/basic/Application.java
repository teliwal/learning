package org.kikala.ioc.basic;

public class Application {

    public static void main(String args[]) {
        MessageService messageService = (MessageService) DIFactory.getBean(MessageService.class);
        AchatService achatService = (AchatService) DIFactory.getBean(AchatService.class);
        MarcheService marcheService = (MarcheService) DIFactory.getBean(MarcheService.class);

        achatService.setMessageService(messageService);
        marcheService.setMessageService(messageService);
        marcheService.setAchatService(achatService);

        for (int i = 0; i < 5; i++) {
            marcheService.trader((i % 2) + 10);
        }
    }
}
