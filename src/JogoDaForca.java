import java.util.*;

public class JogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palavras = {"java", "programacao", "computador", "tecnologia", "desenvolvedor"};
        String palavra = palavras[new Random().nextInt(palavras.length)];
        char[] adivinhar = new char[palavra.length()];
        Arrays.fill(adivinhar, '_');
        int tentativas = 6;
        List<Character> palpites = new ArrayList<>();

        while (tentativas > 0 && !String.valueOf(adivinhar).equals(palavra)) {
            System.out.println("Palavra: " + String.valueOf(adivinhar));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().charAt(0);

            if (palpites.contains(letra)) {
                System.out.println("Você já tentou essa letra. Tente novamente.");
                continue;
            }

            palpites.add(letra);
            boolean acertou = false;
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == letra) {
                    adivinhar[i] = letra;
                    acertou = true;
                }
            }

            if (!acertou) {
                tentativas--;
                System.out.println("Letra incorreta.");
            }
        }

        if (String.valueOf(adivinhar).equals(palavra)) {
            System.out.println("Parabéns! Você adivinhou a palavra: " + palavra);
        } else {
            System.out.println("Que pena! A palavra era: " + palavra);
        }
    }
}
