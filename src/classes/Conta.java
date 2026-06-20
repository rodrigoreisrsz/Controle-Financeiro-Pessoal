package classes;

public class Conta {
    private double saldo;
    private int senha;
    private String dono;
    private char tipoDeConta;
    private boolean statusConta = false;

    public Conta(String dono,  char tipoDeConta){
        this.dono = dono;
        if(tipoDeConta == 'C'){
            this.tipoDeConta = 'C';
            this.saldo = 50;
        }if(tipoDeConta == 'P') {
            this.tipoDeConta = 'P';
            this.saldo = 50;
        }
        this.statusConta = true;
    }
    public double verSaldo(){
        return this.saldo;
    }


}
