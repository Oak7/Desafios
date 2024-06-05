import java.util.Scanner;

abstract class Cofre {
    protected String tipo;
    protected String metodoAbertura;

    public Cofre(String tipo, String metodoAbertura) {
        this.tipo = tipo;
        this.metodoAbertura = metodoAbertura;
    }

    public void imprimirInformacoes() {
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Metodo de abertura: " + this.metodoAbertura);
    }
}

class CofreDigital extends Cofre {

    private int senha;

    public CofreDigital(int senha) {
        super("Cofre Digital", "Senha");
        this.senha = senha;
    }

    public boolean validarSenha(int confirmacaoSenha) {
        return confirmacaoSenha == this.senha;
    }
}

class CofreFisico extends Cofre {

    public CofreFisico() {
        super("Cofre Fisico", "Chave");
    }

}

public class Desafio {
    public static void main(String[] args) {
        // Lê o tipo de cofre (primeira linha da entrada)
        Scanner scanner = new Scanner(System.in);
        String tipoCofre = scanner.nextLine();

        // Verifica o tipo de cofre e cria o cofre correspondente
        if (tipoCofre.equalsIgnoreCase("digital")) {
            // Se for um cofre digital, solicita a senha
            int senha = scanner.nextInt();
            int confirmacaoSenha = scanner.nextInt();

            // Cria o cofre digital com a senha informada
            CofreDigital cofreDigital = new CofreDigital(senha);

            // Verifica se a senha confirmação é válida
            if (cofreDigital.validarSenha(confirmacaoSenha)) {
                // Se a senha for válida, exibe as informações do cofre
                cofreDigital.imprimirInformacoes();
                System.out.println("Cofre aberto!");
            } else {
                // Se a senha for inválida, exibe uma mensagem de erro
                cofreDigital.imprimirInformacoes();
                System.out.println("Senha incorreta!");
            }
        } else if (tipoCofre.equalsIgnoreCase("fisico")) {
            // Se for um cofre físico, cria o cofre físico diretamente
            CofreFisico cofreFisico = new CofreFisico();
            // Exibe as informações do cofre físico
            cofreFisico.imprimirInformacoes();
        }

        scanner.close();
    }
}
