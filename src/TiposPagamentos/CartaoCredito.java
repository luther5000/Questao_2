package TiposPagamentos;
public class CartaoCredito implements Pagamentos, Parcelado {

//---------------------------------------------------------------------------------

    //declaração dos campos da classe. O valor receve o valor da compra, o numPrestacoes recebe quantas prestações serão
    //utilizadas pelo comprador para pagar, e o juros recebe o valor de juros na compra com base no número de prestações
    private double valor;
    private byte numPrestacoes;
    private static double juros;

//----------------------------------------------------------------------------------

    //construtor completo da classe. Diferencial é que ele chama um método, juros(), que calcula os juros da compra
    public CartaoCredito(double valor, byte prestacoes) {
        this.valor = valor;
        numPrestacoes = prestacoes;
        juros = juros();
    }

    //metodo que calcula os juros da compra
    @Override
    public double juros() {
        if (numPrestacoes == 1)
            return 0;
        else if (numPrestacoes < 6)
            return (valor * 8 / 100);
        else
            return (valor * 12 / 100);
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
            System.out.println("PRODUTO............. XXXXX\nVALOR.............. R$" + df.format(valor) + "\n" +
                    "PAGO................ R$" + df.format(valorPago) + "\nFORMA DE PAGAMENTO.. Cartão de Crédito \n" +
                    "JUROS............... R$" + df.format(juros) + "\nVALOR TOTAL......... R$" +
                    df.format(valor + juros));
        else
            System.out.println("O pagamento completo não foi realizado! Impossível" +
                    " imprimir o recibo!");
    }
}
