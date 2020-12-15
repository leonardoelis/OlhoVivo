package consumidorapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecutorChamadas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        ConsumidorAPI consumidor = ConsumidorAPI.getInstance();
        String saida;
        String path, numLinha;
        System.out.println("Digite o número de uma linha de ônibus");
        numLinha = entrada.nextLine();
        path = "Linha/Buscar?termosBusca=" + numLinha;
        consumidor.doLogin();
        saida = consumidor.doRequest(path);
        //System.out.println("Saida: " + saida);

        Gson gson = new Gson();
        // A classe TypeToken permite que se consiga pegar o tipo genérico do ArrayList (nesse caso, é Linha), para poder passar para o método fromJson do Gson
        Type collectionType = new TypeToken<ArrayList<Linha>>() {}.getType();
        // O método fromJson(), pega as propriedades do JSON de saída e atribui automaticamente para todos os atributos da classe Linha (desde que eles tenham o mesmo nome)
        // Nesse caso, como ele pode retornar mais de uma linha de ônibus, foi usado um ArrayList para armazenar todas as Linhas
        ArrayList<Linha> linhas = gson.fromJson(saida, collectionType);
        for (Linha linha : linhas) {
            System.out.println(linha.toString());
        }

        int cod;
        for (Linha linha : linhas) {
            cod = linha.getCl();
            System.out.println("Código da Linha: " + cod);
            System.out.println(linha.info());
            path = "Posicao/Linha?codigoLinha=" + cod;
            saida = consumidor.doRequest(path);
            //System.out.println(saida);
            int inicio = saida.indexOf("[");
            int fim = saida.lastIndexOf("]");
            String s = saida.substring(inicio, fim+1);
            // A classe TypeToken permite que se consiga pegar o tipo genérico do ArrayList (nesse caso, é Linha), para poder passar para o método fromJson do Gson
            collectionType = new TypeToken<ArrayList<Veiculo>>() {}.getType();
            // O método fromJson(), pega as propriedades do JSON de saída e atribui automaticamente para todos os atributos da classe Linha (desde que eles tenham o mesmo nome)
            // Nesse caso, como ele pode retornar mais de um veículo, foi usado um ArrayList para armazenar todos os Veículos
            ArrayList<Veiculo> veiculos = gson.fromJson(s, collectionType);
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo.toString());
            }
        }
    }

}
