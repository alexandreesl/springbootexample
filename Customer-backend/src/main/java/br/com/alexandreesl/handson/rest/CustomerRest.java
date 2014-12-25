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
public class CustomerRest {

	private static List<Customer> clients = new ArrayList<Customer>();

	static {

		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setName("Cliente 1");
		customer1.setEmail("customer1@gmail.com");

		Customer customer2 = new Customer();
		customer2.setId(2);
		customer2.setName("Cliente 2");
		customer2.setEmail("customer2@gmail.com");

		Customer customer3 = new Customer();
		customer3.setId(3);
		customer3.setName("Cliente 3");
		customer3.setEmail("customer3@gmail.com");

		Customer customer4 = new Customer();
		customer4.setId(4);
		customer4.setName("Cliente 4");
		customer4.setEmail("customer4@gmail.com");

		Customer customer5 = new Customer();
		customer5.setId(5);
		customer5.setName("Cliente 5");
		customer5.setEmail("customer5@gmail.com");

		clients.add(customer1);
		clients.add(customer2);
		clients.add(customer3);
		clients.add(customer4);
		clients.add(customer5);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getClientes() {
		return clients;
	}

	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCliente(@QueryParam("id") long id) {

		Customer cli = null;

		for (Customer c : clients) {

			if (c.getId() == id)
				cli = c;

		}

		return cli;
	}

}
