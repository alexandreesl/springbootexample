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
public class ClienteRest {

	private static List<Cliente> clientes = new ArrayList<Cliente>();

	static {

		Cliente cliente1 = new Cliente();
		cliente1.setId(1);
		cliente1.setNome("Cliente 1");
		cliente1.setEmail("cliente1@gmail.com");

		Cliente cliente2 = new Cliente();
		cliente2.setId(2);
		cliente2.setNome("Cliente 2");
		cliente2.setEmail("cliente2@gmail.com");

		Cliente cliente3 = new Cliente();
		cliente3.setId(3);
		cliente3.setNome("Cliente 3");
		cliente3.setEmail("cliente3@gmail.com");

		Cliente cliente4 = new Cliente();
		cliente4.setId(4);
		cliente4.setNome("Cliente 4");
		cliente4.setEmail("cliente4@gmail.com");

		Cliente cliente5 = new Cliente();
		cliente5.setId(5);
		cliente5.setNome("Cliente 5");
		cliente5.setEmail("cliente5@gmail.com");

		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente3);
		clientes.add(cliente4);
		clientes.add(cliente5);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> getClientes() {
		return clientes;
	}

	@GET
	@Path("cliente")
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente getCliente(@QueryParam("id") long id) {

		Cliente cli = null;

		for (Cliente c : clientes) {

			if (c.getId() == id)
				cli = c;

		}

		return cli;
	}

}
