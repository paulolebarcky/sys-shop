package sys.shop.controller;

import sys.shop.entity.CliCliente;

/**
 * Trata operações relacionadas aos clientes.
 * 
 * @author paulo
 * @since 2012-09-09
 */
public class CliClienteJpaController extends PrincipalController<CliCliente> {

    public CliClienteJpaController(CliCliente cliCliente) {
        super(cliCliente);
    }
}