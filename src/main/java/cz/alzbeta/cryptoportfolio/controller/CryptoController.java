package cz.alzbeta.cryptoportfolio.controller;

import cz.alzbeta.cryptoportfolio.model.Crypto;
import cz.alzbeta.cryptoportfolio.service.CryptoService;
import org.springframework.http.ResponseEntity;
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
    public List<Crypto> getAllCryptos(@RequestParam(required = false) String sort) {
        if (sort == null) {
            return cryptoService.getAll();
        }
        return cryptoService.getAllSorted(sort);
    }

    @PostMapping("/cryptos")
    public ResponseEntity<Void> addCrypto(@RequestBody Crypto crypto) {
        boolean added = cryptoService.addCrypto(crypto);
        if (added) {
            return ResponseEntity.status(201).build(); // Created
        }
        return ResponseEntity.status(409).build(); // Conflict – duplicitní ID
    }

    @GetMapping("/cryptos/{id}")
    public Crypto getCryptoById(@PathVariable Integer id) {
        return cryptoService.getById(id);
    }

    @PutMapping("/cryptos/{id}")
    public ResponseEntity<Void> updateCrypto(@PathVariable Integer id, @RequestBody Crypto crypto) {
        boolean updated = cryptoService.updateCrypto(id, crypto);
        if (updated) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.notFound().build(); // 404
    }

    @GetMapping("/portfolio-value")
    public double getPortfolioValue() {
        return cryptoService.getPortfolioValue();
    }
}
