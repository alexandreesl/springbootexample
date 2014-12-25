package br.com.alexandreesl.handson.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class ProdutoRest {

	private static List<Produto> produtos = new ArrayList<Produto>();

	static {

		Produto produto1 = new Produto();
		produto1.setId(1);
		produto1.setSku("abcd1");
		produto1.setDescricao("Produto1");

		Produto produto2 = new Produto();
		produto2.setId(2);
		produto2.setSku("abcd2");
		produto2.setDescricao("Produto2");

		Produto produto3 = new Produto();
		produto3.setId(3);
		produto3.setSku("abcd3");
		produto3.setDescricao("Produto3");

		Produto produto4 = new Produto();
		produto4.setId(4);
		produto4.setSku("abcd4");
		produto4.setDescricao("Produto4");

		produtos.add(produto1);
		produtos.add(produto2);
		produtos.add(produto3);
		produtos.add(produto4);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> getProdutos() {
		return produtos;
	}

	@GET
	@Path("produto")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto getProduto(@QueryParam("id") long id) {

		Produto prod = null;

		for (Produto p : produtos) {

			if (p.getId() == id)
				prod = p;

		}

		return prod;
	}

}
