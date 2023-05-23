package UsaPagamentos;

import javax.swing.*;
import java.util.Scanner;

class EntradaDados {
    private static Scanner tc = new Scanner(System.in);
    private static String retorna;

//----------------------------------------------------------------------------------------------------------------------

    //método que realiza a entrada de uma string padrão
    public static String entraString() {
        return tc.nextLine();
    }

    //método para o fechamento do Scanner após o fim do programa
    public static void fechaScanner (){
        tc.close();
    }

    //------------------------------------------------------------------------------------------------------------------

    //método que realiza a entrada dos valores de compra/pagamento
    public static String entraValor(){

        //criamos uma repetição cuja condição de saída é inserir um valor numérico válido.
        do {
            retorna = tc.nextLine();
            if (verificaNumero(retorna)) //chamada da função tipo boolean que verifica se o numero inserido eh valido
                return retorna;
        }while (true);
    }



    /*para verificar se o numero inserido é realmente um número utilizamos a tabela ASCCI e a passagem de char para int
    que nos fornece o número da tabela ASCCI que se refere ao caracter. como os número de 0 a 9 são representados
    pelos números de 48 a 57 e o ponto é representado pelo número 46 na tabela ASCCI, qualquer outro valor que seja
    inserido fará com que a função retorne falso*/
    public static boolean verificaNumero (String s){

        if (s.indexOf('.') != s.indexOf('.'))//o valor so pode possuir um ponto ja que há apenas uma separação
            // utilizando ponto nos números
            return false;
        for (int i=0; i<s.length(); i++)
            if ((s.charAt(i) < 48 && s.charAt(i) != 46) || s.charAt(i) > 57) {
                JOptionPane.showMessageDialog(null, "Insira apenas " +
                        "números e, se necessário, um ponto por favor", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        return true;
    }

//----------------------------------------------------------------------------------------------------------------------

    //método que realiza a entrada das chaves PIX numéricas, CPF e número de celular. Esse método recebe um int da main
    //para que ele seja passado para o método que verifica, para que ele possa realizar as diferentes verificações
    //para ambos os casos.
    public static String entraChave(int a){

        //criamos uma repetição cuja condição de saída é inserir um valor numérico válido.
        do {
            retorna = tc.nextLine();
            if (verificaChave(retorna, a)) //chamada da função tipo boolean que verifica se o numero inserido eh valido
                return retorna;
        }while (true);
    }

    //método que realiza a verificação das chaves
    public static boolean verificaChave (String s, int a){
        //primeiro realizamos a verificação do tamanho dos números, lembrando que a eh a variável que determina o que
        //está sendo inserido pelo usuário
        if (a==1)
            if (s.length() != 8) {
                JOptionPane.showMessageDialog(null, "Insira um CPF " +
                        "válida por favor", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        if (a==0)
            if (s.length() != 11) {
                JOptionPane.showMessageDialog(null, "Insira um número de telefone " +
                                "válido por favor (11 dígitos com DDD)", "ERRO",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }

        //agora verificamos se algo além de números foram inseridos usando a tabela ASCCI
        for (int i=0; i<s.length(); i++)
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                JOptionPane.showMessageDialog (null, "Insira apenas " +
                        "números por favor", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        return true;
    }

    //--------------------------------------------------------------------------------------------------------------------

    //o método entraEmail realiza a entrada do email
    public static String entradaEmail () {
        do {
            retorna = tc.nextLine();
            if (verificaEmail(retorna))//chamada da função tipo boolean que retorna se o email inserido foi válido
                return retorna;
            else
                JOptionPane.showMessageDialog (null, "Insira um email válido",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
        }while (true);
    }



    //método que realiza a verificação do email. Como base foram usadas as regras de criação de email do gmail, fora a
    //parte de precisar conter gmail após o @
    public static boolean verificaEmail (String s){

        //a localização do @ é importante para verificar se o que vem após ele é a formatação do tipo de email (gmail,
        //hotmail,, etc)
        int indice = s.indexOf('@');

        if (indice != s.lastIndexOf('@'))//verificação para saber se há mais de um @
            return false;
        if (s.indexOf(' ') != -1)//verificação para saber se há algum espaço
            return false;
        else if (indice < 4)//o minimo de caracteres antes do @ é 3, logo ele precisa estar pelo menos no indice 3
            return false;
        else if (s.lastIndexOf('.') < indice )//verificação para saber se há um ponto após o @
            return false;
        else if (s.lastIndexOf("com") < indice)//verificação para saber se há o "com" após o @
            return false;
        else if (s.indexOf('.')+1 == '.' || s.lastIndexOf('.')+1 == '.')//verifica se há dois pontos seguidos no email
            return false;
        for (int i=0; i<s.length(); i++) {
            int verifica = s.charAt(i);
            if (verifica < 46 || verifica == 47 || verifica > 122 || (verifica > 57 && verifica < 64)
                    || (verifica > 90 && verifica < 95) || verifica == 96)
                //verificação de todos os caracteres especiais da tabela ASCCI
                return false;
        }
        return true;
    }

    //---------------------------------------------------------------------------------------------------------------------

}
