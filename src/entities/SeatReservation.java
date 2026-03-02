package entities;

public class SeatReservation {

    private String cpf;
    private String name;
    private Integer seat;

    public SeatReservation(){

    }

    public SeatReservation(String cpf, String name, Integer seat) {
        this.cpf = cpf;
        this.name = name;
        this.seat = seat;
    }

    public String getCpf() {
        return cpf;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }


    @Override
    public String toString(){
        return name
                +", "
                +cpf
                +", "
                +seat;
    }



}
