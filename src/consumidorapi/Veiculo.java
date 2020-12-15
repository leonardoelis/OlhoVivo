package consumidorapi;

public class Veiculo {
    private int p; // Prefixo do veículo
    private boolean a; // Indica se o veículo é ou não acessível para pessoas com deficiência
    private String ta; // Indica o horário universal UTC em que a localização foi capturada. Essa informação está no padrão ISO 8601
    private double py; // Informação de latitude da localização do veículo
    private double px; // Informação de longitude da localização do veículo
    
    public Veiculo(){
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public boolean isA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public double getPy() {
        return py;
    }

    public void setPy(double py) {
        this.py = py;
    }

    public double getPx() {
        return px;
    }

    public void setPx(double px) {
        this.px = px;
    }
    
    @Override
    public String toString() {
        return "Veículo: \n"
                + "Prefixo: "+p+"\n"
                + "Veículo Acessível: "+a+"\n"
                + "Horário Universal (UTC): "+ta+"\n"
                + "Latitude: "+py+"\n"
                + "Longitude: "+px+"\n";
    }
}
