package TiposPagamentos;

public class CartaoDebito implements Pagamentos {

//-------------------------------------------------------------------------------------

    //declaração dos campos da classe. O valor recebe o valor da compra
    private double valor;

//-----------------------------------------------------------------------------------------

    //construtor completo da classe
    public CartaoDebito(double valor) {
        this.valor = valor;
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
                    "PAGO................ R$" + df.format(valorPago) + "\nFORMA DE PAGAMENTO.. Cartão de Débito");
        else
            System.out.println("O pagamento completo não foi realizado! Impossível" +
                    " imprimir o recibo!");
    }
}
