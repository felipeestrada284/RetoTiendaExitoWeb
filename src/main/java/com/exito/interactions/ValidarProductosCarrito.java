package com.exito.interactions;

import com.exito.utils.DatosExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

import java.io.IOException;

import static com.exito.userInterfaces.ProductosUI.*;
import static com.exito.userInterfaces.ProductosUI.TXT_VALOR_TOTAL_PRODUCTO_CARRITO;

public class ValidarProductosCarrito implements Interaction {

    public String nombresProductos;
    public String cantidadesProductos;
    public String valorTotalProducto;
    public static String totalPreciosProductos;
    @Override
    public <T extends Actor> void performAs(T actor) {

        DatosExcel datos = new DatosExcel();

        for (int i = 0; i < 3; i++) {
            try {
                String nombresProductos = datos.leerDatoExcel("Hoja de datos","data.xlsx", i, 0);
                String cantidadesProductos = datos.leerDatoExcel("Hoja de datos","data.xlsx",i,2);
                String valorTotalProducto = datos.leerDatoExcel("Hoja de datos","data.xlsx",i,3);

                totalPreciosProductos ="$ "+valorTotalProducto;

                TXT_NOMBRE_PRODUCTO_CARRITO = Target.the("xpath nombre")
                        .locatedBy("//*[contains(text(), "+"'"+ nombresProductos +"')]");
                TXT_CANTIDAD_PRODUCTO_CARRITO = Target.the("xpath cantidad ")
                        .locatedBy("//span[@data-molecule-quantity-und-value='true' and " +
                                "contains(text(), "+"'"+ cantidadesProductos +"')]");
                TXT_VALOR_TOTAL_PRODUCTO_CARRITO = Target.the("xpath cantidad")
                        .locatedBy("//*[contains(text(), "+"'"+valorTotalProducto+"')]");

                actor.attemptsTo(
                        Ensure.that(TXT_NOMBRE_PRODUCTO_CARRITO).text().contains(nombresProductos),
                        Ensure.that(TXT_CANTIDAD_PRODUCTO_CARRITO).text().isEqualTo(cantidadesProductos),
                        Ensure.that(TXT_VALOR_TOTAL_PRODUCTO_CARRITO).text().isEqualTo(totalPreciosProductos)
                );

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static ValidarProductosCarrito on(){
        return Tasks.instrumented(ValidarProductosCarrito.class);
    }
}
