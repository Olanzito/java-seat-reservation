package program;

import entities.SeatReservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class SeatReservationList {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        List<SeatReservation> listS = new ArrayList<>();

        int option;

        do {

            System.out.println("Menu de interação");
            System.out.println("1 - Cadastrar assento");
            System.out.println("2 - Remover assento");
            System.out.println("3 - Visualizar assentos ocupados");
            System.out.println("4 - Visualizar assentos vagos");
            System.out.println("5 - Sair");

            option =sc.nextInt();
            sc.nextLine();

            switch (option){

                case 1:

                    System.out.println("Quantas pessoas você deseja cadastrar?:");
                    int cadastro = sc.nextInt();
                    sc.nextLine();

                    for (int i=0; i<cadastro; i++){

                        System.out.println("Insira o nome do #"+(i+1)+" passageiro:");
                        String name = sc.nextLine();

                        System.out.println("Insira o CPF do passageiro");
                        String cpf = sc.nextLine();

                        int seat;
                        boolean repetir = false;
                        
                        do {
                            System.out.println("Insira o assento escolhido (1-20):");
                                seat = sc.nextInt();
                                sc.nextLine();
                                
                                if (seat<1 || seat>20){
                                    System.out.println("Assento inválido");
                                    repetir = true;
                                } else if (isSeatOccupied(seat, listS)) {
                                    System.out.println("Assento já ocupado, escolha outro");
                                    repetir = true;
                                    
                                }
                                else {
                                    repetir = false;
                                }
                                
                        }while (repetir);

                        listS.add(new SeatReservation(name, cpf, seat));
                        System.out.println("Assento reservado com sucesso!");


                    }
                break;

                case 2:
                    System.out.println("Digite o numero de assentos que deseja remover:");
                    int seatRemove = sc.nextInt();
                    sc.nextLine();

                    listS.removeIf(s -> s.getSeat() ==seatRemove);
                    System.out.println("Remoção concluída com sucesso!");
                    break;


                case 3:
                    System.out.println("Assentos ocupados");

                    for (SeatReservation s : listS){
                        System.out.println(s);
                    }
                break;

                case 4:
                    System.out.println("Assentos vagos:");
                    for (int i = 1; i<= 20; i++){
                        int finalI = i;
                        boolean ocupado = listS.stream()
                                .anyMatch(s -> s.getSeat() == finalI);
                        if (!ocupado){
                            System.out.println("Assento " + i + " está vago.");
                        }

                    }
                    break;

                case 5:
                    System.out.println("Programa encerrado");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        } while (option !=5);







        sc.close();

    }

    public static boolean isSeatOccupied(int seat, List<SeatReservation> listS) {
        for (SeatReservation s : listS) {
            if (s.getSeat() == seat) {
                return true;
            }
        }
        return false;
    }
}
