package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String [] candidatos =  {"JOÃO", "JOSÉ", "FERNANDO", "MARIA", "RODRIGO" };
        for(String candidato: candidatos) {
            ligarUsuario(candidato);
        }
    }

    static void ligarUsuario(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu=false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Ligação atendida!");
        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas+ "° tentativa.");
        else
            System.out.println("Candidato " + candidato + " não atendeu nas 3 tentativas");
    }

    // tentar atender
    static boolean atender() {
        return new Random().nextInt(3)==1;

    }

    static void imprimirSelecionados() {
        String [] candidatos =  {"JOÃO", "JOSÉ", "FERNANDO", "MARIA", "RODRIGO" };
        System.out.println("Imprimindo a lista dos candidatos:");

        for (int i=0; i < candidatos.length; i++){
            System.out.println("O candidato N° " + (i+1) + " é o " +  candidatos[i] );
        }
        
        // forma abreviada:
        System.out.println("forma mais simples de exibir com foreach");
        for (String candidato: candidatos) {
            System.out.println("o candidado selecionado foi: " + candidato);
        }
    }

    static void selecionarCandidato() {
        String []  candidatos = {"JOÃO", "JOSÉ", "FERNANDO", "MARIA", "RODRIGO", "JUNIOR", "CIDOCA", "MONICA" ,"JULIA", "IVANEY"};

        int candidatoSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase=2000.0;
        while(candidatoSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou o valor de: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!");
            }
            candidatoAtual++;
        }

    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }


    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para candidato");
        }else if (salarioBase==salarioPretendido)
            System.out.println("Oferecer contra proposta");
        else{
            System.out.println("aguardando o resultado dos demais candidatos");
        }
    }
}
