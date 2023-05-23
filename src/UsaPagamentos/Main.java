package UsaPagamentos;
import TiposPagamentos.*;
public class Main {
    public static void main(String[] args) {
        /*pix, dinheiro, cartão de credito, cartão de débito, boleto, transferencia bancária*/
        System.out.println("BEM VINDO AO SERVIÇO DE PAGAMENTOS XXXXXXXXXX!\nINSIRA A FORMA DE PAGAMENTO" +
                "QUE DESEJA UTILIZAR: \n1. Dinheiro \n2. Cartão de Crédito \n3. Cartão de Débito " +
                "\n4. Pix \n5. Boleto \n6. Transferência Bancária \n7. Cancelar a operação");
        String verifica = EntradaDados.entraString();
        switch (verifica){
            case "1":
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                Dinheiro pagamento1 = new Dinheiro(Float.parseFloat(EntradaDados.entraValor()));
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                float pago1 = Float.parseFloat(EntradaDados.entraValor());
                pagamento1.realizarPagamento(pago1);
                pagamento1.imprimirRecibo(pago1);
                break;

            case "2":
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                float pagar2 = Float.parseFloat(EntradaDados.entraValor());
                System.out.println("Insira o número de prestações que será pago");
                byte prestacoes2 = Byte.parseByte(EntradaDados.entraChave());//entra.Chave não aceita '.', então é mais
                //útil para esse caso
                CartaoCredito pagamento2 = new CartaoCredito(pagar2, prestacoes2);
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                float pago2 = Float.parseFloat(EntradaDados.entraValor());
                pagamento2.realizarPagamento(pago2);
                pagamento2.imprimirRecibo(pago2);
                break;

            case "3":
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                CartaoDebito pagamento3 = new CartaoDebito(Float.parseFloat(EntradaDados.entraValor()));
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                float pago3 = Float.parseFloat(EntradaDados.entraValor());
                pagamento3.realizarPagamento(pago3);
                pagamento3.imprimirRecibo(pago3);
                break;

            case "4":
                Pix pagamento4;
                String chave1 = null; String chave3 = null;
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                float pagar4 = Float.parseFloat(EntradaDados.entraValor());
                System.out.println("Qual o tipo de chave PIX? \n1. Número de Celular \n2. CPF \n3. Email");
                verifica = EntradaDados.entraString();
                switch (verifica){
                    case "1", "2":
                        System.out.println("Insira a chave PIX apenas com números");
                        chave1 = EntradaDados.entraChave();
                        break;

                    case "3":
                        System.out.println("Insira o email da chave PIX");
                        chave3 = EntradaDados.entradaEmail();
                        break;
                }
                if (verifica.equals("1") || verifica.equals("2"))
                    pagamento4 = new Pix(pagar4, chave1);
                else
                    pagamento4 = new Pix (pagar4, chave3);
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                float pago4 = Float.parseFloat(EntradaDados.entraValor());
                pagamento4.realizarPagamento(pago4);
                pagamento4.imprimirRecibo(pago4);
                break;

            case "5":
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                float pagar5 = Float.parseFloat(EntradaDados.entraValor());
                System.out.println("Insira o número de prestações que será pago");
                byte prestacoes5 = Byte.parseByte(EntradaDados.entraChave());//entra.Chave não aceita '.', então é mais
                //útil para esse caso
                System.out.println("Insira o endereço para cobrança");
                String endereco5 = EntradaDados.entraString();
                Boleto pagamento5 = new Boleto(pagar5, prestacoes5, endereco5);
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                float pago5 = Float.parseFloat(EntradaDados.entraValor());
                pagamento5.realizarPagamento(pago5);
                pagamento5.imprimirRecibo(pago5);
                break;

            case "6":
                System.out.println("Insira a conta para a qual se destina a transferência (APENAS NÚMEROS)");
                String destinatario = EntradaDados.entraChave();
                System.out.println("Insira a conta que está fazendo a tranferência (APENAS NÚMEROS");
                String remetente = EntradaDados.entraChave();
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                float pagar6 = Float.parseFloat(EntradaDados.entraValor());
                Transferencia pagamento6 = new Transferencia(pagar6, destinatario, remetente);
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                float pago6 = Float.parseFloat(EntradaDados.entraValor());
                pagamento6.realizarPagamento(pago6);
                pagamento6.imprimirRecibo(pago6);
                break;

            case "7":
                EntradaDados.fechaScanner();
                System.exit (0);
        }
    }
}