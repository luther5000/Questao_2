package UsaPagamentos;

import javax.swing.*;
import java.util.Scanner;

class EntradaDados {
    private static Scanner tc = new Scanner(System.in);

//----------------------------------------------------------------------------------------------------------------------

    //classe que realiza a entrada de uma string padrão
    public static String entraString() {
        return tc.nextLine();
    }

    public static void fechaScanner (){
        tc.close();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String entraValor(){

        String retorna;

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

    public static String entraChave(){

        String retorna;

        //criamos uma repetição cuja condição de saída é inserir um valor numérico válido.
        do {
            retorna = tc.nextLine();
            if (verificaChave(retorna)) //chamada da função tipo boolean que verifica se o numero inserido eh valido
                return retorna;
        }while (true);
    }

    public static boolean verificaChave (String s){

        for (int i=0; i<s.length(); i++)
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                JOptionPane.showMessageDialog(null, "Insira apenas " +
                        "números e, se necessário, um ponto por favor", "ERRO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        return true;
    }

    //--------------------------------------------------------------------------------------------------------------------

    //semelhantemente a função entradaNumero, a função entradaEmail cria uma repetição que só irá acabar quando o
    //usuário inserir um email válido
    public static String entradaEmail () {

        //declaração da string que armazena a informação inserida pelo usuário
        String retorna;

        do {
            retorna = tc.nextLine();
            if (verificaEmail(retorna))//chamada da função tipo boolean que retorna se o email inserido foi válido
                return retorna;
            else
                JOptionPane.showMessageDialog (null, "Insira um email válido",
                        "ERRO", JOptionPane.ERROR_MESSAGE);
        }while (true);
    }



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
