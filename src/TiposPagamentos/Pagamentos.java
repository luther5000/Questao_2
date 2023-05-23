package TiposPagamentos;
import java.text.DecimalFormat;
public interface Pagamentos {

    DecimalFormat df = new DecimalFormat("########0,00");

    float realizarPagamento (float valor);
    void imprimirRecibo(float valor);
}
