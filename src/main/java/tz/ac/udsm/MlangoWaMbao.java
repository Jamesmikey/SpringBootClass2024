package tz.ac.udsm;

import org.springframework.stereotype.Component;

@Component
public class MlangoWaMbao implements Mlango{
    @Override
    public void funga() {
        System.out.println("Kufunga mlango wa mbao");
    }

    @Override
    public void fungua() {
        System.out.println("Kufungua mlango wa mbao");
    }
}
