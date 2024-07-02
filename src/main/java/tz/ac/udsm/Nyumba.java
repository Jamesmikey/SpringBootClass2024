package tz.ac.udsm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class Nyumba {

    private final Mlango mlango;

    private int ukubwa;

    public int getUkubwa() {
        return ukubwa;
    }

    public void setUkubwa(int ukubwa) {
        this.ukubwa = ukubwa;
    }

    public Nyumba(Mlango mlango) {
        this.mlango = mlango;
    }


    public void fungaMlango(){
        mlango.funga();
    }

    public void funguaMlango(){
        mlango.fungua();
    }
}
