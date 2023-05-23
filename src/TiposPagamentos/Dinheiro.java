package TiposPagamentos;

public class Dinheiro implements Pagamentos{

    private float valor;

    //--------------------------------------------------------

    public Dinheiro (float valor){
        this.valor = valor;
    }
    @Override
    public float realizarPagamento(float valorPago) {
        if (valorPago == valor)
            return 0;
        else if (valorPago > valor) {
            System.out.println("Troco de " +(valorPago-valor)+ "é necessário");
            return (valorPago - valor);
        } else
            return -1;
    }

    @Override
    public void imprimirRecibo(float valorPago) {
        if (realizarPagamento(valorPago) >= 0)
            System.out.println("PRODUTO............. XXXXX\nVALOR.............. R$" + df.format(valor) + "\n" +
                    "PAGO................ R$" + df.format(valorPago) + "FORMA DE PAGAMENTO.. Dinheiro \n" +
                    "TROCO............... R$" + df.format(valor-valorPago));
        else
            System.out.println("O pagamento completo não foi realizado! Impossível" +
                    " imprimir o recibo!");
    }
}
