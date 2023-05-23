package TiposPagamentos;
public class Transferencia implements Pagamentos{

//---------------------------------------------------------------------------------

    //declaração dos campos da classse. O valor recebe o valor da compra e as strings contaRecebe e contaEnvia recebem,
    //respectivamente a conta que recebe o pagamento e a conta que envia o pagamento
    private double valor;
    private String contaRecebe, contaEnvia;

//-----------------------------------------------------------------------------------

    //construtor completo da classe
    public Transferencia(double valor, String origem, String destinatario) {
        this.valor = valor;
        contaRecebe = origem;
        contaEnvia = destinatario;
    }

    //o método realizarPagamento verifica se o valor pago foi o suficiente para pagar o valor total devido
    @Override
    public double realizarPagamento(double valorPago) {
        if (valorPago == valor)
            return 0;
        else if (valorPago > valor) {
            System.out.println("Troco de R$" + (valorPago - valor) + " é necessário");
            return (valorPago - valor);
        } else
            return -1;
    }

    @Override
    public void imprimirRecibo(double valorPago) {
        if (realizarPagamento(valorPago) >= 0)
            System.out.println("PRODUTO............. XXXXX\nVALOR............... R$" + df.format(valor) + "\n" +
                    "PAGO................ R$" + df.format(valorPago) + "\nFORMA DE PAGAMENTO.. Dinheiro \n" +
                    "REMETENTE........... " + contaEnvia + "\nDESTINATÁRIO........ " + contaRecebe);
        else
            System.out.println("O pagamento completo não foi realizado! Impossível" +
                    " imprimir o recibo!");
    }
}