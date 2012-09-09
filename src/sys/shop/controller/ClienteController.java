package sys.shop.controller;

import sys.shop.entity.Cliente;

/**
 * Trata operações relacionadas aos clientes.
 * 
 * @author paulo
 * @since 2012-09-09
 */
public class ClienteController extends PrincipalController<Cliente> {

    public ClienteController(Cliente cliCliente) {
        super(cliCliente);
    }
}