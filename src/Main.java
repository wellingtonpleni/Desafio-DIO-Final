import com.dio.model.Corretor;
import com.dio.model.Pessoa;
import com.dio.model.Proprietario;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao, cont=0, ident, identPro, checar = 0;
        double taxa, valAluguel;
        String nome, telefone;

        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        //Definição da matriz de objetos Corretor / Proprietário
        Pessoa[] objCorPro = new Pessoa[20];

        do {
            System.out.println("\n\n1 - Cadastrar corretor");
            System.out.println("2 - Cadastrar Proprietário");
            System.out.println("3 - Listar corretores");
            System.out.println("4 - Sair");
            System.out.print("\n\n\t Digite a opcao: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    if (cont < objCorPro.length) {
                        System.out.print("Digite a identificação: ");
                        ident = entrada.nextInt();
                        System.out.print("Digite o nome: ");
                        nome = entrada.next();
                        System.out.print("Digite a taxa de comissão: ");
                        taxa = entrada.nextDouble();

                        //Instanciação de objetos da classe Corretor
                        objCorPro[cont] = new Corretor(ident, nome, taxa);
                    }else {
                        System.out.println("\n\t\t-----------------------------------------");
                        System.out.println("\t\t-------------Limite da Matriz------------");
                        System.out.println("\t\t-----------------------------------------");
                    }
                    cont ++;
                    break;
                case 2:
                    if (cont < objCorPro.length) {
                        System.out.print("Digite a identificação do corretor: ");
                        ident = entrada.nextInt();

                        for (int i = 0; i < objCorPro.length; i++) {
                            if (objCorPro[i] instanceof Corretor && objCorPro[i].getIdentificacao() == ident) {
                                checar = 1;
                            }
                        }

                        if(checar == 1) {
                            System.out.print("Digite a identificação do proprietário: ");
                            identPro = entrada.nextInt();
                            System.out.print("Digite o nome do proprietário: ");
                            nome = entrada.next();
                            System.out.print("Digite o telefone do proprietário: ");
                            telefone = entrada.next();
                            System.out.print("Digite o valor do aluguel: ");
                            valAluguel = entrada.nextDouble();

                            objCorPro[cont] = new Proprietario(identPro, nome, telefone);

                            for(int i = 0; i < objCorPro.length; i++) {
                                if(objCorPro[i] instanceof Corretor && objCorPro[i].getIdentificacao() == ident) {
                                    ((Corretor)objCorPro[i]).calcTotalComissao(valAluguel);
                                }
                            }
                        }else{
                            System.out.print("Corretor não encontado!");
                        }
                    }else {
                        System.out.println("\n\t\t-----------------------------------------");
                        System.out.println("\t\t-------------Limite da Matriz------------");
                        System.out.println("\t\t-----------------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("----------Corretores----------");
                    for(int i = 0; i < objCorPro.length; i++) {
                        if(objCorPro[i] instanceof Corretor) {
                            System.out.println("Identificação: " + objCorPro[i].getIdentificacao());
                            System.out.println("Nome: " + objCorPro[i].getNome());
                            System.out.println("Taxa comissão: " + ((Corretor) objCorPro[i]).getTaxaComissao()) ;
                            System.out.println("Total comissão: " + df.format (((Corretor) objCorPro[i]).getTotalComissao()));
                        }
                    }
                    break;

            }
        } while (opcao < 4);
    }

}
