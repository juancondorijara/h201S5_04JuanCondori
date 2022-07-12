package controller;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import model.TarjetaCredito;
//import org.json.JSONObject;
//import org.json.JSONException;
import org.primefaces.json.JSONObject;
import services.TarjetaCreditoS;
import lombok.Data;

@Data
@Named(value = "tarjetacreditoC")
@SessionScoped
public class TarjetaCreditoC implements Serializable {

    TarjetaCredito tarjetacredito;

    public TarjetaCreditoC() {
        tarjetacredito = new TarjetaCredito();
    }

    public  void obtenerDatosTitanic() throws IOException, InterruptedException {
        try {            
            JSONObject cadenaJson = TarjetaCreditoS.obtenerJSonTarjeta(tarjetacredito);
            tarjetacredito.setSCOREDLABELS(cadenaJson.getInt("Scored Labels"));
            tarjetacredito.setCATEGORIA(cadenaJson.getString("Scored Labels"));
            tarjetacredito.setSCOREDPROBABILITIES1(cadenaJson.getDouble("Scored Probabilities for Class \"0\""));
            tarjetacredito.setSCOREDPROBABILITIES2(cadenaJson.getDouble("Scored Probabilities for Class \"1\""));
            if (tarjetacredito.getCATEGORIA().equals("1")) {
                tarjetacredito.setRESULTADO("Que bien, Sobrevivio al Titanic");
            } else {
                tarjetacredito.setRESULTADO("Lo sentimos, según nuestro modelo no sobrevivio al Titanic");
            }
        } catch (Exception e) {
            System.out.println("Error en obtenerDatosTitanic: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
