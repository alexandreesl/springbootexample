package br.com.alexandreesl.handson.rest;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.client.RestTemplate;

@Named
@Path("/")
public class PedidoRest {

	private static long id = 1;

	@Inject
	private RestTemplate restTemplate;

	@GET
	@Path("pedido")
	@Produces(MediaType.APPLICATION_JSON)
	public Pedido efetivaPedido(@QueryParam("idCliente") long idCliente,
			@QueryParam("idProduto") long idProduto,
			@QueryParam("quantidade") long quantidade) {

		Pedido pedido = new Pedido();

		Cliente cliente = restTemplate.getForObject(
				"http://localhost:8081/cliente?id={id}", Cliente.class,
				idCliente);

		Produto produto = restTemplate.getForObject(
				"http://localhost:8082/produto?id={id}", Produto.class,
				idProduto);

		pedido.setCliente(cliente);
		pedido.setProduto(produto);
		pedido.setId(id);
		pedido.setQuantidade(quantidade);
		pedido.setDataPedido(new Date());

		id++;

		return pedido;
	}
}
