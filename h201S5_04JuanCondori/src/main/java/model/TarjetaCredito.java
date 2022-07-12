package model;

import lombok.Data;

@Data

// AzureML
public class TarjetaCredito {

    Double EDAD;
    Double DEUDA;
    Double ANIOS_EMPLEO;
    int PUNTAJE_CREDITO;
    int CODIGO_POSTAL;
    int INGRESO;
    String ESTADO_APROBACION;

    int SCOREDLABELS;
    Double SCOREDPROBABILITIES1;
    Double SCOREDPROBABILITIES2;
    String RESULTADO;
    String CATEGORIA;
    
}
