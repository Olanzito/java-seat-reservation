package program;

import entities.SeatReservation;

import java.util.Locale;
import java.util.Scanner;

public class SeatReservationArray {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        SeatReservation[] vectS = new SeatReservation[20];

        int code;

        do {
            System.out.println("\nMenu inicial");
            System.out.println("1 - Reservar assento");
            System.out.println("2 - Consultar assentos vagos");
            System.out.println("3 - Consultar assentos ocupados");
            System.out.println("4 - Cancelar reserva de assento");
            System.out.println("5 - Sair!");
            code = sc.nextInt();
            sc.nextLine();


            switch (code){


                case 1:
                    int numberOfPeople;

                    System.out.println("Digite a quantidade de pessoas que voce deseja cadastrar: ");
                    numberOfPeople = sc.nextInt();
                    sc.nextLine();

                    for (int i=0; i<numberOfPeople; i++) {
                        System.out.println("Digite o nome do #" + (i + 1) + " passageiro");
                        String name = sc.nextLine();

                        System.out.println("Digite o CPF do usuário: ");
                        String cpf = sc.nextLine();

                        int seat;
                        while (true) {
                            System.out.println("Digite o assento que voce deseja reservar: ");
                            seat = sc.nextInt();
                            sc.nextLine();

                            if (seat < 1 || seat > 20) {
                                System.out.println("Assento inválido!");

                            } else if (vectS[seat - 1] != null) {
                                System.out.println("Assento já cadastrado");

                            } else {
                                break;
                            }

                        }

                        vectS[seat - 1] = new SeatReservation(name, cpf, seat);
                        System.out.println("Assento cadastrado com sucesso!");

                    }break;

                case 2:

                    System.out.println("Assentos vagos:");
                   for (int i=0; i< vectS.length; i++){
                       if (vectS[i] == null){
                           System.out.print((i+1)+ " ");
                       }
                    }
                   break;

                case 3:
                    for (SeatReservation s: vectS){
                        if(s != null){
                            System.out.println(s);
                        }
                    }

                    break;

                case 4:

                    System.out.println("Digite qual assento voce deseja cancelar a reserva: ");
                    int seatToCancel = sc.nextInt();
                    sc.nextLine();

                    if (seatToCancel<1 || seatToCancel>20){
                        System.out.println("Assento invalido");
                    } else if (vectS[seatToCancel-1] == null){
                        System.out.println("Esse assento não foi registrado");
                    } else {
                        vectS[seatToCancel -1] = null;
                        System.out.println("Assento cancelado com sucesso!");
                    }

                    break;

                case 5:
                    System.out.println("Encerrando programa");
                    break;

                default:
                    System.out.println("Opção inválida!");



            }





        } while (code !=5);

        
        
    }
}
