package TiposPagamentos;
import java.text.DecimalFormat;
public interface Pagamentos {

    //----------------------------------------------------------------------

    DecimalFormat df = new DecimalFormat("#################0.00");

    //----------------------------------------------------------------------

    //método responsável pela realização dos pagamentos
    double realizarPagamento (double valor);

    //método responsável pela impressão do recibo do pagamento
    void imprimirRecibo(double valor);
}
