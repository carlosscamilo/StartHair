package br.com.StartHair.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import br.com.StartHair.model.Produto;

@Named
@ViewScoped
public class DataGridView implements Serializable {

    private List<Produto> products;
    private Produto selectedProduct;

    @Inject
    private ProdutoService service;

    @PostConstruct
    public void init() {
        products = service.getProducts(48);
    }

    public List<Produto> getProducts() {
        return products;
    }

    public void setService(ProdutoService service) {
        this.service = service;
    }

    public Produto getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Produto selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public void clearMultiViewState() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        PrimeFaces.current().multiViewState().clearAll(viewId, true, this::showMessage);
    }

    private void showMessage(String clientId) {
        FacesContext.getCurrentInstance()
                .addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, clientId + " multiview state has been cleared out", null));
    }
}
