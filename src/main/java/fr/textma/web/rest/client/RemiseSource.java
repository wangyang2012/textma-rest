package fr.textma.web.rest.client;

import fr.textma.model.RemiseBrut;
import fr.textma.model.WebixTreeNode;
import fr.textma.service.RemiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/textma")
@CrossOrigin(origins = "*")
public class RemiseSource {

    @Autowired
    private RemiseService remiseService;

    @GetMapping(value = "/remise/{clientId}")
    public List<WebixTreeNode> getRemisesOfClient(@PathVariable Integer clientId) {
        return remiseService.getRemisesByCilent(clientId, null);
    }

    @GetMapping(value = "/remise/{clientId}/{nodeId}")
    public RemiseBrut getRemisesOfClientWithNodeId(@PathVariable Integer clientId, @PathVariable String nodeId) {
        return remiseService.getRemiseBrut(clientId, nodeId);
    }
}
