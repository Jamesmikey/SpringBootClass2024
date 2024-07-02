package tz.ac.udsm;

import org.springframework.stereotype.Component;


public class MlangoWaChuma implements Mlango{
    @Override
    public void funga() {
        System.out.println("Kufunga mlango wa chuma");
    }

    @Override
    public void fungua() {
        System.out.println("Kufungua mlango wa chuma");
    }
}
