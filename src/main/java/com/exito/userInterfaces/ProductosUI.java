package com.exito.userInterfaces;

import com.exito.utils.DatosExcel;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.io.IOException;

public class ProductosUI {

    public static final Target BTN_CLOSE_ADVERTING = Target.the("BTN_CLOSE_ADVERTING")
            .locatedBy("//div[@id='wps-overlay-close-button']");
    public static final Target BTN_MENU = Target.the("MENU")
            .locatedBy("//*[@id='Trazado_7822']");
    public static final Target BTN_CATEGORIA_DORMITORIO = Target.the("CATEGORIA DORMITORIO")
            .locatedBy("//p[@id='undefined-nivel2-Dormitorio']");
    public static final Target BTN_SUBCATEGORIA_CABECEROS = Target.the("SUBCATEGORIA CABECEROS")
            .locatedBy("//p[@id='Categorías-nivel3-Cabeceros']");
    public static final Target TXT_CABECEROS = Target.the("TXT_CABECEROS")
            .locatedBy("//a[contains(text(), 'Cabeceros')]");
    public static final Target TXT_NOMBRE_PRODUCTO = Target.the("TXT_NOMBRE_PRODUCTO")
            .locatedBy("//h3[@class='vtex-store-components-3-x-productNameContainer mv0 t-heading-4']//span");

    public static final Target TXT_PRECIO_PRODUCTO = Target.the("TXT_PRECIO_PRODUCTO")
            .locatedBy("//div[@class='exito-vtex-components-4-x-PricePDP']//span");
    public static final Target BTN_COMPRA_RAPIDA = Target.the("BTN_COMPRA_RAPIDA")
            .locatedBy("//div[@class='button-modal flex items-center vtex-button bw1 ba fw5 v-mid relative pa0 lh-solid br2 min-h-small t-action bg-action-primary b--action-primary c-on-action-primary hover-bg-action-primary hover-b--action-primary hover-c-on-action-primary pointer w-100']");

    public static final Target BTN_AGREGAR = Target.the("BTN_AGREGAR_CARRITO")
            .locatedBy("//div[@class='exito-vtex-components-4-x-mainBuyButton']");

    public static final Target BTN_AGREGAR_MAS = Target.the("BOTON AGREGAR MAS PRODUCTOS")
            .locatedBy("//button[@class='exito-vtex-components-4-x-buttonActions exito-vtex-components-4-x-productSummaryAddToCar  product-summary-add-to-car-plus']");
    public static final Target BTN_CONTINUAR_COMPRANDO = Target.the("BTN_CONTINUAR_COMPRANDO")
            .locatedBy("//p[@class='exito-vtex-components-4-x-continue']");


    //Carrito
    public static final Target BTN_CARRITO = Target.the("BOTON CARRITO")
            .locatedBy(("//a[@class='exito-header-3-x-minicartLink']"));
    public static final Target INP_CORREO = Target.the("CORREO")
            .locatedBy("//input[@name='email']");

    public static final Target BTN_CONFIRMAR = Target.the("TXT_CARRITO_COMPRAS")
            .locatedBy("//button[contains(text(), 'Confirmar')]");
    public static final Target TXT_CARRITO_COMPRAS = Target.the("TXT_CARRITO_COMPRAS")
            .locatedBy("//h1[contains(text(), 'Carrito de compras')]");
    public static Target TXT_NOMBRE_PRODUCTO_CARRITO = null;

    public static Target TXT_CANTIDAD_PRODUCTO_CARRITO = null;
    public static Target TXT_VALOR_TOTAL_PRODUCTO_CARRITO = null;

}
