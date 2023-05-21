package com.example.proyectospring.Controllers;

import com.example.proyectospring.Model.Cliente;
import com.example.proyectospring.Model.Plato;
import com.example.proyectospring.Services.InterfacesCliente;
import com.example.proyectospring.Services.InterfacesPlato;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

@Controller
public class ControladorPrincipal {

    private final InterfacesCliente clienteService;
    private final InterfacesPlato platoService;

    public ControladorPrincipal(InterfacesCliente clienteService, InterfacesPlato platoService) {
        this.clienteService = clienteService;
        this.platoService = platoService;
    }

    @GetMapping("/Home")
    public String home(Model model) {
        List<Cliente> clientes = clienteService.findAll();
        List<Plato> platos = platoService.findAll();
        model.addAttribute("clientes", clientes);
        model.addAttribute("platos", platos);
        return "home";
    }

    @PostMapping("/agregar-cliente")
    public String agregarCliente(@RequestParam("nombre") String nombre, @RequestParam("telefono") String telefono) {
        clienteService.insertCliente(nombre, telefono);
        return "redirect:/Home";
    }

    @PostMapping("/agregar-plato")
    public String agregarPlato(@RequestParam("nombre") String nombre, @RequestParam("precio") double precio) {
        platoService.insertPlato(nombre, precio);
        return "redirect:/Home";
    }


    @PostMapping("/asociar-platos")
    public String asociarPlatos(@RequestParam("cliente") long clienteId, @RequestParam("platos") List<Long> platosIds) {
        // Obtener el cliente por su ID
        Optional<Cliente> clienteOptional = clienteService.findClienteById(clienteId);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            // Obtener los platos seleccionados por sus IDs
            List<Plato> platosSeleccionados = platoService.findAllById(platosIds);

            // Asociar los platos al cliente
            cliente.setPlatos(new LinkedHashSet<>(platosSeleccionados));
            clienteService.save(cliente);
        }

        return "redirect:/Home";
    }

    @PostMapping("/borrar-cliente")
    public String borrarCliente(@RequestParam("clienteBorrar") int id) {
        clienteService.deleteCliente(id);
        return "redirect:/Home";
    }

    @PostMapping("/borrar-plato")
    public String borrarPlato(@RequestParam("platoBorrar") long id) {
        platoService.deletePlato(id);
        return "redirect:/Home";
    }

    @PostMapping("/actualizar-cliente")
    public String actualizarCliente(@RequestParam("clienteActualizar") int id,
                                    @RequestParam("nombreClienteActualizar") String nombre,
                                    @RequestParam("telefonoClienteActualizar") String telefono) {
        clienteService.editCliente(id, nombre, telefono);
        return "redirect:/Home";
    }

    @PostMapping("/actualizar-plato")
    public String actualizarPlato(@RequestParam("platoActualizar") long id,
                                  @RequestParam("nombrePlatoActualizar") String nombre,
                                  @RequestParam("precioPlatoActualizar") double precio) {
        platoService.editPlato(id, nombre, precio);
        return "redirect:/Home";
    }

}
