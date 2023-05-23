package TiposPagamentos;
public class CartaoCredito implements Pagamentos, Parcelado {
    private float valor;
    private byte numPrestacoes;
    private float juros;

//----------------------------------------------------------------------------------

    public CartaoCredito(float valor, byte prestacoes) {
        this.valor = valor;
        numPrestacoes = prestacoes;
        juros = juros();
    }


    @Override
    public float realizarPagamento(float valorPago) {
        if (valorPago == valor)
            return 0;
        else if (valorPago > valor) {
            System.out.println("Troco de " + (valorPago - valor) + "é necessário");
            return (valorPago - valor);
        } else
            return -1;
    }

    @Override
    public void imprimirRecibo(float valorPago) {
        if (realizarPagamento(valorPago) >= 0)
            System.out.println("PRODUTO............. XXXXX\nVALOR.............. R$" + df.format(valor) + "\n" +
                    "PAGO................ R$" + df.format(valorPago) + "FORMA DE PAGAMENTO.. Cartão de Crédito \n" +
                    "JUROS............... R$" + df.format(juros) + "VALOR TOTAL......... R$" +
                    df.format(valor + juros));
        else
            System.out.println("O pagamento completo não foi realizado! Impossível" +
                    "imprimir o recibo!");
    }

    @Override
    public float juros() {
        if (numPrestacoes == 1)
            return 0;
        else if (numPrestacoes < 6)
            return (valor * 8 / 100);
        else
            return (valor * 12 / 100);
    }
}
