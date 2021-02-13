package org.kikala.ioc.simple;

public class Application {

    public static void main(String args[]) {
        MarcheService marcheService = (MarcheService) DIFactory.getBean(MarcheService.class);

        for (int i = 0; i < 5; i++) {
            marcheService.trader((i % 2) + 10);
        }
    }
}
