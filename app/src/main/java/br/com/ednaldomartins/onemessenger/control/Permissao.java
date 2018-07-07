package br.com.ednaldomartins.onemessenger.control;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Permissao {
    private final String [] permissoes;
    private final int NUMERO_DE_PERMISSOES = 2;
    //permissoes do APP
    private final String SEND_SMS = Manifest.permission.SEND_SMS;
    private final String INTERNET = Manifest.permission.INTERNET;

    public Permissao()
    {
        this.permissoes = new String[NUMERO_DE_PERMISSOES];
        this.permissoes[0] = SEND_SMS;
        this.permissoes[1] = INTERNET;
    }


    /************************************************************************************
     * esse metodo verifica quais sao todas as permissoes necessarias para o correto    *
     * funcionamento do app, e caso alguma dessas permissoes ainda nao estejam          *
     * garantidas, entao o app deve solicita-las.                                       *
     * @param activity : activity que estah pedindo todas as permissoes do app          *
     * @param requestCode                                                               *
     * @return : true quando todas as permissoes foram aceitas                          *                                               *
     ***********************************************************************************/
    public boolean validarPermissoes (Activity activity, int requestCode)
    {
        List <String> permissoesNecessarias = new ArrayList<String>();
        if(Build.VERSION.SDK_INT >= 23) {
            //buscar permissoes necessarias do APP
            for(int i = 0; i < permissoes.length; i++) {
                //verifica se a activity NAO tem a permissao necessaria garantida
                if( !(ContextCompat.checkSelfPermission(activity, permissoes[i]) == PackageManager.PERMISSION_GRANTED) ){
                    //caso a permissao necessaria ainda nao esteja garantida, entao guardar na lista
                    permissoesNecessarias.add(permissoes[i]);
                }
            }

            if(permissoesNecessarias.isEmpty())
                return true;

            String [] vetorPermissoesNecessarias = new String[ permissoesNecessarias.size() ];
            permissoesNecessarias.toArray( vetorPermissoesNecessarias );
            ActivityCompat.requestPermissions(activity,vetorPermissoesNecessarias, requestCode);
        }

        return true;
    }




    /************************************************************************************
     * os 2 metodos abaixo criam uma caixa de dialogo para a activity que chamou o      *
     * metodo garantirPermissao. Os metodos garantem que o aplicativo serah fechado     *
     * caso as permissoes nao sejam aceitas.                                            *
     * @param activity : activity que estah chamando a caixa de dialogo                 *
     * @param grantResults : estados das permissoes                                     *
     * @param requestCode                                                               *
     ************************************************************************************/
    public void garantirPermissao (Activity activity, int [] grantResults, int requestCode)
    {
        for (int resultado : grantResults) {
            if(resultado == PackageManager.PERMISSION_DENIED) {
                alertaPedirPermissao(activity);
            }
        }
    }

    private void alertaPedirPermissao(final Activity activity) {
        //alertBuilder para dar forma
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity)
                .setTitle("Permissões Negadas")
                .setMessage("Para continuar a utilizar o app, é necessário aceitar as permissões")
                .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.finish();
                    }
                });
        //alerta para mostrar caixa de dialogo
        AlertDialog alerta = alertBuilder.create();
        alerta.show();
    }

}
