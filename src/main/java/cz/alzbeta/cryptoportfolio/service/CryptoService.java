package cz.alzbeta.cryptoportfolio.service;

import cz.alzbeta.cryptoportfolio.model.Crypto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoService {

    private final List<Crypto> cryptos = new ArrayList<>();

    public void addCrypto(Crypto crypto) {
        cryptos.add(crypto);
    }

    public List<Crypto> getAll() {
        return cryptos;
    }

    public Crypto getById(Integer id) {
        for (Crypto crypto : cryptos) {
            if (crypto.getId().equals(id)) {
                return crypto;
            }
        }
        return null;
    }


}
