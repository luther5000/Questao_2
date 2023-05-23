package TiposPagamentos;

public class Pix implements Pagamentos{

//---------------------------------------------------------------------------------------------

    //declaração dos campos da classe. O valor recebe o valor da compra, enquanto a String chavePix recebe a chave PIX
    //para onde o valor será enviado
    private double valor;
    private static String chavePix;

//------------------------------------------------------------------------------------------------

    //construtor completo da classe
    public Pix (double valor, String chave){
        this.valor = valor;
        chavePix = chave;
    }

    //o método realizarPagamento verifica se o valor pago foi o suficiente para pagar o valor total devido
    @Override
    public double realizarPagamento(double valorPago) {
        if (valorPago == valor)
            return 0;
        else if (valorPago > valor) {
            System.out.println("Troco de R$" +(valorPago-valor)+ " é necessário");
            return (valorPago - valor);
        } else
            return -1;
    }

    @Override
    public void imprimirRecibo(double valorPago) {
        if (realizarPagamento(valorPago) >= 0)
            System.out.println("PRODUTO............. XXXXX\nVALOR............... R$" + df.format(valor) + "\n" +
                    "PAGO................ R$" + df.format(valorPago) + "\nFORMA DE PAGAMENTO.. Pix \n" +
                    "\nDESTINATÁRIO....... " + chavePix);
        else
            System.out.println("O pagamento completo não foi realizado! Impossível" +
                    " imprimir o recibo!");
    }
}

