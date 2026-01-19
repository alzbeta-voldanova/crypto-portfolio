package cz.alzbeta.cryptoportfolio.service;

import cz.alzbeta.cryptoportfolio.model.Crypto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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

    public List<Crypto> getAllSorted(String sort) {
        List<Crypto> sorted = new ArrayList<>(cryptos);

        switch (sort) {
            case "name":
                sorted.sort(Comparator.comparing(Crypto::getName, String.CASE_INSENSITIVE_ORDER));
                break;
            case "price":
                sorted.sort(Comparator.comparing(Crypto::getPrice));
                break;
            case "quantity":
                sorted.sort(Comparator.comparing(Crypto::getQuantity));
                break;
            default:
                // když přijde něco jiného než name/price/quantity, vrátíme neřazený seznam
                return cryptos;
        }

        return sorted;
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
