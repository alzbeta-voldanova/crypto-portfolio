package cz.alzbeta.cryptoportfolio.controller;

import cz.alzbeta.cryptoportfolio.model.Crypto;
import cz.alzbeta.cryptoportfolio.service.CryptoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/cryptos")
    public List<Crypto> getAllCryptos() {
        return cryptoService.getAll();
    }

    @PostMapping("/cryptos")
    public void addCrypto(@RequestBody Crypto crypto) {
        cryptoService.addCrypto(crypto);
    }

    @GetMapping("/cryptos/{id}")
    public Crypto getCryptoById(@PathVariable Integer id) {
        return cryptoService.getById(id);
    }
}
