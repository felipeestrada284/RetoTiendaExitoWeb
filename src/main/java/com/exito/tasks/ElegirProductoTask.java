package com.exito.tasks;

import com.exito.interactions.CantidadProductosAleatorio;
import com.exito.interactions.CerrarPublicidad;
import com.exito.interactions.SeleccionarProductoAleatorio;
import com.exito.utils.EscribirExcel;
import com.exito.utils.Limpiar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import static com.exito.userInterfaces.ProductosUI.*;
import static com.exito.utils.VariableGlobal.*;
import static com.exito.utils.VariableGlobal.productoAleatorio;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ElegirProductoTask implements Task {

    public static String valor;
    public static int valorTotal;
    public static String valorTotalProductos;

    @Override
    public <T extends Actor> void performAs(T actor) {

        Map<String, Object[]> dataExcel = new TreeMap<String, Object[]>();

        actor.attemptsTo(

                CerrarPublicidad.on(),
                WaitUntil.the(BTN_MENU, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_MENU),
                Click.on(BTN_CATEGORIA_DORMITORIO),
                Click.on(BTN_SUBCATEGORIA_CABECEROS),
                WaitUntil.the(TXT_CABECEROS, isVisible()).forNoMoreThan(30).seconds()
        );

        for (int i = 1; i <= 5 ; i++) {

            actor.attemptsTo(
                    SeleccionarProductoAleatorio.on(i),
                    WaitUntil.the(BTN_AGREGAR,  isVisible()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_AGREGAR),
                    CantidadProductosAleatorio.entre(1,5)
            );


            valor = Limpiar.numero(valorProducto);
            valorTotal = cantidadProducto * Integer.parseInt(valor);

            //Agregar formato a valorTotal
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
            numberFormat.setGroupingUsed(true);
            valorTotalProductos = numberFormat.format(valorTotal);

            //Escribir dataExcel en excel
            Object[] productData = new Object[]{
                    productoAleatorio, valorProducto, cantidadProducto, valorTotalProductos
            };

            System.out.println("Nombre producto: " + productoAleatorio);
            System.out.println("Valor producto: " + valorProducto);

            dataExcel.put(String.valueOf(i+1), productData);
            EscribirExcel.EscribirExcel(dataExcel);

            actor.attemptsTo(
                    Click.on(BTN_CONTINUAR_COMPRANDO),
                    WaitUntil.the(BTN_COMPRA_RAPIDA, isVisible()).forNoMoreThan(10).seconds()
            );
        }
    }

    public static ElegirProductoTask on(){
        return Tasks.instrumented(ElegirProductoTask.class);
    }
}
