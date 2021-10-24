package br.com.StartHair.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.StartHair.model.Produto;

@Named
@ApplicationScoped
public class ProdutoService {

    private List<Produto> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Produto(1000, "f230fh0g3", "Bamboo Watch", "Product Description", "bamboo-watch.jpg", 65,
                "Accessories", 24, null, 5));
        products.add(new Produto(1001, "nvklal433", "Black Watch", "Product Description", "black-watch.jpg", 72,
                "Accessories", 61, null, 4));
        products.add(new Produto(1002, "zz21cz3c1", "Blue Band", "Product Description", "blue-band.jpg", 79,
                "Fitness", 2, null, 3));
        products.add(new Produto(1003, "244wgerg2", "Blue T-Shirt", "Product Description", "blue-t-shirt.jpg", 29,
                "Clothing", 25, null, 5));
        products.add(new Produto(1004, "h456wer53", "Bracelet", "Product Description", "bracelet.jpg", 15,
                "Accessories", 73, null, 4));
        products.add(new Produto(1005, "av2231fwg", "Brown Purse", "Product Description", "brown-purse.jpg", 120,
                "Accessories", 0, null, 4));
        products.add(new Produto(1006, "bib36pfvm", "Chakra Bracelet", "Product Description", "chakra-bracelet.jpg", 32,
                "Accessories", 5, null, 3));
        products.add(new Produto(1007, "mbvjkgip5", "Galaxy Earrings", "Product Description", "galaxy-earrings.jpg", 34,
                "Accessories", 23, null, 5));
        products.add(new Produto(1008, "vbb124btr", "Game Controller", "Product Description", "game-controller.jpg", 99,
                "Electronics", 2, null, 4));
        products.add(new Produto(1009, "cm230f032", "Gaming Set", "Product Description", "gaming-set.jpg", 299,
                "Electronics", 63, null, 3));
        products.add(new Produto(1010, "plb34234v", "Gold Phone Case", "Product Description", "gold-phone-case.jpg", 24,
                "Accessories", 0, null, 4));
        products.add(new Produto(1011, "4920nnc2d", "Green Earbuds", "Product Description", "green-earbuds.jpg", 89,
                "Electronics", 23, null, 4));
        products.add(new Produto(1012, "250vm23cc", "Green T-Shirt", "Product Description", "green-t-shirt.jpg", 49,
                "Clothing", 74, null, 5));
        products.add(new Produto(1013, "fldsmn31b", "Grey T-Shirt", "Product Description", "grey-t-shirt.jpg", 48,
                "Clothing", 0, null, 3));
        products.add(new Produto(1014, "waas1x2as", "Headphones", "Product Description", "headphones.jpg", 175,
                "Electronics", 8, null, 5));
        products.add(new Produto(1015, "vb34btbg5", "Light Green T-Shirt", "Product Description", "light-green-t-shirt.jpg", 49,
                "Clothing", 34, null, 4));
        products.add(new Produto(1016, "k8l6j58jl", "Lime Band", "Product Description", "lime-band.jpg", 79,
                "Fitness", 12, null, 3));
        products.add(new Produto(1017, "v435nn85n", "Mini Speakers", "Product Description", "mini-speakers.jpg", 85,
                "Clothing", 42, null, 4));
        products.add(new Produto(1018, "09zx9c0zc", "Painted Phone Case", "Product Description", "painted-phone-case.jpg", 56,
                "Accessories", 41, null, 5));
        products.add(new Produto(1019, "mnb5mb2m5", "Pink Band", "Product Description", "pink-band.jpg", 79,
                "Fitness", 63, null, 4));
        products.add(new Produto(1020, "r23fwf2w3", "Pink Purse", "Product Description", "pink-purse.jpg", 110,
                "Accessories", 0, null, 4));
        products.add(new Produto(1021, "pxpzczo23", "Purple Band", "Product Description", "purple-band.jpg", 79,
                "Fitness", 6, null, 3));
        products.add(new Produto(1022, "2c42cb5cb", "Purple Gemstone Necklace", "Product Description", "purple-gemstone-necklace.jpg", 45,
                "Accessories", 62, null, 4));
        products.add(new Produto(1023, "5k43kkk23", "Purple T-Shirt", "Product Description", "purple-t-shirt.jpg", 49,
                "Clothing", 2, null, 5));
        products.add(new Produto(1024, "lm2tny2k4", "Shoes", "Product Description", "shoes.jpg", 64,
                "Clothing", 0, null, 4));
        products.add(new Produto(1025, "nbm5mv45n", "Sneakers", "Product Description", "sneakers.jpg", 78,
                "Clothing", 52, null, 4));
        products.add(new Produto(1026, "zx23zc42c", "Teal T-Shirt", "Product Description", "teal-t-shirt.jpg", 49,
                "Clothing", 3, null, 3));
        products.add(new Produto(1027, "acvx872gc", "Yellow Earbuds", "Product Description", "yellow-earbuds.jpg", 89,
                "Electronics", 35, null, 3));
        products.add(new Produto(1028, "tx125ck42", "Yoga Mat", "Product Description", "yoga-mat.jpg", 20,
                "Fitness", 15, null, 5));
        products.add(new Produto(1029, "gwuby345v", "Yoga Set", "Product Description", "yoga-set.jpg", 20,
                "Fitness", 25, null, 8));

    }

    public List<Produto> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Produto> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Produto> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(products.size());
                randomList.add(products.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(products.subList(0, size));
        }

    }

    public List<Produto> getClonedProducts(int size) {
        List<Produto> results = new ArrayList<>();
        List<Produto> originals = getProducts(size);
        for (Produto original : originals) {
            results.add(original.clone());
        }
        return results;
    }
}