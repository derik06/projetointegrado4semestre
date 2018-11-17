package model;

public class Led {

    private int idLed; // NÃO PODE SER STRING PORQUE ELE É INT NO CAMPO
    private String status;

    public Led(String serialLed){

        String array[] = new String[2];
        array = serialLed.split("-");

        setIdLed(Integer.parseInt(array[0]));
        setStatus(array[1]);

    }

    public int getIdLed() {
        return idLed;
    }

    public String getStatus() {
        return status;
    }

    public void setIdLed(int idLed) {
        this.idLed = idLed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public String cortaStringId(){}

}




