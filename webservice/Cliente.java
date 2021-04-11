package webservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import javax.ws.rs.core.MediaType;

public class Cliente {
     
    public static void main(String[] args) {
        ClientConfig config = new DefaultClientConfig();
        Client cliente = Client.create(config);
        WebResource servico = cliente.resource("http://localhost:9000/calculadora");

        int a = 5;
        int b = 6;
        WebResource servicoSomarInt = servico.path("somarInt").path(a + "/" + b);

        ClientResponse respostaSomarInt = servicoSomarInt.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        String respostaJsonSomarInt = respostaSomarInt.getEntity(String.class);
        System.out.println("Resposta da adicao: " + respostaJsonSomarInt);

    }
}
