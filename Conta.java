import java.util.Scanner;

public class Conta {
    boolean isFalse = false;
    boolean isTrue = true;
    String titular;
    double saldo;
    static Conta destino1;
    Conta destino2;
    Conta destino3;

    boolean Levantar(double quantidade) {
        if (this.saldo >= quantidade) {
            this.saldo -= quantidade;
            return true;
        } else {
            return false;
        }
    }

    boolean Depositar(Conta destino2, double valor) {
        if (this.saldo >= valor) {
            destino2.saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    boolean Transferir(Conta destino3, double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino3.saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) { //objeto para manipular info.
        /* Início da primeira parte. */
        Scanner input = new Scanner(System.in);
        Conta minhaConta = new Conta();
        minhaConta.titular = "Mariana";
        System.out.println(minhaConta.titular);
        System.out.print("Digite o valor desejado para a sua conta: ");
        double saldo1 = input.nextInt();
        minhaConta.saldo = saldo1;
        System.out.println("Saldo disponível: " + saldo1);
        System.out.println(minhaConta.saldo);
        /* Início da segunda parte. */
        System.out.print("Deseja realizar um levantamento? (sim/não)");
        String resposta1 = input.next();
        if (resposta1.equalsIgnoreCase("sim")) {
            Conta destino1 = new Conta();
            System.out.print("Insira o nome do titular da conta: ");
            destino1.titular = input.next();
            System.out.print("Digite o valor a levantar: ");
            double valor1 = input.nextDouble();
            boolean conseguir1 = minhaConta.Levantar(valor1);
            if (conseguir1) {
                System.out.println("Saldo levantado: " + valor1);
                System.out.println("Saldo atual: " + minhaConta.saldo);
            } else {
                System.out.println("Levantamento não autorizada.");
                System.out.println("Saldo atual: " + minhaConta.saldo);
            }
        } else {
            if (resposta1.equalsIgnoreCase("não")) {
                System.out.println("Volte sempre!");                
            } else{
                System.out.println("Resposta incorrecta!"); 
            }
        } 
        /* Início da terceira parte. */
        System.out.print("Deseja realizar um depósito? (sim/não)");
        String resposta2 = input.next();
        if (resposta2.equalsIgnoreCase("sim")) {
            Conta destino2 = new Conta();
            System.out.print("Insira o nome do titular da conta: ");
            destino2.titular = input.next();
            System.out.print("Digite o valor a depositar: ");
            double valor2 = input.nextDouble();
            if (destino2.titular.equals(minhaConta.titular)) {
                minhaConta.Depositar(minhaConta, valor2);
                System.out.println("Saldo depositado: " + valor2);
                System.out.println("Saldo atual: " + minhaConta.saldo);
            } 
            else if (!destino2.titular.equals(minhaConta.titular)) {
                minhaConta.Depositar(destino2, valor2);
                minhaConta.saldo = minhaConta.saldo - valor2;
                System.out.println("Saldo depositado: " + valor2);
                System.out.println("Saldo atual: " + minhaConta.saldo);
            } 
        } else {
            if (resposta2.equalsIgnoreCase("não")) {
                System.out.println("Volte sempre!");                
            } else{
                System.out.println("Resposta incorrecta!"); 
            }
        } 
        /* Início da quarta parte. */
        System.out.print("Deseja realizar uma transferência? (sim/não)");
        String resposta3 = input.next();
        if (resposta3.equalsIgnoreCase("sim")) {
            Conta destino3 = new Conta();
            System.out.print("Insira o nome do titular da conta: ");
            destino3.titular = input.next();
            if (destino3.titular.equals(minhaConta.titular)) {
                System.out.println("Não pode realizar a operação.");
            } 
            else if (!destino3.titular.equals(minhaConta.titular)) {
                System.out.print("Digite o valor a transferir: ");
                double valor3 = input.nextDouble();
                minhaConta.Transferir(destino3, valor3);
                System.out.println("Saldo transferido: " + valor3);
                System.out.println("Saldo atual: " + minhaConta.saldo);
            } 
        } else {
            if (resposta3.equalsIgnoreCase("não")) {
                System.out.println("Volte sempre!");                
            } else{
                System.out.println("Resposta incorrecta!"); 
            }
        }

        input.close(); //função fechar objeto.
    }
}