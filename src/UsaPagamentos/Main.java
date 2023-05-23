package UsaPagamentos;
import TiposPagamentos.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("BEM VINDO AO SERVIÇO DE PAGAMENTOS XXXXXXXXXX!\nINSIRA A FORMA DE PAGAMENTO" +
                "QUE DESEJA UTILIZAR: \n1. Dinheiro \n2. Cartão de Crédito \n3. Cartão de Débito " +
                "\n4. Pix \n5. Boleto \n6. Transferência Bancária \n7. Cancelar a operação");
        String verifica = EntradaDados.entraString();
        try { //verificação para quer o usuário não insira um valor que não possui operações disponíveis
            if (Integer.parseInt(verifica) > 7 || Integer.parseInt(verifica) < 1) {
                JOptionPane.showMessageDialog(null, "Essa opção não existe! \nOPERAÇÃO " +
                        "CANCELADA", "ERRO", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (NumberFormatException erro){
            JOptionPane.showMessageDialog(null, "Essa opção não existe! \nOPERAÇÃO " +
                    "CANCELADA", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        switch (verifica){
            case "1": {
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                Dinheiro pagamento1 = new Dinheiro(Double.parseDouble(EntradaDados.entraValor()));
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                double pago1 = Double.parseDouble(EntradaDados.entraValor());
                pagamento1.realizarPagamento(pago1);
                pagamento1.imprimirRecibo(pago1);
                EntradaDados.fechaScanner ();
                break;
            }

            case "2": {
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                double pagar2 = Double.parseDouble(EntradaDados.entraValor());
                System.out.println("Insira o número de prestações que será pago \nATENÇÃO: 10 prestaçoes é o limite. " +
                        "Se um valor maior for inserido, serão consideradas 10 prestações");
                byte prestacoes2 = Byte.parseByte(EntradaDados.entraChave(2));//entra.Chave não aceita '.', então é mais
                //útil para esse caso
                if (prestacoes2 > 10)
                    prestacoes2 = 10;
                CartaoCredito pagamento2 = new CartaoCredito(pagar2, prestacoes2);
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                double pago2 = Double.parseDouble(EntradaDados.entraValor());
                pagamento2.realizarPagamento(pago2);
                pagamento2.imprimirRecibo(pago2);
                EntradaDados.fechaScanner ();
                break;
            }

            case "3": {
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                CartaoDebito pagamento3 = new CartaoDebito(Double.parseDouble(EntradaDados.entraValor()));
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                double pago3 = Double.parseDouble(EntradaDados.entraValor());
                pagamento3.realizarPagamento(pago3);
                pagamento3.imprimirRecibo(pago3);
                EntradaDados.fechaScanner ();
                break;
            }

            case "4": {
                Pix pagamento4;
                String chave1 = null;
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                double pagar4 = Double.parseDouble(EntradaDados.entraValor());
                System.out.println("Qual o tipo de chave PIX? \n1. Número de Celular \n2. CPF \n3. Email");
                verifica = EntradaDados.entraString();
                try {//verificação para quer o usuário não insira um valor que não possui operações disponíveis
                    if (Integer.parseInt(verifica) > 7 || Integer.parseInt(verifica) < 1) {
                        JOptionPane.showMessageDialog(null, "Essa opção não existe! \nOPERAÇÃO " +
                                "CANCELADA", "ERRO", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                } catch (NumberFormatException erro) {
                    JOptionPane.showMessageDialog(null, "Essa opção não existe! \nOPERAÇÃO " +
                            "CANCELADA", "ERRO", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                switch (verifica) {
                    case "1":
                        System.out.println("Insira a chave PIX apenas com números");
                        chave1 = EntradaDados.entraChave(0);
                        break;

                    case "2":
                        System.out.println("Insira a chave PIX apenas com números");
                        chave1 = EntradaDados.entraChave(1);
                        break;

                    case "3":
                        System.out.println("Insira o email da chave PIX");
                        chave1 = EntradaDados.entradaEmail();
                        break;
                }
                pagamento4 = new Pix(pagar4, chave1);
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                double pago4 = Double.parseDouble(EntradaDados.entraValor());
                pagamento4.realizarPagamento(pago4);
                pagamento4.imprimirRecibo(pago4);
                EntradaDados.fechaScanner ();
                break;
            }

            case "5": {
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                double pagar5 = Double.parseDouble(EntradaDados.entraValor());
                System.out.println("Insira o número de prestações que será pago \nATENÇÃO: 10 prestaçoes é o limite. " +
                        "Se um valor maior for inserido, serão consideradas 10 prestações");
                byte prestacoes5 = Byte.parseByte(EntradaDados.entraChave(2));//entra.Chave não aceita '.', então é mais
                //útil para esse caso
                if (prestacoes5 > 10)
                    prestacoes5 = 10;
                System.out.println("Insira o endereço para cobrança");
                String endereco5 = EntradaDados.entraString();
                Boleto pagamento5 = new Boleto(pagar5, prestacoes5, endereco5);
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                double pago5 = Double.parseDouble(EntradaDados.entraValor());
                pagamento5.realizarPagamento(pago5);
                pagamento5.imprimirRecibo(pago5);
                EntradaDados.fechaScanner ();
                break;
            }

            case "6": {
                System.out.println("Insira a conta para a qual se destina a transferência (APENAS NÚMEROS)");
                String destinatario = EntradaDados.entraChave(2);
                System.out.println("Insira a conta que está fazendo a tranferência (APENAS NÚMEROS");
                String remetente = EntradaDados.entraChave(2);
                System.out.println("Insira o valor a ser pago utilizando '.' para separar a casa decimal");
                double pagar6 = Double.parseDouble(EntradaDados.entraValor());
                Transferencia pagamento6 = new Transferencia(pagar6, destinatario, remetente);
                System.out.println("Insira o valor pago utilizando '.' para separar a casa decimal");
                double pago6 = Double.parseDouble(EntradaDados.entraValor());
                pagamento6.realizarPagamento(pago6);
                pagamento6.imprimirRecibo(pago6);
                EntradaDados.fechaScanner ();
                break;
            }

            case "7": {
                EntradaDados.fechaScanner();
                System.exit(0);
            }
        }
    }
}